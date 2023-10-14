package net.Energyblade7.inscribedbyancients.util;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

public class ModSoundType {
    public static final SoundType RECLAIMATION = new SoundType(1.0F, 1.0F, SoundEvents.SUSPICIOUS_GRAVEL_BREAK, SoundEvents.DEEPSLATE_BRICKS_STEP, SoundEvents.DEEPSLATE_PLACE,SoundEvents.NETHERRACK_HIT, SoundEvents.SUSPICIOUS_GRAVEL_FALL);
    public static final SoundType MOSSY_RECLAIMATION = new SoundType(1.0F, 1.0F, SoundEvents.SUSPICIOUS_GRAVEL_BREAK, SoundEvents.MOSS_STEP, SoundEvents.DEEPSLATE_PLACE,SoundEvents.NETHERRACK_HIT, SoundEvents.SUSPICIOUS_GRAVEL_FALL);

    public static final SoundType INSCRIPTION_TILE = new SoundType(1.0F, 1.0F, SoundEvents.GRINDSTONE_USE, SoundEvents.ENCHANTMENT_TABLE_USE, SoundEvents.GRINDSTONE_USE, SoundEvents.STONE_HIT, SoundEvents.STONE_FALL);
}
