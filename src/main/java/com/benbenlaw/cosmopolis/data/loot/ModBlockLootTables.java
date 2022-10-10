package com.benbenlaw.cosmopolis.data.loot;

import com.benbenlaw.cosmopolis.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        simpleDrops();
    }

    private void simpleDrops() {
        this.dropSelf(ModBlocks.ASTEROID_BLOCK.get());
        this.dropSelf(ModBlocks.ARTIFICIAL_PLANKS.get());
        this.dropSelf(ModBlocks.MARS_FUNGUS.get());
        this.dropSelf(ModBlocks.VENUS_FUNGUS.get());
        this.dropSelf(ModBlocks.MINING_BELT_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.SPACE_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.VENUS_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.MARS_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.MOON_PORTAL_FRAME.get());
        this.dropSelf(ModBlocks.GLOWSTONE_LANTERN.get());
        this.dropSelf(ModBlocks.GLOWSTONE_TORCH.get());


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
