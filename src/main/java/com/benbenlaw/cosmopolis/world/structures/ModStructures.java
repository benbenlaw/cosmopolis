package com.benbenlaw.cosmopolis.world.structures;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModStructures {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE
            = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, Cosmopolis.MOD_ID);


  //   * Registers the base structure itself and sets what its path is. In this case,
  //   * this base structure will have the resourcelocation of structure_tutorial:sky_structures.


    public static final RegistryObject<StructureType<?>> ASTEROIDS =
            DEFERRED_REGISTRY_STRUCTURE.register("asteroids", () -> typeConvert(AsteroidStructures.CODEC));

    public static final RegistryObject<StructureType<?>> ASTEROID_BUILDINGS =
            DEFERRED_REGISTRY_STRUCTURE.register("asteroid_buildings", () -> typeConvert(AsteroidBuildingStructures.CODEC));

    public static final RegistryObject<StructureType<?>> MINING_BELT_ASTEROID =
            DEFERRED_REGISTRY_STRUCTURE.register("mining_belt", () -> typeConvert(MiningBeltAsteroidStructure.CODEC));


    public static <S extends Structure> StructureType<S> typeConvert(Codec<S> codec) {
        return () -> codec;
    }

    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }



}
