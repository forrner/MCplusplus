package com.forrner.mcpp.block;

import com.forrner.mcpp.block.custom.Blazeflower;
import com.forrner.mcpp.block.custom.BlazeflowerCrop;
import com.forrner.mcpp.block.custom.StrawberryCrop;
import com.forrner.mcpp.particle.ModParticleTypes;
import com.forrner.mcpp.references.ModBlockIds;
import com.forrner.mcpp.references.ModBlockItemIds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.SolidDebugger;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ModBlocks {
    private static final BlockBehaviour.StatePredicate NOT_CLOSED_SHULKER = (state, level, pos) -> level.getBlockEntity(pos) instanceof ShulkerBoxBlockEntity shulkerBoxBlockEntity
            ? shulkerBoxBlockEntity.isClosed()
            : true;
    private static final BlockBehaviour.StatePredicate NOT_EXTENDED_PISTON = (state, level, pos) -> !state.getValue(PistonBaseBlock.EXTENDED);
    private static final BlockBehaviour.StateArgumentPredicate<AABB> NEAR_PLANE_INTERSECTS_OUTLINE = (state, level, blockPos, nearPlaneBox) -> {
        for (AABB outlineBox : state.getOcclusionShape().toAabbs()) {
            if (outlineBox.move(blockPos).intersects(nearPlaneBox)) {
                return true;
            }
        }

        return false;
    };
    public static final Block TIN_ORE = register(
            ModBlockItemIds.TIN_ORE,
            p -> new DropExperienceBlock(ConstantInt.of(0), p),
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)
    );
    public static final Block DEEPSLATE_TIN_ORE = register(
            ModBlockItemIds.DEEPSLATE_TIN_ORE,
            p -> new DropExperienceBlock(ConstantInt.of(0), p),
            BlockBehaviour.Properties.ofFullCopy(TIN_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)
    );

    public static final Block LEAD_ORE = register(
            ModBlockItemIds.LEAD_ORE,
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)
    );
    public static final Block DEEPSLATE_LEAD_ORE = register(
            ModBlockItemIds.DEEPSLATE_LEAD_ORE,
            p -> new DropExperienceBlock(ConstantInt.of(0), p),
            BlockBehaviour.Properties.ofFullCopy(LEAD_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)
    );

    public static final Block HOT_OBSIDIAN = register(
            ModBlockItemIds.HOT_OBSIDIAN,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(30.0F, 1200.0F)
                    .lightLevel(statex -> 10)
    );

    public static final Block TIN_BLOCK = register(
            ModBlockItemIds.TIN_BLOCK,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(4.5F, 6.0F)
                    .sound(SoundType.IRON)
    );

    public static final Block TIN_STAIRS = registerStair(ModBlockItemIds.TIN_STAIRS, TIN_BLOCK);
    public static final Block TIN_SLAB = registerSlab(ModBlockItemIds.TIN_SLAB, TIN_BLOCK);

    public static final Block STRAWBERRY_CROP = register(
            ModBlockItemIds.STRAWBERRY_CROP, StrawberryCrop::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.POPPED)
    );

    public static final Block BLAZEFLOWER = register(
            ModBlockItemIds.BLAZEFLOWER,
            Blazeflower::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .lightLevel(statex -> 5)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.POPPED)
    );

    public static final Block POTTED_BLAZEFLOWER = register(ModBlockIds.POTTED_BLAZEFLOWER, p -> new FlowerPotBlock(BLAZEFLOWER, p), flowerPotProperties().lightLevel(statex -> 5));

    public static final Block BLAZEFLOWER_CROP = register(
            ModBlockItemIds.BLAZEFLOWER_CROP,
            BlazeflowerCrop::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.POPPED)
    );

    public static final Block BLAZE_TORCH = register(
            ModBlockItemIds.BLAZE_TORCH,
            p -> new TorchBlock(ModParticleTypes.BLAZE_FIRE_FLAME, p),
            BlockBehaviour.Properties.of().noCollision().instabreak().lightLevel(statex -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED)
    );
    public static final Block WALL_BLAZE_TORCH = register(
            ModBlockIds.WALL_BLAZE_TORCH,
            p -> new WallTorchBlock(ModParticleTypes.BLAZE_FIRE_FLAME, p),
            wallVariant(BLAZE_TORCH, true).noCollision().instabreak().lightLevel(statex -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED)
    );

    public static final Block VOIDIUM_ORE = register(ModBlockItemIds.VOIDIUM_ORE,
            p -> new DropExperienceBlock(UniformInt.of(12, 15), p),
            BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).lightLevel(statex -> 2).requiresCorrectToolForDrops().strength(20.0F, 1200.0F));
    public static final Block DEPLETED_VOIDIUM_ORE = register(ModBlockItemIds.DEPLETED_VOIDIUM_ORE,
            BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).lightLevel(statex -> 1).requiresCorrectToolForDrops().strength(10.0F, 1200.0F));

    public static final Block VOIDIUM_TORCH = register(
            ModBlockItemIds.VOIDIUM_TORCH,
            p -> new TorchBlock(ModParticleTypes.VOIDIUM_FIRE_FLAME, p),
            BlockBehaviour.Properties.of().noCollision().instabreak().lightLevel(statex -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED)
    );
    public static final Block WALL_VOIDIUM_TORCH = register(
            ModBlockIds.WALL_VOIDIUM_TORCH,
            p -> new WallTorchBlock(ModParticleTypes.VOIDIUM_FIRE_FLAME, p),
            wallVariant(VOIDIUM_TORCH, true).noCollision().instabreak().lightLevel(statex -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED)
    );


    public static ToIntFunction<BlockState> litBlockEmission(final int lightEmission) {
        return state -> state.getValue(BlockStateProperties.LIT) ? lightEmission : 0;
    }

    private static Function<BlockState, MapColor> waterloggedMapColor(final MapColor mapColor) {
        return blockState -> blockState.getValue(BlockStateProperties.WATERLOGGED) ? MapColor.WATER : mapColor;
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static Boolean never(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos, final EntityType<?> entityType) {
        return false;
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static Boolean always(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos, final EntityType<?> entityType) {
        return true;
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static Boolean ocelotOrParrot(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos, final EntityType<?> entityType) {
        return entityType == EntityTypes.OCELOT || entityType == EntityTypes.PARROT;
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static BlockBehaviour.Properties logProperties(final MapColor topColor, final MapColor sideColor, final SoundType soundType) {
        return BlockBehaviour.Properties.of()
                .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(soundType)
                .ignitedByLava();
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static BlockBehaviour.Properties netherStemProperties(final MapColor mapColor) {
        return BlockBehaviour.Properties.of().mapColor(state -> mapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.STEM);
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static boolean always(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos) {
        return true;
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static boolean never(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos) {
        return false;
    }

    private static BlockPos postProcessSelf(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos) {
        return blockPos;
    }

    private static BlockPos postProcessAbove(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos) {
        return blockPos.above();
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static BlockBehaviour.Properties leavesProperties(final SoundType soundType) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .strength(0.2F)
                .randomTicks()
                .sound(soundType)
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating(Blocks::never)
                .ignitedByLava()
                .pushReaction(PushReaction.POPPED)
                .isRedstoneConductor(Blocks::never);
    }

    private static BlockBehaviour.Properties shulkerBoxProperties(final MapColor mapColor) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .forceSolidOn()
                .strength(2.0F)
                .dynamicShape()
                .noOcclusion()
                .isSuffocating(NOT_CLOSED_SHULKER)
                .pushReaction(PushReaction.POPPED);
    }

    private static BlockBehaviour.Properties pistonProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .strength(1.5F)
                .isRedstoneConductor(Blocks::never)
                .isSuffocating(NOT_EXTENDED_PISTON)
                .pushReaction(PushReaction.IMMOVEABLE);
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static BlockBehaviour.Properties buttonProperties() {
        return BlockBehaviour.Properties.of().noCollision().strength(0.5F).pushReaction(PushReaction.POPPED);
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static BlockBehaviour.Properties flowerPotProperties() {
        return BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.POPPED);
    }

    private static BlockBehaviour.Properties candleProperties(final MapColor color) {
        return BlockBehaviour.Properties.of()
                .mapColor(color)
                .noOcclusion()
                .strength(0.1F)
                .sound(SoundType.CANDLE)
                .lightLevel(CandleBlock.LIGHT_EMISSION)
                .pushReaction(PushReaction.POPPED);
    }

    private static Block registerLegacyStair(final BlockItemId id, final Block base) {
        return register(
                id.block(), p -> new StairBlock(base.defaultBlockState(), p), BlockBehaviour.Properties.ofLegacyCopy(base).isViewBlocking(NEAR_PLANE_INTERSECTS_OUTLINE)
        );
    }

    private static Block registerStair(final BlockItemId id, final Block base) {
        return register(
                id, p -> new StairBlock(base.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(base).isViewBlocking(NEAR_PLANE_INTERSECTS_OUTLINE)
        );
    }

    private static Block registerSlab(final BlockItemId id, final Block base) {
        return register(id, SlabBlock::new, BlockBehaviour.Properties.ofLegacyCopy(base).isViewBlocking(NEAR_PLANE_INTERSECTS_OUTLINE));
    }

    private static Block registerSlab(final BlockItemId id, final Block base, final float destroyTime) {
        return register(id, SlabBlock::new, BlockBehaviour.Properties.ofLegacyCopy(base).isViewBlocking(NEAR_PLANE_INTERSECTS_OUTLINE).destroyTime(destroyTime));
    }

    private static Block registerSlab(final BlockItemId id, final Block base, final float destroyTime, final float explosionResistance) {
        return register(
                id, SlabBlock::new, BlockBehaviour.Properties.ofLegacyCopy(base).isViewBlocking(NEAR_PLANE_INTERSECTS_OUTLINE).strength(destroyTime, explosionResistance)
        );
    }

    private static Block registerWall(final BlockItemId id, final Block base) {
        return register(id, WallBlock::new, BlockBehaviour.Properties.ofLegacyCopy(base).forceSolidOn());
    }

    private static BlockBehaviour.Properties wallVariant(final Block standingBlock, final boolean copyName) {
        BlockBehaviour.Properties wallProperties = BlockBehaviour.Properties.of().overrideLootTable(standingBlock.getLootTable());
        if (copyName) {
            wallProperties = wallProperties.overrideDescription(standingBlock.getDescriptionId());
        }

        return wallProperties;
    }

    private static Block register(final BlockItemId id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        return register(id.block(), factory, properties);
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static Block register(final ResourceKey<Block> id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    private static Block register(final BlockItemId id, final BlockBehaviour.Properties properties) {
        return register(id.block(), properties);
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public static Block register(final ResourceKey<Block> id, final BlockBehaviour.Properties properties) {
        return register(id, Block::new, properties);
    }

    static {
        SolidDebugger.runAndDump(() -> {
            for (Block block : BuiltInRegistries.BLOCK) {
                for (BlockState state : block.getStateDefinition().getPossibleStates()) {
                    Block.BLOCK_STATE_REGISTRY.add(state);
                    state.initCache();
                }
            }
        });
    }
    public static void register(){

    }
}