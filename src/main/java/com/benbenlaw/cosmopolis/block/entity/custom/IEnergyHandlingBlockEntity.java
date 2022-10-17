package com.benbenlaw.cosmopolis.block.entity.custom;

import net.minecraftforge.energy.IEnergyStorage;

public interface IEnergyHandlingBlockEntity {
    void setEnergyLevel(int energyLevel);
    IEnergyStorage getEnergyStorage();
}