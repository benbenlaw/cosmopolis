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
    public static final ForgeConfigSpec.ConfigValue<Integer> gravityGeneratorPowerMars;
    public static final ForgeConfigSpec.ConfigValue<Integer> gravityGeneratorPowerVenus;
    public static final ForgeConfigSpec.ConfigValue<Integer> gravityGeneratorPowerMoon;
    public static final ForgeConfigSpec.ConfigValue<Integer> gravityGeneratorPowerSpace;
    public static final ForgeConfigSpec.ConfigValue<Integer> gravityGeneratorPowerMiningBelt;
    public static final ForgeConfigSpec.ConfigValue<Integer> gravityGeneratorPowerOverworld;
    public static final ForgeConfigSpec.ConfigValue<Integer> gravityGeneratorPowerNether;
    public static final ForgeConfigSpec.ConfigValue<Integer> gravityGeneratorPowerEnd;



    static {
        BUILDER.push("Cosmopolis config file");

        iceShardDropChance = BUILDER.comment("Chance that hammer drops ice shards, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Is Sharf Drop Chance", 0.5);

        waterDropChance = BUILDER.comment("Chance that hammer drops water drops, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Water Drop Chance", 0.25);

        organicDropChance = BUILDER.comment("Chance that organic powder drops, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Organic Drop Chance", 0.25);

        asteroidRockDropchance = BUILDER.comment("Chance that asteroid rocks drops, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Asteroid Drop Chance", 0.25);

        rockDropchance = BUILDER.comment("Chance that rocks drops, 0.0 = always, 1.0 = never, 0.5 = 50% chance, default = 0.25")
                .define("Rock Drop Chance", 0.25);

        gravityGeneratorPowerMars = BUILDER.comment("RF produced per tick of the gravity generator on Mars, must be a whole number")
                .define("Mars", 40);

        gravityGeneratorPowerVenus = BUILDER.comment("RF produced per tick of the gravity generator on Venus, must be a whole number")
                .define("Venus", 60);

        gravityGeneratorPowerMoon = BUILDER.comment("RF produced per tick of the gravity generator on Moon, must be a whole number")
                .define("Moon", 20);

        gravityGeneratorPowerSpace = BUILDER.comment("RF produced per tick of the gravity generator in Space, must be a whole number")
                .define("Space", 30);

        gravityGeneratorPowerMiningBelt = BUILDER.comment("RF produced per tick of the gravity generator in Mining Belt, must be a whole number")
                .define("Mining Belt", 100);

        gravityGeneratorPowerOverworld = BUILDER.comment("RF produced per tick of the gravity generator on the Overworld, must be a whole number")
                .define("Overworld", 10);

        gravityGeneratorPowerNether = BUILDER.comment("RF produced per tick of the gravity generator on the Nether, must be a whole number")
                .define("Nether", 10);

        gravityGeneratorPowerEnd = BUILDER.comment("RF produced per tick of the gravity generator on the End, must be a whole number")
                .define("End", 10);




        BUILDER.pop();
        SPEC = BUILDER.build();
    }



}
