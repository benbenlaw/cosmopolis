package com.benbenlaw.cosmopolis.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab COSMOPOLIS = new CreativeModeTab("Cosmopolis") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ROCK.get());
        }
    };
}
