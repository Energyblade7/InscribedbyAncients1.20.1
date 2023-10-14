package net.Energyblade7.inscribedbyancients.event;


import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.particle.ModParticleTypes;
import net.Energyblade7.inscribedbyancients.particle.custom.DreckLeavesParticle;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InscribedbyAncients.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    // --- Event Subscribers -------------------------------------------------------------------------------------------
    @SubscribeEvent
    public static void registerParticleFactory(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.DRECK_TALLOW_LEAVES.get(), DreckLeavesParticle.Provider:: new);
    }


    // -----------------------------------------------------------------------------------------------------------------

}
