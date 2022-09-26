package com.benbenlaw.cosmopolis.events;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.effect.ModEffects;
import com.benbenlaw.cosmopolis.util.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;


import java.util.UUID;

@Mod.EventBusSubscriber(modid = Cosmopolis.MOD_ID)

public class ModEvents {

    //Space Breathing
    @SubscribeEvent
    public static void spaceBreathing(TickEvent.@NotNull PlayerTickEvent event) {

        Level world = event.player.getLevel();
        Player player = event.player;

        if (!player.isCreative()) {

            boolean head = player.getItemBySlot(EquipmentSlot.HEAD).is(ModTags.Items.SPACE_SUIT_HELMET);
            boolean chestplate = player.getItemBySlot(EquipmentSlot.CHEST).is(ModTags.Items.SPACE_SUIT_CHESTPLATE);
            boolean legs = player.getItemBySlot(EquipmentSlot.LEGS).is(ModTags.Items.SPACE_SUIT_LEGGINGS);
            boolean boots = player.getItemBySlot(EquipmentSlot.FEET).is(ModTags.Items.SPACE_SUIT_BOOTS);

            if (head && chestplate && boots && legs || world.getDifficulty().equals(Difficulty.PEACEFUL)) {
            }

            else if (player.getLevel().getBiome(player.getOnPos()).is(ModTags.Biomes.NEEDS_SPACE_SUIT)){
                player.addEffect(new MobEffectInstance(ModEffects.NO_OXYGEN.get(), 1));
            }
        }
    }

    @SubscribeEvent
    public static void bannedInSpaceBlocks(BlockEvent.@NotNull EntityPlaceEvent event) {

        BlockState blockState = event.getPlacedBlock();
        Level level = (Level) event.getLevel();
        Entity player = event.getEntity();
        BlockPos pos = event.getPos();
        Holder<Biome> biome = event.getLevel().getBiome(pos);

        if (!level.isClientSide()) {

            if (blockState.is(ModTags.Blocks.BANNED_IN_SPACE_BLOCKS)){
                if(biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
                    event.setCanceled(true);
                    player.sendSystemMessage(Component.translatable("This block can not be placed here!").withStyle(ChatFormatting.DARK_RED));
                }
            }
        }
    }

    @SubscribeEvent
    public static void bannedInSpaceItems(PlayerInteractEvent.@NotNull RightClickItem event) {

        Entity player = event.getEntity();
        Level level = player.getLevel();
        BlockPos pos = event.getPos();
        Holder<Biome> biome = event.getLevel().getBiome(pos);
        ItemStack mainHandItem = event.getEntity().getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack offHandItem = event.getEntity().getItemInHand(InteractionHand.OFF_HAND);

        if (!level.isClientSide()) {

            if (mainHandItem.is(ModTags.Items.BANNED_IN_SPACE_ITEMS) && biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
                event.setCanceled(true);
                player.sendSystemMessage(Component.translatable("This item can not be used here!").withStyle(ChatFormatting.DARK_RED));
            }

            if (offHandItem.is(ModTags.Items.BANNED_IN_SPACE_ITEMS) && biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
                event.setCanceled(true);
                player.sendSystemMessage(Component.translatable("This item can not be used here!").withStyle(ChatFormatting.DARK_RED));
            }
        }
    }



}