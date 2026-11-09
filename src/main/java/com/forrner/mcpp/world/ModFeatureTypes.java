package com.forrner.mcpp.world;

import com.forrner.mcpp.MCplusplus;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModFeatureTypes {

    public static final MapCodec<ReedPatchFeature> REED_PATCH = ReedPatchFeature.CODEC;

    public static void register() {
        Registry.register(BuiltInRegistries.FEATURE_TYPE, MCplusplus.id("reed_patch"), REED_PATCH);
    }
}
