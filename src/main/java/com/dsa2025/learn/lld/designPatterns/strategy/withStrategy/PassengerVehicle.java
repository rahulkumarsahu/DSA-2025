package com.dsa2025.learn.lld.designPatterns.strategy.withStrategy;

public class PassengerVehicle extends Vehicle {
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
