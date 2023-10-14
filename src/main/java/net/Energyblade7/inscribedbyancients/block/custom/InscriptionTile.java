package net.Energyblade7.inscribedbyancients.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class InscriptionTile extends MultifaceBlock implements SimpleWaterloggedBlock {
    protected static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty RECORDED = BooleanProperty.create("recorded");
    private final MultifaceSpreader spreader = new MultifaceSpreader(this);
    public InscriptionTile(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.registerDefaultState(this.defaultBlockState().setValue(RECORDED, Boolean.valueOf(false)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED, RECORDED);
    }



    // --- Block Behaviors ---------------------------------------------------------------------------------------------


    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }



    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND && !pPlayer.isCrouching()){

            //boolean currentState = pState.getValue(RECORDED);
            //pLevel.setBlock(pPos, pState.setValue(RECORDED, !currentState), 3);

            pLevel.playSound(null, pPos, SoundEvents.BRUSH_GRAVEL, SoundSource.BLOCKS, 1F, 1F);
            return InteractionResult.SUCCESS;

        } else {
            return InteractionResult.PASS;
        }
    }



    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public MultifaceSpreader getSpreader() {
        return spreader;
    }
}
