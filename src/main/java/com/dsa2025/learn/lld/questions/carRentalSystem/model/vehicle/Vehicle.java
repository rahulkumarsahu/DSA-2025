package com.dsa2025.learn.lld.questions.carRentalSystem.model.vehicle;

import com.dsa2025.learn.lld.questions.carRentalSystem.model.enums.VehicleStatus;
import com.dsa2025.learn.lld.questions.carRentalSystem.model.enums.VehicleType;

import java.time.LocalDate;

public abstract class Vehicle {

    private String id;
    private String chassisNumber;
    private String registrationNumber;
    private VehicleType vehicleType;
    private String modelName;
    private double average;
    private int kmDriven;
    private LocalDate mfDate;
    private VehicleStatus status;

    public Vehicle(String id, String chassisNumber, String registrationNumber,
                   VehicleType vehicleType, String modelName, double average,
                   int kmDriven, LocalDate mfDate) {
        this.id = id;
        this.chassisNumber = chassisNumber;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.modelName = modelName;
        this.average = average;
        this.kmDriven = kmDriven;
        this.mfDate = mfDate;
        this.status = VehicleStatus.ACTIVE;
    }

    // TO check vehicle is available
    public boolean isAvailable() {
        return status == VehicleStatus.ACTIVE;
    }

    // To make vehicle reserve
    public void reserve() {
        this.status = VehicleStatus.RESERVED;
    }

    // To make vehicle release when period is over
    public void release() {
        this.status = VehicleStatus.ACTIVE;
    }

    public String getId() { return id; }
    public String getModelName() { return modelName; }
    public VehicleType getVehicleType() { return vehicleType; }
    public VehicleStatus getStatus() { return status; }
    public String getRegistrationNumber() { return registrationNumber; }
    public double getAverage() { return average; }
    public int getKmDriven() { return kmDriven; }
    public void setStatus(VehicleStatus status) { this.status = status; }

    public void setId(String id) {
        this.id = id;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public LocalDate getMfDate() {
        return mfDate;
    }

    public void setMfDate(LocalDate mfDate) {
        this.mfDate = mfDate;
    }

    public String toString() {
        return vehicleType + " - " + modelName + " (" + registrationNumber + ") [" + status + "]";
    }
}
