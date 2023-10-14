package net.Energyblade7.inscribedbyancients.particle;

import com.mojang.serialization.Codec;
import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModParticleTypes {

   public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
           DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, InscribedbyAncients.MOD_ID);
    // --- Particle Registry ------------------------------------------------------------------------------------------
    public static final RegistryObject<SimpleParticleType> DRECK_TALLOW_LEAVES = PARTICLE_TYPES.register("dreck_tallow_leaves", () -> new SimpleParticleType(true));



    //-----------------------------------------------------------------------------------------------------------------

    public static void register(IEventBus eventbus){
        PARTICLE_TYPES.register(eventbus);
    }

}
