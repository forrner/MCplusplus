package com.forrner.mcpp.world;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class ModVegetationPlacements {
    public static final ResourceKey<PlacedFeature> REED_PATCH = ResourceKey.create(
            Registries.PLACED_FEATURE, MCplusplus.id("reed_patch")
    );

    /**
     * 每个区块生成芦苇的概率分母：即 1/REED_CHANCE 的概率。
     * 调大 = 更稀少，调小 = 更常见。想要"每区块 X% 概率"就写 round(100 / X)。
     */
    private static final int REED_CHANCE = 2;

    public static void bootstrap(final BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> reedPatch = configuredFeatures.getOrThrow(ModVegetationFeatures.REED_PATCH);

        PlacementUtils.register(context, REED_PATCH, reedPatch, List.<PlacementModifier>of(
                RarityFilter.onAverageOnceEvery(REED_CHANCE),
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR),
                BiomeFilter.biome()
        ));
    }
}
