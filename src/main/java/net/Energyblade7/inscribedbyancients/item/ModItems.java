package net.Energyblade7.inscribedbyancients.item;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.item.custom.ArtifactItem;
import net.Energyblade7.inscribedbyancients.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InscribedbyAncients.MOD_ID);

    public static final RegistryObject<Item> NETHER_ANTHRACITE = ITEMS.register("nether_anthracite",
            () -> new FuelItem(4000, "tooltip.inscribedbyancients.nether_anthracite.description", new Item.Properties()));
    //Nether Anthracite Smelts for 10 Operations
    public static final RegistryObject<Item> ANCIENT_RELIC = ITEMS.register("rusted_artifact",
                () -> new ArtifactItem(new Item.Properties()));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);

    }
}
