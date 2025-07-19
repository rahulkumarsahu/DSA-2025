package com.dsa2025.learn.lld.questions.designCarRentalSystem.model.vehicle;

import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.enums.VehicleType;

import java.time.LocalDate;

public class Bike extends Vehicle {

    public Bike(String id, String chassisNumber, String registrationNumber,
                String modelName, double average, int kmDriven, LocalDate mfDate) {
        super(id, chassisNumber, registrationNumber, VehicleType.BIKE,
                modelName, average, kmDriven, mfDate);
    }

}
