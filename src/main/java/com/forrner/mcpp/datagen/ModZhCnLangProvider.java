package com.forrner.mcpp.datagen;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModZhCnLangProvider extends FabricLanguageProvider {

    public ModZhCnLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput,"zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.DIAMOND_NUGGET,"钻石粒");
        translationBuilder.add(ModItems.TIN_INGOT,"锡锭");
        translationBuilder.add(ModItems.LEAD_INGOT,"铅锭");
        translationBuilder.add(ModItems.RAW_TIN,"粗锡");
        translationBuilder.add(ModItems.RAW_LEAD,"粗铅");
        translationBuilder.add(ModItems.STRAWBERRY_SEEDS,"草莓种子");
        translationBuilder.add(ModItems.STRAWBERRY,"草莓");
        translationBuilder.add(ModItems.GOLDEN_STRAWBERRY,"金草莓");
        translationBuilder.add(ModItems.BLAZEFLOWER_SEEDS,"烈焰花种子");
        translationBuilder.add(ModItems.COAL_TAR,"煤焦油");
        translationBuilder.add(ModItems.LEAD_SWORD,"铅剑");
        translationBuilder.add(ModItems.LEAD_SHOVEL,"铅锹");
        translationBuilder.add(ModItems.LEAD_PICKAXE,"铅镐");
        translationBuilder.add(ModItems.LEAD_AXE,"铅斧");
        translationBuilder.add(ModItems.LEAD_HOE,"铅锄");
        translationBuilder.add(ModItems.LEAD_SPEAR,"铅矛");
        translationBuilder.add(ModItems.LEAD_BOW,"铅弓");
        translationBuilder.add(ModItems.LEAD_HELMET,"铅头盔");
        translationBuilder.add(ModItems.LEAD_CHESTPLATE,"铅胸甲");
        translationBuilder.add(ModItems.LEAD_LEGGINGS,"铅护腿");
        translationBuilder.add(ModItems.LEAD_BOOTS,"铅靴子");
        translationBuilder.add(ModItems.BLAZE_SHARD,"烈焰碎片");
        translationBuilder.add(ModItems.BLAZE_CORE,"烈焰核心");
        translationBuilder.add(ModItems.INACTIVE_BLAZE_INGOT,"惰性烈焰锭");
        translationBuilder.add(ModItems.BLAZE_INGOT,"烈焰锭");
        translationBuilder.add(ModItems.BLAZE_UPGRADE_SMITHING_TEMPLATE,"烈焰升级");
        translationBuilder.add(ModItems.BLAZE_SWORD,"烈焰剑");
        translationBuilder.add(ModItems.BLAZE_SHOVEL,"烈焰锹");
        translationBuilder.add(ModItems.BLAZE_PICKAXE,"烈焰镐");
        translationBuilder.add(ModItems.BLAZE_AXE,"烈焰斧");
        translationBuilder.add(ModItems.BLAZE_HOE,"烈焰锄");
        translationBuilder.add(ModItems.BLAZE_SPEAR,"烈焰矛");
        translationBuilder.add(ModItems.BLAZE_HELMET,"烈焰头盔");
        translationBuilder.add(ModItems.BLAZE_CHESTPLATE,"烈焰胸甲");
        translationBuilder.add(ModItems.BLAZE_LEGGINGS,"烈焰护腿");
        translationBuilder.add(ModItems.BLAZE_BOOTS,"烈焰靴子");
        translationBuilder.add(ModItems.VOIDIUM,"虚空紫晶");
        translationBuilder.add(ModItems.DEPLETED_VOIDIUM,"劣质虚空紫晶");
        translationBuilder.add(ModItems.VOIDIUM_UPGRADE_SMITHING_TEMPLATE,"虚空紫晶升级");
        translationBuilder.add(ModItems.VOIDIUM_SWORD,"虚空紫晶剑");
        translationBuilder.add(ModItems.VOIDIUM_SHOVEL,"虚空紫晶锹");
        translationBuilder.add(ModItems.VOIDIUM_PICKAXE,"虚空紫晶镐");
        translationBuilder.add(ModItems.VOIDIUM_AXE,"虚空紫晶斧");
        translationBuilder.add(ModItems.VOIDIUM_HOE,"虚空紫晶锄");
        translationBuilder.add(ModItems.VOIDIUM_SPEAR,"虚空紫晶矛");
        translationBuilder.add(ModItems.VOIDIUM_HELMET,"虚空紫晶头盔");
        translationBuilder.add(ModItems.VOIDIUM_CHESTPLATE,"虚空紫晶胸甲");
        translationBuilder.add(ModItems.VOIDIUM_LEGGINGS,"虚空紫晶护腿");
        translationBuilder.add(ModItems.VOIDIUM_BOOTS,"虚空紫晶靴子");
        translationBuilder.add(ModItems.LUMEN_FEATHER,"流明之羽");
        translationBuilder.add(ModItems.UMBRA_FEATHER,"幽湮之羽");
        translationBuilder.add(ModItems.LUMEN_ELYTRA,"流明鞘翅");
        translationBuilder.add(ModItems.UMBRA_ELYTRA,"幽湮鞘翅");

        translationBuilder.add(ModBlocks.TIN_ORE,"锡矿石");
        translationBuilder.add(ModBlocks.DEEPSLATE_TIN_ORE,"深层锡矿石");
        translationBuilder.add(ModBlocks.LEAD_ORE,"铅矿石");
        translationBuilder.add(ModBlocks.DEEPSLATE_LEAD_ORE,"深层铅矿石");
        translationBuilder.add(ModBlocks.TIN_BLOCK,"锡块");
        translationBuilder.add(ModBlocks.TIN_STAIRS,"锡楼梯");
        translationBuilder.add(ModBlocks.TIN_SLAB,"锡台阶");
        translationBuilder.add(ModBlocks.HOT_OBSIDIAN,"炽热的黑曜石");
        translationBuilder.add(ModBlocks.BLAZEFLOWER,"烈焰花");
        translationBuilder.add(ModBlocks.BLAZE_TORCH,"烈焰火把");
        translationBuilder.add(ModBlocks.VOIDIUM_ORE,"虚空紫晶矿石");
        translationBuilder.add(ModBlocks.DEPLETED_VOIDIUM_ORE,"劣质虚空紫晶矿石");
        translationBuilder.add(ModBlocks.VOIDIUM_TORCH,"虚空紫晶火把");

        translationBuilder.add("itemGroup.mcpp","Minecraft++");
        translationBuilder.add("item.mcpp.smithing_template.blaze_upgrade.applies_to","下界合金装备");
        translationBuilder.add("item.mcpp.smithing_template.blaze_upgrade.ingredients","烈焰锭");
        translationBuilder.add("item.mcpp.smithing_template.blaze_upgrade.base_slot_description","放入下界合金盔甲、武器或工具");
        translationBuilder.add("item.mcpp.smithing_template.blaze_upgrade.additions_slot_description","放入烈焰锭");
        translationBuilder.add("item.mcpp.smithing_template.voidium_upgrade.applies_to","烈焰装备");
        translationBuilder.add("item.mcpp.smithing_template.voidium_upgrade.ingredients","虚空紫晶");
        translationBuilder.add("item.mcpp.smithing_template.voidium_upgrade.base_slot_description","放入烈焰盔甲、武器或工具");
        translationBuilder.add("item.mcpp.smithing_template.voidium_upgrade.additions_slot_description","放入虚空紫晶");
        translationBuilder.add("item.mcpp.armor.set_bonus","套装效果：");
        translationBuilder.add("item.mcpp.armor.blazearmor_effect","抗火");
        translationBuilder.add("item.mcpp.armor.voidiumarmor_effect","夜视  迅捷II");
        translationBuilder.add("message.mcpp.enderdragonkilled","§1暗影的帷幕被掀开。§d灵光自虚空溢出。");
    }
}
