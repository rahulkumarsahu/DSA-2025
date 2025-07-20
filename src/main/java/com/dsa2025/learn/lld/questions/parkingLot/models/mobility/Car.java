package com.dsa2025.learn.lld.questions.parkingLot.models.mobility;

import com.dsa2025.learn.lld.questions.parkingLot.models.constant.VehicleType;

public class Car extends Vehicle {

    public Car(String vehicleId, String vehicleRegistrationNumber) {
        super(vehicleId, vehicleRegistrationNumber, VehicleType.CAR);
    }
}
