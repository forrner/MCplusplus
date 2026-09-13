package com.forrner.mcpp.references;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class ModItemIds {
    public static final ResourceKey<Item> DIAMOND_NUGGET = create("diamond_nugget");
    public static final ResourceKey<Item> TIN_INGOT = create("tin_ingot");
    public static final ResourceKey<Item> LEAD_INGOT = create("lead_ingot");
    public static final ResourceKey<Item> RAW_TIN = create("raw_tin");
    public static final ResourceKey<Item> RAW_LEAD = create("raw_lead");
    public static final ResourceKey<Item> COAL_TAR = create("coal_tar");
    public static final ResourceKey<Item> STRAWBERRY = create("strawberry");
    public static final ResourceKey<Item> GOLDEN_STRAWBERRY = create("golden_strawberry");
    public static final ResourceKey<Item> LEAD_SWORD = create("lead_sword");
    public static final ResourceKey<Item> LEAD_SHOVEL = create("lead_shovel");
    public static final ResourceKey<Item> LEAD_PICKAXE = create("lead_pickaxe");
    public static final ResourceKey<Item> LEAD_AXE = create("lead_axe");
    public static final ResourceKey<Item> LEAD_HOE = create("lead_hoe");
    public static final ResourceKey<Item> LEAD_SPEAR = create("lead_spear");
    public static final ResourceKey<Item> LEAD_BOW = create("lead_bow");
    public static final ResourceKey<Item> LEAD_HELMET = create("lead_helmet");
    public static final ResourceKey<Item> LEAD_CHESTPLATE = create("lead_chestplate");
    public static final ResourceKey<Item> LEAD_LEGGINGS = create("lead_leggings");
    public static final ResourceKey<Item> LEAD_BOOTS = create("lead_boots");
    public static final ResourceKey<Item> BLAZE_SHARD = create("blaze_shard");
    public static final ResourceKey<Item> BLAZE_CORE = create("blaze_core");
    public static final ResourceKey<Item> INACTIVE_BLAZE_INGOT = create("inactive_blaze_ingot");
    public static final ResourceKey<Item> BLAZE_INGOT = create("blaze_ingot");
    public static final ResourceKey<Item> BLAZE_UPGRADE_SMITHING_TEMPLATE = create("blaze_upgrade_smithing_template");
    public static final ResourceKey<Item> BLAZE_SWORD = create("blaze_sword");
    public static final ResourceKey<Item> BLAZE_SHOVEL = create("blaze_shovel");
    public static final ResourceKey<Item> BLAZE_PICKAXE = create("blaze_pickaxe");
    public static final ResourceKey<Item> BLAZE_AXE = create("blaze_axe");
    public static final ResourceKey<Item> BLAZE_HOE = create("blaze_hoe");
    public static final ResourceKey<Item> BLAZE_SPEAR = create("blaze_spear");
    public static final ResourceKey<Item> BLAZE_HELMET = create("blaze_helmet");
    public static final ResourceKey<Item> BLAZE_CHESTPLATE = create("blaze_chestplate");
    public static final ResourceKey<Item> BLAZE_LEGGINGS = create("blaze_leggings");
    public static final ResourceKey<Item> BLAZE_BOOTS = create("blaze_boots");
    public static final ResourceKey<Item> VOIDIUM = create("voidium");
    public static final ResourceKey<Item> DEPLETED_VOIDIUM = create("depleted_voidium");
    public static final ResourceKey<Item> VOIDIUM_UPGRADE_SMITHING_TEMPLATE = create("voidium_upgrade_smithing_template");
    public static final ResourceKey<Item> VOIDIUM_SWORD = create("voidium_sword");
    public static final ResourceKey<Item> VOIDIUM_SHOVEL = create("voidium_shovel");
    public static final ResourceKey<Item> VOIDIUM_PICKAXE = create("voidium_pickaxe");
    public static final ResourceKey<Item> VOIDIUM_AXE = create("voidium_axe");
    public static final ResourceKey<Item> VOIDIUM_HOE = create("voidium_hoe");
    public static final ResourceKey<Item> VOIDIUM_SPEAR = create("voidium_spear");
    public static final ResourceKey<Item> VOIDIUM_HELMET = create("voidium_helmet");
    public static final ResourceKey<Item> VOIDIUM_CHESTPLATE = create("voidium_chestplate");
    public static final ResourceKey<Item> VOIDIUM_LEGGINGS = create("voidium_leggings");
    public static final ResourceKey<Item> VOIDIUM_BOOTS = create("voidium_boots");
    public static final ResourceKey<Item> LUMEN_FEATHER = create("lumen_feather");
    public static final ResourceKey<Item> UMBRA_FEATHER = create("umbra_feather");
    public static final ResourceKey<Item> LUMEN_ELYTRA = create("lumen_elytra");
    public static final ResourceKey<Item> UMBRA_ELYTRA = create("umbra_elytra");

    private static ResourceKey<Item> create(final String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID, name));
    }

    private static ResourceKey<Item> createPotterySherd(final ResourceKey<DecoratedPotPattern> sherd) {
        return sherd.dependent(Registries.ITEM, "_pottery_sherd");
    }

    private static ResourceKey<Item> createArmorTrimSmithingTemplate(final ResourceKey<TrimPattern> template) {
        return template.dependent(Registries.ITEM, "_armor_trim_smithing_template");
    }

    private static ResourceKey<Item> createMusicDisc(final ResourceKey<JukeboxSong> music) {
        return music.dependent(Registries.ITEM, path -> "music_disc_" + path);
    }

    private static ResourceKey<Item> createSpawnEgg(final ResourceKey<EntityType<?>> entity) {
        return entity.dependent(Registries.ITEM, "_spawn_egg");
    }

    private static ColorCollection<ResourceKey<Item>> createSimpleColored(final String baseName) {
        return ColorCollection.prefixWithColor(ColorCollection.create(baseName)).map(ModItemIds::create);
    }
}
