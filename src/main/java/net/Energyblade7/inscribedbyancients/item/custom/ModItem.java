package net.Energyblade7.inscribedbyancients.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
public class ModItem extends Item {

    protected final String description;
    protected final String shiftDescription;

    public ModItem(String description, @Nullable String shiftDescription, Properties pProperties) {
        super(pProperties);
        this.description = description;
        this.shiftDescription = shiftDescription;
    }


    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponent, TooltipFlag pIsAdvancedFlag) {

        if (Screen.hasShiftDown() && shiftDescription != null) {
            pTooltipComponent.add(Component.translatable(shiftDescription).withStyle(ChatFormatting.ITALIC));


        } else {
            pTooltipComponent.add(Component.translatable(description).withStyle(ChatFormatting.GRAY));

        }
    }


}
