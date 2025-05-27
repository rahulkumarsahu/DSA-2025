package com.dsa2025.learn.lld.designPatterns.strategy.withStrategy;

public class OffRoadVehicle extends Vehicle {

    public OffRoadVehicle() {
        super(new SpecialDriveStrategy());
    }

}
