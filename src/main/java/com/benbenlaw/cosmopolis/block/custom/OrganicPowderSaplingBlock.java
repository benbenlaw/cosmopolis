package com.benbenlaw.cosmopolis.block.custom;

import com.benbenlaw.cosmopolis.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class OrganicPowderSaplingBlock extends Block {
    public OrganicPowderSaplingBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        if (player.hasCorrectToolForDrops(this.defaultBlockState())) {

            List<Item> saplings = Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModTags.Items.ORGANIC_POWDER_FUNGUS_SAPLING_DROPS).stream().toList();
            Random rand = new Random();
            Item randomSapling = saplings.get(rand.nextInt(saplings.size()));

            level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    new ItemStack(randomSapling)));
        }

        else {
            level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    new ItemStack(this)));
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
