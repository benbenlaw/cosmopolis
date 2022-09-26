package com.benbenlaw.cosmopolis.item.custom;

import com.benbenlaw.cosmopolis.item.ModCreativeModTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class AsteroidRockItem extends Item {

    final boolean hasBurnTime;

    public AsteroidRockItem(boolean burnTime) {
        super(new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)
                .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build()));

        this.hasBurnTime = burnTime;

    }
    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> type) {
        if(this.hasBurnTime == true) {
            return 100;
        }

        return -1;
    }
}
