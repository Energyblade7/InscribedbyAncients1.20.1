package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> NETHER_ANTHRACITE_ORE = List.of(ModBlocks.NETHER_ANTHRACITE_ORE.get());
    private static final List<ItemLike> METALLIC_ARTIFACTS = List.of(ModItems.ANTIQUE_APPARATUS.get(), ModItems.ANCIENT_RELIC.get());
    private static final List<ItemLike> ORGANIC_ARTIFACTS = List.of(ModItems.GNARLED_EFFIGY.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        //------------------------------------------------------------------------------------------------------------
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.NETHER_ANTHRACITE.get(), RecipeCategory.MISC, ModBlocks.NETHER_ANTHRACITE_BLOCK.get()
            ,"inscribedbyancients:nether_anthracite", "inscribedbyancients:nether_anthracite", "inscribedbyancients:nether_anthracite_block", "inscribedbyancients:nether_anthracite");
        oreBlasting(pWriter, NETHER_ANTHRACITE_ORE, RecipeCategory.MISC, ModItems.NETHER_ANTHRACITE.get(), 2F, 100, "inscribedbyancients:nether_anthracite");
        oreSmelting(pWriter, NETHER_ANTHRACITE_ORE, RecipeCategory.MISC, ModItems.NETHER_ANTHRACITE.get(), 1.2F, 200, "inscribedbyancients:nether_anthracite");

        oreSmelting(pWriter, METALLIC_ARTIFACTS, RecipeCategory.MISC, ModItems.ANCIENT_ALLOY.get(), 1.5F, 200, "inscribedbyancients:metallic_artifacts");
        oreSmelting(pWriter, ORGANIC_ARTIFACTS, RecipeCategory.MISC, Items.CHARCOAL, 1.5F, 200, "inscribedbyancients:organic_artifacts");
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



    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, InscribedbyAncients.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
