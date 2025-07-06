package com.dsa2025.learn.lld.questions.designParkingLot.models.mobility;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.VehicleType;

public class Bike extends Vehicle {

    public Bike(String vehicleId, String vehicleRegistrationNumber) {
        super(vehicleId, vehicleRegistrationNumber, VehicleType.BIKE);
    }
}
