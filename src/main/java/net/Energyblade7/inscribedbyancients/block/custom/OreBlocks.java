package net.Energyblade7.inscribedbyancients.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class OreBlocks extends Block {

    private static int expDrop;
    public OreBlocks(int expDrop, Properties properties) {
        super(properties);
        this.expDrop = expDrop;
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
        return expDrop;
    }
}
