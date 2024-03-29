package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Cosmopolis.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        customItemModels();
    }

    private void customItemModels() {

        //Item Models

        simpleItem(ModItems.ROCK);
        simpleItem(ModItems.ASTEROID_ROCK);
        simpleItem(ModItems.MINI_CHARCOAL);
        simpleItem(ModItems.MINI_COAL);
        simpleItem(ModItems.SPACE_CORE);
        simpleItem(ModItems.WATER_DROP);
        simpleItem(ModItems.ICE_SHARD);
        simpleItem(ModItems.ORGANIC_POWDER);
        simpleItem(ModItems.MARS_SPORES);
        simpleItem(ModItems.VENUS_SPORES);
        simpleItem(ModItems.PLANETARY_CORE_TELEPORTER);
        simpleItem(ModItems.ARTIFICIAL_STICK);
        simpleItem(ModItems.ASTEROID_STEW);
        simpleItem(ModItems.SPACE_SUIT_UPGRADE);
        simpleItem(ModItems.SPACE_SUIT_BOOTS);
        simpleItem(ModItems.SPACE_SUIT_CHESTPLATE);
        simpleItem(ModItems.SPACE_SUIT_LEGGINGS);
        simpleItem(ModItems.SPACE_SUIT_HELMET);
        simpleItem(ModItems.HOT_ASTEROID_STEW);
        simpleItem(ModItems.CHEESE);
        simpleItem(ModItems.ALIEN_ARTIFACT);

        simpleItem(ModItems.RAW_OSMIUM);
        simpleItem(ModItems.RAW_URANIUM);

        //Torches

        simpleTorch(ModItems.STONE_TORCH);


        //Tool Models

        toolItem(ModItems.HAMMER);
        toolItem(ModItems.ASTEROID_PICKAXE);
        toolItem(ModItems.ASTEROID_HOE);
        toolItem(ModItems.ASTEROID_AXE);
        toolItem(ModItems.ASTEROID_SWORD);
        toolItem(ModItems.ASTEROID_SHOVEL);

        //Block Models

        simpleBlock(ModBlocks.ARTIFICIAL_PLANKS);
        withExistingParent("artificial_slab", modLoc("block/artificial_slab"));
        withExistingParent("artificial_stairs", modLoc("block/artificial_stairs"));
    //    withExistingParent("artificial_fence", modLoc("block/artificial_fence_post"));
        withExistingParent("artificial_fence_gate", modLoc("block/artificial_fence_gate"));
    //    withExistingParent("artificial_door", modLoc("item/artificial_door"));
        
        simpleBlock(ModBlocks.ASTEROID_BLOCK);
        withExistingParent("asteroid_slab", modLoc("block/asteroid_slab"));
        withExistingParent("asteroid_stairs", modLoc("block/asteroid_stairs"));

        simpleBlock(ModBlocks.ASTEROID_BRICKS);
        withExistingParent("asteroid_brick_slab", modLoc("block/asteroid_brick_slab"));
        withExistingParent("asteroid_brick_stairs", modLoc("block/asteroid_brick_stairs"));
        
        simpleBlock(ModBlocks.ASTEROID_TILES);
        withExistingParent("asteroid_tile_slab", modLoc("block/asteroid_tile_slab"));
        withExistingParent("asteroid_tile_stairs", modLoc("block/asteroid_tile_stairs"));

        simpleBlock(ModBlocks.MARS_FUNGUS);
        simpleBlock(ModBlocks.VENUS_FUNGUS);
        simpleBlock(ModBlocks.MINING_BELT_PORTAL_FRAME);
        simpleBlock(ModBlocks.SPACE_PORTAL_FRAME);
        simpleBlock(ModBlocks.VENUS_PORTAL_FRAME);
        simpleBlock(ModBlocks.MARS_PORTAL_FRAME);
        simpleBlock(ModBlocks.MOON_PORTAL_FRAME);
        orientable("gravity_generator",
                modLoc("block/gravity_generator_side"), modLoc("block/gravity_generator_front"), modLoc("block/gravity_generator_top"));



        simpleBlock(ModBlocks.BLACKSTONE_DEBRIS_ORE);
        simpleBlock(ModBlocks.BLACKSTONE_URANIUM_ORE);
        simpleBlock(ModBlocks.BLACKSTONE_DIAMOND_ORE);
        simpleBlock(ModBlocks.BLACKSTONE_EMERALD_ORE);
        simpleBlock(ModBlocks.BLACKSTONE_OSMIUM_ORE);
        simpleBlock(ModBlocks.BLACKSTONE_CHEESE_ORE);
        simpleBlock(ModBlocks.ORGANIC_POWDER_FUNGUS_BLOCK);
        simpleBlock(ModBlocks.ORGANIC_POWDER_SEED_BLOCK);
        simpleBlock(ModBlocks.ORGANIC_POWDER_SAPLING_BLOCK);



    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Cosmopolis.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleTorch(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Cosmopolis.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder toolItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Cosmopolis.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlock(RegistryObject<Block> block) {
        return cubeAll(block.getId().getPath(), new ResourceLocation(Cosmopolis.MOD_ID,
                "block/" + block.getId().getPath()));
    }
}