package com.benbenlaw.cosmopolis.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModTab {
    public static final CreativeModeTab COSMOPOLIS = new CreativeModeTab("Cosmopolis") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.ROCK.get());
        }
    };
}
