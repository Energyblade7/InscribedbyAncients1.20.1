package net.Energyblade7.inscribedbyancients.datagen.loot;

import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModLootTables extends BlockLootSubProvider {
    public ModLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

    }

    public static LootTable.Builder tableBuilder(LootPool.Builder pLootPool) {
        return LootTable.lootTable().withPool(pLootPool);
    }

}
