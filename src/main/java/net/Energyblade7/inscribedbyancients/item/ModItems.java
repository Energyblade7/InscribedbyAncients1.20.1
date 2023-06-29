package net.Energyblade7.inscribedbyancients.item;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.item.custom.ArcheologistsJournal;
import net.Energyblade7.inscribedbyancients.item.custom.ArtifactItem;
import net.Energyblade7.inscribedbyancients.item.custom.DescriptiveItem;
import net.Energyblade7.inscribedbyancients.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InscribedbyAncients.MOD_ID);
//---------------------------------------------------------------------------------------------------------------------
//Put the number of Smelting Operations a Fuel Object should get, not burn time!
    public static final RegistryObject<Item> ARCHEOLOGISTS_JOURNAL = ITEMS.register("archeologists_journal",
            () -> new ArcheologistsJournal(new Item.Properties()
                    .stacksTo(1)));
    public static final RegistryObject<Item> NETHER_ANTHRACITE = ITEMS.register("nether_anthracite",
            () -> new FuelItem(10, "tooltip.inscribedbyancients.nether_anthracite.description", new Item.Properties()));
    //Nether Anthracite Smelts for 10 Operations

    public static final RegistryObject<Item> ANCIENT_RELIC = ITEMS.register("rusted_artifact",
            () -> new ArtifactItem("tooltip.inscribedbyancients.artifactitem.rustedartifact.description", new Item.Properties()
                    .stacksTo(16)));

    public static final RegistryObject<Item> ANCIENT_ALLOY = ITEMS.register("ancient_alloy",
            () -> new DescriptiveItem("tooltip.inscribedbyancients.ancient_alloy.description", new Item.Properties()));


//---------------------------------------------------------------------------------------------------------------------
//Put the number of Smelting Operations a Fuel Object should get, not burn time!
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
