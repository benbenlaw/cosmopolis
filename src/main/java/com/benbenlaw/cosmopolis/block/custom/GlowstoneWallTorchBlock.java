package com.benbenlaw.cosmopolis.block.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.WallTorchBlock;

public class GlowstoneWallTorchBlock extends WallTorchBlock {
    public GlowstoneWallTorchBlock(Properties pProperties) {
        super(pProperties, ParticleTypes.FLAME);
    }

}