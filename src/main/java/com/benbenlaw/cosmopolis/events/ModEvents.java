package com.benbenlaw.cosmopolis.events;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.item.ModItems;
import com.benbenlaw.cosmopolis.world.ModBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = Cosmopolis.MOD_ID)

public class ModEvents {

/*

    //Space Breathing
    @SubscribeEvent
    public static void spaceBreathing(TickEvent.PlayerTickEvent event) {

        TextComponent msg = new TextComponent("/say hello");
        UUID playerUUID = Minecraft.getInstance().player.getUUID();

        boolean head = event.player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.SPACE_SUIT_HELMET.get());
        boolean chestplate = event.player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.SPACE_SUIT_CHESTPLATE.get());
        boolean legs = event.player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.SPACE_SUIT_LEGGINGS.get());
        boolean boots = event.player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.SPACE_SUIT_BOOTS.get());

        if (head && chestplate && boots && legs) {
            Minecraft.getInstance().player.sendMessage(msg, playerUUID);

        };



}



    /*

    //All Ores Drop Essence
    @SubscribeEvent
    public static void allOreChance(BlockEvent.BreakEvent event) {
        if (!event.getPlayer().level.isClientSide()) {
            BlockPos blockPos = event.getPos(); //          Block block = event.getState().getBlock();
            Level world = (Level) event.getWorld();
            TextComponent msg = new TextComponent("/say hello");
            UUID playerUUID = Minecraft.getInstance().player.getUUID();

            if (event.getState().is(Tags.Blocks.ORES))  //CHANGE TO ORES

                Minecraft.getInstance().player.sendMessage(msg, playerUUID);


                    world.addFreshEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                            new ItemStack(ModItems.ASTEROID_ROCK.get())));     //event.getPlayer().addItem(new ItemStack(ModItems.ADVANCED_MOB_ESSENCE.get().asItem()));  //event.getPlayer().setSecondsOnFire(3);
                    //new ItemStack(ModItems.BASIC_ORE_ESSENCE.get())));
                }

    }


     */


}