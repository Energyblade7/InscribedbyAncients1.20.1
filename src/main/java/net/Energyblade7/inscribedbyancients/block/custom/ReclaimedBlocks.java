package net.Energyblade7.inscribedbyancients.block.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;

public class ReclaimedBlocks extends BrushableBlock {

    public ReclaimedBlocks(Block turnsInto, SoundEvent brushSound, SoundEvent brushSoundComplete, Properties properties) {
        super(turnsInto, properties, brushSound, brushSoundComplete);
    }
}
