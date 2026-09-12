package com.forrner.mcpp.datagen;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModEnUsLangProvider extends FabricLanguageProvider {

    public ModEnUsLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput,"en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.DIAMOND_NUGGET,"Diamond Nugget");
        translationBuilder.add(ModItems.TIN_INGOT,"Tin Ingot");
        translationBuilder.add(ModItems.LEAD_INGOT,"Lead Ingot");
        translationBuilder.add(ModItems.RAW_TIN,"Raw Tin");
        translationBuilder.add(ModItems.RAW_LEAD,"Raw Lead");
        translationBuilder.add(ModItems.STRAWBERRY_SEEDS,"Strawberry Seeds");
        translationBuilder.add(ModItems.STRAWBERRY,"Strawberry");
        translationBuilder.add(ModItems.GOLDEN_STRAWBERRY,"Golden Strawberry");
        translationBuilder.add(ModItems.BLAZEFLOWER_SEEDS,"Blazeflower Seeds");
        translationBuilder.add(ModItems.COAL_TAR,"Coal Tar");
        translationBuilder.add(ModItems.LEAD_SWORD,"Lead Sword");
        translationBuilder.add(ModItems.LEAD_SHOVEL,"Lead Shovel");
        translationBuilder.add(ModItems.LEAD_PICKAXE,"Lead Pickaxe");
        translationBuilder.add(ModItems.LEAD_AXE,"Lead Axe");
        translationBuilder.add(ModItems.LEAD_HOE,"Lead Hoe");
        translationBuilder.add(ModItems.LEAD_SPEAR,"Lead Spear");
        translationBuilder.add(ModItems.LEAD_BOW,"Lead Bow");
        translationBuilder.add(ModItems.LEAD_HELMET,"Lead Helmet");
        translationBuilder.add(ModItems.LEAD_CHESTPLATE,"Lead Chestplate");
        translationBuilder.add(ModItems.LEAD_LEGGINGS,"Lead Leggings");
        translationBuilder.add(ModItems.LEAD_BOOTS,"Lead Boots");
        translationBuilder.add(ModItems.BLAZE_SHARD,"Blaze Shard");
        translationBuilder.add(ModItems.BLAZE_CORE,"Blaze Core");
        translationBuilder.add(ModItems.INACTIVE_BLAZE_INGOT,"Inactive Blaze Ingot");
        translationBuilder.add(ModItems.BLAZE_INGOT,"Blaze Ingot");
        translationBuilder.add(ModItems.BLAZE_UPGRADE_SMITHING_TEMPLATE,"Blaze Upgrade");
        translationBuilder.add(ModItems.BLAZE_SWORD,"Blaze Sword");
        translationBuilder.add(ModItems.BLAZE_SHOVEL,"Blaze Shovel");
        translationBuilder.add(ModItems.BLAZE_PICKAXE,"Blaze Pickaxe");
        translationBuilder.add(ModItems.BLAZE_AXE,"Blaze Axe");
        translationBuilder.add(ModItems.BLAZE_HOE,"Blaze Hoe");
        translationBuilder.add(ModItems.BLAZE_SPEAR,"Blaze Spear");
        translationBuilder.add(ModItems.BLAZE_HELMET,"Blaze Helmet");
        translationBuilder.add(ModItems.BLAZE_CHESTPLATE,"Blaze Chestplate");
        translationBuilder.add(ModItems.BLAZE_LEGGINGS,"Blaze Leggings");
        translationBuilder.add(ModItems.BLAZE_BOOTS,"Blaze Boots");
        translationBuilder.add(ModItems.VOIDIUM,"Voidium");
        translationBuilder.add(ModItems.DEPLETED_VOIDIUM,"Depleted Voidium");
        translationBuilder.add(ModItems.VOIDIUM_UPGRADE_SMITHING_TEMPLATE,"Voidium Upgrade");
        translationBuilder.add(ModItems.VOIDIUM_SWORD,"Voidium Sword");
        translationBuilder.add(ModItems.VOIDIUM_SHOVEL,"Voidium Shovel");
        translationBuilder.add(ModItems.VOIDIUM_PICKAXE,"Voidium Pickaxe");
        translationBuilder.add(ModItems.VOIDIUM_AXE,"Voidium Axe");
        translationBuilder.add(ModItems.VOIDIUM_HOE,"Voidium Hoe");
        translationBuilder.add(ModItems.VOIDIUM_SPEAR,"Voidium Spear");
        translationBuilder.add(ModItems.VOIDIUM_HELMET,"Voidium Helmet");
        translationBuilder.add(ModItems.VOIDIUM_CHESTPLATE,"Voidium Chestplate");
        translationBuilder.add(ModItems.VOIDIUM_LEGGINGS,"Voidium Leggings");
        translationBuilder.add(ModItems.VOIDIUM_BOOTS,"Voidium Boots");
        translationBuilder.add(ModItems.LUMEN_FEATHER,"Lumen Feather");
        translationBuilder.add(ModItems.UMBRA_FEATHER,"Umbra Feather");
        translationBuilder.add(ModItems.LUMEN_ELYTRA,"Lumen Elytra");
        translationBuilder.add(ModItems.UMBRA_ELYTRA,"Umbra Elytra");

        translationBuilder.add(ModBlocks.TIN_ORE,"Tin Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_TIN_ORE,"Deepslate Tin Ore");
        translationBuilder.add(ModBlocks.LEAD_ORE,"Lead Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_LEAD_ORE,"Deepslate Lead Ore");
        translationBuilder.add(ModBlocks.TIN_BLOCK,"Tin Block");
        translationBuilder.add(ModBlocks.TIN_STAIRS,"Tin Stairs");
        translationBuilder.add(ModBlocks.TIN_SLAB,"Tin Slab");
        translationBuilder.add(ModBlocks.HOT_OBSIDIAN,"Hot Obsidian");
        translationBuilder.add(ModBlocks.BLAZEFLOWER,"Blazeflower");
        translationBuilder.add(ModBlocks.BLAZE_TORCH,"Blaze Torch");
        translationBuilder.add(ModBlocks.VOIDIUM_ORE,"Voidium Ore");
        translationBuilder.add(ModBlocks.DEPLETED_VOIDIUM_ORE,"Depleted Voidium Ore");
        translationBuilder.add(ModBlocks.VOIDIUM_TORCH,"Voidium Torch");

        translationBuilder.add("itemGroup.mcpp","Minecraft++");
        translationBuilder.add("item.mcpp.smithing_template.blaze_upgrade.applies_to","Netherite Equipment");
        translationBuilder.add("item.mcpp.smithing_template.blaze_upgrade.ingredients","Blaze Ingot");
        translationBuilder.add("item.mcpp.smithing_template.blaze_upgrade.base_slot_description","Add Netherite armor, weapon, or tool");
        translationBuilder.add("item.mcpp.smithing_template.blaze_upgrade.additions_slot_description","Add Blaze Ingot");
        translationBuilder.add("item.mcpp.smithing_template.voidium_upgrade.applies_to","Blaze Equipment");
        translationBuilder.add("item.mcpp.smithing_template.voidium_upgrade.ingredients","Voidium");
        translationBuilder.add("item.mcpp.smithing_template.voidium_upgrade.base_slot_description","Add Blaze armor, weapon, or tool");
        translationBuilder.add("item.mcpp.smithing_template.voidium_upgrade.additions_slot_description","Add Voidium");
        translationBuilder.add("item.mcpp.armor.set_bonus","Set Bonus:");
        translationBuilder.add("item.mcpp.armor.blazearmor_effect","Fire Resistance");
        translationBuilder.add("item.mcpp.armor.voidiumarmor_effect","Night Vision  SpeedII" );
        translationBuilder.add("message.mcpp.enderdragonkilled","§1The curtain of shadow rises.§dRadiance spills out from the void.");
    }
}
