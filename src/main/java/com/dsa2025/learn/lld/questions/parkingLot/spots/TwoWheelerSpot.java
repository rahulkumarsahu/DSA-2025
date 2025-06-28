package com.dsa2025.learn.lld.questions.parkingLot.spots;

import com.dsa2025.learn.lld.questions.parkingLot.constant.ParkingStrategyType;
import com.dsa2025.learn.lld.questions.parkingLot.constant.SpotSize;
import com.dsa2025.learn.lld.questions.parkingLot.constant.VehicleType;

public class TwoWheelerSpot extends ParkingSpot {

    public TwoWheelerSpot(String spotId, ParkingStrategyType parkingStrategyType) {
        super(spotId, VehicleType.TWO_WHEELER.getBasePrice(), parkingStrategyType, SpotSize.SMALL);
    }

}
