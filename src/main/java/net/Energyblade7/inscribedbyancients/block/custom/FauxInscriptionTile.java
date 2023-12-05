package net.Energyblade7.inscribedbyancients.block.custom;

import net.Energyblade7.inscribedbyancients.block.library.WritingTile;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class FauxInscriptionTile extends WritingTile {
    public static final BooleanProperty INSCRIPTION_STATE = BooleanProperty.create("inscription_state");

    public FauxInscriptionTile(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(INSCRIPTION_STATE, true));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(INSCRIPTION_STATE);
    }

    // --- Block Behaviors ---------------------------------------------------------------------------------------------

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(pLevel.isClientSide
                || pPlayer.isCrouching()
                || pHand != pPlayer.getUsedItemHand()){return InteractionResult.FAIL;}

        if (pState.getValue(INSCRIPTION_STATE)) {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(INSCRIPTION_STATE, false));
        } else {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(INSCRIPTION_STATE, true));
        }

        pLevel.playSound(null, pPos, SoundEvents.BRUSH_GRAVEL, SoundSource.BLOCKS, 1F, 1F);
        return InteractionResult.SUCCESS;
    }

    // -----------------------------------------------------------------------------------------------------------------
}
