package com.forrner.mcpp.tag;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> SUGAR = create("sugar");
    public static final TagKey<Item> LEAD_TOOL_MATERIALS = create("lead_tool_materials");
    public static final TagKey<Item> REPAIRS_LEAD_ARMOR = create("repairs_lead_armor");
    public static final TagKey<Item> BLAZE_TOOL_MATERIALS = create("blaze_tool_materials");
    public static final TagKey<Item> REPAIRS_BLAZE_ARMOR = create("repairs_blaze_armor");
    public static final TagKey<Item> BLAZE_ARMOR = create("blaze_armor");
    public static final TagKey<Item> VOIDIUM_TOOL_MATERIALS = create("voidium_tool_materials");
    public static final TagKey<Item> REPAIRS_VOIDIUM_ARMOR = create("repairs_voidium_armor");
    public static final TagKey<Item> VOIDIUM_ARMOR = create("voidium_armor");

    private static TagKey<Item> create(final String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID, name));
    }
}
