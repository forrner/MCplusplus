package com.forrner.mcpp.item;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.item.custom.LeadBowItem;
import com.forrner.mcpp.item.custom.ModArmor;
import com.forrner.mcpp.item.custom.ModSmithingTemplateItem;
import com.forrner.mcpp.item.equipment.ModArmorMaterials;
import com.forrner.mcpp.item.equipment.ModEquipmentAssets;
import com.forrner.mcpp.references.ModBlockItemIds;
import com.forrner.mcpp.references.ModItemIds;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ModItems {

    public static final Item TIN_ORE = registerBlock(ModBlockItemIds.TIN_ORE,ModBlocks.TIN_ORE);
    public static final Item DEEPSLATE_TIN_ORE = registerBlock(ModBlockItemIds.DEEPSLATE_TIN_ORE,ModBlocks.DEEPSLATE_TIN_ORE);
    public static final Item LEAD_ORE = registerBlock(ModBlockItemIds.LEAD_ORE,ModBlocks.LEAD_ORE);
    public static final Item DEEPSLATE_LEAD_ORE = registerBlock(ModBlockItemIds.DEEPSLATE_LEAD_ORE,ModBlocks.DEEPSLATE_LEAD_ORE);
    public static final Item TIN_BLOCK = registerBlock(ModBlockItemIds.TIN_BLOCK,ModBlocks.TIN_BLOCK);
    public static final Item TIN_STAIRS = registerBlock(ModBlockItemIds.TIN_STAIRS,ModBlocks.TIN_STAIRS);
    public static final Item TIN_SLAB = registerBlock(ModBlockItemIds.TIN_SLAB,ModBlocks.TIN_SLAB);
    public static final Item HOT_OBSIDIAN = registerBlock(ModBlockItemIds.HOT_OBSIDIAN,ModBlocks.HOT_OBSIDIAN);
    public static final Item BLAZEFLOWER = registerBlock(ModBlockItemIds.BLAZEFLOWER,ModBlocks.BLAZEFLOWER);
    public static final Item BLAZE_TORCH = registerBlock(
            ModBlockItemIds.BLAZE_TORCH, ModBlocks.BLAZE_TORCH, (b, p) -> new StandingAndWallBlockItem(b, ModBlocks.WALL_BLAZE_TORCH, Direction.DOWN, p)
    );
    public static final Item VOIDIUM_ORE = registerBlock(ModBlockItemIds.VOIDIUM_ORE,ModBlocks.VOIDIUM_ORE,new Item.Properties().rarity(Rarity.RARE));
    public static final Item DEPLETED_VOIDIUM_ORE = registerBlock(ModBlockItemIds.DEPLETED_VOIDIUM_ORE,ModBlocks.DEPLETED_VOIDIUM_ORE,new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item VOIDIUM_TORCH = registerBlock(
            ModBlockItemIds.VOIDIUM_TORCH, ModBlocks.VOIDIUM_TORCH, (b, p) -> new StandingAndWallBlockItem(b, ModBlocks.WALL_VOIDIUM_TORCH, Direction.DOWN, p.rarity(Rarity.UNCOMMON))
    );
    
    public static final Item DIAMOND_NUGGET = registerItem(ModItemIds.DIAMOND_NUGGET);
    public static final Item TIN_INGOT = registerItem(ModItemIds.TIN_INGOT);
    public static final Item LEAD_INGOT = registerItem(ModItemIds.LEAD_INGOT);
    public static final Item RAW_TIN = registerItem(ModItemIds.RAW_TIN);
    public static final Item RAW_LEAD = registerItem(ModItemIds.RAW_LEAD);
    public static final Item COAL_TAR = registerItem(ModItemIds.COAL_TAR,new Item.Properties().component(DataComponents.COOKING_FUEL,
            new CookingFuel(new ResolvableInt.Constant(18000), ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER)))
    );
    public static final Item STRAWBERRY_SEEDS = registerItem(ModBlockItemIds.STRAWBERRY_CROP, createBlockItemWithCustomItemName(ModBlocks.STRAWBERRY_CROP));
    public static final Item STRAWBERRY = registerItem(ModItemIds.STRAWBERRY, new Item.Properties().food(ModFoods.STRAWBERRY));
    public static final Item GOLDEN_STRAWBERRY = registerItem(ModItemIds.GOLDEN_STRAWBERRY, new Item.Properties().food(ModFoods.GOLDEN_STRAWBERRY, ModConsumables.GOLDEN_STRAWBERRY));
    public static final Item BLAZEFLOWER_SEEDS = registerItem(ModBlockItemIds.BLAZEFLOWER_CROP, createBlockItemWithCustomItemName(ModBlocks.BLAZEFLOWER_CROP));
    public static final Item LEAD_SWORD = registerItem(ModItemIds.LEAD_SWORD, new Item.Properties().sword(ModToolMaterial.LEAD, 3.0F, -2.4F));
    public static final Item LEAD_SHOVEL = registerItem(ModItemIds.LEAD_SHOVEL, new Item.Properties().shovel(ModToolMaterial.LEAD, 1.5F, -3.0F));
    public static final Item LEAD_PICKAXE = registerItem(ModItemIds.LEAD_PICKAXE, new Item.Properties().pickaxe(ModToolMaterial.LEAD, 1.0F, -2.8F));
    public static final Item LEAD_AXE = registerItem(ModItemIds.LEAD_AXE, new Item.Properties().axe(ModToolMaterial.LEAD, 5.5F, -3.1F));
    public static final Item LEAD_HOE = registerItem(ModItemIds.LEAD_HOE, new Item.Properties().hoe(ModToolMaterial.LEAD, -2.5F, -0.5F));
    public static final Item LEAD_SPEAR = registerItem(
            ModItemIds.LEAD_SPEAR, new Item.Properties().spear(ModToolMaterial.LEAD, 0.95F, 0.95F, 0.55F, 2.5F, 10.0F, 6.75F, 5.1F, 10.5F, 4.6F)
    );
    public static final Item LEAD_BOW = registerItem(ModItemIds.LEAD_BOW, LeadBowItem::new, new Item.Properties().durability(450).enchantable(1));
    public static final Item LEAD_HELMET = registerItem(ModItemIds.LEAD_HELMET, new Item.Properties().humanoidArmor(ModArmorMaterials.LEAD, ArmorType.HELMET));
    public static final Item LEAD_CHESTPLATE = registerItem(ModItemIds.LEAD_CHESTPLATE, new Item.Properties().humanoidArmor(ModArmorMaterials.LEAD, ArmorType.CHESTPLATE));
    public static final Item LEAD_LEGGINGS = registerItem(ModItemIds.LEAD_LEGGINGS, new Item.Properties().humanoidArmor(ModArmorMaterials.LEAD, ArmorType.LEGGINGS));
    public static final Item LEAD_BOOTS = registerItem(ModItemIds.LEAD_BOOTS, new Item.Properties().humanoidArmor(ModArmorMaterials.LEAD, ArmorType.BOOTS));

    public static final Item BLAZE_SHARD = registerItem(ModItemIds.BLAZE_SHARD);
    public static final Item BLAZE_CORE = registerItem(ModItemIds.BLAZE_CORE);
    public static final Item INACTIVE_BLAZE_INGOT = registerItem(ModItemIds.INACTIVE_BLAZE_INGOT);
    public static final Item BLAZE_INGOT = registerItem(ModItemIds.BLAZE_INGOT,new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_UPGRADE_SMITHING_TEMPLATE = registerItem(
            ModItemIds.BLAZE_UPGRADE_SMITHING_TEMPLATE, ModSmithingTemplateItem::createBlazeUpgradeTemplate, new Item.Properties().rarity(Rarity.UNCOMMON)
    );
    public static final Item BLAZE_SWORD = registerItem(ModItemIds.BLAZE_SWORD, new Item.Properties().sword(ModToolMaterial.BLAZE, 3.0F, -2.4F).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_SHOVEL = registerItem(ModItemIds.BLAZE_SHOVEL, new Item.Properties().shovel(ModToolMaterial.BLAZE, 1.5F, -3.0F).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_PICKAXE = registerItem(ModItemIds.BLAZE_PICKAXE, new Item.Properties().pickaxe(ModToolMaterial.BLAZE, 1.0F, -2.8F).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_AXE = registerItem(ModItemIds.BLAZE_AXE, new Item.Properties().axe(ModToolMaterial.BLAZE, 5.0F, -2.9F).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_HOE = registerItem(ModItemIds.BLAZE_HOE, new Item.Properties().hoe(ModToolMaterial.BLAZE, -5.0F, 1.0F).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_SPEAR = registerItem(
            ModItemIds.BLAZE_SPEAR, new Item.Properties().spear(ModToolMaterial.BLAZE, 1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F).rarity(Rarity.UNCOMMON).fireResistant()
    );
    public static final Item BLAZE_HELMET = registerItem(ModItemIds.BLAZE_HELMET, ModArmor::createBlazeArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.BLAZE, ArmorType.HELMET).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_CHESTPLATE = registerItem(ModItemIds.BLAZE_CHESTPLATE, ModArmor::createBlazeArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.BLAZE, ArmorType.CHESTPLATE).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_LEGGINGS = registerItem(ModItemIds.BLAZE_LEGGINGS, ModArmor::createBlazeArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.BLAZE, ArmorType.LEGGINGS).rarity(Rarity.UNCOMMON).fireResistant());
    public static final Item BLAZE_BOOTS = registerItem(ModItemIds.BLAZE_BOOTS, ModArmor::createBlazeArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.BLAZE, ArmorType.BOOTS).rarity(Rarity.UNCOMMON).fireResistant());

    public static final Item VOIDIUM = registerItem(ModItemIds.VOIDIUM,new Item.Properties().rarity(Rarity.RARE));
    public static final Item DEPLETED_VOIDIUM = registerItem(ModItemIds.DEPLETED_VOIDIUM,new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item VOIDIUM_UPGRADE_SMITHING_TEMPLATE = registerItem(
            ModItemIds.VOIDIUM_UPGRADE_SMITHING_TEMPLATE, ModSmithingTemplateItem::createVoidiumUpgradeTemplate, new Item.Properties().rarity(Rarity.RARE)
    );
    public static final Item VOIDIUM_SWORD = registerItem(ModItemIds.VOIDIUM_SWORD, new Item.Properties().sword(ModToolMaterial.VOIDIUM, 3.0F, -2.4F).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_SHOVEL = registerItem(ModItemIds.VOIDIUM_SHOVEL, new Item.Properties().shovel(ModToolMaterial.VOIDIUM, 1.5F, -3.0F).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_PICKAXE = registerItem(ModItemIds.VOIDIUM_PICKAXE, new Item.Properties().pickaxe(ModToolMaterial.VOIDIUM, 1.0F, -2.8F).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_AXE = registerItem(ModItemIds.VOIDIUM_AXE, new Item.Properties().axe(ModToolMaterial.VOIDIUM, 5.0F, -2.8F).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_HOE = registerItem(ModItemIds.VOIDIUM_HOE, new Item.Properties().hoe(ModToolMaterial.VOIDIUM, -5.0F, 2.0F).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_SPEAR = registerItem(
            ModItemIds.VOIDIUM_SPEAR, new Item.Properties().spear(ModToolMaterial.VOIDIUM, 1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F).rarity(Rarity.RARE).fireResistant()
    );
    public static final Item VOIDIUM_HELMET = registerItem(ModItemIds.VOIDIUM_HELMET, ModArmor::createVoidiumArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.VOIDIUM, ArmorType.HELMET).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_CHESTPLATE = registerItem(ModItemIds.VOIDIUM_CHESTPLATE, ModArmor::createVoidiumArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.VOIDIUM, ArmorType.CHESTPLATE).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_LEGGINGS = registerItem(ModItemIds.VOIDIUM_LEGGINGS, ModArmor::createVoidiumArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.VOIDIUM, ArmorType.LEGGINGS).rarity(Rarity.RARE).fireResistant());
    public static final Item VOIDIUM_BOOTS = registerItem(ModItemIds.VOIDIUM_BOOTS, ModArmor::createVoidiumArmor, new Item.Properties().humanoidArmor(ModArmorMaterials.VOIDIUM, ArmorType.BOOTS).rarity(Rarity.RARE).fireResistant());
    public static final Item LUMEN_FEATHER = registerItem(ModItemIds.LUMEN_FEATHER,new Item.Properties().rarity(Rarity.RARE));
    public static final Item UMBRA_FEATHER = registerItem(ModItemIds.UMBRA_FEATHER,new Item.Properties().rarity(Rarity.RARE));
    public static final Item LUMEN_ELYTRA = registerItem(
            ModItemIds.LUMEN_ELYTRA,
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
            ModItemIds.UMBRA_ELYTRA,
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

    private static Item registerSpawnEgg(final ResourceKey<Item> id, final EntityType<?> type) {
        return registerItem(id, SpawnEggItem::new, new Item.Properties().spawnEgg(type));
    }

    private static Item registerBlock(final BlockItemId id, final Block block) {
        return registerBlock(id, block, BlockItem::new);
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final Item.Properties properties) {
        return registerBlock(id, block, BlockItem::new, properties);
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final UnaryOperator<Item.Properties> propertiesFunction) {
        return registerBlock(id, block, (b, p) -> new BlockItem(b, propertiesFunction.apply(p)));
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final Block... alternatives) {
        Item item = registerBlock(id, block);

        for (Block alternative : alternatives) {
            Item.BY_BLOCK.put(alternative, item);
        }

        return item;
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory) {
        return registerBlock(id, block, itemFactory, new Item.Properties());
    }

    private static Item registerBlock(
            final BlockItemId id, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties
    ) {
        return registerItem(id.item(), p -> itemFactory.apply(block, p), properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()));
    }

    private static Item registerItem(final ResourceKey<Item> id, final Item.Properties properties) {
        return registerItem(id, Item::new, properties);
    }

    private static Item registerItem(final ResourceKey<Item> id) {
        return registerItem(id, Item::new, new Item.Properties());
    }

    private static Item registerItem(final BlockItemId id, final Function<Item.Properties, Item> itemFactory) {
        return registerItem(id.item(), itemFactory);
    }

    private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory) {
        return registerItem(id, itemFactory, new Item.Properties());
    }

    private static Item registerItem(final BlockItemId id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        return registerItem(id.item(), itemFactory, properties);
    }

    private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(id));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void register(){

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
