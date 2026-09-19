package com.forrner.mcpp.world;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacements {
    public static final ResourceKey<PlacedFeature> ORE_TIN =  createKey("ore_tin");
    public static final ResourceKey<PlacedFeature> ORE_LEAD = createKey("ore_lead");
    public static final ResourceKey<PlacedFeature> ORE_HOT_OBSIDIAN = createKey("ore_hot_obsidian");
    public static final ResourceKey<PlacedFeature> ORE_VOIDIUM = createKey("ore_voidium");
    public static final ResourceKey<PlacedFeature> ORE_DEPLETED_VOIDIUM = createKey("ore_depleted_voidium");
    public static ResourceKey<PlacedFeature> createKey(final String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, MCplusplus.id(name));
    }


    private static List<PlacementModifier> orePlacement(final PlacementModifier frequencyModifier, final PlacementModifier heightRange) {
        return List.of(frequencyModifier, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(final int count, final PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(final int rarity, final PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), heightRange);
    }

    public static void bootstrap(final BootstrapContext<PlacedFeature> context) {
        HolderGetter<Feature> configuredFeatures = context.lookup(Registries.FEATURE);
        Holder<Feature> oreTin = configuredFeatures.getOrThrow(ModOreFeatures.ORE_TIN);
        Holder<Feature> oreLead = configuredFeatures.getOrThrow(ModOreFeatures.ORE_LEAD);
        Holder<Feature> oreHotObsidian = configuredFeatures.getOrThrow(ModOreFeatures.ORE_HOT_OBSIDIAN);
        Holder<Feature> oreVoidium = configuredFeatures.getOrThrow(ModOreFeatures.ORE_VOIDIUM);
        Holder<Feature> oreDepletedVoidium = configuredFeatures.getOrThrow(ModOreFeatures.ORE_DEPLETED_VOIDIUM);

        PlacementUtils.register(
                context, ORE_TIN, oreTin, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))
        );
        PlacementUtils.register(
                context, ORE_LEAD, oreLead, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(40)))
        );
        PlacementUtils.register(
                context,
                ORE_HOT_OBSIDIAN,
                oreHotObsidian,
                InSquarePlacement.spread(),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(100), VerticalAnchor.absolute(124)),
                BiomeFilter.biome()
        );
        PlacementUtils.register(
                context, ORE_VOIDIUM, oreVoidium, commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(10), VerticalAnchor.absolute(40)))
        );
        PlacementUtils.register(
                context, ORE_DEPLETED_VOIDIUM, oreDepletedVoidium, commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(40)))
        );
    }
}
