package com.forrner.mcpp.datagen;

import com.forrner.mcpp.references.ModItemIds;
import com.forrner.mcpp.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {

    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    protected void addTags(HolderLookup.Provider provider) {
        builder(ItemTags.HEAD_ARMOR)
                .add(ModItemIds.LEAD_HELMET)
                .add(ModItemIds.BLAZE_HELMET)
                .add(ModItemIds.VOIDIUM_HELMET);

        builder(ItemTags.CHEST_ARMOR)
                .add(ModItemIds.LEAD_CHESTPLATE)
                .add(ModItemIds.BLAZE_CHESTPLATE)
                .add(ModItemIds.VOIDIUM_CHESTPLATE);

        builder(ItemTags.LEG_ARMOR)
                .add(ModItemIds.LEAD_LEGGINGS)
                .add(ModItemIds.BLAZE_LEGGINGS)
                .add(ModItemIds.VOIDIUM_LEGGINGS);

        builder(ItemTags.FOOT_ARMOR)
                .add(ModItemIds.LEAD_BOOTS)
                .add(ModItemIds.BLAZE_BOOTS)
                .add(ModItemIds.VOIDIUM_BOOTS);

        builder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItemIds.LEAD_HELMET)
                .add(ModItemIds.LEAD_CHESTPLATE)
                .add(ModItemIds.LEAD_LEGGINGS)
                .add(ModItemIds.LEAD_BOOTS)
                .add(ModItemIds.BLAZE_HELMET)
                .add(ModItemIds.BLAZE_CHESTPLATE)
                .add(ModItemIds.BLAZE_LEGGINGS)
                .add(ModItemIds.BLAZE_BOOTS)
                .add(ModItemIds.VOIDIUM_HELMET)
                .add(ModItemIds.VOIDIUM_CHESTPLATE)
                .add(ModItemIds.VOIDIUM_LEGGINGS)
                .add(ModItemIds.VOIDIUM_BOOTS);

        builder(ItemTags.SWORDS)
                .add(ModItemIds.LEAD_SWORD)
                .add(ModItemIds.BLAZE_SWORD)
                .add(ModItemIds.VOIDIUM_SWORD);

        builder(ItemTags.SHOVELS)
                .add(ModItemIds.LEAD_SHOVEL)
                .add(ModItemIds.BLAZE_SHOVEL)
                .add(ModItemIds.VOIDIUM_SHOVEL);

        builder(ItemTags.PICKAXES)
                .add(ModItemIds.LEAD_PICKAXE)
                .add(ModItemIds.BLAZE_PICKAXE)
                .add(ModItemIds.VOIDIUM_PICKAXE);

        builder(ItemTags.AXES)
                .add(ModItemIds.LEAD_AXE)
                .add(ModItemIds.BLAZE_AXE)
                .add(ModItemIds.VOIDIUM_AXE);

        builder(ItemTags.HOES)
                .add(ModItemIds.LEAD_HOE)
                .add(ModItemIds.BLAZE_HOE)
                .add(ModItemIds.VOIDIUM_HOE);

        builder(ItemTags.SPEARS)
                .add(ModItemIds.LEAD_SPEAR)
                .add(ModItemIds.BLAZE_SPEAR)
                .add(ModItemIds.VOIDIUM_SPEAR);

        builder(ItemTags.SKELETON_PREFERRED_WEAPONS)
                .add(ModItemIds.LEAD_BOW);

        builder(ItemTags.WITHER_SKELETON_DISLIKED_WEAPONS)
                .add(ModItemIds.LEAD_BOW);

        builder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItemIds.LEAD_BOW);

        builder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItemIds.LUMEN_ELYTRA)
                .add(ModItemIds.UMBRA_ELYTRA);

        builder(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(ModItemIds.LUMEN_ELYTRA)
                .add(ModItemIds.UMBRA_ELYTRA);

        builder(ModItemTags.SUGAR)
                .add(ItemIds.BEETROOT)
                .add(ModItemIds.STRAWBERRY);

        builder(ModItemTags.LEAD_TOOL_MATERIALS)
                .add(ModItemIds.LEAD_INGOT);

        builder(ModItemTags.REPAIRS_LEAD_ARMOR)
                .add(ModItemIds.LEAD_INGOT);

        builder(ModItemTags.BLAZE_TOOL_MATERIALS)
                .add(ModItemIds.BLAZE_INGOT);

        builder(ModItemTags.REPAIRS_BLAZE_ARMOR)
                .add(ModItemIds.BLAZE_INGOT);

        builder(ModItemTags.VOIDIUM_TOOL_MATERIALS)
                .add(ModItemIds.VOIDIUM);

        builder(ModItemTags.REPAIRS_VOIDIUM_ARMOR)
                .add(ModItemIds.VOIDIUM);

        builder(ModItemTags.BLAZE_ARMOR)
                .add(ModItemIds.BLAZE_HELMET)
                .add(ModItemIds.BLAZE_CHESTPLATE)
                .add(ModItemIds.BLAZE_LEGGINGS)
                .add(ModItemIds.BLAZE_BOOTS);

        builder(ModItemTags.VOIDIUM_ARMOR)
                .add(ModItemIds.VOIDIUM_HELMET)
                .add(ModItemIds.VOIDIUM_CHESTPLATE)
                .add(ModItemIds.VOIDIUM_LEGGINGS)
                .add(ModItemIds.VOIDIUM_BOOTS);

    }
}