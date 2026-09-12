package com.forrner.mcpp.item;

import com.forrner.mcpp.MCplusplus;
import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.item.custom.LeadBowItem;
import com.forrner.mcpp.item.custom.ModArmor;
import com.forrner.mcpp.item.custom.ModSmithingTemplateItem;
import com.forrner.mcpp.item.equipment.ModArmorMaterials;
import com.forrner.mcpp.item.equipment.ModEquipmentAssets;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ModItems {

    public static final Item TIN_ORE = registerBlock(ModBlocks.TIN_ORE);
    public static final Item DEEPSLATE_TIN_ORE = registerBlock(ModBlocks.DEEPSLATE_TIN_ORE);
    public static final Item LEAD_ORE = registerBlock(ModBlocks.LEAD_ORE);
    public static final Item DEEPSLATE_LEAD_ORE = registerBlock(ModBlocks.DEEPSLATE_LEAD_ORE);
    public static final Item TIN_BLOCK = registerBlock(ModBlocks.TIN_BLOCK);
    public static final Item TIN_STAIRS = registerBlock(ModBlocks.TIN_STAIRS);
    public static final Item TIN_SLAB = registerBlock(ModBlocks.TIN_SLAB);
    public static final Item HOT_OBSIDIAN = registerBlock(ModBlocks.HOT_OBSIDIAN);
    public static final Item BLAZEFLOWER = registerBlock(ModBlocks.BLAZEFLOWER);
    public static final Item BLAZE_TORCH = registerBlock(
            ModBlocks.BLAZE_TORCH, (b, p) -> new StandingAndWallBlockItem(b, ModBlocks.BLAZE_WALL_TORCH, Direction.DOWN, p)
    );
    public static final Item VOIDIUM_ORE = registerBlock(ModBlocks.VOIDIUM_ORE,new Item.Properties().rarity(Rarity.RARE));
    public static final Item DEPLETED_VOIDIUM_ORE = registerBlock(ModBlocks.DEPLETED_VOIDIUM_ORE,new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item VOIDIUM_TORCH = registerBlock(
            ModBlocks.VOIDIUM_TORCH, (b, p) -> new StandingAndWallBlockItem(b, ModBlocks.VOIDIUM_WALL_TORCH, Direction.DOWN, p.rarity(Rarity.UNCOMMON))
    );
    
    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget");
    public static final Item TIN_INGOT = registerItem("tin_ingot");
    public static final Item LEAD_INGOT = registerItem("lead_ingot");
    public static final Item RAW_TIN = registerItem("raw_tin");
    public static final Item RAW_LEAD = registerItem("raw_lead");
    public static final Item COAL_TAR = registerItem("coal_tar");
    public static final Item STRAWBERRY_SEEDS = registerItem("strawberry_seeds", createBlockItemWithCustomItemName(ModBlocks.STRAWBERRY_CROP));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item.Properties().food(ModFoods.STRAWBERRY));
    public static final Item GOLDEN_STRAWBERRY = registerItem("golden_strawberry", new Item.Properties().food(ModFoods.GOLDEN_STRAWBERRY, ModConsumables.GOLDEN_STRAWBERRY));
    public static final Item BLAZEFLOWER_SEEDS = registerItem("blazeflower_seeds", createBlockItemWithCustomItemName(ModBlocks.BLAZEFLOWER_CROP));
    public static final Item LEAD_SWORD = registerItem("lead_sword", new Item.Properties().sword(ModToolMaterial.LEAD, 3.0F, -2.4F));
    public static final Item LEAD_SHOVEL = registerItem("lead_shovel", p -> new ShovelItem(ModToolMaterial.LEAD, 1.5F, -3.0F, p));
    public static final Item LEAD_PICKAXE = registerItem("lead_pickaxe", new Item.Properties().pickaxe(ModToolMaterial.LEAD, 1.0F, -2.8F));
    public static final Item LEAD_AXE = registerItem("lead_axe", p -> new AxeItem(ModToolMaterial.LEAD, 5.5F, -3.1F, p));
    public static final Item LEAD_HOE = registerItem("lead_hoe", p -> new HoeItem(ModToolMaterial.LEAD, -2.5F, -0.5F, p));
    public static final Item LEAD_SPEAR = registerItem(
            "lead_spear", new Item.Properties().spear(ModToolMaterial.LEAD, 0.95F, 0.95F, 0.55F, 2.5F, 10.0F, 6.75F, 5.1F, 10.5F, 4.6F)
    );
    public static final Item LEAD_BOW = registerItem("lead_bow", LeadBowItem::new, new Item.Properties().durability(450).enchantable(1));
    public static final Item LEAD_HELMET = registerItem("lead_helmet", new Item.Properties().humanoidArmor(ModArmorMaterials.LEAD, ArmorType.HELMET));
    public static final Item LEAD_CHESTPLATE = registerItem("lead_chestplate", new Item.Properties().humanoidArmor(ModArmorMaterials.LEAD, ArmorType.CHESTPLATE));
    public static final Item LEAD_LEGGINGS = registerItem("lead_leggings", new Item.Properties().humanoidArmor(ModArmorMaterials.LEAD, ArmorType.LEGGINGS));
    public static final Item LEAD_BOOTS = registerItem("lead_boots", new Item.Properties().humanoidArmor(ModArmorMaterials.LEAD, ArmorType.BOOTS));

    public static final Item BLAZE_SHARD = registerItem("blaze_shard");
    public static final Item BLAZE_CORE = registerItem("blaze_core");
    public static final Item INACTIVE_BLAZE_INGOT = registerItem("inactive_blaze_ingot");
    public static final Item BLAZE_INGOT = registerItem("blaze_ingot",new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "blaze_upgrade_smithing_template", ModSmithingTemplateItem::createBlazeUpgradeTemplate, new Item.Properties().rarity(Rarity.UNCOMMON)
    );
    public static final Item BLAZE_SWORD = registerItem("blaze_sword", new Item.Properties().sword(ModToolMaterial.BLAZE, 3.0F, -2.4F).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_SHOVEL = registerItem("blaze_shovel", p -> new ShovelItem(ModToolMaterial.BLAZE, 1.5F, -3.0F, p.rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item BLAZE_PICKAXE = registerItem("blaze_pickaxe", new Item.Properties().pickaxe(ModToolMaterial.BLAZE, 1.0F, -2.8F).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_AXE = registerItem("blaze_axe", p -> new AxeItem(ModToolMaterial.BLAZE, 5.0F, -2.9F, p.rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item BLAZE_HOE = registerItem("blaze_hoe", p -> new HoeItem(ModToolMaterial.BLAZE, -5.0F, 1.0F, p.rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item BLAZE_SPEAR = registerItem(
            "blaze_spear", new Item.Properties().spear(ModToolMaterial.BLAZE, 1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F).rarity(Rarity.UNCOMMON).fireResistant()
    );
    public static final Item BLAZE_HELMET = registerItem("blaze_helmet", ModArmor::createBlazeArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.BLAZE, ArmorType.HELMET).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_CHESTPLATE = registerItem("blaze_chestplate", ModArmor::createBlazeArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.BLAZE, ArmorType.CHESTPLATE).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_LEGGINGS = registerItem("blaze_leggings", ModArmor::createBlazeArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.BLAZE, ArmorType.LEGGINGS).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_BOOTS = registerItem("blaze_boots", ModArmor::createBlazeArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.BLAZE, ArmorType.BOOTS).rarity(Rarity.UNCOMMON).fireResistant());

    public static final Item VOIDIUM = registerItem("voidium",new Item.Properties().rarity(Rarity.RARE));
    public static final Item DEPLETED_VOIDIUM = registerItem("depleted_voidium",new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item VOIDIUM_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "voidium_upgrade_smithing_template", ModSmithingTemplateItem::createVoidiumUpgradeTemplate, new Item.Properties().rarity(Rarity.RARE)
    );
    public static final Item VOIDIUM_SWORD = registerItem("voidium_sword", new Item.Properties().sword(ModToolMaterial.VOIDIUM, 3.0F, -2.4F).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_SHOVEL = registerItem("voidium_shovel", p -> new ShovelItem(ModToolMaterial.VOIDIUM, 1.5F, -3.0F, p.rarity(Rarity.RARE).fireResistant()));
    public static final Item VOIDIUM_PICKAXE = registerItem("voidium_pickaxe", new Item.Properties().pickaxe(ModToolMaterial.VOIDIUM, 1.0F, -2.8F).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_AXE = registerItem("voidium_axe", p -> new AxeItem(ModToolMaterial.VOIDIUM, 5.0F, -2.8F, p.rarity(Rarity.RARE).fireResistant()));
    public static final Item VOIDIUM_HOE = registerItem("voidium_hoe", p -> new HoeItem(ModToolMaterial.VOIDIUM, -5.0F, 2.0F, p.rarity(Rarity.RARE).fireResistant()));
    public static final Item VOIDIUM_SPEAR = registerItem(
            "voidium_spear", new Item.Properties().spear(ModToolMaterial.VOIDIUM, 1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F).rarity(Rarity.RARE).fireResistant()
    );
    public static final Item VOIDIUM_HELMET = registerItem("voidium_helmet", ModArmor::createVoidiumArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.VOIDIUM, ArmorType.HELMET).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_CHESTPLATE = registerItem("voidium_chestplate", ModArmor::createVoidiumArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.VOIDIUM, ArmorType.CHESTPLATE).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_LEGGINGS = registerItem("voidium_leggings", ModArmor::createVoidiumArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.VOIDIUM, ArmorType.LEGGINGS).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_BOOTS = registerItem("voidium_boots", ModArmor::createVoidiumArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.VOIDIUM, ArmorType.BOOTS).rarity(Rarity.RARE).fireResistant());
    public static final Item LUMEN_FEATHER = registerItem("lumen_feather",new Item.Properties().rarity(Rarity.RARE));
    public static final Item UMBRA_FEATHER = registerItem("umbra_feather",new Item.Properties().rarity(Rarity.RARE));
    public static final Item LUMEN_ELYTRA = registerItem(
            "lumen_elytra",
            new Item.Properties()
                    .durability(800)
                    .rarity(Rarity.EPIC)
                    .component(DataComponents.GLIDER, Unit.INSTANCE)
                    .component(
                            DataComponents.EQUIPPABLE,
                            Equippable.builder(EquipmentSlot.CHEST).setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA).setAsset(ModEquipmentAssets.LUMEN_ELYTRA).setDamageOnHurt(false).build()
                    )
                    .repairable(Items.PHANTOM_MEMBRANE)
                    .fireResistant()
    );

    public static final Item UMBRA_ELYTRA = registerItem(
            "umbra_elytra",
            new Item.Properties()
                    .durability(800)
                    .rarity(Rarity.EPIC)
                    .component(DataComponents.GLIDER, Unit.INSTANCE)
                    .component(
                            DataComponents.EQUIPPABLE,
                            Equippable.builder(EquipmentSlot.CHEST).setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA).setAsset(ModEquipmentAssets.UMBRA_ELYTRA).setDamageOnHurt(false).build()
                    )
                    .repairable(Items.PHANTOM_MEMBRANE)
                    .fireResistant()
    );

    private static Function<Item.Properties, Item> createBlockItemWithCustomItemName(final Block block) {
        return p -> new BlockItem(block, p.useItemDescriptionPrefix());
    }

    private static ResourceKey<Item> ModItemId(final String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,name));
    }

    private static ResourceKey<Item> blockIdToItemId(final ResourceKey<Block> blockName) {
        return ResourceKey.create(Registries.ITEM, blockName.identifier());
    }

    private static Item registerSpawnEgg(final EntityType<?> type) {
        return registerItem(
                ResourceKey.create(Registries.ITEM, EntityType.getKey(type).withSuffix("_spawn_egg")), SpawnEggItem::new, new Item.Properties().spawnEgg(type)
        );
    }

    private static Item registerBlock(final Block block) {
        return registerBlock(block, BlockItem::new);
    }

    private static Item registerBlock(final Block block, final Item.Properties properties) {
        return registerBlock(block, BlockItem::new, properties);
    }

    private static Item registerBlock(final Block block, final UnaryOperator<Item.Properties> propertiesFunction) {
        return registerBlock(block, (b, p) -> new BlockItem(b, propertiesFunction.apply(p)));
    }

    private static Item registerBlock(final Block block, final Block... alternatives) {
        Item item = registerBlock(block);

        for (Block alternative : alternatives) {
            Item.BY_BLOCK.put(alternative, item);
        }

        return item;
    }

    private static Item registerBlock(final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory) {
        return registerBlock(block, itemFactory, new Item.Properties());
    }

    private static Item registerBlock(final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties) {
        return registerItem(
                blockIdToItemId(block.builtInRegistryHolder().key()),
                p -> itemFactory.apply(block, p),
                properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures())
        );
    }

    private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory) {
        return registerItem(ModItemId(name), itemFactory, new Item.Properties());
    }

    private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        return registerItem(ModItemId(name), itemFactory, properties);
    }

    private static Item registerItem(final String name, final Item.Properties properties) {
        return registerItem(ModItemId(name), Item::new, properties);
    }

    private static Item registerItem(final String name) {
        return registerItem(ModItemId(name), Item::new, new Item.Properties());
    }

    private static Item registerItem(final ResourceKey<Item> key, final Function<Item.Properties, Item> itemFactory) {
        return registerItem(key, itemFactory, new Item.Properties());
    }

    private static Item registerItem(final ResourceKey<Item> key, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void register(){

        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.COAL_TAR, 18000);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register(FabricCreativeModeTabOutput->{
                    FabricCreativeModeTabOutput.accept(DIAMOND_NUGGET);
                    FabricCreativeModeTabOutput.accept(TIN_INGOT);
                    FabricCreativeModeTabOutput.accept(LEAD_INGOT);
                    FabricCreativeModeTabOutput.accept(RAW_TIN);
                    FabricCreativeModeTabOutput.accept(RAW_LEAD);
                    FabricCreativeModeTabOutput.accept(COAL_TAR);
                    FabricCreativeModeTabOutput.accept(BLAZE_SHARD);
                    FabricCreativeModeTabOutput.accept(BLAZE_CORE);
                    FabricCreativeModeTabOutput.accept(INACTIVE_BLAZE_INGOT);
                    FabricCreativeModeTabOutput.accept(BLAZE_INGOT);
                    FabricCreativeModeTabOutput.accept(BLAZE_UPGRADE_SMITHING_TEMPLATE);
                    FabricCreativeModeTabOutput.accept(VOIDIUM);
                    FabricCreativeModeTabOutput.accept(DEPLETED_VOIDIUM);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_UPGRADE_SMITHING_TEMPLATE);
                    FabricCreativeModeTabOutput.accept(LUMEN_FEATHER);
                    FabricCreativeModeTabOutput.accept(UMBRA_FEATHER);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register(FabricCreativeModeTabOutput->{
                    FabricCreativeModeTabOutput.accept(TIN_ORE);
                    FabricCreativeModeTabOutput.accept(DEEPSLATE_TIN_ORE);
                    FabricCreativeModeTabOutput.accept(LEAD_ORE);
                    FabricCreativeModeTabOutput.accept(DEEPSLATE_LEAD_ORE);
                    FabricCreativeModeTabOutput.accept(HOT_OBSIDIAN);
                    FabricCreativeModeTabOutput.accept(STRAWBERRY_SEEDS);
                    FabricCreativeModeTabOutput.accept(BLAZEFLOWER_SEEDS);
                    FabricCreativeModeTabOutput.accept(BLAZEFLOWER);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_ORE);
                    FabricCreativeModeTabOutput.accept(DEPLETED_VOIDIUM_ORE);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register(FabricCreativeModeTabOutput->{
                    FabricCreativeModeTabOutput.accept(STRAWBERRY);
                    FabricCreativeModeTabOutput.accept(GOLDEN_STRAWBERRY);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register(FabricCreativeModeTabOutput->{
                    FabricCreativeModeTabOutput.accept(TIN_BLOCK);
                    FabricCreativeModeTabOutput.accept(TIN_STAIRS);
                    FabricCreativeModeTabOutput.accept(TIN_SLAB);
                });


        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((FabricCreativeModeTabOutput->{
                    FabricCreativeModeTabOutput.accept(LEAD_SWORD);
                    FabricCreativeModeTabOutput.accept(LEAD_SPEAR);
                    FabricCreativeModeTabOutput.accept(LEAD_AXE);
                    FabricCreativeModeTabOutput.accept(LEAD_BOW);
                    FabricCreativeModeTabOutput.accept(LEAD_HELMET);
                    FabricCreativeModeTabOutput.accept(LEAD_CHESTPLATE);
                    FabricCreativeModeTabOutput.accept(LEAD_LEGGINGS);
                    FabricCreativeModeTabOutput.accept(LEAD_BOOTS);
                    FabricCreativeModeTabOutput.accept(BLAZE_SWORD);
                    FabricCreativeModeTabOutput.accept(BLAZE_SPEAR);
                    FabricCreativeModeTabOutput.accept(BLAZE_AXE);
                    FabricCreativeModeTabOutput.accept(BLAZE_HELMET);
                    FabricCreativeModeTabOutput.accept(BLAZE_CHESTPLATE);
                    FabricCreativeModeTabOutput.accept(BLAZE_LEGGINGS);
                    FabricCreativeModeTabOutput.accept(BLAZE_BOOTS);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_SWORD);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_SPEAR);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_AXE);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_HELMET);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_CHESTPLATE);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_LEGGINGS);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_BOOTS);
                }));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((FabricCreativeModeTabOutput->{
                    FabricCreativeModeTabOutput.accept(LEAD_SHOVEL);
                    FabricCreativeModeTabOutput.accept(LEAD_PICKAXE);
                    FabricCreativeModeTabOutput.accept(LEAD_AXE);
                    FabricCreativeModeTabOutput.accept(LEAD_HOE);
                    FabricCreativeModeTabOutput.accept(BLAZE_SHOVEL);
                    FabricCreativeModeTabOutput.accept(BLAZE_PICKAXE);
                    FabricCreativeModeTabOutput.accept(BLAZE_AXE);
                    FabricCreativeModeTabOutput.accept(BLAZE_HOE);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_SHOVEL);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_PICKAXE);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_AXE);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_HOE);
                    FabricCreativeModeTabOutput.accept(LUMEN_ELYTRA);
                    FabricCreativeModeTabOutput.accept(UMBRA_ELYTRA);
                }));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(FabricCreativeModeTabOutput->{
                    FabricCreativeModeTabOutput.accept(BLAZE_TORCH);
                    FabricCreativeModeTabOutput.accept(VOIDIUM_TORCH);
                });
    }
}
