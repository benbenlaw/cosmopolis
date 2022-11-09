package com.benbenlaw.cosmopolis.data.loot;

import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.item.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        simpleDrops();
    }

    private void simpleDrops() {
        this.dropOther(ModBlocks.ASTEROID_BLOCK.get(), (ModItems.ASTEROID_ROCK.get()));
        this.dropSelf(ModBlocks.ASTEROID_SLAB.get());
        this.dropSelf(ModBlocks.ASTEROID_STAIRS.get());
        this.dropSelf(ModBlocks.ASTEROID_WALL.get());

        this.dropSelf(ModBlocks.ASTEROID_BRICKS.get());
        this.dropSelf(ModBlocks.ASTEROID_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.ASTEROID_BRICK_SLAB.get());
        this.dropSelf(ModBlocks.ASTEROID_BRICK_WALL.get());
        
        this.dropSelf(ModBlocks.ASTEROID_TILES.get());
        this.dropSelf(ModBlocks.ASTEROID_TILE_STAIRS.get());
        this.dropSelf(ModBlocks.ASTEROID_TILE_SLAB.get());
        this.dropSelf(ModBlocks.ASTEROID_TILE_WALL.get());

        this.dropSelf(ModBlocks.ARTIFICIAL_PLANKS.get());
        this.dropSelf(ModBlocks.ARTIFICIAL_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ARTIFICIAL_FENCE.get());
        this.add(ModBlocks.ARTIFICIAL_DOOR.get(), (Block) -> createDoorTable(ModBlocks.ARTIFICIAL_DOOR.get()));
        this.dropSelf(ModBlocks.ARTIFICIAL_STAIRS.get());
        this.dropSelf(ModBlocks.ARTIFICIAL_SLAB.get());
        this.dropSelf(ModBlocks.MARS_FUNGUS.get());
        this.dropSelf(ModBlocks.VENUS_FUNGUS.get());
        this.dropSelf(ModBlocks.MINING_BELT_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.SPACE_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.VENUS_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.MARS_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.MOON_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.GLOWSTONE_LANTERN.get());
        this.dropSelf(ModBlocks.GLOWSTONE_TORCH.get());
        this.dropSelf(ModBlocks.GRAVITY_GENERATOR.get());

        this.add(ModBlocks.ORGANIC_POWDER_SAPLING_BLOCK.get(), (Block) -> noDrop());
        this.add(ModBlocks.ORGANIC_POWDER_SEED_BLOCK.get(), (Block) -> noDrop());
        this.add(ModBlocks.ORGANIC_POWDER_FUNGUS_BLOCK.get(), (Block) -> noDrop());

        this.add(ModBlocks.BLACKSTONE_CHEESE_ORE.get(), (Block) ->
                createOreDrop(ModBlocks.BLACKSTONE_CHEESE_ORE.get(), ModItems.CHEESE.get()).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));

        this.add(ModBlocks.BLACKSTONE_EMERALD_ORE.get(), (Block) ->
                createOreDrop(ModBlocks.BLACKSTONE_EMERALD_ORE.get(), Items.EMERALD).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));

        this.add(ModBlocks.BLACKSTONE_DIAMOND_ORE.get(), (Block) ->
                createOreDrop(ModBlocks.BLACKSTONE_DIAMOND_ORE.get(), Items.DIAMOND).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));

        this.add(ModBlocks.BLACKSTONE_OSMIUM_ORE.get(), (Block) ->
                createOreDrop(ModBlocks.BLACKSTONE_OSMIUM_ORE.get(), ModItems.RAW_OSMIUM.get()).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));

        this.add(ModBlocks.BLACKSTONE_DEBRIS_ORE.get(), (Block) ->
                createOreDrop(ModBlocks.BLACKSTONE_DEBRIS_ORE.get(), Items.ANCIENT_DEBRIS).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));

        this.add(ModBlocks.BLACKSTONE_URANIUM_ORE.get(), (Block) ->
                createOreDrop(ModBlocks.BLACKSTONE_URANIUM_ORE.get(), ModItems.RAW_URANIUM.get()).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));


    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }




}
