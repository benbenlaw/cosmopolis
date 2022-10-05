package com.benbenlaw.cosmopolis.entity;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.entity.custom.UFOEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            Cosmopolis.MOD_ID);

    public static final RegistryObject<EntityType<UFOEntity>> UFO = ENTITIES.register("ufo",
            () -> EntityType.Builder.of(UFOEntity::new, MobCategory.CREATURE)
                    .sized(3.5F, 1.5F)
                    .clientTrackingRange(8)
                    .setShouldReceiveVelocityUpdates(false)
                    .build("ufo"));

    public static void register(IEventBus eventBus) {
        ModEntities.ENTITIES.register(eventBus);
    }
}
