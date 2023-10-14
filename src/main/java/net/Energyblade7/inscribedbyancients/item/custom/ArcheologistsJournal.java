package net.Energyblade7.inscribedbyancients.item.custom;

import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class ArcheologistsJournal extends ModItem {


    public ArcheologistsJournal(String description, @Nullable String shiftDescription, Properties pProperties) {
        super(description, shiftDescription, pProperties);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        if (!useOnContext.getLevel().isClientSide) {
            BlockPos positionClicked = useOnContext.getClickedPos();
            Player player = useOnContext.getPlayer();
            boolean isInscriptionTile;

            BlockState block = useOnContext.getLevel().getBlockState(positionClicked);

            if (isInscribedBlock(block)) {
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 2000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }


// MISC Functions -------------------------------------------------------------------------------------------------
    private boolean isInscribedBlock(BlockState block) {
        return block.is(ModBlocks.INSCRIBED_TILE.get());
    }

}
