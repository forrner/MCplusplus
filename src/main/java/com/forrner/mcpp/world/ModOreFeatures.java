package com.forrner.mcpp.world;

import com.forrner.mcpp.MCplusplus;
import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.tag.ModBlockTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.ScatteredOreFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.HeightMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModOreFeatures {
    public static final ResourceKey<Feature> ORE_TIN = createKey("ore_tin");
    public static final ResourceKey<Feature> ORE_LEAD = createKey("ore_lead");
    public static final ResourceKey<Feature> ORE_HOT_OBSIDIAN = createKey("ore_hot_obsidian");
    public static final ResourceKey<Feature> ORE_VOIDIUM = createKey("ore_voidium");
    public static final ResourceKey<Feature> ORE_DEPLETED_VOIDIUM = createKey("ore_depleted_voidium");

    public static ResourceKey<Feature> createKey(final String name) {
        return ResourceKey.create(Registries.FEATURE, MCplusplus.id(name));
    }

    public static void bootstrap(final BootstrapContext<Feature> context) {

        RuleTest stoneOreReplaceables = RuleTest.either(
                new TagMatchTest(BlockTags.HEIGHT_SPECIFIC_ORE_REPLACEABLES), HeightMatchTest.min(0), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)
        );
        RuleTest deepslateOreReplaceables = RuleTest.either(
                new TagMatchTest(BlockTags.HEIGHT_SPECIFIC_ORE_REPLACEABLES), HeightMatchTest.max(8), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
        );
        RuleTest netherOreReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endOreReplaceables = new TagMatchTest(ModBlockTags.BASE_STONE_END);

        List<BlockReplacement> oreTinTargetList = List.of(
                BlockReplacement.replace(stoneOreReplaceables, ModBlocks.TIN_ORE.defaultBlockState()),
                BlockReplacement.replace(deepslateOreReplaceables, ModBlocks.DEEPSLATE_TIN_ORE.defaultBlockState())
        );
        List<BlockReplacement> oreLeadTargetList = List.of(
                BlockReplacement.replace(stoneOreReplaceables, ModBlocks.LEAD_ORE.defaultBlockState()),
                BlockReplacement.replace(deepslateOreReplaceables, ModBlocks.DEEPSLATE_LEAD_ORE.defaultBlockState())
        );
        List<BlockReplacement> oreDepletedVoidiumTargetList = List.of(
                BlockReplacement.replace(endOreReplaceables, ModBlocks.DEPLETED_VOIDIUM_ORE.defaultBlockState())
        );


        context.register(ORE_TIN, new OreFeature(oreTinTargetList, 7));
        context.register(ORE_LEAD, new OreFeature(oreLeadTargetList,8,0.3F));
        context.register(
                ORE_HOT_OBSIDIAN, new ScatteredOreFeature(netherOreReplaceables, ModBlocks.HOT_OBSIDIAN.defaultBlockState(), 3, 1.0F)
        );
        context.register(
                ORE_VOIDIUM, new ScatteredOreFeature(endOreReplaceables, ModBlocks.VOIDIUM_ORE.defaultBlockState(), 3, 1.0F)
        );
        context.register(ORE_DEPLETED_VOIDIUM, new OreFeature(oreDepletedVoidiumTargetList,4,1.0F));
    }
}
