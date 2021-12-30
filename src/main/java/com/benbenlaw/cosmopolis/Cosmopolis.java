package com.benbenlaw.cosmopolis;

import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Cosmopolis.MOD_ID)

public class Cosmopolis {

    public static final String MOD_ID = "cosmopolis";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Cosmopolis() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigFile.SPEC, "essence_common.toml");
    }

        private void enqueueIMC(final InterModEnqueueEvent event) {
            // some example code to dispatch IMC to another mod
            InterModComms.sendTo("cosmopolis", "helloworld", () -> {
                LOGGER.info("Hello world from the MDK");
                return "Hello world";
            });
        }

        private void processIMC(final InterModProcessEvent event) {
            // some example code to receive and process InterModComms from other mods
            LOGGER.info("Got IMC {}", event.getIMCStream().
                    map(m -> m.messageSupplier().get()).
                    collect(Collectors.toList()));
        }

        private void doClientStuff(final FMLClientSetupEvent event) {
            // do something that can only be done on the client
        }
    }
