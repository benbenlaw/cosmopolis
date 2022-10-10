package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.util.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, Cosmopolis.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ASTEROID_BLOCK.get());


        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SPACE_PORTAL_FRAME.get())
                .add(ModBlocks.MINING_BELT_PORTAL_FRAME.get())
                .add(ModBlocks.VENUS_PORTAL_FRAME.get())
                .add(ModBlocks.MARS_PORTAL_FRAME.get())
                .add(ModBlocks.MOON_PORTAL_FRAME.get())
                .add(ModBlocks.ASTEROID_BLOCK.get())
                .add(ModBlocks.GLOWSTONE_LANTERN.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.VENUS_FUNGUS.get())
                .add(ModBlocks.MARS_FUNGUS.get());

        tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.ARTIFICIAL_PLANKS.get());

        tag(ModTags.Blocks.MINING_BELT_FRAME_BLOCKS)
                .add(ModBlocks.MINING_BELT_PORTAL_FRAME.get());

        tag(ModTags.Blocks.PORTAL_FRAME_BLOCKS)
                .add(ModBlocks.SPACE_PORTAL_FRAME.get());

        tag(ModTags.Blocks.MARS_FRAME_BLOCKS)
                .add(ModBlocks.MARS_PORTAL_FRAME.get());

        tag(ModTags.Blocks.VENUS_FRAME_BLOCKS)
                .add(ModBlocks.VENUS_PORTAL_FRAME.get());

        tag(ModTags.Blocks.MOON_FRAME_BLOCKS)
                .add(ModBlocks.MOON_PORTAL_FRAME.get());






        tag(ModTags.Blocks.BANNED_IN_SPACE_BLOCKS)
                .addTags(BlockTags.SAPLINGS)
                .add(Blocks.ICE);

    }

}