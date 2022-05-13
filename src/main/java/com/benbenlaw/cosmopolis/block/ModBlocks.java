package com.benbenlaw.cosmopolis.block;

import com.benbenlaw.cosmopolis.Cosmopolis;

import com.benbenlaw.cosmopolis.item.ModCreativeModTab;
import com.benbenlaw.cosmopolis.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Cosmopolis.MOD_ID);



//New Blocks

    public static final RegistryObject<Block> ASTEROID_BLOCK = registerBlock("asteroid_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0f, 6f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ARTIFICIAL_PLANKS = registerBlock("artificial_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0f, 3f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> VENUS_FUNGUS = registerBlock("venus_fungus",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f, 0.5f).sound(SoundType.CROP)));

    public static final RegistryObject<Block> MARS_FUNGUS = registerBlock("mars_fungus",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f, 0.5f).sound(SoundType.CROP)));






    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
