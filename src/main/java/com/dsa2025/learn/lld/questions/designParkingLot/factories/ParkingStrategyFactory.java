package com.dsa2025.learn.lld.questions.designParkingLot.factories;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingStrategyType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.Vehicle;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking.ChargingSpotStrategy;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking.ParkingStrategy;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking.RandomParkingStrategy;

public class ParkingStrategyFactory {

    public static ParkingStrategy getParkingStrategy(ParkingStrategyType strategyType,
                                                     Vehicle vehicle) {
        return switch (strategyType) {
            case RANDOM_SPOT -> new RandomParkingStrategy(vehicle);
            case WITH_CHARGING_PARKING_SPOT -> new ChargingSpotStrategy(vehicle);
        };
    }

}
