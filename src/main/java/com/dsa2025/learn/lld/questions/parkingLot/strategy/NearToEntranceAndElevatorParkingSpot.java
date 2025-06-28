package com.dsa2025.learn.lld.questions.parkingLot.strategy;

import com.dsa2025.learn.lld.questions.parkingLot.constant.ParkingStrategyType;
import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpot;

import java.util.List;
import java.util.Optional;

public class NearToEntranceAndElevatorParkingSpot implements ParkingStrategy {
    /**
     * This method we will be using to find a spot which is near to the entrance and elevator
     * @param parkingSpots parkingSpots
     * @return Optional<ParkingSpot>
     */
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingSpot> parkingSpots) {

        // Find spots near the entrance and elevator first
        return parkingSpots.stream()
                .filter(ParkingSpot::isEmpty)
                .filter(spot -> spot.getParkingStrategyType() == ParkingStrategyType.NEAR_TO_ENTRANCE_AND_ELEVATOR)
                .findFirst()
                .or(() -> parkingSpots.stream()
                        .filter(ParkingSpot::isEmpty)
                        .findFirst());
    }
}
