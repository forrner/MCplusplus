package com.forrner.mcpp.block.custom;

import com.forrner.mcpp.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class StrawberryCrop extends CropBlock{
    public static final MapCodec<StrawberryCrop> CODEC = simpleCodec(StrawberryCrop::new);

    public static final int MAX_AGE = 5;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    @Override
    public MapCodec<? extends CropBlock> codec() {
        return CODEC;
    }

    public StrawberryCrop(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.STRAWBERRY_SEEDS;
    }

}
