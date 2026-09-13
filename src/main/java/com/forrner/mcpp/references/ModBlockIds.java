package com.forrner.mcpp.references;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;

public class ModBlockIds {

    public static final ResourceKey<Block> POTTED_BLAZEFLOWER = create("potted_blazeflower");
    public static final ResourceKey<Block> WALL_BLAZE_TORCH = create("wall_blaze_torch");
    public static final ResourceKey<Block> WALL_VOIDIUM_TORCH = create("wall_voidium_torch");


    private static ResourceKey<Block> create(final String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,name));
    }

    private static ColorCollection<ResourceKey<Block>> createSimpleColored(final String baseName) {
        return ColorCollection.prefixWithColor(ColorCollection.create(baseName)).map(ModBlockIds::create);
    }
}
