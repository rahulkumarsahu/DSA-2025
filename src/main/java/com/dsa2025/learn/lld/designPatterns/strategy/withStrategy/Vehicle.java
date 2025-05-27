package com.dsa2025.learn.lld.designPatterns.strategy.withStrategy;

public class Vehicle {

    private final DriveStrategy driveStrategy;

    // this is known as constructor Injection...
    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }

}
