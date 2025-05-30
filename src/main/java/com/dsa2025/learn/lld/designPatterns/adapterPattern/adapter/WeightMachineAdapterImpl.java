package com.dsa2025.learn.lld.designPatterns.adapterPattern.adapter;

import com.dsa2025.learn.lld.designPatterns.adapterPattern.adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {

    private WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        double weightInPound = weightMachine.getWeightInPound();
        return weightInPound * 10;
    }
}
