package com.benbenlaw.cosmopolis.item.custom;

import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.config.CosmopolisConfigFile;
import com.benbenlaw.cosmopolis.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class OrganicPowderItem extends Item {
    public OrganicPowderItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

    BlockPos blockPos = pContext.getClickedPos();
    Level world = pContext.getLevel();
    BlockState blockState = pContext.getLevel().getBlockState(blockPos);
    Player player = pContext.getPlayer();
    boolean hand = player.getMainHandItem().is(this);

        if (blockState.is(ModBlocks.ASTEROID_BLOCK.get()) && hand) {
            if (!world.isClientSide) {
                world.setBlock(blockPos, ModBlocks.ARTIFICIAL_PLANKS.get().defaultBlockState(), 1);
                player.playNotifySound(SoundEvents.AMETHYST_BLOCK_STEP, SoundSource.AMBIENT, 1.0f,1);
                player.getMainHandItem().shrink(1);
            }
        } return InteractionResult.SUCCESS;
    }
}
