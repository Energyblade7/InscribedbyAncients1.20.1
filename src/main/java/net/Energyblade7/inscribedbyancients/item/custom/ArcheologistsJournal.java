package net.Energyblade7.inscribedbyancients.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;


public class ArcheologistsJournal extends ModItem {


    public ArcheologistsJournal(String description, Properties pProperties) {
        super(description, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponent,
                                TooltipFlag pIsAdvancedFlag) {

        if (Screen.hasShiftDown()) {
            pTooltipComponent.add(Component.translatable("tooltip.inscribedbyancients.archeologists_journal.shift").withStyle(ChatFormatting.ITALIC));


        } else {
            pTooltipComponent.add(Component.translatable(description).withStyle(ChatFormatting.GRAY));

        }
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        if (!useOnContext.getLevel().isClientSide) {
            BlockPos isinscribed = useOnContext.getClickedPos();
            Player player = useOnContext.getPlayer();

            BlockState block = useOnContext.getLevel().getBlockState(isinscribed);

            if (isInscribedBlock(block)) {}
        }

        return InteractionResult.SUCCESS;
    }

    private boolean isInscribedBlock(BlockState block) {
        return block.is(Blocks.CRACKED_STONE_BRICKS);
    }

}
