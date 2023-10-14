package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, InscribedbyAncients.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ANCIENT_DATAPAD);
        simpleItem(ModItems.ARCHEOLOGISTS_JOURNAL);
        simpleItem(ModItems.DAMAGED_TABLET);

        simpleItem(ModItems.ANCIENT_ALLOY);
        simpleItem(ModItems.ETHER_BANK);
        simpleItem(ModItems.WEEPING_BLACKBOX);
        simpleItem(ModItems.EXPERIENCE_DRIVE);

        simpleItem(ModItems.NETHER_ANTHRACITE);

        simpleItem(ModItems.ANCIENT_RELIC);
        simpleItem(ModItems.ANTIQUE_APPARATUS);
        simpleItem(ModItems.GNARLED_EFFIGY);

        simpleItem(ModItems.DRECK_TALLOW_NUT);

        buttonItem(ModBlocks.DRECK_TALLOW_BUTTON, ModBlocks.DRECK_TALLOW_PLANK);
        fenceItem(ModBlocks.DRECK_TALLOW_FENCE, ModBlocks.DRECK_TALLOW_PLANK);

    }


    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(InscribedbyAncients.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(InscribedbyAncients.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(InscribedbyAncients.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(InscribedbyAncients.MOD_ID,"item/" + item.getId().getPath()));
    }
}
