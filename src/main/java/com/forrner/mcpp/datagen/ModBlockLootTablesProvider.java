package com.forrner.mcpp.datagen;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.block.custom.StrawberryCrop;
import com.forrner.mcpp.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.concurrent.CompletableFuture;


public class ModBlockLootTablesProvider extends FabricBlockLootSubProvider {

    public ModBlockLootTablesProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.TIN_BLOCK);
        dropSelf(ModBlocks.TIN_STAIRS);
        dropSelf(ModBlocks.HOT_OBSIDIAN);
        dropSelf(ModBlocks.BLAZE_TORCH);
        dropSelf(ModBlocks.VOIDIUM_TORCH);
        add(ModBlocks.TIN_SLAB,createSlabItemTable(ModBlocks.TIN_SLAB));
        add(ModBlocks.TIN_ORE,createCopperOreLikeDrops(ModBlocks.TIN_ORE, ModItems.RAW_TIN,2,5));
        add(ModBlocks.DEEPSLATE_TIN_ORE,createCopperOreLikeDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN,2,5));
        add(ModBlocks.LEAD_ORE,createOreDrop(ModBlocks.LEAD_ORE,ModItems.RAW_LEAD));
        add(ModBlocks.DEEPSLATE_LEAD_ORE,createOreDrop(ModBlocks.DEEPSLATE_LEAD_ORE,ModItems.RAW_LEAD));

        LootItemCondition.Builder isStrawberryMaxAge = MatchBlock.blockMatches(this.blocks,ModBlocks.STRAWBERRY_CROP,StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCrop.AGE, 5));
        add(ModBlocks.STRAWBERRY_CROP, createStrawberryCropDrops(ModBlocks.STRAWBERRY_CROP, ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEEDS, isStrawberryMaxAge));

        add(
                ModBlocks.BLAZEFLOWER_CROP,
                this.applyExplosionDecay(ModBlocks.BLAZEFLOWER_CROP, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.BLAZEFLOWER_SEEDS))))
        );
        dropSelf(ModBlocks.BLAZEFLOWER);
        dropPottedContents(ModBlocks.POTTED_BLAZEFLOWER);
        add(
                ModBlocks.VOIDIUM_ORE,
                createSingleItemTableWithSilkTouch(ModBlocks.VOIDIUM_ORE, ModItems.VOIDIUM, ContextIntProviders.exactly(1))
        );
        add(
                ModBlocks.DEPLETED_VOIDIUM_ORE,
                createSingleItemTableWithSilkTouch(ModBlocks.DEPLETED_VOIDIUM_ORE, ModItems.DEPLETED_VOIDIUM, ContextIntProviders.exactly(1))
        );
    }

    public LootTable.Builder createStrawberryCropDrops(final Block original, final Item cropDrop, final Item seedDrop, final LootItemCondition.Builder isMaxAge) {
        return this.applyExplosionDecay(
                original,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(cropDrop).when(isMaxAge).otherwise(LootItem.lootTableItem(seedDrop))))
                        .withPool(
                                LootPool.lootPool()
                                        .when(isMaxAge)
                                        .add(
                                                LootItem.lootTableItem(seedDrop)
                                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(this.enchantments.getOrThrow(Enchantments.FORTUNE), 0.65F, 1))
                                        )
                        )
        );
    }

    public LootTable.Builder createCopperOreLikeDrops(Block block,Item item,int minCount,int maxCount) {
        return this.createSilkTouchDispatchTable(
                block,
                this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(minCount, maxCount)))
                                .apply(ApplyBonusCount.addOreBonusCount(this.enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

}
