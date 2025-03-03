package net.eitan.mccourse.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class PinkGarnetParticle extends SpriteBillboardParticle {

    protected PinkGarnetParticle(ClientWorld clientWorld, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd) {
        // the xd, yd, and zd are the change in the x, y, and z directions
        super(clientWorld, xCoord, yCoord, zCoord, xd, yd, zd);

        this.velocityMultiplier = 0.5f;
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;

        this.scale *= 0.75f;
        this.maxAge = 10;
        this.setSpriteForAge(spriteSet);

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld,
                                       double x, double y, double z, double xd, double yd, double zd) {
            return new PinkGarnetParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}
