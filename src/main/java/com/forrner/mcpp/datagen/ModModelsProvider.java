package com.forrner.mcpp.datagen;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.block.custom.StrawberryCrop;
import com.forrner.mcpp.item.ModItems;
import com.forrner.mcpp.item.equipment.ModEquipmentAssets;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.ItemModelGenerators.*;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.TIN_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_TIN_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.LEAD_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_LEAD_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.HOT_OBSIDIAN);
        blockModelGenerators.createTrivialCube(ModBlocks.VOIDIUM_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEPLETED_VOIDIUM_ORE);

        blockModelGenerators.createNormalTorch(ModBlocks.BLAZE_TORCH, ModBlocks.BLAZE_WALL_TORCH);
        blockModelGenerators.createNormalTorch(ModBlocks.VOIDIUM_TORCH, ModBlocks.VOIDIUM_WALL_TORCH);

        blockModelGenerators.family(ModBlocks.TIN_BLOCK)
                .stairs(ModBlocks.TIN_STAIRS)
                .slab(ModBlocks.TIN_SLAB);

        blockModelGenerators.createCropBlock(ModBlocks.STRAWBERRY_CROP, StrawberryCrop.AGE,0,1,2,3,4,5);
        blockModelGenerators.createCrossBlock(ModBlocks.BLAZEFLOWER_CROP, BlockModelGenerators.PlantType.NOT_TINTED, BlockStateProperties.AGE_1, 0, 1);
        blockModelGenerators.createPlantWithDefaultItem(ModBlocks.BLAZEFLOWER, ModBlocks.POTTED_BLAZEFLOWER, BlockModelGenerators.PlantType.NOT_TINTED);
    }


    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.DIAMOND_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TIN_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEAD_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_TIN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_LEAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STRAWBERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLDEN_STRAWBERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COAL_TAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLAZE_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLAZE_CORE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.INACTIVE_BLAZE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLAZE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLAZE_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VOIDIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DEPLETED_VOIDIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VOIDIUM_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LUMEN_FEATHER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.UMBRA_FEATHER, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateTrimmableItem(ModItems.LEAD_HELMET, ModEquipmentAssets.LEAD, TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.LEAD_CHESTPLATE, ModEquipmentAssets.LEAD, TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.LEAD_LEGGINGS, ModEquipmentAssets.LEAD, TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.LEAD_BOOTS, ModEquipmentAssets.LEAD, TRIM_PREFIX_BOOTS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.BLAZE_HELMET, ModEquipmentAssets.BLAZE, TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.BLAZE_CHESTPLATE, ModEquipmentAssets.BLAZE, TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.BLAZE_LEGGINGS, ModEquipmentAssets.BLAZE, TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.BLAZE_BOOTS, ModEquipmentAssets.BLAZE, TRIM_PREFIX_BOOTS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.VOIDIUM_HELMET, ModEquipmentAssets.VOIDIUM, TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.VOIDIUM_CHESTPLATE, ModEquipmentAssets.VOIDIUM, TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.VOIDIUM_LEGGINGS, ModEquipmentAssets.VOIDIUM, TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.VOIDIUM_BOOTS, ModEquipmentAssets.VOIDIUM, TRIM_PREFIX_BOOTS, false);

        itemModelGenerators.generateFlatItem(ModItems.LEAD_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEAD_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEAD_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEAD_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEAD_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLAZE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLAZE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLAZE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLAZE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLAZE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VOIDIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VOIDIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VOIDIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VOIDIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VOIDIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateSpear(ModItems.LEAD_SPEAR);
        itemModelGenerators.generateSpear(ModItems.BLAZE_SPEAR);
        itemModelGenerators.generateSpear(ModItems.VOIDIUM_SPEAR);

        itemModelGenerators.generateBow(ModItems.LEAD_BOW);

        itemModelGenerators.generateElytra(ModItems.LUMEN_ELYTRA);
        itemModelGenerators.generateElytra(ModItems.UMBRA_ELYTRA);
    }
}