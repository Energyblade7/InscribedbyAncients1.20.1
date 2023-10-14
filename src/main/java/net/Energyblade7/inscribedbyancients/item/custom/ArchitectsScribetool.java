package net.Energyblade7.inscribedbyancients.item.custom;

import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.block.custom.FauxInscriptionTile;
import net.Energyblade7.inscribedbyancients.item.library.IBAItem;
import net.Energyblade7.inscribedbyancients.util.ModBlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ArchitectsScribetool extends IBAItem {

    protected static UseOnContext savedContext;
    public ArchitectsScribetool(String description, @Nullable String shiftDescription, Properties pProperties) {
        super(description, shiftDescription, pProperties);
    }

    // --- Item Stack Properties ---------------------------------------------------------------------------------------
    @NotNull
    @Override
    public UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 5;
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {

        savedContext = context;


        if(context.getLevel().isClientSide
                || Objects.requireNonNull(context.getPlayer()).isCrouching()) { return InteractionResult.PASS;}


        context.getPlayer().startUsingItem(context.getHand());
        return InteractionResult.SUCCESS;
    }

    @Override
    public void onUseTick(Level pLevel, @NotNull LivingEntity pLivingEntity, @NotNull ItemStack pStack, int pRemainingUseDuration) {
        if(pLevel.getBlockState(savedContext.getClickedPos()).is(ModBlockTags.INSCRIPTION_TILE_LIKE)
                || pRemainingUseDuration != 1) {return;}


        pLevel.setBlockAndUpdate(savedContext.getClickedPos()
                , ModBlocks.FAUX_INSCRIPTION_TILE.get().defaultBlockState());

    }

    // -----------------------------------------------------------------------------------------------------------------
}
