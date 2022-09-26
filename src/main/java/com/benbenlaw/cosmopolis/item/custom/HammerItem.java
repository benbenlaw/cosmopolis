package com.benbenlaw.cosmopolis.item.custom;

import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.config.CosmopolisConfigFile;
import com.benbenlaw.cosmopolis.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.concurrent.Delayed;

public class HammerItem extends Item {
    public HammerItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        BlockPos blockPos = pContext.getClickedPos();
        Level world = pContext.getLevel();
        BlockState blockState = pContext.getLevel().getBlockState(blockPos);
        Player player = pContext.getPlayer();
        boolean hand = player.getMainHandItem().is(this);

        if (blockState.is(ModBlocks.ASTEROID_BLOCK.get())) {

            if (!world.isClientSide && hand) {

                world.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 1);
                player.playNotifySound(SoundEvents.STONE_BREAK, SoundSource.AMBIENT, 1.0f,1);
                player.getItemBySlot(EquipmentSlot.MAINHAND).hurtAndBreak(1, player,
                        (player1) -> player1.broadcastBreakEvent(player1.getUsedItemHand()));

                if (Math.random() > CosmopolisConfigFile.iceShardDropChance.get()) {
                    world.addFreshEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                            new ItemStack(ModItems.ICE_SHARD.get())));
                }
                if (Math.random() > CosmopolisConfigFile.asteroidRockDropchance.get()) {
                    world.addFreshEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                            new ItemStack(ModItems.ASTEROID_ROCK.get())));
                }

                if (Math.random() > CosmopolisConfigFile.rockDropchance.get()) {
                    world.addFreshEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                            new ItemStack(ModItems.ROCK.get())));
                }

                if (Math.random() > CosmopolisConfigFile.waterDropChance.get()) {
                    world.addFreshEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                            new ItemStack(ModItems.WATER_DROP.get())));
                }

                if (Math.random() > CosmopolisConfigFile.organicDropChance.get()) {
                    world.addFreshEntity(new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.01, blockPos.getZ()+ 0.5,
                            new ItemStack(ModItems.ORGANIC_POWDER.get())));
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}
