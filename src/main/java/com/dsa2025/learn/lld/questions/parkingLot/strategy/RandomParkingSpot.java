package com.dsa2025.learn.lld.questions.parkingLot.strategy;

import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpot;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class RandomParkingSpot implements ParkingStrategy {

    private final Random random = new Random();


    /**
     * This method we will be using to find a spot any parking Spot
     * @param parkingSpots parkingSpots
     * @return Optional<ParkingSpot>
     */
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingSpot> parkingSpots) {
        List<ParkingSpot> availableSpots = parkingSpots.stream()
                .filter(ParkingSpot::isEmpty)
                .toList();

        if (availableSpots.isEmpty()) {
            return Optional.empty();
        }

        int randomIndex = random.nextInt(availableSpots.size());
        return Optional.of(availableSpots.get(randomIndex));

    }
}
