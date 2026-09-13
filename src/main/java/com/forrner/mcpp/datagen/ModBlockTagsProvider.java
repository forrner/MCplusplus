package com.forrner.mcpp.datagen;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture){
        super(output,registryLookupFuture);
    }

    protected void addTags(HolderLookup.Provider provider){
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_STAIRS)
                .add(ModBlocks.TIN_SLAB)
                .add(ModBlocks.HOT_OBSIDIAN)
                .add(ModBlocks.VOIDIUM_ORE)
                .add(ModBlocks.DEPLETED_VOIDIUM_ORE);



        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_STAIRS)
                .add(ModBlocks.TIN_SLAB);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE);

        valueLookupBuilder(ModBlockTags.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.HOT_OBSIDIAN);

        valueLookupBuilder(ModBlockTags.NEEDS_BLAZE_TOOL)
                .add(ModBlocks.VOIDIUM_ORE)
                .add(ModBlocks.DEPLETED_VOIDIUM_ORE);



        valueLookupBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .addTag(ModBlockTags.NEEDS_NETHERITE_TOOL)
                .addTag(ModBlockTags.NEEDS_BLAZE_TOOL);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(ModBlockTags.NEEDS_NETHERITE_TOOL)
                .addTag(ModBlockTags.NEEDS_BLAZE_TOOL);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(ModBlockTags.NEEDS_NETHERITE_TOOL)
                .addTag(ModBlockTags.NEEDS_BLAZE_TOOL);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_COPPER_TOOL)
                .addTag(ModBlockTags.NEEDS_NETHERITE_TOOL)
                .addTag(ModBlockTags.NEEDS_BLAZE_TOOL);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(ModBlockTags.NEEDS_NETHERITE_TOOL)
                .addTag(ModBlockTags.NEEDS_BLAZE_TOOL);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(ModBlockTags.NEEDS_NETHERITE_TOOL)
                .addTag(ModBlockTags.NEEDS_BLAZE_TOOL);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addTag(ModBlockTags.NEEDS_BLAZE_TOOL);



        valueLookupBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.BLAZEFLOWER);

        valueLookupBuilder(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_BLAZEFLOWER);

        valueLookupBuilder(ModBlockTags.BASE_STONE_END)
                .add(Blocks.END_STONE);
    }
}
