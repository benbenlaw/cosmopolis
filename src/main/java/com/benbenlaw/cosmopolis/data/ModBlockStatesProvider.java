package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Cosmopolis.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ASTEROID_BLOCK.get());
        stairsBlock((StairBlock) ModBlocks.ASTEROID_STAIRS.get(), blockTexture(ModBlocks.ASTEROID_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.ASTEROID_WALL.get(), blockTexture(ModBlocks.ASTEROID_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.ASTEROID_SLAB.get(), blockTexture(ModBlocks.ASTEROID_BLOCK.get()), blockTexture(ModBlocks.ASTEROID_BLOCK.get()));

        simpleBlock(ModBlocks.ARTIFICIAL_PLANKS.get());
        stairsBlock((StairBlock) ModBlocks.ARTIFICIAL_STAIRS.get(), blockTexture(ModBlocks.ARTIFICIAL_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.ARTIFICIAL_SLAB.get(), blockTexture(ModBlocks.ARTIFICIAL_PLANKS.get()), blockTexture(ModBlocks.ARTIFICIAL_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.ARTIFICIAL_FENCE.get(), blockTexture(ModBlocks.ARTIFICIAL_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.ARTIFICIAL_FENCE_GATE.get(), blockTexture(ModBlocks.ARTIFICIAL_PLANKS.get()));
        doorBlock((DoorBlock) ModBlocks.ARTIFICIAL_DOOR.get(), blockTexture(ModBlocks.ARTIFICIAL_PLANKS.get()), blockTexture(ModBlocks.ARTIFICIAL_PLANKS.get()));

        simpleBlock(ModBlocks.MARS_FUNGUS.get());
        simpleBlock(ModBlocks.VENUS_FUNGUS.get());
        simpleBlock(ModBlocks.MINING_BELT_PORTAL_FRAME.get());
        simpleBlock(ModBlocks.SPACE_PORTAL_FRAME.get());
        simpleBlock(ModBlocks.VENUS_PORTAL_FRAME.get());
        simpleBlock(ModBlocks.MARS_PORTAL_FRAME.get());
        simpleBlock(ModBlocks.MOON_PORTAL_FRAME.get());
        simpleBlock(ModBlocks.BLACKSTONE_URANIUM_ORE.get());
        simpleBlock(ModBlocks.BLACKSTONE_DEBRIS_ORE.get());
        simpleBlock(ModBlocks.BLACKSTONE_EMERALD_ORE.get());
        simpleBlock(ModBlocks.BLACKSTONE_DIAMOND_ORE.get());
        simpleBlock(ModBlocks.BLACKSTONE_OSMIUM_ORE.get());
        simpleBlock(ModBlocks.BLACKSTONE_CHEESE_ORE.get());
        simpleBlock(ModBlocks.ORGANIC_POWDER_SEED_BLOCK.get());
        simpleBlock(ModBlocks.ORGANIC_POWDER_FUNGUS_BLOCK.get());
        simpleBlock(ModBlocks.ORGANIC_POWDER_SAPLING_BLOCK.get());

        horizontalBlock(ModBlocks.GRAVITY_GENERATOR.get(), models().orientable("gravity_generator",
                modLoc("block/gravity_generator_side"), modLoc("block/gravity_generator_front"), modLoc("block/gravity_generator_top")));


    }


}