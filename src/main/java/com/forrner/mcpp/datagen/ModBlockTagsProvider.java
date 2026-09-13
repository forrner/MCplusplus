package com.forrner.mcpp.datagen;

import com.forrner.mcpp.references.ModBlockIds;
import com.forrner.mcpp.references.ModBlockItemIds;
import com.forrner.mcpp.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture){
        super(output,registryLookupFuture);
    }

    protected void addTags(HolderLookup.Provider provider){
      builder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlockItemIds.TIN_ORE)
                .add(ModBlockItemIds.DEEPSLATE_TIN_ORE)
                .add(ModBlockItemIds.LEAD_ORE)
                .add(ModBlockItemIds.DEEPSLATE_LEAD_ORE)
                .add(ModBlockItemIds.TIN_BLOCK)
                .add(ModBlockItemIds.TIN_STAIRS)
                .add(ModBlockItemIds.TIN_SLAB)
                .add(ModBlockItemIds.HOT_OBSIDIAN)
                .add(ModBlockItemIds.VOIDIUM_ORE)
                .add(ModBlockItemIds.DEPLETED_VOIDIUM_ORE);

        builder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlockItemIds.TIN_ORE)
                .add(ModBlockItemIds.DEEPSLATE_TIN_ORE)
                .add(ModBlockItemIds.LEAD_ORE)
                .add(ModBlockItemIds.DEEPSLATE_LEAD_ORE)
                .add(ModBlockItemIds.TIN_BLOCK)
                .add(ModBlockItemIds.TIN_STAIRS)
                .add(ModBlockItemIds.TIN_SLAB);

        builder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlockItemIds.LEAD_ORE)
                .add(ModBlockItemIds.DEEPSLATE_LEAD_ORE);

        builder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlockItemIds.HOT_OBSIDIAN);

        builder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(ModBlockItemIds.VOIDIUM_ORE)
                .add(ModBlockItemIds.DEPLETED_VOIDIUM_ORE);

        builder(BlockTags.SMALL_FLOWERS)
                .add(ModBlockItemIds.BLAZEFLOWER);

        builder(BlockTags.FLOWER_POTS)
                .add(ModBlockIds.POTTED_BLAZEFLOWER);

        builder(ModBlockTags.BASE_STONE_END)
                .add(BlockItemIds.END_STONE);
    }
}
