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
    private static int burn_time;
    private static String description;

    public FuelItem(int burnTime, String item_description, Properties pProperties) {
        super(pProperties);
        burn_time = burnTime;
        description = item_description;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return burn_time;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponent, TooltipFlag pIsAdvancedFlag) {
        pTooltipComponent.add(Component.translatable(description).withStyle(ChatFormatting.GRAY));
    }
}
