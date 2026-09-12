package com.forrner.mcpp.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3F).build();
    public static final FoodProperties GOLDEN_STRAWBERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(1.2F).alwaysEdible().build();
}
