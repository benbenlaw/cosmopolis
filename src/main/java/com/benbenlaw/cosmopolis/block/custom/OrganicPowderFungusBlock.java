package com.benbenlaw.cosmopolis.block.custom;

import com.benbenlaw.cosmopolis.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.schedule.Schedule;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.ticks.ScheduledTick;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Async;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class OrganicPowderFungusBlock extends Block {
    public OrganicPowderFungusBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        if (player.hasCorrectToolForDrops(this.defaultBlockState())) {

            List<Item> fungus = Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModTags.Items.ORGANIC_POWDER_FUNGUS_BLOCK_DROPS).stream().toList();
            Random rand = new Random();
            Item randomFungus = fungus.get(rand.nextInt(fungus.size()));

            level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    new ItemStack(randomFungus)));
        }
        else {
            level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    new ItemStack(this)));
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
