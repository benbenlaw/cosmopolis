package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.util.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, Cosmopolis.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ASTEROID_BLOCK.get())
                .add(ModBlocks.ASTEROID_SLAB.get())
                .add(ModBlocks.ASTEROID_STAIRS.get())
                .add(ModBlocks.ASTEROID_WALL.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLACKSTONE_DEBRIS_ORE.get())
                .add(ModBlocks.BLACKSTONE_URANIUM_ORE.get())
                .add(ModBlocks.BLACKSTONE_DIAMOND_ORE.get())
                .add(ModBlocks.BLACKSTONE_EMERALD_ORE.get())
                .add(ModBlocks.BLACKSTONE_OSMIUM_ORE.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SPACE_PORTAL_FRAME.get())
                .add(ModBlocks.MINING_BELT_PORTAL_FRAME.get())
                .add(ModBlocks.VENUS_PORTAL_FRAME.get())
                .add(ModBlocks.MARS_PORTAL_FRAME.get())
                .add(ModBlocks.MOON_PORTAL_FRAME.get())
                .add(ModBlocks.ASTEROID_BLOCK.get())
                .add(ModBlocks.ASTEROID_SLAB.get())
                .add(ModBlocks.ASTEROID_STAIRS.get())
                .add(ModBlocks.ASTEROID_WALL.get())
                .add(ModBlocks.GLOWSTONE_LANTERN.get())
                .add(ModBlocks.BLACKSTONE_CHEESE_ORE.get())
                .add(ModBlocks.BLACKSTONE_DEBRIS_ORE.get())
                .add(ModBlocks.BLACKSTONE_URANIUM_ORE.get())
                .add(ModBlocks.BLACKSTONE_DIAMOND_ORE.get())
                .add(ModBlocks.BLACKSTONE_EMERALD_ORE.get())
                .add(ModBlocks.BLACKSTONE_OSMIUM_ORE.get())
                .add(ModBlocks.GRAVITY_GENERATOR.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.ORGANIC_POWDER_SAPLING_BLOCK.get())
                .add(ModBlocks.ORGANIC_POWDER_SEED_BLOCK.get())
                .add(ModBlocks.ORGANIC_POWDER_FUNGUS_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.VENUS_FUNGUS.get())
                .add(ModBlocks.MARS_FUNGUS.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.ARTIFICIAL_PLANKS.get())
                .add(ModBlocks.ARTIFICIAL_SLAB.get())
                .add(ModBlocks.ARTIFICIAL_STAIRS.get())
                .add(ModBlocks.ARTIFICIAL_FENCE.get())
                .add(ModBlocks.ARTIFICIAL_FENCE_GATE.get())
                .add(ModBlocks.ARTIFICIAL_DOOR.get());

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

        tag(ModTags.Blocks.VENUS_ORE_REPLACEABLES)
                .add(Blocks.BLACKSTONE);

        tag(Tags.Blocks.ORES)
                .add(ModBlocks.BLACKSTONE_DEBRIS_ORE.get())
                .add(ModBlocks.BLACKSTONE_URANIUM_ORE.get())
                .add(ModBlocks.BLACKSTONE_DIAMOND_ORE.get())
                .add(ModBlocks.BLACKSTONE_EMERALD_ORE.get())
                .add(ModBlocks.BLACKSTONE_OSMIUM_ORE.get())
                .add(ModBlocks.BLACKSTONE_CHEESE_ORE.get());

        tag(Tags.Blocks.ORES_DIAMOND).add(ModBlocks.BLACKSTONE_DIAMOND_ORE.get());
        tag(Tags.Blocks.ORES_EMERALD).add(ModBlocks.BLACKSTONE_EMERALD_ORE.get());
        tag(Tags.Blocks.ORES_NETHERITE_SCRAP).add(ModBlocks.BLACKSTONE_DEBRIS_ORE.get());
        tag(ModTags.Blocks.ORES_URANIUM).add(ModBlocks.BLACKSTONE_URANIUM_ORE.get());
        tag(ModTags.Blocks.ORES_OSMIUM).add(ModBlocks.BLACKSTONE_OSMIUM_ORE.get());
        tag(ModTags.Blocks.ORES_CHEESE).add(ModBlocks.BLACKSTONE_CHEESE_ORE.get());

        tag(BlockTags.WALLS).add(ModBlocks.ASTEROID_WALL.get());
        tag(BlockTags.FENCES).add(ModBlocks.ARTIFICIAL_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.ARTIFICIAL_FENCE_GATE.get());


    }

}