package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.Cosmopolis;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cosmopolis.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new ModLootTableProvider(generator));
        generator.addProvider(true, new ModBlockStatesProvider(generator, existingFileHelper));

        generator.addProvider(true, new ModBlockTagProvider(generator, Cosmopolis.MOD_ID, existingFileHelper));
        generator.addProvider(true, new ModItemTagProvider(generator, existingFileHelper));

        generator.addProvider(true, new ModItemModelProvider(generator, existingFileHelper));

        generator.addProvider(true, new ModBiomeTagsProvider(generator, existingFileHelper));

    }
}