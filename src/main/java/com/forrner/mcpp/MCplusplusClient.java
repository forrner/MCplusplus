package com.forrner.mcpp;

import com.forrner.mcpp.particle.ModParticleTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.FlameParticle;

public class MCplusplusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleProviderRegistry.getInstance().register(ModParticleTypes.BLAZE_FIRE_FLAME,
                FlameParticle.Provider::new);

        ParticleProviderRegistry.getInstance().register(ModParticleTypes.VOIDIUM_FIRE_FLAME,
                FlameParticle.Provider::new);
    }
}
