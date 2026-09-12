package com.forrner.mcpp.datagen;

import com.forrner.mcpp.item.ModItems;
import com.forrner.mcpp.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {

    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.LEAD_HELMET)
                .add(ModItems.BLAZE_HELMET)
                .add(ModItems.VOIDIUM_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.LEAD_CHESTPLATE)
                .add(ModItems.BLAZE_CHESTPLATE)
                .add(ModItems.VOIDIUM_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.LEAD_LEGGINGS)
                .add(ModItems.BLAZE_LEGGINGS)
                .add(ModItems.VOIDIUM_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.LEAD_BOOTS)
                .add(ModItems.BLAZE_BOOTS)
                .add(ModItems.VOIDIUM_BOOTS);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.LEAD_HELMET)
                .add(ModItems.LEAD_CHESTPLATE)
                .add(ModItems.LEAD_LEGGINGS)
                .add(ModItems.LEAD_BOOTS)
                .add(ModItems.BLAZE_HELMET)
                .add(ModItems.BLAZE_CHESTPLATE)
                .add(ModItems.BLAZE_LEGGINGS)
                .add(ModItems.BLAZE_BOOTS)
                .add(ModItems.VOIDIUM_HELMET)
                .add(ModItems.VOIDIUM_CHESTPLATE)
                .add(ModItems.VOIDIUM_LEGGINGS)
                .add(ModItems.VOIDIUM_BOOTS);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.LEAD_SWORD)
                .add(ModItems.BLAZE_SWORD)
                .add(ModItems.VOIDIUM_SWORD);

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.LEAD_SHOVEL)
                .add(ModItems.BLAZE_SHOVEL)
                .add(ModItems.VOIDIUM_SHOVEL);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.LEAD_PICKAXE)
                .add(ModItems.BLAZE_PICKAXE)
                .add(ModItems.VOIDIUM_PICKAXE);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.LEAD_AXE)
                .add(ModItems.BLAZE_AXE)
                .add(ModItems.VOIDIUM_AXE);

        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.LEAD_HOE)
                .add(ModItems.BLAZE_HOE)
                .add(ModItems.VOIDIUM_HOE);

        valueLookupBuilder(ItemTags.SPEARS)
                .add(ModItems.LEAD_SPEAR)
                .add(ModItems.BLAZE_SPEAR)
                .add(ModItems.VOIDIUM_SPEAR);

        valueLookupBuilder(ItemTags.SKELETON_PREFERRED_WEAPONS)
                .add(ModItems.LEAD_BOW);

        valueLookupBuilder(ItemTags.WITHER_SKELETON_DISLIKED_WEAPONS)
                .add(ModItems.LEAD_BOW);

        valueLookupBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.LEAD_BOW);

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.LUMEN_ELYTRA)
                .add(ModItems.UMBRA_ELYTRA);

        valueLookupBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(ModItems.LUMEN_ELYTRA)
                .add(ModItems.UMBRA_ELYTRA);

        valueLookupBuilder(ModItemTags.SUGAR)
                .add(Items.BEETROOT)
                .add(ModItems.STRAWBERRY);

        valueLookupBuilder(ModItemTags.LEAD_TOOL_MATERIALS)
                .add(ModItems.LEAD_INGOT);

        valueLookupBuilder(ModItemTags.REPAIRS_LEAD_ARMOR)
                .add(ModItems.LEAD_INGOT);

        valueLookupBuilder(ModItemTags.BLAZE_TOOL_MATERIALS)
                .add(ModItems.BLAZE_INGOT);

        valueLookupBuilder(ModItemTags.REPAIRS_BLAZE_ARMOR)
                .add(ModItems.BLAZE_INGOT);

        valueLookupBuilder(ModItemTags.VOIDIUM_TOOL_MATERIALS)
                .add(ModItems.VOIDIUM);

        valueLookupBuilder(ModItemTags.REPAIRS_VOIDIUM_ARMOR)
                .add(ModItems.VOIDIUM);

        valueLookupBuilder(ModItemTags.BLAZE_ARMOR)
                .add(ModItems.BLAZE_HELMET)
                .add(ModItems.BLAZE_CHESTPLATE)
                .add(ModItems.BLAZE_LEGGINGS)
                .add(ModItems.BLAZE_BOOTS);

        valueLookupBuilder(ModItemTags.VOIDIUM_ARMOR)
                .add(ModItems.VOIDIUM_HELMET)
                .add(ModItems.VOIDIUM_CHESTPLATE)
                .add(ModItems.VOIDIUM_LEGGINGS)
                .add(ModItems.VOIDIUM_BOOTS);

    }
}