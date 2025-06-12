package com.dsa2025.learn.lld.designPatterns.strategy.withStrategy;

public class HybridDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Hybrid Capability...");
    }
}
