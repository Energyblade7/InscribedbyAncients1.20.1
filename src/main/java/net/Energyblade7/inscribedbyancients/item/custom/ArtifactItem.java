package net.Energyblade7.inscribedbyancients.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArtifactItem extends ModItem {

    private static final String shiftDescription = "tooltip.inscribedbyancients.artifactitem.shift";
    public ArtifactItem(String description, Properties pProperties) {
        super(description, shiftDescription, pProperties);
    }


}
