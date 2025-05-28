package com.dsa2025.learn.lld.designPatterns.NULL;

public class VehicleFactory {

    public static Vehicle getVehicleObject(String obj) {

        if (obj.equalsIgnoreCase("Car")) {
            return new Car();
        }

        return new NullVehicle();
    }
}
