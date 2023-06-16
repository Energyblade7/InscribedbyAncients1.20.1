package net.Energyblade7.inscribedbyancients.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ArcheologistsJournal extends Item {
    public ArcheologistsJournal(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponent,
                                TooltipFlag pIsAdvancedFlag) {

        pTooltipComponent.add(Component.translatable("tooltip.inscribedbyancients.archeologists_journal_1").withStyle(ChatFormatting.GRAY));
    }
}
