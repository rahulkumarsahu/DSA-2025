package com.dsa2025.learn.lld.questions.parkingLot.factories;
import com.dsa2025.learn.lld.questions.parkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.parkingLot.models.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.parkingLot.models.spots.manager.*;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.parking.ParkingStrategy;

import java.util.List;

public class ParkingSpotManagerFactory {

    public static ParkingSpotManager getParkingSpotManager(ParkingSpotType parkingSpotType, ParkingStrategy strategy,
                                                           List<ParkingSpot> list) {
        return switch (parkingSpotType) {
            case TWO_WHEELER -> new TwoWheelerParkingSpotManager(list, strategy);
            case FOUR_WHEELER -> new FourWheelerParkingSpotManager(list, strategy);
            case TWO_WHEELER_CHARGING -> new TwoWheelerWithChargingParkingSpotManager(list, strategy);
            case FOUR_WHEELER_CHARGING -> new FourWheelerWithChargingParkingSpotManager(list, strategy);
        };
    }
}
