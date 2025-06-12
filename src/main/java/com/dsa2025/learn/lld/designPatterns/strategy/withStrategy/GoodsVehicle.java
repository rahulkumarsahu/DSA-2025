package com.dsa2025.learn.lld.designPatterns.strategy.withStrategy;

public class GoodsVehicle extends Vehicle {
    public GoodsVehicle() {
        super(new HybridDriveStrategy());
    }
}
