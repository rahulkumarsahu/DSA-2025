package com.dsa2025.learn.lld.designPatterns.bridge;

public class WaterBreatheImplementation implements BreatheImplementor {

    @Override
    public void breathe() {
        System.out.println("Breathe through gills – absorb oxygen from water.");
    }
}
