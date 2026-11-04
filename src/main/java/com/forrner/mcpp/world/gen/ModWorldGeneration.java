package com.forrner.mcpp.world.gen;

import com.forrner.mcpp.world.ModFeature;

public class ModWorldGeneration {
    public static void register(){
        ModFeature.register();
        ModOreGeneration.generateOres();
        ModVegetationGeneration.generateVegetation();
    }
}