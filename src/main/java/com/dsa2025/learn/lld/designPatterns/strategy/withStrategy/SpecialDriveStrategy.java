package com.dsa2025.learn.lld.designPatterns.strategy.withStrategy;

public class SpecialDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Special Drive Capability");
    }
}
