package com.forrner.mcpp;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.item.ModCreativeModeTabs;
import com.forrner.mcpp.item.ModItems;
import com.forrner.mcpp.loot.ModLootTableModifications;
import com.forrner.mcpp.util.ModArmorEffects;
import com.forrner.mcpp.util.ModElytra;
import com.forrner.mcpp.util.ModEvents;
import com.forrner.mcpp.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCplusplus implements ModInitializer {
	public static final String MOD_ID = "mcpp";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.register();
		ModItems.register();
		ModCreativeModeTabs.register();
		ModWorldGeneration.register();
		ModLootTableModifications.register();
		ModArmorEffects.register();
		ModElytra.register();
		ModEvents.register();

		LOGGER.info(MOD_ID + " has been loaded!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
