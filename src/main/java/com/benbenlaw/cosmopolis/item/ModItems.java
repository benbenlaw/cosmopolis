package com.benbenlaw.cosmopolis.item;

import com.benbenlaw.cosmopolis.Cosmopolis;

import com.benbenlaw.cosmopolis.item.custom.AsteroidRock;
import com.benbenlaw.cosmopolis.item.custom.MiniCoal;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cosmopolis.MOD_ID);

    public static final RegistryObject<Item> ROCK = ITEMS.register("rock", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> ASTEROID_ROCK = ITEMS.register("asteroid_rock", () -> new AsteroidRock(true));
    public static final RegistryObject<Item> MINI_COAL = ITEMS.register("mini_coal", () -> new MiniCoal(true));
    public static final RegistryObject<Item> MINI_CHARCOAL = ITEMS.register("mini_charcoal", () -> new MiniCoal(true));

//Armor

    public static final RegistryObject<Item> SPACE_SUIT_BOOTS = ITEMS.register("space_suit_boots", () ->
            new ArmorItem(ModArmorMaterial.spacesuit, EquipmentSlot.FEET,
            new  Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> SPACE_SUIT_LEGGINGS = ITEMS.register("space_suit_leggings", () ->
            new ArmorItem(ModArmorMaterial.spacesuit, EquipmentSlot.LEGS,
            new  Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> SPACE_SUIT_CHESTPLATE = ITEMS.register("space_suit_chestplate", () ->
            new ArmorItem(ModArmorMaterial.spacesuit, EquipmentSlot.CHEST,
            new  Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> SPACE_SUIT_HELMET = ITEMS.register("space_suit_helmet", () ->
            new ArmorItem(ModArmorMaterial.spacesuit, EquipmentSlot.HEAD, //change to ModArmorItem to enable full suit effect
            new  Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

//Tools

    public static final RegistryObject<Item> ASTEROID_PICKAXE = ITEMS.register("asteroid_pickaxe", () ->
            new PickaxeItem(ModTiers.ASTEROID, 1, 1f,
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> ASTEROID_HOE = ITEMS.register("asteroid_hoe", () ->
            new HoeItem(ModTiers.ASTEROID, 0, 1f,
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> ASTEROID_AXE = ITEMS.register("asteroid_axe", () ->
            new AxeItem(ModTiers.ASTEROID, 2, 1f,
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> ASTEROID_SWORD = ITEMS.register("asteroid_sword", () ->
            new SwordItem(ModTiers.ASTEROID, 3, 2f,
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> ASTEROID_SHOVEL = ITEMS.register("asteroid_shovel", () ->
            new ShovelItem(ModTiers.ASTEROID, 1, 1f,
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

//Misc

    public static final RegistryObject<Item> WATER_DROP = ITEMS.register("water_drop", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> ORGANIC_POWDER = ITEMS.register("organic_powder", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> VENUS_SPORES = ITEMS.register("venus_spores", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> MARS_SPORES = ITEMS.register("mars_spores", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> PLANETARY_CORE_TELEPORTER = ITEMS.register("planetary_core_teleporter", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    public static final RegistryObject<Item> ASTEROID_STEW = ITEMS.register("asteroid_stew", () -> new BowlFoodItem(
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.4F).build())));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
