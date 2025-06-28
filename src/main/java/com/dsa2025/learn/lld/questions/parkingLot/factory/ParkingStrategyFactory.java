package com.dsa2025.learn.lld.questions.parkingLot.factory;

import com.dsa2025.learn.lld.questions.parkingLot.constant.ParkingStrategyType;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.NearToEntranceAndElevatorParkingSpot;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.NearToEntranceParkingSpot;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.ParkingStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.RandomParkingSpot;

public class ParkingStrategyFactory {

    public static ParkingStrategy getParkingStrategy(ParkingStrategyType strategyType) {
        return switch (strategyType) {
            case NEAR_TO_ENTRANCE -> new NearToEntranceParkingSpot();
            case NEAR_TO_ENTRANCE_AND_ELEVATOR -> new NearToEntranceAndElevatorParkingSpot();
            case RANDOM -> new RandomParkingSpot();
        };
    }

}
