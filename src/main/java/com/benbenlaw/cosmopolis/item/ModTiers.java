package com.benbenlaw.cosmopolis.item;

import com.benbenlaw.cosmopolis.block.ModBlocks;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModTiers {

    public static final ForgeTier ASTEROID = new ForgeTier(1,131,4.5f
            , 4f, 8, Tags.Blocks.NEEDS_GOLD_TOOL,
            () -> Ingredient.of(ModBlocks.ASTEROID_BLOCK.get()));
}
