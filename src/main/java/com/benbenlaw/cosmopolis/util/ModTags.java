package com.benbenlaw.cosmopolis.util;

import com.benbenlaw.cosmopolis.Cosmopolis;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {

    /*

    public static class Blocks {
        public static final TagKey<Block> HELLO = null;

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Cosmopolis.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }


     */

    public static class Items {
        public static final TagKey<Item> SPACE_SUIT_HELMET = tag("space_suit_helmet");
        public static final TagKey<Item> SPACE_SUIT_CHESTPLATE = tag("space_suit_chestplate");
        public static final TagKey<Item> SPACE_SUIT_LEGGINGS = tag("space_suit_leggings");
        public static final TagKey<Item> SPACE_SUIT_BOOTS = tag("space_suit_boots");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Cosmopolis.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

    }

}
