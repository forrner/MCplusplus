package com.forrner.mcpp.item.equipment;

import com.forrner.mcpp.tag.ModItemTags;
import com.google.common.collect.Maps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.Map;

public interface ModArmorMaterials {
    ArmorMaterial LEAD = new ArmorMaterial(
            24, makeDefense(3, 5, 6, 3, 6),
            9, SoundEvents.ARMOR_EQUIP_IRON,
            0.0F, 0.0F, ModItemTags.REPAIRS_LEAD_ARMOR, ModEquipmentAssets.LEAD);

    ArmorMaterial BLAZE = new ArmorMaterial(
            37, makeDefense(4, 7, 9, 4, 20),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0F, 0.3F, ModItemTags.REPAIRS_BLAZE_ARMOR, ModEquipmentAssets.BLAZE);

    ArmorMaterial VOIDIUM = new ArmorMaterial(
            37, makeDefense(6, 8, 10, 6, 30),
            25, SoundEvents.ARMOR_EQUIP_NETHERITE,
            5.0F, 0.5F, ModItemTags.REPAIRS_VOIDIUM_ARMOR, ModEquipmentAssets.VOIDIUM);


    static Map<ArmorType, Integer> makeDefense(final int boots, final int legs, final int chest, final int helm, final int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }

}
