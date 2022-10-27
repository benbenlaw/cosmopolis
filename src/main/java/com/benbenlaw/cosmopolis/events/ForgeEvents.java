package com.benbenlaw.cosmopolis.events;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.entity.ModEntities;
import com.benbenlaw.cosmopolis.entity.UFOModel;
import com.benbenlaw.cosmopolis.entity.UFORenderer;
import com.benbenlaw.cosmopolis.entity.custom.UFOEntity;
import com.benbenlaw.cosmopolis.util.ModTags;
import com.benbenlaw.cosmopolis.world.dimension.ModDimensions;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cosmopolis.MOD_ID)
public class ForgeEvents {


    //Space Breathing
    @SubscribeEvent
    public static void spaceBreathing(TickEvent.PlayerTickEvent event) {

        if (!event.player.isCreative()) {

            Level world = event.player.getLevel();

            boolean head = event.player.getItemBySlot(EquipmentSlot.HEAD).is(ModTags.Items.SPACE_SUIT_HELMET);
            boolean chestplate = event.player.getItemBySlot(EquipmentSlot.CHEST).is(ModTags.Items.SPACE_SUIT_CHESTPLATE);
            boolean legs = event.player.getItemBySlot(EquipmentSlot.LEGS).is(ModTags.Items.SPACE_SUIT_LEGGINGS);
            boolean boots = event.player.getItemBySlot(EquipmentSlot.FEET).is(ModTags.Items.SPACE_SUIT_BOOTS);

            if (head && chestplate && boots && legs || world.getDifficulty().equals(Difficulty.PEACEFUL)) {
            } else if (event.player.getLevel().dimension().equals(ModDimensions.SPACE)) {
                event.player.hurt(DamageSource.OUT_OF_WORLD, 1);

            }
        }
    }


    // UFO Entity

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


