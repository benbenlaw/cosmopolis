package com.benbenlaw.cosmopolis.world.dimension;

import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.entity.custom.TeleporterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.util.ITeleporter;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class SpaceDimensionTeleporter implements ITeleporter {

    private BlockPos pos;

    public SpaceDimensionTeleporter(BlockPos pos) {
        this.pos = pos;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        Entity e = repositionEntity.apply(false);
        if (!(e instanceof ServerPlayer)) {
            return e;
        }
        ServerPlayer player = (ServerPlayer) e;
        LevelChunk chunk = (LevelChunk) destWorld.getChunk(pos);
        BlockPos teleporterPos = findPortalInChunk(chunk);

        if (teleporterPos == null) {
            if (destWorld.dimension().equals(ModDimensions.SPACE)) {
                teleporterPos = placeTeleporterMining(destWorld, chunk);
            } else {
                teleporterPos = placeTeleporterOverworld(destWorld, chunk);
            }
        }
        if (teleporterPos == null) {
            return e;
        }

        player.giveExperienceLevels(0);
        player.teleportTo(teleporterPos.getX() + 0.5D, teleporterPos.getY() + 1D, teleporterPos.getZ() + 0.5D);
        return e;
    }

    private BlockPos findPortalInChunk(LevelChunk chunk) {
        Stream<Map.Entry<BlockPos, BlockEntity>> stream = chunk.getBlockEntities()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() instanceof TeleporterBlockEntity);

        BlockPos teleporter;

        if (true) {
            teleporter = stream.sorted(Comparator.comparingInt(o -> o.getKey().getY())).map(Map.Entry::getKey).findFirst().orElse(null);
        } else {
            teleporter = stream.sorted((o1, o2) -> o2.getKey().getY() - o1.getKey().getY()).map(Map.Entry::getKey).findFirst().orElse(null);
        }

        if (teleporter != null) {
            if (chunk.getBlockState(teleporter.above()).isAir()) {
                return teleporter;
            }
        }
        return null;
    }

    private BlockPos placeTeleporterMining(ServerLevel world, LevelChunk chunk) {
        boolean deep = true;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int min = world.getMinBuildHeight();
        int max = world.getMaxBuildHeight();
        for (int y = deep ? min : max - 1; (deep ? y < max - 1 : y >= min); y = (deep ? y + 1 : y - 1)) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    pos.set(x, 0, z);
                    if (chunk.getBlockState(pos).isAir() && chunk.getBlockState(pos.above(1)).isAir() && chunk.getBlockState(pos.above(2)).isAir()) {
                        BlockPos absolutePos = chunk.getPos().getWorldPosition().offset(pos.getX(), pos.getY(), pos.getZ());
                        world.setBlockAndUpdate(absolutePos, ModBlocks.TELEPORTER.get().defaultBlockState());
                        return absolutePos;
                    }
                }
            }
        }

        for (int y = deep ? min : max - 1; (deep ? y < max - 1 : y >= min); y = (deep ? y + 1 : y - 1)) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    pos.set(x, y, z);
                    if (isAirOrAsteroid(chunk, pos) && isAirOrAsteroid(chunk, pos.above(1)) && isAirOrAsteroid(chunk, pos.above(2))) {
                        BlockPos absolutePos = chunk.getPos().getWorldPosition().offset(pos.getX(), pos.getY(), pos.getZ());
                        if (isReplaceable(world, absolutePos.above(3)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.NORTH)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.NORTH)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.SOUTH)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.EAST)) &&
                                isReplaceable(world, absolutePos.above(1).relative(Direction.WEST)) &&
                                isReplaceable(world, absolutePos.above(2).relative(Direction.NORTH)) &&
                                isReplaceable(world, absolutePos.above(2).relative(Direction.SOUTH)) &&
                                isReplaceable(world, absolutePos.above(2).relative(Direction.EAST)) &&
                                isReplaceable(world, absolutePos.above(2).relative(Direction.WEST))
                        ) {
                            world.setBlockAndUpdate(absolutePos, ModBlocks.TELEPORTER.get().defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(1), Blocks.AIR.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2), Blocks.AIR.defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(3), ModBlocks.ASTEROID_BLOCK.get().defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(1).relative(Direction.NORTH), ModBlocks.ASTEROID_BLOCK.get().defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(1).relative(Direction.SOUTH), ModBlocks.ASTEROID_BLOCK.get().defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(1).relative(Direction.EAST), ModBlocks.ASTEROID_BLOCK.get().defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(1).relative(Direction.WEST), ModBlocks.ASTEROID_BLOCK.get().defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2).relative(Direction.NORTH), ModBlocks.ASTEROID_BLOCK.get().defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2).relative(Direction.SOUTH), ModBlocks.ASTEROID_BLOCK.get().defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2).relative(Direction.EAST), ModBlocks.ASTEROID_BLOCK.get().defaultBlockState());
                            world.setBlockAndUpdate(absolutePos.above(2).relative(Direction.WEST), ModBlocks.ASTEROID_BLOCK.get().defaultBlockState());
                            return absolutePos;
                        }
                    }
                }
            }
        }

        return null;
    }

    private boolean isAirOrAsteroid(LevelChunk chunk, BlockPos pos) {
        BlockState state = chunk.getBlockState(pos);
        return state.getBlock().equals(ModBlocks.ASTEROID_BLOCK.get()) || state.isAir();
    }

    private boolean isReplaceable(Level world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.getBlock().equals(ModBlocks.ASTEROID_BLOCK.get()) ||
                state.isAir();
    }

    private BlockPos placeTeleporterOverworld(ServerLevel world, LevelChunk chunk) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = -20; y < world.getMaxBuildHeight(); y++) {
                    pos.set(x, y, z);
                    if (chunk.getBlockState(pos).isAir() && chunk.getBlockState(pos.above(1)).isAir()) {
                        BlockPos absolutePos = chunk.getPos().getWorldPosition().offset(pos.getX(), pos.getY(), pos.getZ());
                        world.setBlockAndUpdate(absolutePos, ModBlocks.TELEPORTER.get().defaultBlockState());
                        return absolutePos;
                    }
                }
            }
        }
        return null;
    }

}
