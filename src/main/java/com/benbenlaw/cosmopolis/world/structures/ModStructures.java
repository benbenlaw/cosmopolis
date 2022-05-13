package com.benbenlaw.cosmopolis.world.structures;

import com.benbenlaw.cosmopolis.Cosmopolis;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModStructures {
    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Cosmopolis.MOD_ID);

    /**
     * Registers the base structure itself and sets what its path is. In this case,
     * this base structure will have the resourcelocation of structure_tutorial:sky_structures.
     */
    public static final RegistryObject<StructureFeature<?>> ASTEROIDS =
            DEFERRED_REGISTRY_STRUCTURE.register("asteroids", AsteroidStructures::new);

    public static final RegistryObject<StructureFeature<?>> ASTEROID_BUILDINGS =
            DEFERRED_REGISTRY_STRUCTURE.register("asteroid_buildings", AsteroidBuildingStructures::new);


    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }


}