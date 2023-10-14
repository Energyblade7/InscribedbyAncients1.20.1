package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = InscribedbyAncients.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packoutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        var blockTagProvider = new ModBlockTagGenerator(packoutput, event.getLookupProvider(), existingFileHelper);


        if(event.includeServer()) {
            generator.addProvider(true, blockTagProvider);
            generator.addProvider(true, new ModItemTagGenerator(packoutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));
            generator.addProvider(true, new ModRecipeProvider(packoutput));
            generator.addProvider(true, ModLootTableProvider.create(packoutput));
        }

        if(event.includeClient()){
            generator.addProvider(true, new ModItemModelProvider(packoutput, existingFileHelper));
            generator.addProvider(true, new ModBlockStateProvider(packoutput, existingFileHelper));
        }
    }
}
