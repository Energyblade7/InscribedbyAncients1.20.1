package net.Energyblade7.inscribedbyancients.event;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.Energyblade7.inscribedbyancients.player.capabilities.PlayerLinguisticsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;


@Mod.EventBusSubscriber(modid = InscribedbyAncients.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    // --- Event Subscribers -------------------------------------------------------------------------------------------

    @SubscribeEvent
    public static void returnArcheologistsJournal(PlayerInteractEvent.RightClickBlock event) {

        if (!event.getItemStack().is(Items.WRITABLE_BOOK)
                || event.getItemStack().getDamageValue() != 1) return;

        event.getLevel().setBlockAndUpdate(event.getPos(), ModBlocks.DULL_TILE.get().withPropertiesOf(event.getLevel().getBlockState(event.getPos())));
        event.getEntity().setItemSlot(Objects.requireNonNull(event.getEntity().getItemInHand(event.getHand()).getEquipmentSlot()), ModItems.ARCHEOLOGISTS_JOURNAL.get().getDefaultInstance());
        event.getLevel().playSound(null, event.getPos(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1F, 0.3F);
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(!(event.getObject() instanceof Player)) return;

        if(event.getObject().getCapability(PlayerLinguisticsProvider.PLAYER_LINGUISTICS).isPresent()) return;

        event.addCapability(new ResourceLocation(InscribedbyAncients.MOD_ID, "properties"), new PlayerLinguisticsProvider());
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(!event.isWasDeath()) return;

        event.getOriginal().reviveCaps();


        event.getOriginal().getCapability(PlayerLinguisticsProvider.PLAYER_LINGUISTICS).ifPresent(oldStore ->
                event.getEntity().getCapability(PlayerLinguisticsProvider.PLAYER_LINGUISTICS).ifPresent(newStore ->
                        newStore.copyFrom(oldStore)));


        event.getOriginal().invalidateCaps();
    }

    // -----------------------------------------------------------------------------------------------------------------
}
