package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
                .add(ModBlocks.NETHER_ANTHRACITE_ORE.get());


        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.COMPACTED_RECLAIMATION.get())
                .add(ModBlocks.ENRICHED_RECLAIMATION.get())
                .add(ModBlocks.MOSSY_RECLAIMATION.get());


        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.NETHER_ANTHRACITE_BLOCK.get())
                .add(ModBlocks.NETHER_ANTHRACITE_ORE.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.COMPACTED_RECLAIMATION.get())
                .add(ModBlocks.ENRICHED_RECLAIMATION.get())
                .add(ModBlocks.MOSSY_RECLAIMATION.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
