package net.Energyblade7.inscribedbyancients.block.custom;

import net.Energyblade7.inscribedbyancients.block.library.WritingTile;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;



public class InscriptionTile extends WritingTile {

    public InscriptionTile(Properties pProperties) {
        super(pProperties);
    }

    // --- Block Behaviors ---------------------------------------------------------------------------------------------

    @NotNull
    @Override
    public  InteractionResult use(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide
                || pPlayer.isCrouching()
                || pHand != pPlayer.getUsedItemHand()) return InteractionResult.FAIL;

        if (pPlayer.getItemInHand(pHand).is(ModItems.ARCHEOLOGISTS_JOURNAL.get())) return InteractionResult.PASS;

        pPlayer.sendSystemMessage(Component.translatable("block.message.inscribed_tile.hint"));
        pLevel.playSound(null, pPos, SoundEvents.BRUSH_GRAVEL, SoundSource.BLOCKS, 1F, 1F);
        return InteractionResult.SUCCESS;
    }

// -----------------------------------------------------------------------------------------------------------------
}
