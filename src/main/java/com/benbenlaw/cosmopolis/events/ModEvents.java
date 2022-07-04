package com.benbenlaw.cosmopolis.events;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.item.ModItems;
import com.benbenlaw.cosmopolis.util.ModTags;
import com.benbenlaw.cosmopolis.world.ModBiomes;
import com.benbenlaw.cosmopolis.world.dimension.ModDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import java.util.UUID;

@Mod.EventBusSubscriber(modid = Cosmopolis.MOD_ID)

public class ModEvents {



    //Space Breathing
    @SubscribeEvent
    public static void spaceBreathing(TickEvent.PlayerTickEvent event) {

        Level world = event.player.getLevel();
        BlockPos blockPos = event.player.getOnPos();

        boolean head = event.player.getItemBySlot(EquipmentSlot.HEAD).is(ModTags.Items.SPACE_SUIT_HELMET);
        boolean chestplate = event.player.getItemBySlot(EquipmentSlot.CHEST).is(ModTags.Items.SPACE_SUIT_CHESTPLATE);
        boolean legs = event.player.getItemBySlot(EquipmentSlot.LEGS).is(ModTags.Items.SPACE_SUIT_LEGGINGS);
        boolean boots = event.player.getItemBySlot(EquipmentSlot.FEET).is(ModTags.Items.SPACE_SUIT_BOOTS);

        if (head && chestplate && boots && legs || world.getDifficulty().equals(Difficulty.PEACEFUL)) {}

        else if (event.player.getLevel().dimension().equals(ModDimensions.SPACE)) {
            event.player.hurt(DamageSource.OUT_OF_WORLD, 1);

            /*
            world.addFreshEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                    new ItemStack(ModItems.ASTEROID_ROCK.get())));

 event.player.M
             */

        }

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

            if (event.getState().is(Tags.Blocks.ORES))   //CHANGE TO ORES

                Minecraft.getInstance().player.sendMessage(msg, playerUUID);


                    world.addFreshEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                            new ItemStack(ModItems.ASTEROID_ROCK.get())));     //event.getPlayer().addItem(new ItemStack(ModItems.ADVANCED_MOB_ESSENCE.get().asItem()));  //event.getPlayer().setSecondsOnFire(3);
                    //new ItemStack(ModItems.BASIC_ORE_ESSENCE.get())));
                }

    }


     */


}