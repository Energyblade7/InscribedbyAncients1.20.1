package net.Energyblade7.inscribedbyancients.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FuelItem extends Item {
    private int burnTime;
    private String description;

    public FuelItem(int burnTime, String description, Properties pProperties) {
        super(pProperties);
        this.burnTime = burnTime * 200;
        this.description = description;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return burnTime;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponent, TooltipFlag pIsAdvancedFlag) {
        pTooltipComponent.add(Component.translatable(description).withStyle(ChatFormatting.GRAY));
    }
}
