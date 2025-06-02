package com.dsa2025.learn.lld.designPatterns.bridge;

public class LeafBreatheImplementation implements BreatheImplementor{
    @Override
    public void breathe() {
        System.out.println("Breathe through leaves – photosynthesis.");
    }
}
