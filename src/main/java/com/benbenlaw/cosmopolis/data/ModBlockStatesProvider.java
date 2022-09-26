package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

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
    }
}