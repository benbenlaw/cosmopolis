package com.benbenlaw.cosmopolis.block.custom;

import com.benbenlaw.cosmopolis.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class OrganicPowderSeedBlock extends Block {
    public OrganicPowderSeedBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        if (player.hasCorrectToolForDrops(this.defaultBlockState())) {

            List<Item> seeds = Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModTags.Items.ORGANIC_POWDER_SEED_SAPLING_DROPS).stream().toList();
            Random rand = new Random();
            Item randomSeed = seeds.get(rand.nextInt(seeds.size()));
            level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    new ItemStack(randomSeed)));
        }

        else {
            level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    new ItemStack(this)));
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
