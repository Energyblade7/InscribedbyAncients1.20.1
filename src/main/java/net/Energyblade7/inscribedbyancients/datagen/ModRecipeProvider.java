package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> NETHER_ANTHRACITE_ORE = List.of(ModBlocks.NETHER_ANTHRACITE_ORE.get());
    private static final List<ItemLike> METALLIC_ARTIFACTS = List.of(ModItems.ANTIQUE_APPARATUS.get(), ModItems.ANCIENT_RELIC.get());
    private static final List<ItemLike> ORGANIC_ARTIFACTS = List.of(ModItems.GNARLED_EFFIGY.get());

    private static final List<ItemLike> DRECK_LOG_TYPE = List.of(ModBlocks.DRECK_TALLOW_LOG.get(), ModBlocks.DRECK_TALLOW_WOOD.get(), ModBlocks.STRIPPED_DRECK_TALLOW_LOG.get(), ModBlocks.STRIPPED_DRECK_TALLOW_WOOD.get());

    private static final List<ItemLike> DRECK_TALLOW_PLANKS = List.of(ModBlocks.DRECK_TALLOW_PLANK.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        //------------------------------------------------------------------------------------------------------------
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.NETHER_ANTHRACITE.get(), RecipeCategory.MISC, ModBlocks.NETHER_ANTHRACITE_BLOCK.get());
        oreBlasting(pWriter, NETHER_ANTHRACITE_ORE, RecipeCategory.MISC, ModItems.NETHER_ANTHRACITE.get(), 2F, 100, "nether_anthracite");
        oreSmelting(pWriter, NETHER_ANTHRACITE_ORE, RecipeCategory.MISC, ModItems.NETHER_ANTHRACITE.get(), 1.2F, 200, "nether_anthracite");

        oreSmelting(pWriter, METALLIC_ARTIFACTS, RecipeCategory.MISC, ModItems.ANCIENT_ALLOY.get(), 1.5F, 200, "metallic_artifacts");
        oreSmelting(pWriter, ORGANIC_ARTIFACTS, RecipeCategory.MISC, Items.CHARCOAL, 1.5F, 200, "organic_artifacts");

        //------------------------------------------------------------------------------------------------------------

        /* EXAMPLE OF SHAPED AND SHAPELESS RECIPES
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHER_ANTHRACITE_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")

                .define('X', ModItems.NETHER_ANTHRACITE.get())
                .unlockedBy("has_nether_anthracite", inventoryTrigger(
                        ItemPredicate.Builder.item().of(ModItems.NETHER_ANTHRACITE.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHER_ANTHRACITE.get(), 9)
                .requires(ModBlocks.NETHER_ANTHRACITE_BLOCK.get())
                .unlockedBy("has_nether_anthracite_block", inventoryTrigger(
                        ItemPredicate.Builder.item().of(ModBlocks.NETHER_ANTHRACITE_BLOCK.get()).build()))
                .save(pWriter);
         */
    }


    // --- Recipe Functions -------------------------------------------------------------------------------------------
    /*
        If I decide to put anything here, while it is somewhat detrimental that all recipes default to the 'minecraft'
    namespace, the names are organized in a very methodic way to where modpack devs shouldnt have a such difficult time
    adjusting anything that needs it.  Since it creates so much extra work just to get the crafting recipes in
    MY namespace, I'll only do this for recipes that absolutely need to be in MY namespace.
    */

}
