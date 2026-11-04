package com.forrner.mcpp.world;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class ModFeature {
    public static final Feature<ReedPatchFeature.Config> REED_PATCH_FEATURE =
            register("reed_patch", new ReedPatchFeature(ReedPatchFeature.Config.CODEC));

    public static void register() {

    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(final String name, final F feature) {
        return Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID, name), feature);
    }
}
