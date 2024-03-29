package com.benbenlaw.cosmopolis.villager;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Cosmopolis.MOD_ID);

    public static final RegistryObject<PoiType> SPACE_PORTAL =
            POI.register("space_portal", () -> new PoiType(ImmutableSet.copyOf(
                    ModBlocks.SPACE_PORTAL.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<PoiType> MINING_BELT_PORTAL =
            POI.register("mining_dimension_portal", () -> new PoiType(ImmutableSet.copyOf(
                    ModBlocks.MINING_BELT_PORTAL.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<PoiType> VENUS_PORTAL =
            POI.register("venus_portal", () -> new PoiType(ImmutableSet.copyOf(
                    ModBlocks.VENUS_PORTAL.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<PoiType> MARS_PORTAL =
            POI.register("mars_portal", () -> new PoiType(ImmutableSet.copyOf(
                    ModBlocks.MARS_PORTAL.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<PoiType> MOON_PORTAL =
            POI.register("moon_portal", () -> new PoiType(ImmutableSet.copyOf(
                    ModBlocks.MOON_PORTAL.get().getStateDefinition().getPossibleStates()), 1, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}