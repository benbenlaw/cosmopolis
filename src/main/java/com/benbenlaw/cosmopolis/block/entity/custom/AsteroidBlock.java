package com.benbenlaw.cosmopolis.block.entity.custom;

import com.benbenlaw.cosmopolis.config.CosmopolisConfigFile;
import com.benbenlaw.cosmopolis.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class AsteroidBlock extends Block {
    public AsteroidBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        if (player.getMainHandItem().is(ModItems.HAMMER.get())) {

            if (Math.random() > CosmopolisConfigFile.iceShardDropChance.get()) {
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(),
                        new ItemStack(ModItems.ICE_SHARD.get())));
            }
            if (Math.random() > CosmopolisConfigFile.asteroidRockDropchance.get()) {
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(),
                        new ItemStack(ModItems.ASTEROID_ROCK.get())));
            }

            if (Math.random() > CosmopolisConfigFile.rockDropchance.get()) {
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(),
                        new ItemStack(ModItems.ROCK.get())));
            }

            if (Math.random() > CosmopolisConfigFile.waterDropChance.get()) {
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(),
                        new ItemStack(ModItems.WATER_DROP.get())));
            }

            if (Math.random() > CosmopolisConfigFile.organicDropChance.get()) {
                level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.01, pos.getZ()+ 0.5,
                        new ItemStack(ModItems.ORGANIC_POWDER.get())));
            }
        }
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
