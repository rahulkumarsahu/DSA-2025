package com.dsa2025.learn.lld.questions.parkingLot.strategy;

import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpot;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    // here we have to get the spot according to strategy if it is Nearest to elevator or Nearest to entrance or Random
    Optional<ParkingSpot> findSpot(List<ParkingSpot> parkingSpots);
}
