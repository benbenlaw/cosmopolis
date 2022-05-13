package com.benbenlaw.cosmopolis.world.dimension;

import com.benbenlaw.cosmopolis.Cosmopolis;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;


public class ModDimensions {

    public static final ResourceKey<Level> SPACE =
            ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(
                    Cosmopolis.MOD_ID, "space"));
    }



