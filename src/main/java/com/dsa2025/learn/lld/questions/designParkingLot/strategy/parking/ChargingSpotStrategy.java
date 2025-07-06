package com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingLotStatus;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.VehicleType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.Vehicle;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.ParkingSpot;

import java.util.List;
import java.util.Optional;

/**
 * Strategy to find only charging spots.
 * ELECTRIC_BIKE -> TWO_WHEELER_CHARGING
 * ELECTRIC_CAR -> FOUR_WHEELER_CHARGING
 */
public class ChargingSpotStrategy implements ParkingStrategy {

    private final Vehicle vehicle;

    public ChargingSpotStrategy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingSpot> parkingSpotList) {
        return parkingSpotList.stream()
                .filter(parkingSpot ->
                        parkingSpot.getParkingLotStatus() == ParkingLotStatus.EMPTY)
                .filter(this::isChargingCompatible)
                .findFirst();
    }

    private boolean isChargingCompatible(ParkingSpot parkingSpot) {
        VehicleType type = vehicle.getVehicleType();
        return switch (type) {
            case ELECTRIC_BIKE ->
                    parkingSpot.getParkingSpotType() == ParkingSpotType.TWO_WHEELER_CHARGING;
            case ELECTRIC_CAR  ->
                    parkingSpot.getParkingSpotType() == ParkingSpotType.FOUR_WHEELER_CHARGING;
            default -> false; // Skip non-electric vehicles in charging-only strategy
        };
    }
}
