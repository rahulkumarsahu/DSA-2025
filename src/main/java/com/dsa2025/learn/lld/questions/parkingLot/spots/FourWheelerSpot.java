package com.dsa2025.learn.lld.questions.parkingLot.spots;

import com.dsa2025.learn.lld.questions.parkingLot.constant.ParkingStrategyType;
import com.dsa2025.learn.lld.questions.parkingLot.constant.SpotSize;
import com.dsa2025.learn.lld.questions.parkingLot.constant.VehicleType;

public class FourWheelerSpot extends ParkingSpot {

    public FourWheelerSpot(String spotId, ParkingStrategyType parkingStrategyType) {
        super(spotId, VehicleType.FOUR_WHEELER.getBasePrice(), parkingStrategyType, SpotSize.MEDIUM);
    }



}
