package com.benbenlaw.cosmopolis.block.entity;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.block.entity.custom.GravityGeneratorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Cosmopolis.MOD_ID);

    public static final RegistryObject<BlockEntityType<GravityGeneratorBlockEntity>> GRAVITY_GENERATOR =
            BLOCK_ENTITIES.register("gravity_generator", () ->
                    BlockEntityType.Builder.of(GravityGeneratorBlockEntity::new,
                            ModBlocks.GRAVITY_GENERATOR.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}