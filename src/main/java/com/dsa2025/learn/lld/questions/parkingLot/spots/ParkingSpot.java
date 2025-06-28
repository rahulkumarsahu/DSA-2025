package com.dsa2025.learn.lld.questions.parkingLot.spots;

import com.dsa2025.learn.lld.questions.parkingLot.constant.ParkingStrategyType;
import com.dsa2025.learn.lld.questions.parkingLot.constant.SpotSize;
import com.dsa2025.learn.lld.questions.parkingLot.dto.Vehicle;
import lombok.Data;

import java.util.Optional;

/**
 * This class represents a single parking spot which has a property id, spot is available and vehicle which is parked and basePrice of that
 * and in the spot park or remove vehicle.
 */
public abstract class ParkingSpot {

    private String spotId;
    private boolean isEmpty = true;
    private Vehicle parkedVehicle;
    private int basePrice;
    private ParkingStrategyType parkingStrategyType;
    private SpotSize spotSize;

    public ParkingSpot(String id, int basePrice, ParkingStrategyType parkingStrategyType, SpotSize spotSize) {
        this.basePrice = basePrice;
        this.spotId = id;
        this.parkingStrategyType = parkingStrategyType;
        this.spotSize = spotSize;
    }

    /**
     * This method will park the vehicle in a spot
     * @param vehicle vehicle
     * @return boolean
     */
    public boolean parkVehicle(Vehicle vehicle) {
        if (!isEmpty) return false;
        this.parkedVehicle = vehicle;
        this.isEmpty = Boolean.FALSE;
        return Boolean.TRUE;
    }

    /**
     * This method will be used to remove vehicle
     * @return Optional<Vehicle>
     */
    public Optional<Vehicle> removeVehicle() {
        if (isEmpty) return Optional.empty();
        Vehicle vehicle = this.parkedVehicle;
        this.parkedVehicle = null;
        this.isEmpty = Boolean.TRUE;
        return Optional.ofNullable(vehicle);
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public ParkingStrategyType getParkingStrategyType() {
        return parkingStrategyType;
    }
     
}
