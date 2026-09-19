package com.forrner.mcpp;

import com.forrner.mcpp.datagen.*;
import com.forrner.mcpp.world.ModOreFeatures;
import com.forrner.mcpp.world.ModOrePlacements;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MCplusplusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockLootTablesProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModEnUsLangProvider::new);
		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModZhCnLangProvider::new);
		pack.addProvider(ModWorldgenProvider::new);
	}
	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.FEATURE, ModOreFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, ModOrePlacements::bootstrap);
	}
}
