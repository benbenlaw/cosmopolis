package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {


        ShapedRecipeBuilder.shaped(ModBlocks.BLACKSTONE_URANIUM_ORE.get(), 4)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModBlocks.ARTIFICIAL_PLANKS.get())
                .unlockedBy("", has(ModBlocks.ARTIFICIAL_PLANKS.get()))
                .save(pFinishedRecipeConsumer);


/*

        ShapedRecipeBuilder.shaped(ModBlocks.ARTIFICIAL_STAIRS.get().asItem(), 4).define('E', ModBlocks.ARTIFICIAL_PLANKS.get()).pattern("E  ").pattern("EE ").pattern("EEE").unlockedBy("has_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ARTIFICIAL_PLANKS.get()).build())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ARTIFICIAL_SLAB.get().asItem(), 6).define('E', ModBlocks.ARTIFICIAL_PLANKS.get()).pattern("EEE").unlockedBy("has_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ARTIFICIAL_PLANKS.get()).build())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ARTIFICIAL_FENCE.get().asItem(), 3).define('E', ModBlocks.ARTIFICIAL_PLANKS.get()).define('S', ModItems.ARTIFICIAL_STICK.get()).pattern("ESE").pattern("ESE").unlockedBy("has_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ARTIFICIAL_PLANKS.get()).build())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ARTIFICIAL_FENCE_GATE.get().asItem(), 1).define('E', ModBlocks.ARTIFICIAL_PLANKS.get()).define('S', ModItems.ARTIFICIAL_STICK.get()).pattern("SES").pattern("SES").unlockedBy("has_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ARTIFICIAL_PLANKS.get()).build())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ARTIFICIAL_DOOR.get().asItem(), 3).define('E', ModBlocks.ARTIFICIAL_PLANKS.get()).pattern("EE").pattern("EE").pattern("EE").unlockedBy("has_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ARTIFICIAL_PLANKS.get()).build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.ASTEROID_STAIRS.get().asItem(), 4).define('E', ModBlocks.ASTEROID_BLOCK.get()).pattern("E  ").pattern("EE ").pattern("EEE").unlockedBy("has_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ASTEROID_BLOCK.get()).build())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ASTEROID_SLAB.get().asItem(), 6).define('E', ModBlocks.ASTEROID_BLOCK.get()).pattern("EEE").unlockedBy("has_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ASTEROID_BLOCK.get()).build())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ASTEROID_WALL.get().asItem(), 6).define('E', ModBlocks.ASTEROID_BLOCK.get()).pattern("EEE").pattern("EEE").unlockedBy("has_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ASTEROID_BLOCK.get()).build())).save(pFinishedRecipeConsumer);

        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.ASTEROID_STAIRS.get().asItem(), ModBlocks.ASTEROID_BLOCK.get(), 1);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.ASTEROID_SLAB.get().asItem(), ModBlocks.ASTEROID_BLOCK.get(), 2);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.ASTEROID_WALL.get().asItem(), ModBlocks.ASTEROID_BLOCK.get(), 1);


 */





    }
}
