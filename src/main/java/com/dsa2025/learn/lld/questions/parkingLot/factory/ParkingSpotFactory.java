package com.dsa2025.learn.lld.questions.parkingLot.factory;

import com.dsa2025.learn.lld.questions.parkingLot.constant.ParkingStrategyType;
import com.dsa2025.learn.lld.questions.parkingLot.constant.VehicleType;
import com.dsa2025.learn.lld.questions.parkingLot.spots.FourWheelerSpot;
import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.parkingLot.spots.TwoWheelerSpot;

public class ParkingSpotFactory {

    public static ParkingSpot getParkingSpot(VehicleType vehicleType, String spotId, ParkingStrategyType strategyType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> new TwoWheelerSpot(spotId, strategyType);
            case FOUR_WHEELER -> new FourWheelerSpot(spotId, strategyType);
        };
    }

}
