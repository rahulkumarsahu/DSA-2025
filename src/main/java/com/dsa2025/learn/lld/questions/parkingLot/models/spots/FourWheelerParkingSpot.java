package com.dsa2025.learn.lld.questions.parkingLot.models.spots;

import com.dsa2025.learn.lld.questions.parkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.parkingLot.models.constant.PricingType;

public class FourWheelerParkingSpot extends ParkingSpot {

    public FourWheelerParkingSpot(double basePrice, PricingType pricingType) {
        super(ParkingSpotType.FOUR_WHEELER, basePrice, pricingType);
    }
}
