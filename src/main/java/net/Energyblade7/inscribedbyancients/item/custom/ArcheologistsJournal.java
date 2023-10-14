package net.Energyblade7.inscribedbyancients.item.custom;

import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.client.ClientHooks;
import net.Energyblade7.inscribedbyancients.item.library.IBAItem;
import net.Energyblade7.inscribedbyancients.util.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;


public class ArcheologistsJournal extends IBAItem {

    protected static BlockPos savedBlockPos;
    protected static BlockState savedBlockState;

    public ArcheologistsJournal(String description, @Nullable String shiftDescription, Properties pProperties) {
        super(description, shiftDescription, pProperties);
    }

    // --- Item Stack Properties ---------------------------------------------------------------------------------------

    @NotNull
    @Override
    public UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) { return 30; }

    @Override
    public InteractionResult onItemUseFirst(ItemStack pStack, UseOnContext useOnContext) {

        savedBlockPos = useOnContext.getClickedPos();
        savedBlockState = useOnContext.getLevel().getBlockState(savedBlockPos);

        if(!useOnContext.getLevel().getBlockState(useOnContext.getClickedPos()).is(ModBlockTags.TRUE_INSCRIPTION_TILE))
            {return InteractionResult.PASS;}


        Objects.requireNonNull(useOnContext.getPlayer()).startUsingItem(useOnContext.getHand());
        return InteractionResult.SUCCESS;
    }

    @Override
    public void onUseTick(@NotNull Level pLevel, @NotNull LivingEntity pLivingEntity, @NotNull ItemStack pStack, int pRemainingUseDuration) {
        if(pRemainingUseDuration != 1) return;

        finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @NotNull
    @Override
    public ItemStack finishUsingItem(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull LivingEntity pLivingEntity) {

        if(!(pLivingEntity instanceof Player player)) return pStack;

        player.getCooldowns().addCooldown(pStack.getItem(), getUseDuration(pStack) + 10);
        pLevel.playSound(player, player, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1F, 0.7F);
        pLevel.setBlockAndUpdate(savedBlockPos, ModBlocks.DULL_TILE.get().withPropertiesOf(savedBlockState));

        if(pLevel.isClientSide) DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openTranslationScreen);

        return pStack;
    }

    // -----------------------------------------------------------------------------------------------------------------


}
