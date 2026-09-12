package com.forrner.mcpp.particle;

import com.forrner.mcpp.MCplusplus;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;


public class ModParticleTypes {

    public static final SimpleParticleType BLAZE_FIRE_FLAME = register("blaze_fire_flame", false);
    public static final SimpleParticleType VOIDIUM_FIRE_FLAME = register("voidium_fire_flame", false);

    private static SimpleParticleType register(final String name, final boolean alwaysSpawn) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,name),
                FabricParticleTypes.simple(alwaysSpawn));
    }

}
