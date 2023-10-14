package net.Energyblade7.inscribedbyancients.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

    // --- Block Tag Registry ------------------------------------------------------------------------------------------
    public static final TagKey<Item> WRITING_TOOLS = create("writing_tools");

    // -----------------------------------------------------------------------------------------------------------------

    private static TagKey<Item> create(String pName) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(pName));
    }

    public static TagKey<Item> create(ResourceLocation name) {
        return TagKey.create(Registries.ITEM, name);
    }
}
