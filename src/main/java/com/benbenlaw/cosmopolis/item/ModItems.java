package com.benbenlaw.cosmopolis.item;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.item.custom.ModArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cosmopolis.MOD_ID);

    public static final RegistryObject<Item> ASTEROID_ROCK = ITEMS.register("asteroid_rock", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));


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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}