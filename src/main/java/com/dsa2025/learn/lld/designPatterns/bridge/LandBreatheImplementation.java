package com.dsa2025.learn.lld.designPatterns.bridge;

public class LandBreatheImplementation implements BreatheImplementor {

    @Override
    public void breathe() {
        System.out.println("Breathe through nose – inhale oxygen, exhale CO2.");
    }
}
