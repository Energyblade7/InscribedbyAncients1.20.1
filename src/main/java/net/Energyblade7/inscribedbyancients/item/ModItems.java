package net.Energyblade7.inscribedbyancients.item;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.item.custom.*;

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

    public static final RegistryObject<Item> ANCIENT_DATAPAD = ITEMS.register("ancient_datapad",
            () -> new AncientDatapad(new Item.Properties()
                    .stacksTo(1)));

    public static final RegistryObject<Item> DAMAGED_TABLET = ITEMS.register("damaged_tablet",
            () -> new DamagedTablet(new Item.Properties()
                    .stacksTo(1)));

    public static final RegistryObject<Item> EXPERIENCE_DRIVE = ITEMS.register("experience_drive",
            () -> new ExperienceDrive("tooltip.inscribedbyancients.experience_drive.description", new Item.Properties()
                    .stacksTo(1)));

    public static final RegistryObject<Item> WEEPING_BLACKBOX = ITEMS.register("weeping_blackbox",
            () -> new WeepingBlackbox("tooltip.inscribedbyancients.weeping_blackbox.description", new Item.Properties()
                    .stacksTo(16)));

    public static final RegistryObject<Item> NETHER_ANTHRACITE = ITEMS.register("nether_anthracite",
            () -> new FuelItem(10, "tooltip.inscribedbyancients.nether_anthracite.description", new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_RELIC = ITEMS.register("rusted_artifact",
            () -> new ArtifactItem("tooltip.inscribedbyancients.artifactitem.rusted_artifact.description", new Item.Properties()
                    .stacksTo(16)));

    public static final RegistryObject<Item> GNARLED_EFFIGY = ITEMS.register("gnarled_effigy",
            () -> new ArtifactItem("tooltip.inscribedbyancients.artifactitem.gnarled_effigy.description", new Item.Properties()
                    .stacksTo(16)));

    public static final RegistryObject<Item> ANTIQUE_APPARATUS = ITEMS.register("antique_apparatus",
            () -> new ArtifactItem("tooltip.inscribedbyancients.artifactitem.antique_apparatus.description", new Item.Properties()
                    .stacksTo(16)));

    public static final RegistryObject<Item> ANCIENT_ALLOY = ITEMS.register("ancient_alloy",
            () -> new DescriptiveItem("tooltip.inscribedbyancients.ancient_alloy.description", new Item.Properties()));

    public static final RegistryObject<Item> ETHER_BANK = ITEMS.register("ether_bank",
            () -> new DescriptiveItem("tooltip.inscribedbyancients.ether_bank.description", new Item.Properties()));


    //---------------------------------------------------------------------------------------------------------------------
//Put the number of Smelting Operations a Fuel Object should get, not burn time!
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
