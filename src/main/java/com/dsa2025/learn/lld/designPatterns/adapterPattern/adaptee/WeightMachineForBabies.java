package com.dsa2025.learn.lld.designPatterns.adapterPattern.adaptee;

public class WeightMachineForBabies implements WeightMachine {
    @Override
    public double getWeightInPound() {
        return 28;
    }

    //we have diff. type of weight for Teenage and Babies...

}
