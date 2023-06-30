package net.Energyblade7.inscribedbyancients.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
public class ModItem extends Item {

    protected final String description;

    public ModItem(String description, Properties pProperties) {
        super(pProperties);
        this.description = description;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponent, TooltipFlag pIsAdvancedFlag) {
        pTooltipComponent.add(Component.translatable(description).withStyle(ChatFormatting.GRAY));
    }
}
