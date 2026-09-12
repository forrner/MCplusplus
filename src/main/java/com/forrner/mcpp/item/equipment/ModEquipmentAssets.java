package com.forrner.mcpp.item.equipment;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public interface ModEquipmentAssets {

    ResourceKey<EquipmentAsset> LEAD = createId("lead");
    ResourceKey<EquipmentAsset> BLAZE = createId("blaze");
    ResourceKey<EquipmentAsset> VOIDIUM = createId("voidium");
    ResourceKey<EquipmentAsset> LUMEN_ELYTRA = createId("lumen_elytra");
    ResourceKey<EquipmentAsset> UMBRA_ELYTRA = createId("umbra_elytra");

    static ResourceKey<EquipmentAsset> createId(final String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID, name));
    }
}
