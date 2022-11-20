package com.benbenlaw.cosmopolis.events;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.config.CosmopolisConfigFile;
import com.benbenlaw.cosmopolis.damage.ModDamageSources;
import com.benbenlaw.cosmopolis.effect.ModEffects;
import com.benbenlaw.cosmopolis.entity.ModEntities;
import com.benbenlaw.cosmopolis.entity.UFOModel;
import com.benbenlaw.cosmopolis.entity.UFORenderer;
import com.benbenlaw.cosmopolis.entity.custom.UFOEntity;
import com.benbenlaw.cosmopolis.item.ModItems;
import com.benbenlaw.cosmopolis.util.ModTags;
import com.benbenlaw.cosmopolis.world.dimension.ModDimensions;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Cosmopolis.MOD_ID)

public class ModEvents {

    @SubscribeEvent
    public static void onAttributeCreate(@NotNull EntityAttributeCreationEvent event) {
        event.put(ModEntities.UFO.get(), UFOEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.@NotNull RegisterLayerDefinitions event) {
        event.registerLayerDefinition(UFOModel.LAYER_LOCATION, UFOModel::createBodyLayer);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.@NotNull RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.UFO.get(), UFORenderer::new);
    }

    @SubscribeEvent
    public static void changePlayerGravity(TickEvent.@NotNull PlayerTickEvent event) {

        Player player = event.player;
        Level level = player.getLevel();
        BlockPos pos = player.getOnPos();
        Holder<Biome> biome = level.getBiome(pos);

        float OVERWORLD = 0.08F;
        float SPACE = 0.04F;

        if (biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
            Objects.requireNonNull(player.getAttribute(ForgeMod.ENTITY_GRAVITY.get())).setBaseValue(SPACE);
        }

        else if (!biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
            Objects.requireNonNull(player.getAttribute(ForgeMod.ENTITY_GRAVITY.get())).setBaseValue(OVERWORLD);
        }
    }

    @SubscribeEvent
    public static void changeItemEntitiesGravity (@NotNull ItemTossEvent event) {
        ItemEntity entity = event.getEntity();
        Level level = entity.getLevel();
        BlockPos pos = entity.getOnPos();
        Holder<Biome> biome = level.getBiome(pos);

        if (biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
            entity.setDeltaMovement(entity.getDeltaMovement().x,entity.getDeltaMovement().y + 0.12, entity.getDeltaMovement().z);

        }

    }

    @SubscribeEvent
    public static void changeEntityGravity (LivingEvent.@NotNull LivingTickEvent event) {

        Entity entity = event.getEntity();
        Level level = entity.getLevel();
        BlockPos pos = entity.getOnPos();
        Holder<Biome> biome = level.getBiome(pos);

        float OVERWORLD = 0.08F;
        float SPACE = 0.04F;

        if (biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
            event.getEntity().getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue(SPACE);
        }

        else if (!biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
            event.getEntity().getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue(OVERWORLD);
        }

    }

    @SubscribeEvent
    public static void dealDamageToPlayers(TickEvent.@NotNull PlayerTickEvent event) {

        Level world = event.player.getLevel();
        Player player = event.player;

        if (!player.isCreative()) {

            boolean head = player.getItemBySlot(EquipmentSlot.HEAD).is(ModTags.Items.SPACE_SUIT_HELMET);
            boolean chestplate = player.getItemBySlot(EquipmentSlot.CHEST).is(ModTags.Items.SPACE_SUIT_CHESTPLATE);
            boolean legs = player.getItemBySlot(EquipmentSlot.LEGS).is(ModTags.Items.SPACE_SUIT_LEGGINGS);
            boolean boots = player.getItemBySlot(EquipmentSlot.FEET).is(ModTags.Items.SPACE_SUIT_BOOTS);

            if (head && chestplate && boots && legs || world.getDifficulty().equals(Difficulty.PEACEFUL) ||
                    player.hasEffect(ModEffects.AFTER_DEATH_PROTECTION.get())) {
            }
            else if (player.getLevel().getBiome(player.getOnPos()).is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
                player.addEffect(new MobEffectInstance(ModEffects.NO_OXYGEN.get(), 1));
            }
        }
    }

