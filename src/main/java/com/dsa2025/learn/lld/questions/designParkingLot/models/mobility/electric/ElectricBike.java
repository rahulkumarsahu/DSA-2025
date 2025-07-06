package com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.electric;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.VehicleType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.Vehicle;

public class ElectricBike extends Vehicle implements ElectricVehicle {

    public ElectricBike(String vehicleId, String vehicleRegistrationNumber) {
        super(vehicleId, vehicleRegistrationNumber, VehicleType.ELECTRIC_BIKE);
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Bike");
    }

    @Override
    public float getBatteryLevel() {
        return 0;
    }
}
