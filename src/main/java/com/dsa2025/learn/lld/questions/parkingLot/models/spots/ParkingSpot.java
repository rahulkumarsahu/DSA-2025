package com.dsa2025.learn.lld.questions.parkingLot.models.spots;

import com.dsa2025.learn.lld.questions.parkingLot.models.constant.ParkingLotStatus;
import com.dsa2025.learn.lld.questions.parkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.parkingLot.models.constant.PricingType;
import com.dsa2025.learn.lld.questions.parkingLot.models.mobility.Vehicle;

import java.util.Optional;
import java.util.UUID;

/**
 * This class represents a single parking spot which has a property id, spot is available and vehicle which is parked and basePrice of that
 * and in the spot park or remove vehicle.
 */
public class ParkingSpot {

    private final String spotId;
    private Vehicle vehicle;
    private ParkingLotStatus parkingLotStatus;
    private final ParkingSpotType parkingSpotType;
    private final double basePrice;
    private final PricingType pricingType;

    public ParkingSpot(ParkingSpotType parkingSpotType,
                       double basePrice, PricingType pricingType) {
        this.spotId = UUID.randomUUID().toString();
        this.vehicle = new Vehicle();
        this.parkingLotStatus = ParkingLotStatus.EMPTY;
        this.parkingSpotType = parkingSpotType;
        this.basePrice = basePrice;
        this.pricingType = pricingType;
    }


    /**
     * This method will park the vehicle in a spot
     * @param vehicle vehicle
     * @return boolean Boolean
     */
    public boolean parkVehicle(Vehicle vehicle) {
        if (this.parkingLotStatus == ParkingLotStatus.OCCUPIED) return false;
        setVehicle(vehicle);
        setParkingLotStatus(ParkingLotStatus.OCCUPIED);
        return Boolean.TRUE;
    }

    /**
     * This method will be used to remove vehicle
     * @return Vehicle
     */
    public Optional<Vehicle> removeVehicle() {

        if (this.parkingLotStatus == ParkingLotStatus.EMPTY) return Optional.empty();
        Vehicle vehicle = this.vehicle;
        setVehicle(null);
        setParkingLotStatus(ParkingLotStatus.EMPTY);
        return Optional.ofNullable(vehicle);

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public PricingType getPricingType() {
        return pricingType;
    }

}
