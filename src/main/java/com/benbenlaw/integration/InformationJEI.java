package com.benbenlaw.integration;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.item.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class InformationJEI implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Cosmopolis.MOD_ID, "information");
    }
     @Override
    public void registerRecipes(IRecipeRegistration reg) {

        reg.addIngredientInfo(new ItemStack(ModItems.HAMMER.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.cosmopolis.hammer"));
        reg.addIngredientInfo(new ItemStack(ModItems.WATER_DROP.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.cosmopolis.hammer"));
        reg.addIngredientInfo(new ItemStack(ModItems.ORGANIC_POWDER.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.cosmopolis.hammer"));
        reg.addIngredientInfo(new ItemStack(ModItems.ASTEROID_ROCK.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.cosmopolis.hammer"));
        reg.addIngredientInfo(new ItemStack(ModItems.ROCK.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.cosmopolis.hammer"));
        reg.addIngredientInfo(new ItemStack(ModItems.ICE_SHARD.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.cosmopolis.hammer"));

        reg.addIngredientInfo(new ItemStack(ModBlocks.ARTIFICIAL_PLANKS.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.cosmopolis.artificial_planks"));

    }
}