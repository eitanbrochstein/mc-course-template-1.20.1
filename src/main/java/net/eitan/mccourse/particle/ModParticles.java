package net.eitan.mccourse.particle;

import net.eitan.mccourse.McCourse;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final DefaultParticleType PINK_GARNET_PARTICLE =
            registerParticle("pink_garnet_particle", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(McCourse.MOD_ID, name), particleType);
    }
    public static void registerParticles() {
        McCourse.LOGGER.info("Registering Particles for " + McCourse.MOD_ID);
    }
}