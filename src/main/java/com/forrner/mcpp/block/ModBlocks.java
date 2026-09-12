package com.forrner.mcpp.block;

import com.forrner.mcpp.MCplusplus;
import com.forrner.mcpp.block.custom.Blazeflower;
import com.forrner.mcpp.block.custom.BlazeflowerCrop;
import com.forrner.mcpp.block.custom.StrawberryCrop;
import com.forrner.mcpp.particle.ModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ModBlocks {
    private static final BlockBehaviour.StatePredicate NOT_CLOSED_SHULKER = (statex, level, pos) -> level.getBlockEntity(pos) instanceof ShulkerBoxBlockEntity shulkerBoxBlockEntity
            ? shulkerBoxBlockEntity.isClosed()
            : true;
    private static final BlockBehaviour.StatePredicate NOT_EXTENDED_PISTON = (statex, level, pos) -> !statex.getValue(PistonBaseBlock.EXTENDED);

    public static final Block TIN_ORE = register(
            "tin_ore",
            p -> new DropExperienceBlock(ConstantInt.of(0), p),
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)
    );
    public static final Block DEEPSLATE_TIN_ORE = register(
            "deepslate_tin_ore",
            p -> new DropExperienceBlock(ConstantInt.of(0), p),
            BlockBehaviour.Properties.ofFullCopy(TIN_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)
    );

    public static final Block LEAD_ORE = register(
            "lead_ore",
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)
    );
    public static final Block DEEPSLATE_LEAD_ORE = register(
            "deepslate_lead_ore",
            p -> new DropExperienceBlock(ConstantInt.of(0), p),
            BlockBehaviour.Properties.ofFullCopy(LEAD_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)
    );

    public static final Block HOT_OBSIDIAN = register(
            "hot_obsidian",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(30.0F, 1200.0F)
                    .lightLevel(statex -> 10)
    );

    public static final Block TIN_BLOCK = register(
            "tin_block",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(4.5F, 6.0F)
                    .sound(SoundType.IRON)
    );

    public static final Block TIN_STAIRS = registerStair("tin_stairs", TIN_BLOCK);
    public static final Block TIN_SLAB = register("tin_slab",SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(TIN_BLOCK));

    public static final Block STRAWBERRY_CROP = register(
            "strawberry_crop", StrawberryCrop::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)
    );

    public static final Block BLAZEFLOWER = register(
            "blazeflower",
            Blazeflower::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .lightLevel(statex -> 5)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)
    );

    public static final Block POTTED_BLAZEFLOWER = register("potted_blazeflower", p -> new FlowerPotBlock(BLAZEFLOWER, p), flowerPotProperties().lightLevel(statex -> 5));

    public static final Block BLAZEFLOWER_CROP = register(
            "blazeflower_crop",
            BlazeflowerCrop::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)
    );

    public static final Block BLAZE_TORCH = register(
            "blaze_torch",
            p -> new TorchBlock(ModParticleTypes.BLAZE_FIRE_FLAME, p),
            BlockBehaviour.Properties.of().noCollision().instabreak().lightLevel(statex -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)
    );
    public static final Block BLAZE_WALL_TORCH = register(
            "blaze_wall_torch",
            p -> new WallTorchBlock(ModParticleTypes.BLAZE_FIRE_FLAME, p),
            wallVariant(BLAZE_TORCH, true).noCollision().instabreak().lightLevel(statex -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)
    );

    public static final Block VOIDIUM_ORE = register("voidium_ore",
            p -> new DropExperienceBlock(UniformInt.of(12, 15), p),
            BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).lightLevel(statex -> 2).requiresCorrectToolForDrops().strength(20.0F, 1200.0F));
    public static final Block DEPLETED_VOIDIUM_ORE = register("depleted_voidium_ore",
            BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).lightLevel(statex -> 1).requiresCorrectToolForDrops().strength(10.0F, 1200.0F));

    public static final Block VOIDIUM_TORCH = register(
            "voidium_torch",
            p -> new TorchBlock(ModParticleTypes.VOIDIUM_FIRE_FLAME, p),
            BlockBehaviour.Properties.of().noCollision().instabreak().lightLevel(statex -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)
    );
    public static final Block VOIDIUM_WALL_TORCH = register(
            "voidium_wall_torch",
            p -> new WallTorchBlock(ModParticleTypes.VOIDIUM_FIRE_FLAME, p),
            wallVariant(VOIDIUM_TORCH, true).noCollision().instabreak().lightLevel(statex -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)
    );

    public static ToIntFunction<BlockState> litBlockEmission(final int lightEmission) {
        return state -> state.getValue(BlockStateProperties.LIT) ? lightEmission : 0;
    }

    private static Function<BlockState, MapColor> waterloggedMapColor(final MapColor mapColor) {
        return blockState -> blockState.getValue(BlockStateProperties.WATERLOGGED) ? MapColor.WATER : mapColor;
    }

    public static Boolean never(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos, final EntityType<?> entityType) {
        return false;
    }


    public static Boolean always(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos, final EntityType<?> entityType) {
        return true;
    }

    public static Boolean ocelotOrParrot(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos, final EntityType<?> entityType) {
        return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
    }

    private static Block registerBed(final String id, final DyeColor color) {
        return register(
                id,
                p -> new BedBlock(color, p),
                BlockBehaviour.Properties.of()
                        .mapColor(state -> state.getValue(BedBlock.PART) == BedPart.FOOT ? color.getMapColor() : MapColor.WOOL)
                        .sound(SoundType.WOOD)
                        .strength(0.2F)
                        .noOcclusion()
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
        );
    }


    public static BlockBehaviour.Properties logProperties(final MapColor topColor, final MapColor sideColor, final SoundType soundType) {
        return BlockBehaviour.Properties.of()
                .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(soundType)
                .ignitedByLava();
    }

    public static BlockBehaviour.Properties netherStemProperties(final MapColor mapColor) {
        return BlockBehaviour.Properties.of().mapColor(state -> mapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.STEM);
    }

    static boolean always(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos) {
        return true;
    }


    public static boolean never(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos) {
        return false;
    }

    private static BlockPos postProcessSelf(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos) {
        return blockPos;
    }

    private static BlockPos postProcessAbove(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos) {
        return blockPos.above();
    }

    private static Block registerStainedGlass(final String id, final DyeColor color) {
        return register(
                id,
                p -> new StainedGlassBlock(color, p),
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .instrument(NoteBlockInstrument.HAT)
                        .strength(0.3F)
                        .sound(SoundType.GLASS)
                        .noOcclusion()
                        .isValidSpawn(Blocks::never)
                        .isRedstoneConductor(Blocks::never)
                        .isSuffocating(Blocks::never)
                        .isViewBlocking(Blocks::never)
        );
    }


    public static BlockBehaviour.Properties leavesProperties(final SoundType soundType) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .strength(0.2F)
                .randomTicks()
                .sound(soundType)
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating(Blocks::never)
                .isViewBlocking(Blocks::never)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY)
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
                .isViewBlocking(NOT_CLOSED_SHULKER)
                .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties pistonProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .strength(1.5F)
                .isRedstoneConductor(Blocks::never)
                .isSuffocating(NOT_EXTENDED_PISTON)
                .isViewBlocking(NOT_EXTENDED_PISTON)
                .pushReaction(PushReaction.BLOCK);
    }


    public static BlockBehaviour.Properties buttonProperties() {
        return BlockBehaviour.Properties.of().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY);
    }


    public static BlockBehaviour.Properties flowerPotProperties() {
        return BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties candleProperties(final MapColor color) {
        return BlockBehaviour.Properties.of()
                .mapColor(color)
                .noOcclusion()
                .strength(0.1F)
                .sound(SoundType.CANDLE)
                .lightLevel(CandleBlock.LIGHT_EMISSION)
                .pushReaction(PushReaction.DESTROY);
    }

    @Deprecated
    private static Block registerLegacyStair(final String id, final Block base) {
        return register(id, p -> new StairBlock(base.defaultBlockState(), p), BlockBehaviour.Properties.ofLegacyCopy(base));
    }

    private static Block registerStair(final String id, final Block base) {
        return register(id, p -> new StairBlock(base.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(base));
    }

    private static BlockBehaviour.Properties wallVariant(final Block standingBlock, final boolean copyName) {
        BlockBehaviour.Properties wallProperties = BlockBehaviour.Properties.of().overrideLootTable(standingBlock.getLootTable());
        if (copyName) {
            wallProperties = wallProperties.overrideDescription(standingBlock.getDescriptionId());
        }

        return wallProperties;
    }


    public static Block register(final ResourceKey<Block> id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }


    public static Block register(final ResourceKey<Block> id, final BlockBehaviour.Properties properties) {
        return register(id, Block::new, properties);
    }

    private static ResourceKey<Block> ModBlockId(final String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID,name));
    }

    private static Block register(final String id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        return register(ModBlockId(id), factory, properties);
    }

    private static Block register(final String id, final BlockBehaviour.Properties properties) {
        return register(id, Block::new, properties);
    }
    public static void register(){

    }
}
