package com.forrner.mcpp.world.gen;

import com.forrner.mcpp.MCplusplus;
import com.forrner.mcpp.world.ModOrePlacements;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        MCplusplus.LOGGER.info("Registering ores for "+MCplusplus.MOD_ID);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_TIN);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_LEAD);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_HOT_OBSIDIAN);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.END_BARRENS,Biomes.END_HIGHLANDS,Biomes.END_HIGHLANDS),
                GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_VOIDIUM);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.END_BARRENS,Biomes.END_HIGHLANDS,Biomes.END_HIGHLANDS),
                GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_DEPLETED_VOIDIUM);
    }
}
