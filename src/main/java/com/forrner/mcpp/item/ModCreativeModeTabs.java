package com.forrner.mcpp.item;

import com.forrner.mcpp.MCplusplus;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> MCPP_TAB = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID, "mcpp"));

    public static final CreativeModeTab MCPP = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.LEAD_BOW))
            .title(Component.translatable("itemGroup.mcpp"))
            .displayItems((parameters, output) -> {

                output.accept(ModItems.DIAMOND_NUGGET);
                output.accept(ModItems.TIN_INGOT);
                output.accept(ModItems.LEAD_INGOT);
                output.accept(ModItems.RAW_TIN);
                output.accept(ModItems.RAW_LEAD);
                output.accept(ModItems.STRAWBERRY_SEEDS);
                output.accept(ModItems.STRAWBERRY);
                output.accept(ModItems.GOLDEN_STRAWBERRY);
                output.accept(ModItems.BLAZEFLOWER_SEEDS);
                output.accept(ModItems.COAL_TAR);
                output.accept(ModItems.LEAD_SWORD);
                output.accept(ModItems.LEAD_SHOVEL);
                output.accept(ModItems.LEAD_PICKAXE);
                output.accept(ModItems.LEAD_AXE);
                output.accept(ModItems.LEAD_HOE);
                output.accept(ModItems.LEAD_SPEAR);
                output.accept(ModItems.LEAD_BOW);
                output.accept(ModItems.LEAD_HELMET);
                output.accept(ModItems.LEAD_CHESTPLATE);
                output.accept(ModItems.LEAD_LEGGINGS);
                output.accept(ModItems.LEAD_BOOTS);
                output.accept(ModItems.BLAZE_SHARD);
                output.accept(ModItems.BLAZE_CORE);
                output.accept(ModItems.INACTIVE_BLAZE_INGOT);
                output.accept(ModItems.BLAZE_INGOT);
                output.accept(ModItems.BLAZE_UPGRADE_SMITHING_TEMPLATE);
                output.accept(ModItems.BLAZE_SWORD);
                output.accept(ModItems.BLAZE_SHOVEL);
                output.accept(ModItems.BLAZE_PICKAXE);
                output.accept(ModItems.BLAZE_AXE);
                output.accept(ModItems.BLAZE_HOE);
                output.accept(ModItems.BLAZE_SPEAR);
                output.accept(ModItems.BLAZE_HELMET);
                output.accept(ModItems.BLAZE_CHESTPLATE);
                output.accept(ModItems.BLAZE_LEGGINGS);
                output.accept(ModItems.BLAZE_BOOTS);
                output.accept(ModItems.VOIDIUM);
                output.accept(ModItems.DEPLETED_VOIDIUM);
                output.accept(ModItems.VOIDIUM_UPGRADE_SMITHING_TEMPLATE);
                output.accept(ModItems.VOIDIUM_SWORD);
                output.accept(ModItems.VOIDIUM_SHOVEL);
                output.accept(ModItems.VOIDIUM_PICKAXE);
                output.accept(ModItems.VOIDIUM_AXE);
                output.accept(ModItems.VOIDIUM_HOE);
                output.accept(ModItems.VOIDIUM_SPEAR);
                output.accept(ModItems.VOIDIUM_HELMET);
                output.accept(ModItems.VOIDIUM_CHESTPLATE);
                output.accept(ModItems.VOIDIUM_LEGGINGS);
                output.accept(ModItems.VOIDIUM_BOOTS);
                output.accept(ModItems.LUMEN_FEATHER);
                output.accept(ModItems.UMBRA_FEATHER);
                output.accept(ModItems.LUMEN_ELYTRA);
                output.accept(ModItems.UMBRA_ELYTRA);

                output.accept(ModItems.TIN_ORE);
                output.accept(ModItems.DEEPSLATE_TIN_ORE);
                output.accept(ModItems.LEAD_ORE);
                output.accept(ModItems.DEEPSLATE_LEAD_ORE);
                output.accept(ModItems.TIN_BLOCK);
                output.accept(ModItems.TIN_STAIRS);
                output.accept(ModItems.TIN_SLAB);
                output.accept(ModItems.HOT_OBSIDIAN);
                output.accept(ModItems.BLAZEFLOWER);
                output.accept(ModItems.BLAZE_TORCH);
                output.accept(ModItems.VOIDIUM_TORCH);
                output.accept(ModItems.VOIDIUM_ORE);
                output.accept(ModItems.DEPLETED_VOIDIUM_ORE);

            }).build();

    public static void register(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,MCPP_TAB,MCPP);
    }
}
