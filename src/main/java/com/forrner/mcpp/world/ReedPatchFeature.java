package com.forrner.mcpp.world;

import com.forrner.mcpp.block.ModBlocks;
import com.forrner.mcpp.block.custom.ReedBlock;
import com.forrner.mcpp.tag.ModBlockTags;
import com.forrner.mcpp.util.TripleBlockPart;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReedPatchFeature extends Feature<ReedPatchFeature.Config> {

    /**
     * @param reedCount     一次最多长多少株
     * @param searchRadius  水平搜索半径，候选池越大越容易长满一丛
     * @param maxRadius     一丛的生长半径上限：离丛心超过这个距离就不长，防止沿河岸被拉成一条线
     * @param maxSpacing    新株必须落在已有芦苇 N 格以内；直接决定一丛能长多大
     * @param verticalRange 垂直搜索半径
     */
    public record Config(int reedCount, int searchRadius, int maxRadius, int maxSpacing, int verticalRange)
            implements FeatureConfiguration {

        public static final Codec<Config> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                ExtraCodecs.POSITIVE_INT.fieldOf("reed_count").forGetter(Config::reedCount),
                ExtraCodecs.POSITIVE_INT.fieldOf("search_radius").forGetter(Config::searchRadius),
                ExtraCodecs.POSITIVE_INT.fieldOf("max_radius").forGetter(Config::maxRadius),
                ExtraCodecs.POSITIVE_INT.fieldOf("max_spacing").forGetter(Config::maxSpacing),
                ExtraCodecs.POSITIVE_INT.fieldOf("vertical_range").forGetter(Config::verticalRange)
        ).apply(instance, Config::new));
    }

    public ReedPatchFeature(Codec<Config> codec) {
        super(codec);
    }

    private static boolean canSustainReed(final BlockState stateBelow) {
        return stateBelow.is(ModBlockTags.CAN_SUSTAIN_REED);
    }

    private static boolean isValidReedSpot(final WorldGenLevel level, final BlockPos waterPos) {
        if (level.isOutsideBuildHeight(waterPos.above(2))) {
            return false;
        }

        FluidState fluid = level.getFluidState(waterPos);
        if (!fluid.is(Fluids.WATER) || !fluid.isSource()) {
            return false;
        }

        if (!level.getBlockState(waterPos.above()).isAir()) {
            return false;
        }
        if (!level.getBlockState(waterPos.above(2)).isAir()) {
            return false;
        }

        return canSustainReed(level.getBlockState(waterPos.below()));
    }

    @Override
    public boolean place(final FeaturePlaceContext<Config> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        Config config = context.config();

        final int scanRadius = Math.min(config.searchRadius(), config.maxRadius());
        final int vertical = config.verticalRange();
        final double maxRadiusSqr = (double) config.maxRadius() * config.maxRadius();

        List<BlockPos> candidates = new ArrayList<>();

        for (int dx = -scanRadius; dx <= scanRadius; dx++) {
            for (int dz = -scanRadius; dz <= scanRadius; dz++) {
                if ((double) dx * dx + (double) dz * dz > maxRadiusSqr) {
                    continue;
                }

                if (!level.ensureCanWrite(origin.offset(dx, 0, dz))) {
                    continue;
                }

                for (int dy = -vertical; dy <= vertical; dy++) {
                    BlockPos waterPos = origin.offset(dx, dy, dz);
                    if (isValidReedSpot(level, waterPos)) {
                        candidates.add(waterPos);
                        break;
                    }
                }
            }
        }

        if (candidates.isEmpty()) {
            return false;
        }


        for (int i = candidates.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            BlockPos tmp = candidates.get(i);
            candidates.set(i, candidates.get(j));
            candidates.set(j, tmp);
        }

        final List<BlockPos> placed = new ArrayList<>();
        final Set<BlockPos> alreadyPlaced = new HashSet<>();
        final double maxSpacingSqr = (double) config.maxSpacing() * config.maxSpacing();

        while (placed.size() < config.reedCount()) {
            BlockPos best = null;
            double bestDist = -1.0;

            for (BlockPos pos : candidates) {
                if (alreadyPlaced.contains(pos)) {
                    continue;
                }
                if (isOccupied(level, pos)) {
                    continue;
                }

                double dist;
                if (placed.isEmpty()) {
                    dist = 0.0;
                } else {
                    dist = closestSqr(placed, pos);
                    if (dist > maxSpacingSqr) {
                        continue;
                    }
                }

                if (dist > bestDist) {
                    bestDist = dist;
                    best = pos;
                }
            }

            if (best == null) {
                break;
            }

            if (ReedBlock.placeAt(level, best, 2)) {
                placed.add(best);
                alreadyPlaced.add(best);
            } else {
                candidates.remove(best);
            }
        }

        return !placed.isEmpty();
    }

    private static double closestSqr(final List<BlockPos> placed, final BlockPos pos) {
        double best = Double.MAX_VALUE;
        for (BlockPos other : placed) {
            double dx = other.getX() - pos.getX();
            double dy = other.getY() - pos.getY();
            double dz = other.getZ() - pos.getZ();
            double d = dx * dx + dy * dy + dz * dz;
            if (d < best) {
                best = d;
            }
        }
        return best;
    }

    private static boolean isOccupied(final WorldGenLevel level, final BlockPos pos) {
        for (int dy = -2; dy <= 2; dy++) {
            BlockState state = level.getBlockState(pos.offset(0, dy, 0));
            if (state.is(ModBlocks.REED) && state.getValue(ReedBlock.PART) == TripleBlockPart.LOWER) {
                return true;
            }
        }
        return false;
    }
}
