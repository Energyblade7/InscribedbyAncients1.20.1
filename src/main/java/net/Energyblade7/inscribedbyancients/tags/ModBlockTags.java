package net.Energyblade7.inscribedbyancients.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    // --- Block Tag Registry ------------------------------------------------------------------------------------------
    public static final TagKey<Block> DRECK_MOSS = create("dreck_moss");

    // -----------------------------------------------------------------------------------------------------------------
    private ModBlockTags() {
    }

    private static TagKey<Block> create(String pName) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(pName));
    }

    public static TagKey<Block> create(ResourceLocation name) {
        return TagKey.create(Registries.BLOCK, name);
    }
}
