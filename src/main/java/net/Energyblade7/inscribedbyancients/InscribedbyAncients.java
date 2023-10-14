package net.Energyblade7.inscribedbyancients;

import com.mojang.logging.LogUtils;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.block.entity.ModBlockEntities;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.Energyblade7.inscribedbyancients.item.OverriddenItems;
import net.Energyblade7.inscribedbyancients.particle.ModParticleTypes;
import net.Energyblade7.inscribedbyancients.client.IBAMenuTypes;
import net.Energyblade7.inscribedbyancients.util.ModCreativeModeTabs;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(InscribedbyAncients.MOD_ID)
public class InscribedbyAncients
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "inscribedbyancients";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public InscribedbyAncients()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModParticleTypes.register(modEventBus);
        IBAMenuTypes.register(modEventBus);

        OverriddenItems.register(modEventBus);

        //------------------------------------------------------------------------------------


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::clientSetup);

        //------------------------------------------------------------------------------------


    }

    private void clientSetup(final FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DULL_TILE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.INSCRIBED_TILE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FAUX_INSCRIPTION_TILE.get(), RenderType.translucent());
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTab() == ModCreativeModeTabs.ANCIENTS_TAB.get()) {
            event.accept(OverriddenItems.WRITABLE_BOOK);
            event.accept(ModItems.ARCHEOLOGISTS_JOURNAL);
            event.accept(ModItems.ANCIENT_DATAPAD);
            event.accept(ModItems.ARCHITECTS_SCRIBETOOL);


            event.accept(ModItems.NETHER_ANTHRACITE);
            event.accept(ModItems.ANCIENT_ALLOY);
            event.accept(ModItems.ETHER_BANK);
            event.accept(ModItems.EXPERIENCE_DRIVE);
            event.accept(ModItems.WEEPING_BLACKBOX);


            event.accept(ModItems.ANCIENT_RELIC);
            event.accept(ModItems.GNARLED_EFFIGY);
            event.accept(ModItems.ANTIQUE_APPARATUS);
            event.accept(ModItems.DAMAGED_TABLET);


            event.accept(ModBlocks.RECLAIMED_DIRT);
            event.accept(ModBlocks.RECLAIMED_SAND);
            event.accept(ModBlocks.RECLAIMED_GRAVEL);

            event.accept(ModBlocks.NETHER_ANTHRACITE_ORE);
            event.accept(ModBlocks.NETHER_ANTHRACITE_BLOCK);

            event.accept(ModBlocks.COMPACTED_RECLAIMATION);
            event.accept(ModBlocks.ENRICHED_RECLAIMATION);
            event.accept(ModBlocks.MOSSY_RECLAIMATION);
            event.accept(ModBlocks.DRECK_MOSS);

            event.accept(ModBlocks.DRECK_TALLOW_LOG);
            event.accept(ModBlocks.STRIPPED_DRECK_TALLOW_LOG);
            event.accept(ModBlocks.DRECK_TALLOW_WOOD);
            event.accept(ModBlocks.STRIPPED_DRECK_TALLOW_WOOD);
            event.accept(ModBlocks.DRECK_TALLOW_LEAVES);
            event.accept(ModItems.DRECK_TALLOW_NUT);

            event.accept(ModBlocks.DRECK_TALLOW_PLANK);
            event.accept(ModBlocks.DRECK_TALLOW_STAIRS);
            event.accept(ModBlocks.DRECK_TALLOW_SLAB);
            event.accept(ModBlocks.DRECK_TALLOW_DOOR);
            event.accept(ModBlocks.DRECK_TALLOW_TRAPDOOR);
            event.accept(ModBlocks.DRECK_TALLOW_PRESSURE_PLATE);
            event.accept(ModBlocks.DRECK_TALLOW_BUTTON);
            event.accept(ModBlocks.DRECK_TALLOW_FENCE);
            event.accept(ModBlocks.DRECK_TALLOW_FENCE_GATE);

            event.accept((ModBlocks.INSCRIBED_TILE));

        }



        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)  {
            event.accept(ModItems.NETHER_ANTHRACITE);
            event.accept(ModItems.ANCIENT_ALLOY);
            event.accept(ModItems.ETHER_BANK);


            event.accept(ModItems.DRECK_TALLOW_NUT);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.NETHER_ANTHRACITE_BLOCK);

            event.accept(ModBlocks.DRECK_TALLOW_LOG);
            event.accept(ModBlocks.STRIPPED_DRECK_TALLOW_LOG);
            event.accept(ModBlocks.DRECK_TALLOW_WOOD);
            event.accept(ModBlocks.STRIPPED_DRECK_TALLOW_WOOD);

            event.accept(ModBlocks.DRECK_TALLOW_PLANK);
            event.accept(ModBlocks.DRECK_TALLOW_STAIRS);
            event.accept(ModBlocks.DRECK_TALLOW_SLAB);
            event.accept(ModBlocks.DRECK_TALLOW_DOOR);
            event.accept(ModBlocks.DRECK_TALLOW_TRAPDOOR);
            event.accept(ModBlocks.DRECK_TALLOW_FENCE);
            event.accept(ModBlocks.DRECK_TALLOW_FENCE_GATE);

        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.NETHER_ANTHRACITE_ORE);

            event.accept(ModBlocks.COMPACTED_RECLAIMATION);
            event.accept(ModBlocks.ENRICHED_RECLAIMATION);
            event.accept(ModBlocks.MOSSY_RECLAIMATION);
            event.accept(ModBlocks.DRECK_MOSS);

            event.accept(ModBlocks.DRECK_TALLOW_LEAVES);
        }

        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
            event.accept(ModBlocks.RECLAIMED_DIRT);
            event.accept(ModBlocks.RECLAIMED_SAND);
            event.accept(ModBlocks.RECLAIMED_GRAVEL);

            event.accept(ModBlocks.DRECK_TALLOW_PRESSURE_PLATE);
            event.accept(ModBlocks.DRECK_TALLOW_BUTTON);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.ARCHITECTS_SCRIBETOOL);
            event.accept(ModItems.EXPERIENCE_DRIVE);
            event.accept(ModItems.WEEPING_BLACKBOX);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
