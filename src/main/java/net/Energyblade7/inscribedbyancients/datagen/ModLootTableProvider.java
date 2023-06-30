package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.datagen.loot.ModBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {
    // When adding new types of Loot Tables, add a new 'LootTableProvider.SubProviderEntry()' and declare the 'LootContextParamSets'
    // Add new loot set to datagen/loot
    static LootTableProvider create(PackOutput packOutput) {
        return new LootTableProvider(packOutput, Set.of()
                , List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
