package net.Energyblade7.inscribedbyancients.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DreckLeavesParticle extends CherryParticle {

    protected DreckLeavesParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet pSpriteSet) {
        super(pLevel, pX, pY, pZ, pSpriteSet);
    }


    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double pX, double pY, double pZ,
                                       double pXSpeed, double pYSpeed, double pZSpead) {
            return new DreckLeavesParticle(level, pX, pY, pZ, this.sprites);
        }
    }
}
