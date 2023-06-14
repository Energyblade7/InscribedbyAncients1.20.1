package net.Energyblade7.inscribedbyancients.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ArtifactItem extends Item {
    public ArtifactItem(Item.Properties p_41383_) {
        super(p_41383_);

    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponent,
                                TooltipFlag pIsAdvancedFlag) {

        if (Screen.hasShiftDown()) {
            pTooltipComponent.add(Component.translatable("tooltip.inscribedbyancients.artifact.shift").withStyle(ChatFormatting.ITALIC));


        } else {
            pTooltipComponent.add(Component.translatable("tooltip.inscribedbyancients.artifact.inscription").withStyle(ChatFormatting.GRAY));

        }
    }
}
