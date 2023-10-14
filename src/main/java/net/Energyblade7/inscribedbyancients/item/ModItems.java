package net.Energyblade7.inscribedbyancients.item;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.item.custom.*;

import net.Energyblade7.inscribedbyancients.item.library.FuelItem;
import net.Energyblade7.inscribedbyancients.item.library.IBAItem;
import net.Energyblade7.inscribedbyancients.item.library.ModFoods;
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
            () -> new ArcheologistsJournal("tooltip.inscribedbyancients.archeologists_journal.description",
                    "tooltip.inscribedbyancients.archeologists_journal.shift", new Item.Properties()
                    .stacksTo(1)));

    public static final RegistryObject<Item> ANCIENT_DATAPAD = ITEMS.register("ancient_datapad",
            () -> new AncientDatapad("tooltip.inscribedbyancients.ancient_datapad.description",
                    null, new Item.Properties()
                    .stacksTo(1)));

    public static final RegistryObject<Item> ARCHITECTS_SCRIBETOOL = ITEMS.register("architects_scribetool",
            () -> new ArchitectsScribetool("tooltip.inscribedbyancients.architects_scribetool.description",
                    null, new Item.Properties()
                    .stacksTo(1)));

    public static final RegistryObject<Item> DAMAGED_TABLET = ITEMS.register("damaged_tablet",
            () -> new DamagedTablet("tooltip.inscribedbyancients.damaged_tablet.description", null, new Item.Properties()
                    .stacksTo(1)));

    public static final RegistryObject<Item> DEAD_DRIVE = ITEMS.register("dead_drive",
            () -> new ExperienceDrive("tooltip.inscribedbyancients.dead_drive.description",null, new Item.Properties()
                    .stacksTo(16)));

    public static final RegistryObject<Item> EXPERIENCE_DRIVE = ITEMS.register("experience_drive",
            () -> new ExperienceDrive("tooltip.inscribedbyancients.experience_drive.description",null, new Item.Properties()
                    .durability(1395)));

    public static final RegistryObject<Item> WEEPING_BLACKBOX = ITEMS.register("weeping_blackbox",
            () -> new WeepingBlackbox("tooltip.inscribedbyancients.weeping_blackbox.description", null,new Item.Properties()
                    .stacksTo(16)));

    public static final RegistryObject<Item> NETHER_ANTHRACITE = ITEMS.register("nether_anthracite",
            () -> new FuelItem("tooltip.inscribedbyancients.nether_anthracite.description", null, new Item.Properties()
                    , 10));

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
            () -> new IBAItem("tooltip.inscribedbyancients.ancient_alloy.description",
                    null ,new Item.Properties()));

    public static final RegistryObject<Item> ETHER_BANK = ITEMS.register("ether_bank",
            () -> new IBAItem("tooltip.inscribedbyancients.ether_bank.description",
                    null, new Item.Properties()));

    public static final RegistryObject<Item> DRECK_TALLOW_NUT = ITEMS.register("dreck_tallow_nut",
            () -> new IBAItem("tooltip.inscribedbyancients.dreck_tallow_nut.description",
                    null, new Item.Properties()
                    .food(ModFoods.TALLOW_NUT)));


    //---------------------------------------------------------------------------------------------------------------------
//Put the number of Smelting Operations a Fuel Object should get, not burn time!
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
