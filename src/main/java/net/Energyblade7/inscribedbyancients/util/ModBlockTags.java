package net.Energyblade7.inscribedbyancients.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    // --- Block Tag Registry ------------------------------------------------------------------------------------------
    public static final TagKey<Block> DRECK_TALLOW_LOG_TYPE = create("dreck_tallow_log_type");

    public static final TagKey<Block> INSCRIPTION_TILE_LIKE = create("inscription_tile_like");

    public static final TagKey<Block> TRUE_INSCRIPTION_TILE = create("true_inscription_tile");

    // -----------------------------------------------------------------------------------------------------------------

    private static TagKey<Block> create(String pName) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(pName));
    }

    public static TagKey<Block> create(ResourceLocation name) {
        return TagKey.create(Registries.BLOCK, name);
    }
}
