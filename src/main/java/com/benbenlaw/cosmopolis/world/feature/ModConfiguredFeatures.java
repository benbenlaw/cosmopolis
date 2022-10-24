package com.benbenlaw.cosmopolis.world.feature;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.util.ModTags;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Cosmopolis.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> MOON_CHEESE_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_CHEESE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> VENUS_DIAMOND_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_DIAMOND_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> VENUS_EMERALD_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_EMERALD_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> VENUS_DEBRIS_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_DEBRIS_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> VENUS_URANIUM_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_URANIUM_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> VENUS_OSMIUM_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_OSMIUM_ORE.get().defaultBlockState())));





    public static final RegistryObject<ConfiguredFeature<?, ?>> DIAMOND_ORE_VENUS = CONFIGURED_FEATURES.register("diamond_ore_venus",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(VENUS_DIAMOND_ORE.get(),10)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> EMERALD_ORE_VENUS = CONFIGURED_FEATURES.register("emerald_ore_venus",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(VENUS_EMERALD_ORE.get(),10)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> DEBRIS_ORE_VENUS = CONFIGURED_FEATURES.register("debris_ore_venus",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(VENUS_DEBRIS_ORE.get(),15)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> OSMIUM_ORE_VENUS = CONFIGURED_FEATURES.register("osmium_ore_venus",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(VENUS_OSMIUM_ORE.get(),13)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> URANIUM_ORE_VENUS = CONFIGURED_FEATURES.register("uranium_ore_venus",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(VENUS_URANIUM_ORE.get(),12)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CHEESE_ORE_MOON = CONFIGURED_FEATURES.register("cheese_ore_moon",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(MOON_CHEESE_ORE.get(),12)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
