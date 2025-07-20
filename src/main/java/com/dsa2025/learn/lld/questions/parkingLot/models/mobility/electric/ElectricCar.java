package com.dsa2025.learn.lld.questions.parkingLot.models.mobility.electric;

import com.dsa2025.learn.lld.questions.parkingLot.models.constant.VehicleType;
import com.dsa2025.learn.lld.questions.parkingLot.models.mobility.Vehicle;

public class ElectricCar extends Vehicle implements ElectricVehicle {

    public ElectricCar(String vehicleId, String vehicleRegistrationNumber) {
        super(vehicleId, vehicleRegistrationNumber, VehicleType.ELECTRIC_CAR);
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Car");
    }

    @Override
    public float getBatteryLevel() {
        return 50;
    }
}
