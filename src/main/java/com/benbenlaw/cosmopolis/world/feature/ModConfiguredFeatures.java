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
import java.util.Objects;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Cosmopolis.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> BLACKSTONE_CHEESE_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_CHEESE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> BLACKSTONE_DIAMOND_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_DIAMOND_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> BLACKSTONE_EMERALD_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_EMERALD_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> BLACKSTONE_DEBRIS_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_DEBRIS_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> BLACKSTONE_URANIUM_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_URANIUM_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> BLACKSTONE_OSMIUM_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(ModTags.Blocks.VENUS_ORE_REPLACEABLES), ModBlocks.BLACKSTONE_OSMIUM_ORE.get().defaultBlockState())));





    public static final RegistryObject<ConfiguredFeature<?, ?>> BLACKSTONE_DIAMOND_ORE_COSMOPOLIS = CONFIGURED_FEATURES.register("blackstone_diamond_ore_cosmopolis",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(BLACKSTONE_DIAMOND_ORE.get()),10)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLACKSTONE_EMERALD_ORE_COSMOPOLIS = CONFIGURED_FEATURES.register("blackstone_emerald_ore_cosmopolis",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BLACKSTONE_EMERALD_ORE.get(),10)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLACKSTONE_DEBRIS_ORE_COSMOPOLIS = CONFIGURED_FEATURES.register("blackstone_debris_ore_cosmopolis",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BLACKSTONE_DEBRIS_ORE.get(),15)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLACKSTONE_OSMIUM_ORE_COSMOPOLIS = CONFIGURED_FEATURES.register("blackstone_osmium_ore_cosmopolis",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BLACKSTONE_OSMIUM_ORE.get(),13)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLACKSTONE_URANIUM_ORE_COSMOPOLIS = CONFIGURED_FEATURES.register("blackstone_uranium_ore_cosmopolis",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BLACKSTONE_URANIUM_ORE.get(),12)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLACKSTONE_CHEESE_ORE_COSMOPOLIS = CONFIGURED_FEATURES.register("blackstone_cheese_ore_cosmopolis",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BLACKSTONE_CHEESE_ORE.get(),12)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
