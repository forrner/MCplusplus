package com.forrner.mcpp.world;

import com.forrner.mcpp.MCplusplus;
import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.tag.ModBlockTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModOreFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TIN =  ResourceKey.create(
            Registries.CONFIGURED_FEATURE, MCplusplus.id("ore_tin")
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LEAD =  ResourceKey.create(
            Registries.CONFIGURED_FEATURE, MCplusplus.id("ore_lead")
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_HOT_OBSIDIAN =  ResourceKey.create(
            Registries.CONFIGURED_FEATURE, MCplusplus.id("ore_hot_obsidian")
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_VOIDIUM =  ResourceKey.create(
            Registries.CONFIGURED_FEATURE, MCplusplus.id("ore_voidium")
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DEPLETED_VOIDIUM =  ResourceKey.create(
            Registries.CONFIGURED_FEATURE, MCplusplus.id("ore_depleted_voidium")
    );

    public static void bootstrap(final BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneOreReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherOreReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endOreReplaceables = new TagMatchTest(ModBlockTags.BASE_STONE_END);

        List<OreConfiguration.TargetBlockState> oreTinTargetList = List.of(
                OreConfiguration.target(stoneOreReplaceables, ModBlocks.TIN_ORE.defaultBlockState()),
                OreConfiguration.target(deepslateOreReplaceables, ModBlocks.DEEPSLATE_TIN_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> oreLeadTargetList = List.of(
                OreConfiguration.target(stoneOreReplaceables, ModBlocks.LEAD_ORE.defaultBlockState()),
                OreConfiguration.target(deepslateOreReplaceables, ModBlocks.DEEPSLATE_LEAD_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> oreDepletedVoidiumTargetList = List.of(
                OreConfiguration.target(endOreReplaceables, ModBlocks.DEPLETED_VOIDIUM_ORE.defaultBlockState())
        );


        FeatureUtils.register(context, ORE_TIN, Feature.ORE, new OreConfiguration(oreTinTargetList, 7));
        FeatureUtils.register(context, ORE_LEAD, Feature.ORE, new OreConfiguration(oreLeadTargetList,8,0.3F));
        FeatureUtils.register(
                context, ORE_HOT_OBSIDIAN, Feature.SCATTERED_ORE, new OreConfiguration(netherOreReplaceables, ModBlocks.HOT_OBSIDIAN.defaultBlockState(), 3, 1.0F)
        );
        FeatureUtils.register(
                context, ORE_VOIDIUM, Feature.SCATTERED_ORE, new OreConfiguration(endOreReplaceables, ModBlocks.VOIDIUM_ORE.defaultBlockState(), 3, 1.0F)
        );
        FeatureUtils.register(context, ORE_DEPLETED_VOIDIUM, Feature.ORE, new OreConfiguration(oreDepletedVoidiumTargetList,4,1.0F));

    }
}
