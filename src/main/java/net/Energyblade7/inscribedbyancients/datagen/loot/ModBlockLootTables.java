package net.Energyblade7.inscribedbyancients.datagen.loot;

import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;


import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.NETHER_ANTHRACITE_ORE.get(), block -> createOreDrop(ModBlocks.NETHER_ANTHRACITE_ORE.get(), ModItems.NETHER_ANTHRACITE.get()));

        this.dropSelf(ModBlocks.NETHER_ANTHRACITE_BLOCK.get());


        this.dropSelf(ModBlocks.COMPACTED_RECLAIMATION.get());
        this.dropSelf(ModBlocks.ENRICHED_RECLAIMATION.get());
        this.dropSelf(ModBlocks.DRECK_MOSS.get());

        this.dropOther(ModBlocks.MOSSY_RECLAIMATION.get(), ModBlocks.ENRICHED_RECLAIMATION.get());

        this.dropSelf(ModBlocks.DRECK_GINKGO_LOG.get());
        this.add(ModBlocks.DRECK_GINKGO_LEAVES.get(), block -> createOakLeavesDrops(ModBlocks.DRECK_GINKGO_LEAVES.get(), ModBlocks.DRECK_GINKGO_LOG.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
