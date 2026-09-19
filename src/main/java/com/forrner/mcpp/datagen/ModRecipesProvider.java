package com.forrner.mcpp.datagen;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.item.ModItems;
import com.forrner.mcpp.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SuspiciousEffectHolder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    public ModRecipesProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final List<ItemLike> TIN_INGOT_LIST = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE);
    private static final List<ItemLike> LEAD_INGOT_LIST = List.of(ModItems.RAW_LEAD, ModBlocks.LEAD_ORE, ModBlocks.DEEPSLATE_LEAD_ORE);
    private static final List<ItemLike> COAL_TAR_LIST = List.of(Blocks.COAL_BLOCK);
    private static final List<ItemLike> INACTIVE_BLAZE_INGOT_LIST = List.of(ModBlocks.HOT_OBSIDIAN);

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                oreSmelting(TIN_INGOT_LIST, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TIN_INGOT, 0.7F, 200, "tin_ingot");
                oreBlasting(TIN_INGOT_LIST, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TIN_INGOT, 0.7F, 100, "tin_ingot");
                oreSmelting(LEAD_INGOT_LIST, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT, 0.8F, 200, "lead_ingot");
                oreBlasting(LEAD_INGOT_LIST, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT, 0.8F, 100, "lead_ingot");
                oreBlasting(COAL_TAR_LIST, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.COAL_TAR, 1.0F, 400, "coal_tar");
                oreBlasting(INACTIVE_BLAZE_INGOT_LIST, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.INACTIVE_BLAZE_INGOT, 3.0F, 300, "inactive_blaze_ingot");

                stairBuilder(ModBlocks.TIN_STAIRS, Ingredient.of(ModBlocks.TIN_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.TIN_BLOCK), has(ModBlocks.TIN_BLOCK))
                        .save(output);

                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_SLAB, ModBlocks.TIN_BLOCK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_STAIRS, ModBlocks.TIN_BLOCK, 1);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_SLAB, ModBlocks.TIN_BLOCK, 2);

                copySmithingTemplate(ModItems.BLAZE_UPGRADE_SMITHING_TEMPLATE, Items.BLACKSTONE);
                copySmithingTemplate(ModItems.VOIDIUM_UPGRADE_SMITHING_TEMPLATE, Items.PURPUR_BLOCK);

                blazeSmithing(Items.NETHERITE_SWORD, RecipeCategory.COMBAT, ModItems.BLAZE_SWORD);
                blazeSmithing(Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, ModItems.BLAZE_SHOVEL);
                blazeSmithing(Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, ModItems.BLAZE_PICKAXE);
                blazeSmithing(Items.NETHERITE_AXE, RecipeCategory.TOOLS, ModItems.BLAZE_AXE);
                blazeSmithing(Items.NETHERITE_HOE, RecipeCategory.TOOLS, ModItems.BLAZE_HOE);
                blazeSmithing(Items.NETHERITE_SPEAR, RecipeCategory.COMBAT, ModItems.BLAZE_SPEAR);
                blazeSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, ModItems.BLAZE_HELMET);
                blazeSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, ModItems.BLAZE_CHESTPLATE);
                blazeSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, ModItems.BLAZE_LEGGINGS);
                blazeSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, ModItems.BLAZE_BOOTS);

                voidiumSmithing(ModItems.BLAZE_SWORD, RecipeCategory.COMBAT, ModItems.VOIDIUM_SWORD);
                voidiumSmithing(ModItems.BLAZE_SHOVEL, RecipeCategory.TOOLS, ModItems.VOIDIUM_SHOVEL);
                voidiumSmithing(ModItems.BLAZE_PICKAXE, RecipeCategory.TOOLS, ModItems.VOIDIUM_PICKAXE);
                voidiumSmithing(ModItems.BLAZE_AXE, RecipeCategory.TOOLS, ModItems.VOIDIUM_AXE);
                voidiumSmithing(ModItems.BLAZE_HOE, RecipeCategory.TOOLS, ModItems.VOIDIUM_HOE);
                voidiumSmithing(ModItems.BLAZE_SPEAR, RecipeCategory.COMBAT, ModItems.VOIDIUM_SPEAR);
                voidiumSmithing(ModItems.BLAZE_HELMET, RecipeCategory.COMBAT, ModItems.VOIDIUM_HELMET);
                voidiumSmithing(ModItems.BLAZE_CHESTPLATE, RecipeCategory.COMBAT, ModItems.VOIDIUM_CHESTPLATE);
                voidiumSmithing(ModItems.BLAZE_LEGGINGS, RecipeCategory.COMBAT, ModItems.VOIDIUM_LEGGINGS);
                voidiumSmithing(ModItems.BLAZE_BOOTS, RecipeCategory.COMBAT, ModItems.VOIDIUM_BOOTS);

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.TIN_INGOT, RecipeCategory.MISC, ModBlocks.TIN_BLOCK);

                armors(ModItems.LEAD_INGOT, ModItems.LEAD_HELMET, ModItems.LEAD_CHESTPLATE, ModItems.LEAD_LEGGINGS, ModItems.LEAD_BOOTS);

                toolsandspear(ModItems.LEAD_INGOT, ModItems.LEAD_SWORD, ModItems.LEAD_SHOVEL, ModItems.LEAD_PICKAXE, ModItems.LEAD_AXE, ModItems.LEAD_HOE, ModItems.LEAD_SPEAR);

                suspiciousStew(ModItems.BLAZEFLOWER);

                SimpleCookingRecipeBuilder.blasting(
                                Ingredient.of(
                                        Items.DIAMOND_PICKAXE,
                                        Items.DIAMOND_SHOVEL,
                                        Items.DIAMOND_AXE,
                                        Items.DIAMOND_HOE,
                                        Items.DIAMOND_SWORD,
                                        Items.DIAMOND_SPEAR
                                ),
                                RecipeCategory.MISC,
                                CookingBookCategory.MISC,
                                ModItems.DIAMOND_NUGGET,
                                0.1F,
                                200
                        )
                        .unlockedBy("has_diamond_pickaxe", this.has(Items.DIAMOND_PICKAXE))
                        .unlockedBy("has_diamond_shovel", this.has(Items.DIAMOND_SHOVEL))
                        .unlockedBy("has_diamond_axe", this.has(Items.DIAMOND_AXE))
                        .unlockedBy("has_diamond_hoe", this.has(Items.DIAMOND_HOE))
                        .unlockedBy("has_diamond_sword", this.has(Items.DIAMOND_SWORD))
                        .unlockedBy("has_diamond_spear", this.has(Items.DIAMOND_SPEAR))
                        .save(output, getBlastingRecipeName(ModItems.DIAMOND_NUGGET));

                SimpleCookingRecipeBuilder.blasting(
                                Ingredient.of(
                                        Items.DIAMOND_HELMET,
                                        Items.DIAMOND_CHESTPLATE,
                                        Items.DIAMOND_LEGGINGS,
                                        Items.DIAMOND_BOOTS,
                                        Items.DIAMOND_HORSE_ARMOR,
                                        Items.DIAMOND_NAUTILUS_ARMOR
                                ),
                                RecipeCategory.MISC,
                                CookingBookCategory.MISC,
                                Items.DIAMOND,
                                0.1F,
                                200
                        )
                        .unlockedBy("has_diamond_helmet", this.has(Items.DIAMOND_HELMET))
                        .unlockedBy("has_diamond_chestplate", this.has(Items.DIAMOND_CHESTPLATE))
                        .unlockedBy("has_diamond_leggings", this.has(Items.DIAMOND_LEGGINGS))
                        .unlockedBy("has_diamond_boots", this.has(Items.DIAMOND_BOOTS))
                        .unlockedBy("has_diamond_horse_armor", this.has(Items.DIAMOND_HORSE_ARMOR))
                        .unlockedBy("has_diamond_nautilus_armor", this.has(Items.DIAMOND_NAUTILUS_ARMOR))
                        .save(output, getBlastingRecipeName(Items.DIAMOND));


                shapeless(RecipeCategory.MISC, ModItems.BLAZE_INGOT, 1)
                        .requires(ModItems.INACTIVE_BLAZE_INGOT)
                        .requires(ModItems.BLAZE_CORE)
                        .unlockedBy("has_inactive_blaze_ingot", has(ModItems.INACTIVE_BLAZE_INGOT))
                        .unlockedBy("has_blaze_core", has(ModItems.BLAZE_CORE))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.DIAMOND_NUGGET, 4)
                        .requires(Items.DIAMOND)
                        .unlockedBy("has_diamond", has(Items.DIAMOND))
                        .save(output);

                shaped(RecipeCategory.MISC, Items.DIAMOND, 1)
                        .define('#', ModItems.DIAMOND_NUGGET)
                        .pattern("##")
                        .pattern("##")
                        .unlockedBy("has_diamond_nugget", has(ModItems.DIAMOND_NUGGET))
                        .save(output);

                shaped(RecipeCategory.FOOD, ModItems.GOLDEN_STRAWBERRY, 1)
                        .define('#', Items.GOLD_INGOT)
                        .define('S', ModItems.STRAWBERRY)
                        .pattern("###")
                        .pattern("#S#")
                        .pattern("###")
                        .unlockedBy("has_strawberry", has(ModItems.STRAWBERRY))
                        .save(output);

                shaped(RecipeCategory.MISC, Items.SUGAR, 3)
                        .define('#', ModItemTags.SUGAR)
                        .pattern("###")
                        .unlockedBy("has_sugar", has(ModItemTags.SUGAR))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.BLAZE_CORE, 1)
                        .define('#', ModItems.BLAZE_SHARD)
                        .define('F', ModBlocks.BLAZEFLOWER)
                        .define('R', Items.BLAZE_ROD)
                        .define('M', Items.MAGMA_CREAM)
                        .pattern("###")
                        .pattern("RFM")
                        .pattern("###")
                        .unlockedBy("has_blaze_shard", has(ModItems.BLAZE_SHARD))
                        .unlockedBy("has_blazeflower", has(ModBlocks.BLAZEFLOWER))
                        .unlockedBy("has_blaze_rod", has(Items.BLAZE_ROD))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.LEAD_BOW, 1)
                        .define('#', ModItems.LEAD_INGOT)
                        .define('S', Items.STRING)
                        .pattern(" #S")
                        .pattern("# S")
                        .pattern(" #S")
                        .unlockedBy("has_lead_ingot", has(ModItems.LEAD_INGOT))
                        .save(output);

                shaped(RecipeCategory.DECORATIONS, ModBlocks.BLAZE_TORCH, 4)
                        .define('X', Ingredient.of(Items.COAL, Items.CHARCOAL))
                        .define('#', Items.STICK)
                        .define('B', ModItems.BLAZE_SHARD)
                        .pattern("B")
                        .pattern("X")
                        .pattern("#")
                        .unlockedBy("has_blaze_shard", this.has(ModItems.BLAZE_SHARD))
                        .save(output);

                shaped(RecipeCategory.DECORATIONS, ModBlocks.VOIDIUM_TORCH, 4)
                        .define('X', Ingredient.of(Items.COAL, Items.CHARCOAL))
                        .define('#', Items.STICK)
                        .define('V', Ingredient.of(ModItems.VOIDIUM, ModItems.DEPLETED_VOIDIUM))
                        .pattern("V")
                        .pattern("X")
                        .pattern("#")
                        .unlockedBy("has_voidium", this.has(ModItems.VOIDIUM))
                        .unlockedBy("has_depleted_voidium", this.has(ModItems.DEPLETED_VOIDIUM))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.LUMEN_ELYTRA, 1)
                        .define('E', Items.ELYTRA)
                        .define('#', ModItems.LUMEN_FEATHER)
                        .pattern("###")
                        .pattern("#E#")
                        .pattern("###")
                        .unlockedBy("has_elytra", has(Items.ELYTRA))
                        .unlockedBy("has_lumem_feather", this.has(ModItems.LUMEN_FEATHER))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.UMBRA_ELYTRA, 1)
                        .define('E', Items.ELYTRA)
                        .define('#', ModItems.UMBRA_FEATHER)
                        .pattern("###")
                        .pattern("#E#")
                        .pattern("###")
                        .unlockedBy("has_elytra", has(Items.ELYTRA))
                        .unlockedBy("has_umbra_feather", this.has(ModItems.UMBRA_FEATHER))
                        .save(output);
            }
            public void armors(Item ingredient,Item helmet,Item chestplate,Item leggings,Item boots) {
                shaped(RecipeCategory.COMBAT, helmet,1)
                        .define('X', ingredient)
                        .pattern("XXX")
                        .pattern("X X")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);

                shaped(RecipeCategory.COMBAT, chestplate,1)
                        .define('X', ingredient)
                        .pattern("X X")
                        .pattern("XXX")
                        .pattern("XXX")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);

                shaped(RecipeCategory.COMBAT, leggings,1)
                        .define('X', ingredient)
                        .pattern("XXX")
                        .pattern("X X")
                        .pattern("X X")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);

                shaped(RecipeCategory.COMBAT, boots,1)
                        .define('X', ingredient)
                        .pattern("X X")
                        .pattern("X X")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);
            }

            public void toolsandspear(Item ingredient,Item sword,Item shovel,Item pickaxe,Item axe,Item hoe,Item spear) {
                shaped(RecipeCategory.COMBAT,sword,1)
                        .define('#', ingredient)
                        .define('S',Items.STICK)
                        .pattern("#")
                        .pattern("#")
                        .pattern("S")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);

                shaped(RecipeCategory.TOOLS,shovel,1)
                        .define('#', ingredient)
                        .define('S',Items.STICK)
                        .pattern("#")
                        .pattern("S")
                        .pattern("S")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);

                shaped(RecipeCategory.TOOLS,pickaxe,1)
                        .define('#', ingredient)
                        .define('S',Items.STICK)
                        .pattern("###")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);

                shaped(RecipeCategory.TOOLS,axe,1)
                        .define('#', ingredient)
                        .define('S',Items.STICK)
                        .pattern("##")
                        .pattern("#S")
                        .pattern(" S")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);

                shaped(RecipeCategory.TOOLS,hoe,1)
                        .define('#', ingredient)
                        .define('S',Items.STICK)
                        .pattern("##")
                        .pattern(" S")
                        .pattern(" S")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);

                shaped(RecipeCategory.COMBAT,spear,1)
                        .define('#', ingredient)
                        .define('S', Items.STICK)
                        .pattern("  #")
                        .pattern(" S ")
                        .pattern("S  ")
                        .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                        .save(output);
            }

            public void suspiciousStew(final Item item) {
                SuspiciousEffectHolder effectHolder = SuspiciousEffectHolder.tryGet(item);
                ItemStackTemplate stew = new ItemStackTemplate(
                        Items.SUSPICIOUS_STEW, DataComponentPatch.builder().set(DataComponents.SUSPICIOUS_STEW_EFFECTS, effectHolder.getSuspiciousEffects()).build()
                );
                this.shapeless(RecipeCategory.FOOD, stew)
                        .requires(Items.BOWL)
                        .requires(ItemTags.MUSHROOMS)
                        .requires(ItemTags.MUSHROOMS)
                        .requires(item)
                        .group("suspicious_stew")
                        .unlockedBy(getHasName(item), this.has(item))
                        .save(output, getItemName(stew.item().value()) + "_from_" + getItemName(item));
            }

            public void blazeSmithing(final Item base, final RecipeCategory category, final Item result) {
                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.BLAZE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(base), Ingredient.of(ModItems.BLAZE_INGOT), category, result
                        )
                        .unlocks("has_blaze_ingot", this.has(ModItems.BLAZE_INGOT))
                        .save(output, getItemName(result) + "_smithing");
            }
            public void voidiumSmithing(final Item base, final RecipeCategory category, final Item result) {
                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.VOIDIUM_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(base), Ingredient.of(ModItems.VOIDIUM), category, result
                        )
                        .unlocks("has_voidium", this.has(ModItems.VOIDIUM))
                        .save(output, getItemName(result) + "_smithing");
            }
        };
    }



    @Override
    public String getName() {
        return "recipe generator";
    }
}
