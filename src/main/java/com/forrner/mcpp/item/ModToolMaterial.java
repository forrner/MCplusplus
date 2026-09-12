package com.forrner.mcpp.item;

import com.forrner.mcpp.tag.ModBlockTags;
import com.forrner.mcpp.tag.ModItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterial {
    public static final ToolMaterial LEAD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 400, 7.0F, 2.5F, 14,
            ModItemTags.LEAD_TOOL_MATERIALS);
    public static final ToolMaterial BLAZE = new ToolMaterial(
            ModBlockTags.INCORRECT_FOR_BLAZE_TOOL, 2031, 10.0F, 5.0F, 15,
            ModItemTags.BLAZE_TOOL_MATERIALS);
    public static final ToolMaterial VOIDIUM = new ToolMaterial(
            ModBlockTags.INCORRECT_FOR_VOIDIUM_TOOL, 2031, 12.0F, 6.0F, 22,
            ModItemTags.VOIDIUM_TOOL_MATERIALS);
}
