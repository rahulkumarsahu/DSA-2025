package com.dsa2025.learn.lld.questions.designParkingLot.models.spots;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.PricingType;

public class TwoWheelerParkingSpot extends ParkingSpot {

    public TwoWheelerParkingSpot(double basePrice, PricingType pricingType) {
        super(ParkingSpotType.TWO_WHEELER, basePrice, pricingType);
    }
}
