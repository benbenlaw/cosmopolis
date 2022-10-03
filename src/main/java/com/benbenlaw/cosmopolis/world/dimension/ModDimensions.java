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

    public static final ResourceKey<Level> MINING_BELT =
            ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(
                    Cosmopolis.MOD_ID, "mining_belt"));

    public static final ResourceKey<Level> VENUS =
            ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(
                    Cosmopolis.MOD_ID, "venus"));

    public static final ResourceKey<Level> MARS =
            ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(
                    Cosmopolis.MOD_ID, "mars"));

    public static final ResourceKey<Level> MOON =
            ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(
                    Cosmopolis.MOD_ID, "moon"));



}



