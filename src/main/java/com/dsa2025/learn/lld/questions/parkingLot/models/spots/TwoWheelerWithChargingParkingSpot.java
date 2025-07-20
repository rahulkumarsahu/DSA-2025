package com.dsa2025.learn.lld.questions.parkingLot.models.spots;

import com.dsa2025.learn.lld.questions.parkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.parkingLot.models.constant.PricingType;

public class TwoWheelerWithChargingParkingSpot extends ParkingSpot {

    public TwoWheelerWithChargingParkingSpot(double basePrice, PricingType pricingType) {
        super(ParkingSpotType.TWO_WHEELER_CHARGING, basePrice, pricingType);
    }
}
