package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(InscribedbyAncients.MOD_ID,"item/" + item.getId().getPath()));
    }
}
