package com.forrner.mcpp.block.custom;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.tag.ModBlockTags;
import com.forrner.mcpp.util.TripleBlockPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class ReedBlock extends Block implements SimpleWaterloggedBlock, BonemealableBlock {
    public static final EnumProperty<TripleBlockPart> PART = EnumProperty.create("part", TripleBlockPart.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE = Block.column(12.0, 0.0, 16.0);

    public ReedBlock(final BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(PART, TripleBlockPart.LOWER)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, BonemealSource source) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        popResource(level, pos, new ItemStack(this));
    }
    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART, WATERLOGGED);
    }

    @Override
    protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(final BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        if (!level.getFluidState(pos).is(Fluids.WATER)) {
            return null;
        }
        if (level.isOutsideBuildHeight(pos.above(2))) {
            return null;
        }
        if (!level.getBlockState(pos.above()).isAir()) {
            return null;
        }
        if (!level.getBlockState(pos.above(2)).isAir()) {
            return null;
        }
        if (!canSustainReed(level.getBlockState(pos.below()))) {
            return null;
        }

        return this.defaultBlockState()
                .setValue(PART, TripleBlockPart.LOWER)
                .setValue(WATERLOGGED, true);
    }

    @Override
    public void setPlacedBy(final Level level, final BlockPos pos, final BlockState state,
                            final @Nullable LivingEntity by, final ItemStack itemStack) {
        level.setBlock(pos.above(), this.defaultBlockState()
                .setValue(PART, TripleBlockPart.MIDDLE), 3);
        level.setBlock(pos.above(2), this.defaultBlockState()
                .setValue(PART, TripleBlockPart.UPPER), 3);
    }

    @Override
    protected boolean canSurvive(final BlockState state, final LevelReader level, final BlockPos pos) {
        return switch (state.getValue(PART)) {
            case LOWER -> {
                boolean hasWater = level.getFluidState(pos).is(Fluids.WATER)
                        || state.getValue(WATERLOGGED);
                yield hasWater && canSustainReed(level.getBlockState(pos.below()));
            }
            case MIDDLE -> {
                BlockState below = level.getBlockState(pos.below());
                yield below.is(this) && below.getValue(PART) == TripleBlockPart.LOWER;
            }
            case UPPER -> {
                BlockState below = level.getBlockState(pos.below());
                yield below.is(this) && below.getValue(PART) == TripleBlockPart.MIDDLE;
            }
        };
    }

    @Override
    protected BlockState updateShape(
            final BlockState state,
            final LevelReader level,
            final ScheduledTickAccess ticks,
            final BlockPos pos,
            final Direction directionToNeighbour,
            final BlockPos neighbourPos,
            final BlockState neighbourState,
            final RandomSource random
    ) {
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (directionToNeighbour.getAxis() == Direction.Axis.Y && !state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }

        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    @Override
    public FluidState getFluidState(final BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState playerWillDestroy(final Level level, final BlockPos pos, final BlockState state, final Player player) {
        if (!level.isClientSide()) {
            BlockPos lowerPos = switch (state.getValue(PART)) {
                case LOWER -> pos;
                case MIDDLE -> pos.below();
                case UPPER -> pos.below(2);
            };
            BlockState lowerState = level.getBlockState(lowerPos);

            if (lowerState.is(this) && lowerState.getValue(PART) == TripleBlockPart.LOWER) {
                if (!player.isCreative() && !player.isSpectator()) {
                    dropResources(lowerState, level, lowerPos, null, player, player.getMainHandItem());
                }

                BlockState lowerReplacement = lowerState.getFluidState().is(Fluids.WATER)
                        ? Blocks.WATER.defaultBlockState()
                        : Blocks.AIR.defaultBlockState();

                level.setBlock(lowerPos, lowerReplacement, 2);
                level.setBlock(lowerPos.above(), Blocks.AIR.defaultBlockState(), 2);
                level.setBlock(lowerPos.above(2), Blocks.AIR.defaultBlockState(), 2);
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void playerDestroy(final ServerLevel level, final ServerPlayer player, final BlockPos pos,
                              final BlockState state, final @Nullable BlockEntity blockEntity,
                              final ItemStack destroyedWith) {
        super.playerDestroy(level, player, pos, Blocks.AIR.defaultBlockState(), blockEntity, destroyedWith);
    }

    @Override
    protected long getSeed(final BlockState state, final BlockPos pos) {
        int offset = switch (state.getValue(PART)) {
            case LOWER -> 0;
            case MIDDLE -> 1;
            case UPPER -> 2;
        };
        return Mth.getSeed(pos.getX(), pos.below(offset).getY(), pos.getZ());
    }

    private static boolean canSustainReed(final BlockState stateBelow) {
        return stateBelow.is(ModBlockTags.CAN_SUSTAIN_REED);
    }

    public static boolean placeAt(final LevelAccessor level, final BlockPos lowerPos, final int flags) {
        if (level.isOutsideBuildHeight(lowerPos.above(2))) {
            return false;
        }

        boolean waterlogged = level.getFluidState(lowerPos).is(Fluids.WATER);
        BlockState lowerState = ModBlocks.REED.defaultBlockState()
                .setValue(ReedBlock.PART, TripleBlockPart.LOWER)
                .setValue(ReedBlock.WATERLOGGED, waterlogged);
        level.setBlock(lowerPos, lowerState, flags);

        BlockState middleState = ModBlocks.REED.defaultBlockState()
                .setValue(ReedBlock.PART, TripleBlockPart.MIDDLE)
                .setValue(ReedBlock.WATERLOGGED, false);
        level.setBlock(lowerPos.above(), middleState, flags);

        BlockState upperState = ModBlocks.REED.defaultBlockState()
                .setValue(ReedBlock.PART, TripleBlockPart.UPPER)
                .setValue(ReedBlock.WATERLOGGED, false);
        level.setBlock(lowerPos.above(2), upperState, flags);

        if (isWholeReed(level, lowerPos)) {
            return true;
        }
        level.setBlock(lowerPos, Blocks.AIR.defaultBlockState(), flags);
        level.setBlock(lowerPos.above(), Blocks.AIR.defaultBlockState(), flags);
        level.setBlock(lowerPos.above(2), Blocks.AIR.defaultBlockState(), flags);
        return false;
    }

    public static boolean isWholeReed(final LevelReader level, final BlockPos lowerPos) {
        BlockState lower = level.getBlockState(lowerPos);
        BlockState middle = level.getBlockState(lowerPos.above());
        BlockState upper = level.getBlockState(lowerPos.above(2));

        return lower.is(ModBlocks.REED) && lower.getValue(PART) == TripleBlockPart.LOWER
                && middle.is(ModBlocks.REED) && middle.getValue(PART) == TripleBlockPart.MIDDLE
                && upper.is(ModBlocks.REED) && upper.getValue(PART) == TripleBlockPart.UPPER;
    }

}
