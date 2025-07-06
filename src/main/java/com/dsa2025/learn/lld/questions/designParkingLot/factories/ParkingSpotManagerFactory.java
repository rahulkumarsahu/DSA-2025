package com.dsa2025.learn.lld.questions.designParkingLot.factories;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.manager.*;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking.ParkingStrategy;

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
