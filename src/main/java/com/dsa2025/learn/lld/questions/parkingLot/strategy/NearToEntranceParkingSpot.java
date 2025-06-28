package com.dsa2025.learn.lld.questions.parkingLot.strategy;

import com.dsa2025.learn.lld.questions.parkingLot.constant.ParkingStrategyType;
import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpot;

import java.util.List;
import java.util.Optional;

public class NearToEntranceParkingSpot implements ParkingStrategy {

    /**
     * This method we will be using to find a spot which is near to entrance
     * @param parkingSpots parkingSpots
     * @return Optional<ParkingSpot>
     */
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingSpot> parkingSpots) {

        // Find the first available spot (assuming spots are ordered by distance from entrance)
        // later we can change logic because a parking spot contains the property
        return parkingSpots.stream()
                .filter(ParkingSpot::isEmpty)
                .filter(spot -> spot.getParkingStrategyType() == ParkingStrategyType.NEAR_TO_ENTRANCE)
                .findFirst()
                .or(() -> parkingSpots.stream()
                        .filter(ParkingSpot::isEmpty)
                        .findFirst());

    }
}
