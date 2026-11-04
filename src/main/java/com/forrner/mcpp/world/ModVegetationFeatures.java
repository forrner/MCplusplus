package com.forrner.mcpp.world;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModVegetationFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> REED_PATCH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, MCplusplus.id("reed_patch")
    );

    public static void bootstrap(final BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // reed_count     : 一丛最多长多少株
        // search_radius  : 水平候选池半径，越大越容易长满一丛
        // max_radius     : 丛半径上限。这是抑制"沿河岸线状分布"的主要旋钮，
        //                  调小就更抱团、更不像线；调大允许一丛摊得更开。
        // max_spacing    : 新株必须落在已有芦苇 N 格以内；决定一丛能长多大。
        //                  =2 时算上斜角一丛约 9 株，=3 约 21 株。
        // vertical_range : 垂直搜索半径
        FeatureUtils.register(context, REED_PATCH, ModFeature.REED_PATCH_FEATURE,
                new ReedPatchFeature.Config(40, 6, 4, 4, 3));
    }
}
