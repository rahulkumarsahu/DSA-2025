package com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking;

import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.ParkingSpot;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {


    Optional<ParkingSpot> findSpot(List<ParkingSpot> parkingSpotList);
}
