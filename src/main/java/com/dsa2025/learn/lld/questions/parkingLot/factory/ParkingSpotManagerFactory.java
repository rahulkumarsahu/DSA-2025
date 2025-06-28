package com.dsa2025.learn.lld.questions.parkingLot.factory;

import com.dsa2025.learn.lld.questions.parkingLot.constant.VehicleType;
import com.dsa2025.learn.lld.questions.parkingLot.spots.FourWheelerSpotManager;
import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpotManager;
import com.dsa2025.learn.lld.questions.parkingLot.spots.TwoWheelerSpotManager;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.ParkingStrategy;

import java.util.List;

public class ParkingSpotManagerFactory {

    public static ParkingSpotManager getParkingSpotManager(VehicleType vehicleType, ParkingStrategy strategy,
                                                           List<ParkingSpot> list) {
        return switch (vehicleType) {
            case TWO_WHEELER -> new TwoWheelerSpotManager(list, strategy);
            case FOUR_WHEELER -> new FourWheelerSpotManager(list, strategy);
        };
    }

}
