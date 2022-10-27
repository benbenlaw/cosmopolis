package com.benbenlaw.cosmopolis.world.feature;

import com.benbenlaw.cosmopolis.Cosmopolis;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Cosmopolis.MOD_ID);


    //Spawn Essence Ore in Overworld
    //TODO: work out how to get config values correct instead of .getDefault() using .get() //

    public static final RegistryObject<PlacedFeature> BLACKSTONE_CHEESE_ORE_PLACED = PLACED_FEATURES.register("blackstone_cheese_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BLACKSTONE_CHEESE_ORE_COSMOPOLIS.getHolder().get(),
                    commonOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60),
                    VerticalAnchor.aboveBottom(120)))));

    public static final RegistryObject<PlacedFeature> BLACKSTONE_DIAMOND_ORE_PLACED = PLACED_FEATURES.register("blackstone_diamond_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BLACKSTONE_DIAMOND_ORE_COSMOPOLIS.getHolder().get(),
                    commonOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60),
                    VerticalAnchor.aboveBottom(120)))));

    public static final RegistryObject<PlacedFeature> BLACKSTONE_EMERALD_ORE_PLACED = PLACED_FEATURES.register("blackstone_emerald_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BLACKSTONE_EMERALD_ORE_COSMOPOLIS.getHolder().get(),
                    commonOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60),
                    VerticalAnchor.aboveBottom(120)))));

    public static final RegistryObject<PlacedFeature> BLACKSTONE_OSMIUM_ORE_PLACED = PLACED_FEATURES.register("blackstone_osmium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BLACKSTONE_OSMIUM_ORE_COSMOPOLIS.getHolder().get(),
                    commonOrePlacement(10, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60),
                    VerticalAnchor.aboveBottom(120)))));

    public static final RegistryObject<PlacedFeature> BLACKSTONE_DEBRIS_ORE_PLACED = PLACED_FEATURES.register("blackstone_debris_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BLACKSTONE_DEBRIS_ORE_COSMOPOLIS.getHolder().get(),
                    commonOrePlacement(12, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60),
                    VerticalAnchor.aboveBottom(120)))));

    public static final RegistryObject<PlacedFeature> BLACKSTONE_URANIUM_ORE_PLACED = PLACED_FEATURES.register("blackstone_uranium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BLACKSTONE_URANIUM_ORE_COSMOPOLIS.getHolder().get(),
                    commonOrePlacement(12, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60),
                    VerticalAnchor.aboveBottom(120)))));





    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
