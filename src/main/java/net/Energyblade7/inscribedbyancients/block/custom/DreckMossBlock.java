package net.Energyblade7.inscribedbyancients.block.custom;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DreckMossBlock extends Block {
    public DreckMossBlock(Properties pProperties) {
        super(pProperties);
    }

    // --- Block Behavior ----------------------------------------------------------------------------------------------


    private static boolean isNotBuried(LevelReader pLevelReader, BlockPos pPos) {

        BlockPos blockpos = pPos.above();
        BlockState blockstate = pLevelReader.getBlockState(blockpos);

        if (pLevelReader.getMaxLocalRawBrightness(blockpos) > 0 && !pLevelReader.getFluidState(blockpos).is(FluidTags.WATER)) {
            return true;
        } else {
            return false;
        }
    }

@Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {

        if (!isNotBuried(pLevel, pPos) && !pState.is(ModBlocks.DRECK_MOSS.get())) {

            if (!pLevel.isAreaLoaded(pPos, 1)) return;
            // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading

            pLevel.setBlockAndUpdate(pPos, ModBlocks.ENRICHED_RECLAIMATION.get().defaultBlockState());
            // Energy: Checks if block is buried, if true & if block is Mossy Reclaimation, turns target block back into Enriched Reclaimation

        } else {

            if (!pLevel.isAreaLoaded(pPos, 3)) return;
            // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading

            for(int i = 0; i < 3; ++i) {

                BlockPos blockpos = pPos.offset(pRandom.nextInt(4) - 1, pRandom.nextInt(6) - 3, pRandom.nextInt(4) - 1);

                if (pLevel.getBlockState(blockpos).is(ModBlocks.ENRICHED_RECLAIMATION.get()) && isNotBuried(pLevel, blockpos)) {
                    pLevel.setBlockAndUpdate(blockpos, ModBlocks.MOSSY_RECLAIMATION.get().defaultBlockState());
                }
            }

        }
    }

    // -----------------------------------------------------------------------------------------------------------------
}
