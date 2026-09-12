package com.forrner.mcpp.item.custom;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplateItem extends Item{
    public ModSmithingTemplateItem(Properties properties) {
        super(properties);
    }

    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    private static final Component BLAZE_UPGRADE_APPLIES_TO = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,"smithing_template.blaze_upgrade.applies_to"))
    ).withStyle(DESCRIPTION_FORMAT);
    private static final Component BLAZE_UPGRADE_INGREDIENTS = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,"smithing_template.blaze_upgrade.ingredients"))
    ).withStyle(DESCRIPTION_FORMAT);
    private static final Component BLAZE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,"smithing_template.blaze_upgrade.base_slot_description"))
    );
    private static final Component BLAZE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,"smithing_template.blaze_upgrade.additions_slot_description"))
    );
    private static final Component VOIDIUM_UPGRADE_APPLIES_TO = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,"smithing_template.voidium_upgrade.applies_to"))
    ).withStyle(DESCRIPTION_FORMAT);
    private static final Component VOIDIUM_UPGRADE_INGREDIENTS = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,"smithing_template.voidium_upgrade.ingredients"))
    ).withStyle(DESCRIPTION_FORMAT);
    private static final Component VOIDIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,"smithing_template.voidium_upgrade.base_slot_description"))
    );
    private static final Component VOIDIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,"smithing_template.voidium_upgrade.additions_slot_description"))
    );

    private static final Identifier EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace("container/slot/helmet");
    private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace("container/slot/chestplate");
    private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace("container/slot/leggings");
    private static final Identifier EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace("container/slot/boots");
    private static final Identifier EMPTY_SLOT_HOE = Identifier.withDefaultNamespace("container/slot/hoe");
    private static final Identifier EMPTY_SLOT_AXE = Identifier.withDefaultNamespace("container/slot/axe");
    private static final Identifier EMPTY_SLOT_SWORD = Identifier.withDefaultNamespace("container/slot/sword");
    private static final Identifier EMPTY_SLOT_SHOVEL = Identifier.withDefaultNamespace("container/slot/shovel");
    private static final Identifier EMPTY_SLOT_SPEAR = Identifier.withDefaultNamespace("container/slot/spear");
    private static final Identifier EMPTY_SLOT_PICKAXE = Identifier.withDefaultNamespace("container/slot/pickaxe");
    private static final Identifier EMPTY_SLOT_NAUTILUS_ARMOR = Identifier.withDefaultNamespace("container/slot/nautilus_armor");
    private static final Identifier EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace("container/slot/ingot");
    private static final Identifier EMPTY_SLOT_VOIDIUM = Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,"container/slot/voidium");

    private static List<Identifier> createBlazeUpgradeBaseIcons() {
        return List.of(
                EMPTY_SLOT_HELMET,
                EMPTY_SLOT_SWORD,
                EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_LEGGINGS,
                EMPTY_SLOT_AXE,
                EMPTY_SLOT_BOOTS,
                EMPTY_SLOT_HOE,
                EMPTY_SLOT_SHOVEL,
                EMPTY_SLOT_NAUTILUS_ARMOR,
                EMPTY_SLOT_SPEAR
        );
    }

    private static List<Identifier> createVoidiumUpgradeBaseIcons() {
        return List.of(
                EMPTY_SLOT_HELMET,
                EMPTY_SLOT_SWORD,
                EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_LEGGINGS,
                EMPTY_SLOT_AXE,
                EMPTY_SLOT_BOOTS,
                EMPTY_SLOT_HOE,
                EMPTY_SLOT_SHOVEL,
                EMPTY_SLOT_NAUTILUS_ARMOR,
                EMPTY_SLOT_SPEAR
        );
    }

    private static List<Identifier> createBlazeUpgradeMaterialIcons() {
        return List.of(EMPTY_SLOT_INGOT);
    }

    private static List<Identifier> createVoidiumUpgradeMaterialIcons() {
        return List.of(EMPTY_SLOT_VOIDIUM);
    }

    public static SmithingTemplateItem createBlazeUpgradeTemplate(Item.Properties properties) {
        return new SmithingTemplateItem(
                BLAZE_UPGRADE_APPLIES_TO,
                BLAZE_UPGRADE_INGREDIENTS,
                BLAZE_UPGRADE_BASE_SLOT_DESCRIPTION,
                BLAZE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createBlazeUpgradeBaseIcons(),
                createBlazeUpgradeMaterialIcons(),
                properties
        );
    }

    public static SmithingTemplateItem createVoidiumUpgradeTemplate(Item.Properties properties) {
        return new SmithingTemplateItem(
                VOIDIUM_UPGRADE_APPLIES_TO,
                VOIDIUM_UPGRADE_INGREDIENTS,
                VOIDIUM_UPGRADE_BASE_SLOT_DESCRIPTION,
                VOIDIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createVoidiumUpgradeBaseIcons(),
                createVoidiumUpgradeMaterialIcons(),
                properties
        );
    }
}