    @SubscribeEvent
    public static void dealDamageToEntities(LivingEvent.@NotNull LivingTickEvent event) {

        Entity entity = event.getEntity();
        Level level = entity.getLevel();
        BlockPos pos = entity.getOnPos();
        Holder<Biome> biome = level.getBiome(pos);

        if (entity instanceof Player) {

        }
        else if (entity instanceof EnderMan) {

        }
        else if (entity instanceof Blaze) {

        }
        else if (entity instanceof Slime) {

        }
        else if (entity instanceof MagmaCube) {

        }
        else if (entity instanceof Endermite) {

        }
        else if (entity instanceof Phantom) {

        }
        else if (biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
            entity.hurt(ModDamageSources.NO_OXYGEN, 1);
        }
    }


    @SubscribeEvent
    public static void marsSandstoneDropsGems(BlockEvent.@NotNull BreakEvent event) {

        Level level = event.getPlayer().getLevel();
        BlockPos pos = event.getPos();
        BlockState block = event.getLevel().getBlockState(pos);

        List<Item> gems = Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(Tags.Items.GEMS).stream().toList();
        Random rand = new Random();
        Item randomGem = gems.get(rand.nextInt(gems.size()));

        if (level.dimension().equals(ModDimensions.MARS)) {
            if (block.is(Blocks.RED_SANDSTONE)) {
               if (pos.getY() <=0 ) {
                   if (Math.random() > CosmopolisConfigFile.gemsDropOnMars.get()) {
                      level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(),
                              new ItemStack(randomGem)));
                  }
               }
            }
        }
    }

    @SubscribeEvent
    public static void moonBlackstoneDropsPrismarine(BlockEvent.@NotNull BreakEvent event) {

        Level level = event.getPlayer().getLevel();
        BlockPos pos = event.getPos();
        BlockState block = event.getLevel().getBlockState(pos);

        if (level.dimension().equals(ModDimensions.MOON)) {
            if (block.is(Blocks.BLACKSTONE)) {
               if (pos.getY() <=0 ) {
                   if (Math.random() > CosmopolisConfigFile.prismarineDropsOnMoon.get()) {
                      level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(),
                              new ItemStack(Items.PRISMARINE_SHARD)));
                  }
               }
            }
        }
    }

    @SubscribeEvent
    public static void noFallDamageInSpace(TickEvent.@NotNull PlayerTickEvent event) {

        Player player = event.player;

        if(player.getLevel().getBiome(player.getOnPos()).is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
            player.resetFallDistance();
        }
    }

    @SubscribeEvent
    public static void bannedInSpaceItems(PlayerInteractEvent.@NotNull RightClickBlock event) {

        Entity player = event.getEntity();
        Level level = player.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = event.getLevel().getBlockState(pos);
        Holder<Biome> biome = event.getLevel().getBiome(pos);
        ItemStack mainHandItem = event.getEntity().getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack offHandItem = event.getEntity().getItemInHand(InteractionHand.OFF_HAND);

        if (!level.isClientSide()) {
            if (mainHandItem.is(Tags.Items.SEEDS) || offHandItem.is(Tags.Items.SEEDS) || mainHandItem.is(ModTags.Items.BANNED_IN_SPACE_ITEMS) || offHandItem.is(ModTags.Items.BANNED_IN_SPACE_ITEMS)) {
                if (biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
                    if (state.is(Blocks.FARMLAND) || state.is(BlockTags.DIRT)) {
                        event.setCanceled(true);
                        player.sendSystemMessage(Component.translatable("This item can not be used here!").withStyle(ChatFormatting.DARK_RED));
                    }
                }
            }
        }
    }


    @SubscribeEvent
    public static void noTorches(BlockEvent.@NotNull EntityPlaceEvent event) {

        BlockState blockState = event.getPlacedBlock();
        Level level = (Level) event.getLevel();
        Entity player = event.getEntity();
        BlockPos pos = event.getPos();
        Holder<Biome> biome = event.getLevel().getBiome(pos);

        if (!level.isClientSide()) {
            if (blockState.is(Blocks.TORCH) || blockState.is(Blocks.WALL_TORCH)) {
                if (biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
                    event.setCanceled(true);
                    player.sendSystemMessage(Component.translatable("Normal lanterns can not be used in space use glowstone ones").withStyle(ChatFormatting.DARK_RED));
        // //           level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(),
         //                   new ItemStack(Items.STICK)));

                }
            }
        }
        if (!level.isClientSide()) {
            if (blockState.is(Blocks.LANTERN)) {
                if (biome.is(ModTags.Biomes.NEEDS_SPACE_SUIT)) {
                    event.setCanceled(true);
                    player.sendSystemMessage(Component.translatable("Normal lanterns can not be used in space use glowstone ones").withStyle(ChatFormatting.DARK_RED));
          //          level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(),
         //                   new ItemStack(Items.STICK)));
                }
            }
        }
    }

}