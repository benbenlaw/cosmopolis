package com.benbenlaw.cosmopolis.entity;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.entity.custom.TeleporterBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Cosmopolis.MOD_ID);


    public static final RegistryObject<BlockEntityType<TeleporterBlockEntity>> TELEPORTER_BLOCK_ENTITY =
            BLOCK_ENTITES.register("essence_converter_block_entity", () ->
                    BlockEntityType.Builder.of(TeleporterBlockEntity::new,
                            ModBlocks.TELEPORTER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITES.register(eventBus);
    }
}
