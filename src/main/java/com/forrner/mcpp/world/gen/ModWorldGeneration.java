package com.forrner.mcpp.world.gen;

import com.forrner.mcpp.world.ModFeatureTypes;

public class ModWorldGeneration {
    public static void register(){
        // 自定义 feature 类型必须写进静态注册表 BuiltInRegistries.FEATURE_TYPE，
        // 且要早于任何数据包加载，所以放在这里第一次调用。
        ModFeatureTypes.register();
        ModOreGeneration.generateOres();
        ModVegetationGeneration.generateVegetation();
    }
}
