package com.benbenlaw.cosmopolis.item.custom;

import com.benbenlaw.cosmopolis.item.ModCreativeModTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class MiniCoal extends Item {

    final boolean hasBurnTime;

    public MiniCoal(boolean burnTime) {
        super(new Properties().tab(ModCreativeModTab.COSMOPOLIS));

        this.hasBurnTime = burnTime;

    }
    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> type) {
        if(this.hasBurnTime) {
            return 200;
        }

        return -1;
    }
}
