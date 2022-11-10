package com.benbenlaw.cosmopolis.block.entity.custom;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.block.entity.ModBlockEntities;
import com.benbenlaw.cosmopolis.config.CosmopolisConfigFile;
import com.benbenlaw.cosmopolis.util.GeneratorEnergyStorage;
import com.benbenlaw.cosmopolis.util.ModTags;
import com.benbenlaw.cosmopolis.world.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class GravityGeneratorBlockEntity extends BlockEntity {

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    private final GeneratorEnergyStorage ENERGY_STORAGE = createEnergyStorage();

    public GravityGeneratorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.GRAVITY_GENERATOR.get(), pWorldPosition, pBlockState);

    }


    @NotNull
    protected GeneratorEnergyStorage createEnergyStorage() {
        return new GeneratorEnergyStorage(0, 0) {
            @Override
            public void onEnergyChanged() {
                setChanged();
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityEnergy.ENERGY) {
            return lazyEnergyHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, GravityGeneratorBlockEntity entity) {
        if(level.getBlockState(blockPos.above()).getBlock() != Blocks.AIR) {
            if(level.getBlockEntity(blockPos.above()) != null) {
                BlockEntity ent = level.getBlockEntity(blockPos.above());

                ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).ifPresent(handler -> {

                    if(handler.canReceive() && level.getBiome(blockPos).is(ModTags.Biomes.IS_MARS)) {
                            handler.receiveEnergy(CosmopolisConfigFile.gravityGeneratorPowerMars.get(), false);
                    }
                    if(handler.canReceive() && level.getBiome(blockPos).is(ModTags.Biomes.IS_VENUS)) {
                            handler.receiveEnergy(CosmopolisConfigFile.gravityGeneratorPowerVenus.get(), false);
                    }
                    if(handler.canReceive() && level.getBiome(blockPos).is(ModTags.Biomes.IS_MOON)) {
                            handler.receiveEnergy(CosmopolisConfigFile.gravityGeneratorPowerMoon.get(), false);
                    }
                    if(handler.canReceive() && level.getBiome(blockPos).is(ModTags.Biomes.IS_SPACE)) {
                            handler.receiveEnergy(CosmopolisConfigFile.gravityGeneratorPowerSpace.get(), false);
                    }
                    if(handler.canReceive() && level.getBiome(blockPos).is(ModTags.Biomes.IS_MINING_BELT)) {
                            handler.receiveEnergy(CosmopolisConfigFile.gravityGeneratorPowerMiningBelt.get(), false);
                    }
                    if(handler.canReceive() && level.getBiome(blockPos).is(BiomeTags.IS_OVERWORLD)) {
                            handler.receiveEnergy(CosmopolisConfigFile.gravityGeneratorPowerOverworld.get(), false);
                    }
                    if(handler.canReceive() && level.getBiome(blockPos).is(BiomeTags.IS_NETHER)) {
                            handler.receiveEnergy(CosmopolisConfigFile.gravityGeneratorPowerNether.get(), false);
                    }
                    if(handler.canReceive() && level.getBiome(blockPos).is(BiomeTags.IS_END)) {
                            handler.receiveEnergy(CosmopolisConfigFile.gravityGeneratorPowerEnd.get(), false);
                    }

                });
            }
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();

        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyEnergyHandler.invalidate();
    }

}

