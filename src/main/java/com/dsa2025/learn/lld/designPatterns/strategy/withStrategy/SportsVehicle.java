package com.dsa2025.learn.lld.designPatterns.strategy.withStrategy;

public class SportsVehicle extends Vehicle {

    public SportsVehicle() {
        super(new SpecialDriveStrategy());
    }

    public void drive() {
        System.out.println("Special Drive Capability");
    }
}
