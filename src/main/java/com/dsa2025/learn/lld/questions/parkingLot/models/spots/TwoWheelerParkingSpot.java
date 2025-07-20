package com.dsa2025.learn.lld.questions.parkingLot.models.spots;

import com.dsa2025.learn.lld.questions.parkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.parkingLot.models.constant.PricingType;

public class TwoWheelerParkingSpot extends ParkingSpot {

    public TwoWheelerParkingSpot(double basePrice, PricingType pricingType) {
        super(ParkingSpotType.TWO_WHEELER, basePrice, pricingType);
    }
}
