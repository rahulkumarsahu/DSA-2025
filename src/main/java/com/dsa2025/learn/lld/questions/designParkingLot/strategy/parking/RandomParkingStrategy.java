package com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingLotStatus;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.VehicleType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.Vehicle;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.ParkingSpot;

import java.util.List;
import java.util.Optional;

/**
 * Strategy to find any available spot (regular or charging) based on the vehicle type.
 * BIKE or ELECTRIC_BIKE -> TWO_WHEELER or TWO_WHEELER_CHARGING
 * CAR or ELECTRIC_CAR -> FOUR_WHEELER or FOUR_WHEELER_CHARGING
 */
public class RandomParkingStrategy implements ParkingStrategy {

    private final Vehicle vehicle;

    public RandomParkingStrategy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingSpot> parkingSpotList) {

        return parkingSpotList.stream()
                .filter(parkingSpot ->
                        parkingSpot.getParkingLotStatus() == ParkingLotStatus.EMPTY)
                .filter(this::isCompatible)
                .findFirst();
    }

    private boolean isCompatible(ParkingSpot parkingSpot) {
        VehicleType vehicleType = vehicle.getVehicleType();
        return switch (vehicleType) {
            case BIKE, ELECTRIC_BIKE ->
                    parkingSpot.getParkingSpotType() == ParkingSpotType.TWO_WHEELER
                            || parkingSpot.getParkingSpotType() == ParkingSpotType.TWO_WHEELER_CHARGING;
            case CAR, ELECTRIC_CAR ->
                    parkingSpot.getParkingSpotType() == ParkingSpotType.FOUR_WHEELER
                            || parkingSpot.getParkingSpotType() == ParkingSpotType.FOUR_WHEELER_CHARGING;
        };
    }
}
