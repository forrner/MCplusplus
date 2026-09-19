package com.forrner.mcpp.loot;

import com.forrner.mcpp.MCplusplus;
import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.List;

public class ModLootTableModifications{

    private static final List<ResourceKey<LootTable>> STRAWBERRY_SEEDS_TARGET_CHESTS = List.of(
            BuiltInLootTables.ABANDONED_MINESHAFT,
            BuiltInLootTables.SIMPLE_DUNGEON,
            BuiltInLootTables.VILLAGE_PLAINS_HOUSE,
            BuiltInLootTables.VILLAGE_SAVANNA_HOUSE
    );

    private static final List<ResourceKey<LootTable>> BLAZEFLOWER_SEEDS_TARGET_CHESTS_SMALL = List.of(
            BuiltInLootTables.BASTION_OTHER,
            BuiltInLootTables.BASTION_BRIDGE,
            BuiltInLootTables.BASTION_HOGLIN_STABLE
    );
    private static final List<ResourceKey<LootTable>> BLAZEFLOWER_SEEDS_TARGET_CHESTS_LARGE = List.of(
            BuiltInLootTables.BASTION_TREASURE
    );

    private static final List<ResourceKey<LootTable>> HOT_OBSIDIAN_TARGET_CHESTS_SMALL = List.of(
            BuiltInLootTables.BASTION_OTHER,
            BuiltInLootTables.BASTION_BRIDGE,
            BuiltInLootTables.BASTION_HOGLIN_STABLE
    );
    private static final List<ResourceKey<LootTable>> HOT_OBSIDIAN_TARGET_CHESTS_LARGE = List.of(
            BuiltInLootTables.BASTION_TREASURE
    );

    private static final List<ResourceKey<LootTable>> BLAZE_UPGRADE_SMITHING_TEMPLATE_TARGET_CHESTS_SMALL = List.of(
            BuiltInLootTables.BASTION_OTHER,
            BuiltInLootTables.BASTION_BRIDGE,
            BuiltInLootTables.BASTION_HOGLIN_STABLE
    );
    private static final List<ResourceKey<LootTable>> BLAZE_UPGRADE_SMITHING_TEMPLATE_TARGET_CHESTS_LARGE = List.of(
            BuiltInLootTables.BASTION_TREASURE
    );

    private static final List<ResourceKey<LootTable>> BLAZE_SHARD_TARGET_CHESTS = List.of(
            BuiltInLootTables.NETHER_BRIDGE
    );

    public static final List<ResourceKey<LootTable>> VOIDIUM_TARGET_CHESTS = List.of(
            BuiltInLootTables.END_CITY_TREASURE
    );

    public static final List<ResourceKey<LootTable>> DEPLETED_VOIDIUM_TARGET_CHESTS = List.of(
            BuiltInLootTables.END_CITY_TREASURE
    );

    public static final List<ResourceKey<LootTable>> VOIDIUM_UPGRADE_SMITHING_TEMPLATE_TARGET_CHESTS = List.of(
            BuiltInLootTables.END_CITY_TREASURE
    );


    private static final ResourceKey<LootTable> BLAZE_LOOT_ID =
            ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("minecraft", "entities/blaze"));

    private static final ResourceKey<LootTable> ZOMBIE_LOOT_ID =
            ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("minecraft", "entities/zombie"));


    public static void register() {
        MCplusplus.LOGGER.info("Registering loot tables for "+MCplusplus.MOD_ID);

        //strawberry seeds
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && STRAWBERRY_SEEDS_TARGET_CHESTS.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.STRAWBERRY_SEEDS).setWeight(6)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
                        .add(EmptyLootItem.emptyItem().setWeight(4));
                builder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && ZOMBIE_LOOT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.STRAWBERRY_SEEDS)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        //pool有chance的概率生效，若生效会等概率抽取pool中物品之一，抢夺等级+1，chance+0.01
                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(provider.lookupOrThrow(Registries.ENCHANTMENT), 0.01F, 0.01F));
                builder.pool(poolBuilder.build());
            }
        });

        //blazeflower seeds
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && BLAZEFLOWER_SEEDS_TARGET_CHESTS_SMALL.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLAZEFLOWER_SEEDS).setWeight(4)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .add(EmptyLootItem.emptyItem().setWeight(6));
                builder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && BLAZEFLOWER_SEEDS_TARGET_CHESTS_LARGE.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLAZEFLOWER_SEEDS)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))));
                builder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && BLAZE_LOOT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLAZEFLOWER_SEEDS).setWeight(1)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .add(EmptyLootItem.emptyItem().setWeight(9))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer());
                builder.pool(poolBuilder.build());
            }
        });

        //hot obsidian
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && HOT_OBSIDIAN_TARGET_CHESTS_SMALL.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModBlocks.HOT_OBSIDIAN).setWeight(1)
                                 .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .add(EmptyLootItem.emptyItem().setWeight(9));
                builder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && HOT_OBSIDIAN_TARGET_CHESTS_LARGE.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModBlocks.HOT_OBSIDIAN)
                                 .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))));
                builder.pool(poolBuilder.build());
            }
        });

        //blaze upgrade smithing template
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && BLAZE_UPGRADE_SMITHING_TEMPLATE_TARGET_CHESTS_SMALL.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLAZE_UPGRADE_SMITHING_TEMPLATE).setWeight(1)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .add(EmptyLootItem.emptyItem().setWeight(9));
                builder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && BLAZE_UPGRADE_SMITHING_TEMPLATE_TARGET_CHESTS_LARGE.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLAZE_UPGRADE_SMITHING_TEMPLATE)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))));
                builder.pool(poolBuilder.build());
            }
        });

        //blaze shard
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && BLAZE_SHARD_TARGET_CHESTS.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLAZE_SHARD).setWeight(1)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4))))
                        .add(EmptyLootItem.emptyItem().setWeight(1));
                builder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && BLAZE_LOOT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLAZE_SHARD).setWeight(1)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2))))
                        .add(EmptyLootItem.emptyItem().setWeight(1))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer());
                builder.pool(poolBuilder.build());
            }
        });

        //voidium
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && VOIDIUM_TARGET_CHESTS.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.VOIDIUM).setWeight(1)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .add(EmptyLootItem.emptyItem().setWeight(14));
                builder.pool(poolBuilder.build());
            }
        });

        //depleted voidium
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && DEPLETED_VOIDIUM_TARGET_CHESTS.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.DEPLETED_VOIDIUM).setWeight(3)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4))))
                        .add(EmptyLootItem.emptyItem().setWeight(7));
                builder.pool(poolBuilder.build());
            }
        });

        //voidium upgrade smithing template
        LootTableEvents.MODIFY.register((id, builder, source, provider) -> {
            if (source.isBuiltin() && VOIDIUM_UPGRADE_SMITHING_TEMPLATE_TARGET_CHESTS.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.VOIDIUM_UPGRADE_SMITHING_TEMPLATE).setWeight(2)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .add(EmptyLootItem.emptyItem().setWeight(8));
                builder.pool(poolBuilder.build());
            }
        });
    }
}