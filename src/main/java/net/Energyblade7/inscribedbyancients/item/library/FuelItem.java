package net.Energyblade7.inscribedbyancients.item.library;


import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends IBAItem {
    private int smeltOperations;

    public FuelItem(String description, @Nullable String shiftDescription, Properties pProperties, float smeltOperations) {
        super(description, shiftDescription, pProperties);
        this.smeltOperations = (int) smeltOperations * 200;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return smeltOperations;
    }
}
