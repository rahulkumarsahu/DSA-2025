package com.dsa2025.learn.lld.questions.parkingLot.models.spots;

import com.dsa2025.learn.lld.questions.parkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.parkingLot.models.constant.PricingType;

public class FourWheelerWithChargingParkingSpot extends ParkingSpot {

    public FourWheelerWithChargingParkingSpot(double basePrice, PricingType pricingType) {
        super(ParkingSpotType.FOUR_WHEELER_CHARGING, basePrice, pricingType);
    }
}
