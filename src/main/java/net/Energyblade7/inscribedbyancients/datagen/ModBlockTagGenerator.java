package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.tags.ModBlockTags;
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
                .add(ModBlocks.SMOLDERING_NETHER_ANTHRACITE_ORE.get());


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

        this.tag(ModBlockTags.DRECK_MOSS)
                .add(ModBlocks.DRECK_MOSS.get())
                .add(ModBlocks.MOSSY_RECLAIMATION.get());

        // -------------------------------------------------------------------------------------------------------------

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
