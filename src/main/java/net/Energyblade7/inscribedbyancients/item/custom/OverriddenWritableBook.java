package net.Energyblade7.inscribedbyancients.item.custom;

import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.util.ModBlockTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class OverriddenWritableBook extends WritableBookItem {

    public OverriddenWritableBook(Properties pProperties) {
        super(pProperties);
    }

    // --- Item Stack Properties ---------------------------------------------------------------------------------------

    @Override
    public boolean isFoil(ItemStack pStack) {
        return pStack.getDamageValue() != 0;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        if(pStack.getDamageValue() == 0) {
            return;
        }

        pTooltipComponents.add(Component.translatable("item.inscribedbyancients.writable_book.description" ).withStyle(ChatFormatting.GRAY));

    }

    @Override //ModItemTags Seem very iffy atm, InscriptionTile Code not working how logic is writing, bypassing the issue by using this instead
    public InteractionResult onItemUseFirst(ItemStack itemStack, UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockPos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockPos);

        if(level.isClientSide()
                && blockstate.is(ModBlockTags.TRUE_INSCRIPTION_TILE)) return InteractionResult.FAIL;

        if(level.isClientSide()
                || Objects.requireNonNull(pContext.getPlayer()).isCrouching()
                || !blockstate.is(ModBlockTags.TRUE_INSCRIPTION_TILE)) return InteractionResult.PASS;


        countInscriptionProgress(level, pContext.getItemInHand(), blockPos);
        level.setBlockAndUpdate(blockPos, ModBlocks.DULL_TILE.get().withPropertiesOf(blockstate));
        return InteractionResult.SUCCESS; //A special interaction occurs at 4 progress, check Forge Events
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(pContext.getItemInHand().getDamageValue() != 0
                || Objects.requireNonNull(pContext.getPlayer()).isCrouching()) return InteractionResult.PASS;

        return super.useOn(pContext);
    }

    // Negates the ability to open a Book & Quill if the Item is in the process of transforming into the Archeologists' Journal
    @NotNull
    @Override public InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {

        if (pPlayer.getItemInHand(pHand).getDamageValue() != 0
                || pPlayer.isCrouching()) {return InteractionResultHolder.pass(pPlayer.getItemInHand(pHand));}

        return super.use(pLevel, pPlayer, pHand);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // --- Helper Functions --------------------------------------------------------------------------------------------
    @Override
    public void setDamage(ItemStack stack, int damage) {
        stack.getOrCreateTag().putInt("Damage",damage);
    }

    private void countInscriptionProgress(Level pLevel, ItemStack pStack, BlockPos pPos) {
        if(pStack.getDamageValue() == 0) {
            setDamage(pStack, 5);
            pLevel.playSound(null, pPos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1F, 0.7F);
        } else {
            setDamage(pStack, pStack.getDamageValue() - 1);
            pLevel.playSound(null, pPos, SoundEvents.BOOK_PAGE_TURN, SoundSource.PLAYERS, 1F, 0.8F);
        }
    }
    // -----------------------------------------------------------------------------------------------------------------
}
