package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Cosmopolis.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ASTEROID_BLOCK.get());
        simpleBlock(ModBlocks.ARTIFICIAL_PLANKS.get());
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

        horizontalBlock(ModBlocks.GRAVITY_GENERATOR.get(), models().orientable("gravity_generator",
                modLoc("block/gravity_generator_side"), modLoc("block/gravity_generator_front"), modLoc("block/gravity_generator_top")));


    }


}