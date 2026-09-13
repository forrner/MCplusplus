package com.forrner.mcpp.tag;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> NEEDS_NETHERITE_TOOL = create("needs_netherite_tool");
    public static final TagKey<Block> NEEDS_BLAZE_TOOL = create("needs_blaze_tool");
    public static final TagKey<Block> INCORRECT_FOR_BLAZE_TOOL = create("incorrect_for_blaze_tool");
    public static final TagKey<Block> INCORRECT_FOR_VOIDIUM_TOOL = create("incorrect_for_voidium_tool");
    public static final TagKey<Block> BASE_STONE_END = create("base_stone_end");

    private static TagKey<Block> create(final String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,name));
    }
}
