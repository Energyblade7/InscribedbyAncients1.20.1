package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.util.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {


    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider
            , @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, InscribedbyAncients.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COMPACTED_RECLAIMATION.get())
                .add(ModBlocks.ENRICHED_RECLAIMATION.get())
                .add(ModBlocks.MOSSY_RECLAIMATION.get())

                .add(ModBlocks.NETHER_ANTHRACITE_BLOCK.get())
                .add(ModBlocks.NETHER_ANTHRACITE_ORE.get())
                .add(ModBlocks.SMOLDERING_NETHER_ANTHRACITE_ORE.get())

                .add(ModBlocks.ANCIENT_BRICK.get())
                .add(ModBlocks.CHISELED_ANCIENT_BRICK.get())
                .add(ModBlocks.ANCIENT_BRICK_SLAB.get())
                .add(ModBlocks.ANCIENT_BRICK_STAIRS.get())
                .add(ModBlocks.CRACKED_ANCIENT_BRICK.get())
                .add(ModBlocks.LICHEN_ANCIENT_BRICK.get())
                .add(ModBlocks.LICHEN_ANCIENT_BRICK_SLAB.get())
                .add(ModBlocks.LICHEN_ANCIENT_BRICK_STAIRS.get())

                .add(ModBlocks.ANCIENT_RUBBLE.get())
                .add(ModBlocks.ANCIENT_RUBBLE_SLAB.get())
                .add(ModBlocks.ANCIENT_RUBBLE_STAIRS.get())
                .add(ModBlocks.ANCIENT_TILE.get())
                .add(ModBlocks.ANCIENT_TILE_SLAB.get())
                .add(ModBlocks.ANCIENT_TILE_STAIRS.get())
                .add(ModBlocks.LICHEN_ANCIENT_RUBBLE.get())
                .add(ModBlocks.LICHEN_ANCIENT_RUBBLE_SLAB.get())
                .add(ModBlocks.LICHEN_ANCIENT_RUBBLE_STAIRS.get());



        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.COMPACTED_RECLAIMATION.get())
                .add(ModBlocks.ENRICHED_RECLAIMATION.get())
                .add(ModBlocks.MOSSY_RECLAIMATION.get());


        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.NETHER_ANTHRACITE_BLOCK.get())
                .add(ModBlocks.NETHER_ANTHRACITE_ORE.get())
                .add(ModBlocks.SMOLDERING_NETHER_ANTHRACITE_ORE.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.COMPACTED_RECLAIMATION.get())
                .add(ModBlocks.ENRICHED_RECLAIMATION.get())
                .add(ModBlocks.MOSSY_RECLAIMATION.get());

        this.tag(Tags.Blocks.ORES)
                .add(ModBlocks.NETHER_ANTHRACITE_ORE.get());

        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.DRECK_TALLOW_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.DRECK_TALLOW_STAIRS.get());
        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.DRECK_TALLOW_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.DRECK_TALLOW_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.DRECK_TALLOW_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.DRECK_TALLOW_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS);
        this.tag(BlockTags.WOODEN_TRAPDOORS);

        // --- Modded Block Tags ---------------------------------------------------------------------------------------

        this.tag(ModBlockTags.DRECK_TALLOW_LOG_TYPE)
                .add(ModBlocks.DRECK_TALLOW_LOG.get())
                .add(ModBlocks.STRIPPED_DRECK_TALLOW_LOG.get())
                .add(ModBlocks.DRECK_TALLOW_WOOD.get())
                .add(ModBlocks.STRIPPED_DRECK_TALLOW_WOOD.get());

        this.tag(ModBlockTags.INSCRIPTION_TILE_LIKE)
                .add(ModBlocks.INSCRIBED_TILE.get())
                .add(ModBlocks.FAUX_INSCRIPTION_TILE.get())
                .add(ModBlocks.DULL_TILE.get());

        this.tag(ModBlockTags.TRUE_INSCRIPTION_TILE)
                .add(ModBlocks.INSCRIBED_TILE.get());

        // -------------------------------------------------------------------------------------------------------------

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
