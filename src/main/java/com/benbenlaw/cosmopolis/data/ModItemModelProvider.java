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
        simpleBlock(ModBlocks.ASTEROID_BLOCK);
        simpleBlock(ModBlocks.MARS_FUNGUS);
        simpleBlock(ModBlocks.VENUS_FUNGUS);
        simpleBlock(ModBlocks.MINING_BELT_PORTAL_FRAME);
        simpleBlock(ModBlocks.SPACE_PORTAL_FRAME);
        simpleBlock(ModBlocks.GLOWSTONE_LANTERN);



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