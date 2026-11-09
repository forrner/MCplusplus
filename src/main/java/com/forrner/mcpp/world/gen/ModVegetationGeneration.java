package com.forrner.mcpp.world.gen;

import com.forrner.mcpp.world.ModVegetationPlacements;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModVegetationGeneration {
    public static void generateVegetation() {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Biomes.SWAMP, Biomes.MANGROVE_SWAMP,
                        Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.REED_PATCH);
    }
}
