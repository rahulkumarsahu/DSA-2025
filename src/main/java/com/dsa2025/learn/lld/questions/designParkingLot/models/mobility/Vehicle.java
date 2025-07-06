package com.dsa2025.learn.lld.questions.designParkingLot.models.mobility;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.VehicleType;

import java.util.Objects;

/**
 * This class represents the vehicle metadata as per the requirement
 * we will be having bike, car, electric car, electric bike
 * which will be subclassed of vehicle
 * and electric car and bike will be having extra functionality of charging
 */
public class Vehicle {

    private String vehicleId;
    private String vehicleRegistrationNumber;
    private VehicleType vehicleType;

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String vehicleRegistrationNumber,
                   VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleId, vehicle.vehicleId) && Objects.equals(vehicleRegistrationNumber, vehicle.vehicleRegistrationNumber) && vehicleType == vehicle.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, vehicleRegistrationNumber, vehicleType);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleRegistrationNumber='" + vehicleRegistrationNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
