package com.benbenlaw.cosmopolis.world;

import com.benbenlaw.cosmopolis.Cosmopolis;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, Cosmopolis.MOD_ID);

    public static final ResourceKey<Biome> SPACE = register("space");
    public static final ResourceKey<Biome> MINING_BELT = register("mining_belt");
    public static final ResourceKey<Biome> VENUS = register("venus");
    public static final ResourceKey<Biome> VENUS_HELLGROUND = register("venus_hellground");
    public static final ResourceKey<Biome> MARTIAN_ICE_CAP = register("martian_ice_cap");
    public static final ResourceKey<Biome> MARTIAN_PLANE = register("martian_plane");
    public static final ResourceKey<Biome> MOON = register("moon");
    public static final ResourceKey<Biome> MOON_SATELLITE_GRAVEYARD = register("moon_satellite_graveyard");


    private static ResourceKey<Biome> register(String name)     {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(Cosmopolis.MOD_ID, name));
        return key;
    }
    public static void register(IEventBus eventBus) {BIOMES.register(eventBus);
    }

}