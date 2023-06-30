package net.Energyblade7.inscribedbyancients.item.custom;


import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends ModItem {
    private int smeltOperations;

    public FuelItem(String description, Properties pProperties, int smeltOperations) {
        super(description, pProperties);
        this.smeltOperations = smeltOperations * 200;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return smeltOperations;
    }

}
