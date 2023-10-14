package net.Energyblade7.inscribedbyancients.block.custom;


import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DreckMossBlock extends Block {
    public DreckMossBlock(Properties pProperties) {
        super(pProperties);
    }

    // --- Block Behavior ----------------------------------------------------------------------------------------------

    private static boolean isNotBuried(LevelReader pLevelReader, BlockPos pPos) {

        BlockPos blockpos = pPos.above();

        if (pLevelReader.getMaxLocalRawBrightness(blockpos) == 0
                || pLevelReader.getFluidState(blockpos).is(FluidTags.WATER)) {return false;}

        return true;
    }

@Override
    public void randomTick(@NotNull BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {

        if (!isNotBuried(pLevel, pPos) && !pState.is(ModBlocks.DRECK_MOSS.get())) {

            if (!pLevel.isAreaLoaded(pPos, 1)) return;
            // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading

            pLevel.setBlockAndUpdate(pPos, ModBlocks.ENRICHED_RECLAIMATION.get().defaultBlockState());
            // Energy: Checks if block is buried, if true & if block is Mossy Reclaimation, turns target block back into Enriched Reclaimation

        } else {

            if (!pLevel.isAreaLoaded(pPos, 3)) return;
            // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading

            runGrowthSelector(pState, pLevel, pPos, pRandom);

        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void runGrowthSelector(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        for(int i = 0; i < 3; ++i) {

            BlockPos blockpos = pPos.offset(pRandom.nextInt(4) - 1, pRandom.nextInt(6) - 3, pRandom.nextInt(4) - 1);

            if (!pLevel.getBlockState(blockpos).is(ModBlocks.ENRICHED_RECLAIMATION.get())
                    || !isNotBuried(pLevel, blockpos)) return;

            pLevel.setBlockAndUpdate(blockpos, ModBlocks.MOSSY_RECLAIMATION.get().defaultBlockState());
        }
    }
}
