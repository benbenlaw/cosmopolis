package com.benbenlaw.cosmopolis.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class CosmopolisConfigFile {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Double> iceShardDropChance;
    public static final ForgeConfigSpec.ConfigValue<Double> waterDropChance;
    public static final ForgeConfigSpec.ConfigValue<Double> organicDropChance;
    public static final ForgeConfigSpec.ConfigValue<Double> asteroidRockDropchance;
    public static final ForgeConfigSpec.ConfigValue<Double> rockDropchance;



    static {
        BUILDER.push("Cosmopolis config file");

        iceShardDropChance = BUILDER.comment("Chance that hammer drops water drops, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Water Drop Chance", 0.5);

        waterDropChance = BUILDER.comment("Chance that hammer drops water drops, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Water Drop Chance", 0.25);

        organicDropChance = BUILDER.comment("Chance that organic powder drops, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Organic Drop Chance", 0.25);

        asteroidRockDropchance = BUILDER.comment("Chance that asteroid rocks drops, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Organic Drop Chance", 0.25);

        rockDropchance = BUILDER.comment("Chance that rocks drops, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Organic Drop Chance", 0.25);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }



}
