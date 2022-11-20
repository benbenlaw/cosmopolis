package com.benbenlaw.cosmopolis.util;

import com.benbenlaw.cosmopolis.Cosmopolis;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import javax.swing.text.html.parser.Entity;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> PORTAL_FRAME_BLOCKS = tag("portal_frame_blocks");
        public static final TagKey<Block> MINING_BELT_FRAME_BLOCKS = tag("mining_belt_frame_blocks");
        public static final TagKey<Block> MARS_FRAME_BLOCKS = tag("mars_frame_blocks");
        public static final TagKey<Block> VENUS_FRAME_BLOCKS = tag("venus_frame_blocks");
        public static final TagKey<Block> MOON_FRAME_BLOCKS = tag("moon_frame_blocks");
        public static final TagKey<Block> BANNED_IN_SPACE_BLOCKS = tag("banned_in_space_blocks");

        public static final TagKey<Block> VENUS_ORE_REPLACEABLES = tag("venus_ore_replaceables");

        public static final TagKey<Block> ORES_URANIUM = forgeTag("ores/uranium");
        public static final TagKey<Block> ORES_OSMIUM = forgeTag("ores/osmium");
        public static final TagKey<Block> ORES_CHEESE = forgeTag("ores/cheese");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Cosmopolis.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }

    public static class Items {
        public static final TagKey<Item> SPACE_SUIT_HELMET = tag("space_suit_helmet");
        public static final TagKey<Item> SPACE_SUIT_CHESTPLATE = tag("space_suit_chestplate");
        public static final TagKey<Item> SPACE_SUIT_LEGGINGS = tag("space_suit_leggings");
        public static final TagKey<Item> SPACE_SUIT_BOOTS = tag("space_suit_boots");

        public static final TagKey<Item> ASTEROID_ROCKS = tag("asteroid_rocks");
        public static final TagKey<Item> BANNED_IN_SPACE_ITEMS = tag("banned_in_space_items");

        public static final TagKey<Item> ORGANIC_POWDER_FUNGUS_BLOCK_DROPS = tag("organic_powder_fungus_block_drops");
        public static final TagKey<Item> ORGANIC_POWDER_FUNGUS_SAPLING_DROPS = tag("organic_powder_sapling_block_drops");
        public static final TagKey<Item> ORGANIC_POWDER_SEED_SAPLING_DROPS = tag("organic_powder_seed_block_drops");

        public static final TagKey<Item> ORES_URANIUM = forgeTag("ores/uranium");
        public static final TagKey<Item> ORES_OSMIUM = forgeTag("ores/osmium");
        public static final TagKey<Item> ORES_CHEESE = forgeTag("ores/cheese");

        public static final TagKey<Item> RAW_MATERIALS_URANIUM = forgeTag("raw_materials/uranium");
        public static final TagKey<Item> RAW_MATERIALS_OSMIUM = forgeTag("raw_materials/osmium");
        public static final TagKey<Item> TOOLS_PAXELS = forgeTag("tools/paxels");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Cosmopolis.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> IS_VENUS = tag("is_venus");
        public static final TagKey<Biome> IS_SPACE = tag("is_space");
        public static final TagKey<Biome> IS_MOON = tag("is_moon");
        public static final TagKey<Biome> IS_MARS = tag("is_mars");
        public static final TagKey<Biome> IS_MINING_BELT = tag("is_mining_belt");
        public static final TagKey<Biome> NEEDS_SPACE_SUIT = tag("needs_space_suit");



        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Cosmopolis.MOD_ID, name));
        }

        private static TagKey<Biome> forgeTag(String name) {
            return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("forge", name));
        }

    }

    public static class Entities {

        public static final TagKey<EntityType<?>> IMMUNE_IN_SPACE = tag("immune_in_space");


        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(Cosmopolis.MOD_ID, name));
        }

        private static TagKey<EntityType<?>> forgeTag(String name) {
            return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge", name));
        }
    }
}
