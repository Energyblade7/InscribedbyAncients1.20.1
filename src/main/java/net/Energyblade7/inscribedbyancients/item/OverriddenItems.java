package net.Energyblade7.inscribedbyancients.item;

import net.Energyblade7.inscribedbyancients.item.custom.OverriddenWritableBook;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OverriddenItems {

    public static final DeferredRegister<Item> OVERRIDDEN_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    // --- Overridden Item Register ------------------------------------------------------------------------------------

    public static final RegistryObject<Item> WRITABLE_BOOK = OVERRIDDEN_ITEMS.register("writable_book",
            () -> new OverriddenWritableBook(new Item.Properties()
                    .durability(5)));

    // -----------------------------------------------------------------------------------------------------------------

    public static void register(IEventBus eventbus) {OVERRIDDEN_ITEMS.register(eventbus);
    }
}
