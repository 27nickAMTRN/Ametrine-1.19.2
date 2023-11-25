package net.nick.ametrine.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nick.ametrine.Ametrine;

public class ModParticleTypes {
    public static final DefaultParticleType AMETRINE_SWEEP_ATTACK_PARTICLE =
            registerParticle("ametrine_sweep_attack_particle", FabricParticleTypes.simple());

    public static final DefaultParticleType WARFAN_BLADE_PARTICLE =
            registerParticle("warfan_blade_particle", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType alwaysShow) {
        return Registry.register(Registry.PARTICLE_TYPE, new Identifier(Ametrine.MOD_ID, name), alwaysShow);
    }


    public static void registerParticles() {
        Ametrine.LOGGER.info("Registering Particles for" + Ametrine.MOD_ID);
    }
}
