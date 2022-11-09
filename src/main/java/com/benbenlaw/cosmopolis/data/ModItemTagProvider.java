package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.item.ModItems;
import com.benbenlaw.cosmopolis.util.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, new ModBlockTagProvider(pGenerator, Cosmopolis.MOD_ID, existingFileHelper),
                Cosmopolis.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

          tag(ModTags.Items.ASTEROID_ROCKS)
                  .add(ModItems.ROCK.get())
                  .add(ModItems.ASTEROID_ROCK.get());

          tag(ModTags.Items.BANNED_IN_SPACE_ITEMS)
                  .addTags(Tags.Items.SEEDS);

          tag(ModTags.Items.SPACE_SUIT_HELMET)
                  .add(ModItems.SPACE_SUIT_HELMET.get());

          tag(ModTags.Items.SPACE_SUIT_CHESTPLATE)
                  .add(ModItems.SPACE_SUIT_CHESTPLATE.get());

          tag(ModTags.Items.SPACE_SUIT_LEGGINGS)
                  .add(ModItems.SPACE_SUIT_LEGGINGS.get());

          tag(ModTags.Items.SPACE_SUIT_BOOTS)
                  .add(ModItems.SPACE_SUIT_BOOTS.get());

          tag(Tags.Items.ORES)
                  .add(ModBlocks.BLACKSTONE_DEBRIS_ORE.get().asItem())
                  .add(ModBlocks.BLACKSTONE_URANIUM_ORE.get().asItem())
                  .add(ModBlocks.BLACKSTONE_DIAMOND_ORE.get().asItem())
                  .add(ModBlocks.BLACKSTONE_EMERALD_ORE.get().asItem())
                  .add(ModBlocks.BLACKSTONE_OSMIUM_ORE.get().asItem())
                  .add(ModBlocks.BLACKSTONE_CHEESE_ORE.get().asItem());

          tag(Tags.Items.ORES_DIAMOND).add(ModBlocks.BLACKSTONE_DIAMOND_ORE.get().asItem());
          tag(Tags.Items.ORES_EMERALD).add(ModBlocks.BLACKSTONE_EMERALD_ORE.get().asItem());
          tag(Tags.Items.ORES_NETHERITE_SCRAP).add(ModBlocks.BLACKSTONE_DEBRIS_ORE.get().asItem());
          tag(ModTags.Items.ORES_URANIUM).add(ModBlocks.BLACKSTONE_URANIUM_ORE.get().asItem());
          tag(ModTags.Items.ORES_OSMIUM).add(ModBlocks.BLACKSTONE_OSMIUM_ORE.get().asItem());
          tag(ModTags.Items.ORES_CHEESE).add(ModBlocks.BLACKSTONE_CHEESE_ORE.get().asItem());

          tag(Tags.Items.TOOLS_HOES).add(ModItems.ASTEROID_HOE.get());
          tag(Tags.Items.TOOLS_PICKAXES).add(ModItems.ASTEROID_PICKAXE.get());
          tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(ModItems.ASTEROID_PICKAXE.get());
          tag(Tags.Items.TOOLS_SWORDS).add(ModItems.ASTEROID_SWORD.get());
          tag(Tags.Items.TOOLS_SHOVELS).add(ModItems.ASTEROID_SHOVEL.get());
          tag(Tags.Items.TOOLS_AXES).add(ModItems.ASTEROID_AXE.get());
          tag(ModTags.Items.TOOLS_PAXELS).add(ModItems.HAMMER.get());


          tag(Tags.Items.RAW_MATERIALS)
                  .add(ModItems.RAW_OSMIUM.get())
                  .add(ModItems.RAW_URANIUM.get());

        tag(ModTags.Items.RAW_MATERIALS_OSMIUM).add(ModItems.RAW_OSMIUM.get());
        tag(ModTags.Items.RAW_MATERIALS_URANIUM).add(ModItems.RAW_URANIUM.get());
    }

}