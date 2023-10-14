package net.Energyblade7.inscribedbyancients.datagen.loot;

import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.block.custom.SmolderingNetherAnthraciteOre;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;


import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }



// --- Quick Registery (for simple blocks only) -----------------------------------------------------------------------
    @Override
    protected void generate() {
        this.add(ModBlocks.NETHER_ANTHRACITE_ORE.get(), block -> createOreDrop(ModBlocks.NETHER_ANTHRACITE_ORE.get(), ModItems.NETHER_ANTHRACITE.get()));
        this.add(ModBlocks.SMOLDERING_NETHER_ANTHRACITE_ORE.get(), block -> tableBuilder(smolderingNetherAnthraciteOre));

        this.dropSelf(ModBlocks.NETHER_ANTHRACITE_BLOCK.get());


        this.dropSelf(ModBlocks.COMPACTED_RECLAIMATION.get());
        this.dropSelf(ModBlocks.ENRICHED_RECLAIMATION.get());
        this.dropSelf(ModBlocks.DRECK_MOSS.get());

        this.dropOther(ModBlocks.MOSSY_RECLAIMATION.get(), ModBlocks.ENRICHED_RECLAIMATION.get());

        this.dropSelf(ModBlocks.DRECK_TALLOW_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_DRECK_TALLOW_LOG.get());
        this.dropSelf(ModBlocks.DRECK_TALLOW_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_DRECK_TALLOW_WOOD.get());
        this.add(ModBlocks.DRECK_TALLOW_LEAVES.get(), block -> createOakLeavesDrops(ModBlocks.DRECK_TALLOW_LEAVES.get(), ModBlocks.DRECK_TALLOW_LOG.get()));

        this.dropSelf(ModBlocks.DRECK_TALLOW_PLANK.get());
        this.dropSelf(ModBlocks.DRECK_TALLOW_STAIRS.get());
        this.dropSelf(ModBlocks.DRECK_TALLOW_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DRECK_TALLOW_BUTTON.get());
        this.add(ModBlocks.DRECK_TALLOW_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DRECK_TALLOW_SLAB.get()));
        this.add(ModBlocks.DRECK_TALLOW_DOOR.get(),
            block -> createDoorTable(ModBlocks.DRECK_TALLOW_DOOR.get()));
        this.dropSelf(ModBlocks.DRECK_TALLOW_TRAPDOOR.get());
        this.dropSelf(ModBlocks.DRECK_TALLOW_FENCE.get());
        this.dropSelf(ModBlocks.DRECK_TALLOW_FENCE_GATE.get());

    }

    // -----------------------------------------------------------------------------------------------------------------
    // --- Custom Loot Tables ------------------------------------------------------------------------------------------
    public static LootPool.Builder smolderingNetherAnthraciteOre = LootPool.lootPool()
            .name("smoldering_nether_anthracite_ore")
            .setRolls(ConstantValue.exactly(1.0F))
            .add(LootItem.lootTableItem(ModItems.NETHER_ANTHRACITE.get()))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SMOLDERING_NETHER_ANTHRACITE_ORE.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SmolderingNetherAnthraciteOre.SMOLDERING, false))))


                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SMOLDERING_NETHER_ANTHRACITE_ORE.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SmolderingNetherAnthraciteOre.SMOLDERING, true))));


    // -----------------------------------------------------------------------------------------------------------------

    public static LootTable.Builder tableBuilder(LootPool.Builder pLootPool) {
        return LootTable.lootTable().withPool(pLootPool);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
