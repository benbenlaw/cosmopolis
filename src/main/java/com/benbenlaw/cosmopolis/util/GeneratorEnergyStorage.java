package com.benbenlaw.cosmopolis.util;

import net.minecraftforge.energy.EnergyStorage;

public abstract class GeneratorEnergyStorage extends EnergyStorage {
    public GeneratorEnergyStorage(int capacity) {
        super(capacity);
    }

    public GeneratorEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public GeneratorEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    public GeneratorEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int extractedEnergy = super.extractEnergy(maxExtract, simulate);
        if(extractedEnergy != 0) {
            onEnergyChanged();
        }

        return extractedEnergy;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int receiveEnergy = super.receiveEnergy(maxReceive, simulate);
        if(receiveEnergy != 0) {
            onEnergyChanged();
        }

        return receiveEnergy;
    }

    public int setEnergy(int energy) {
        this.energy = energy;
        return energy;
    }

    public abstract void onEnergyChanged();
}