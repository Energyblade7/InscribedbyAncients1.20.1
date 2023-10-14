package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.Energyblade7.inscribedbyancients.util.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture,
                               CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, blockTagProvider, InscribedbyAncients.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Add Item Tags here
        this.tag(Tags.Items.SEEDS)
                .add(ModItems.DRECK_TALLOW_NUT.get());


        this.tag(Tags.Items.INGOTS)
                .add(ModItems.ANCIENT_ALLOY.get());

        this.tag(ModItemTags.WRITING_TOOLS)
                .add(Items.WRITABLE_BOOK)
                .add(ModItems.ARCHEOLOGISTS_JOURNAL.get())
                .add(ModItems.ANCIENT_DATAPAD.get());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
