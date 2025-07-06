package com.dsa2025.learn.lld.questions.designParkingLot.factories;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.PricingType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.*;

public class ParkingSpotFactory {

    public static ParkingSpot getParkingSpot(ParkingSpotType parkingSpotType, double basePrice,
                                             PricingType pricingType) {
        return switch (parkingSpotType) {
            case TWO_WHEELER -> new TwoWheelerParkingSpot(basePrice, pricingType);
            case FOUR_WHEELER -> new FourWheelerParkingSpot(basePrice, pricingType);
            case TWO_WHEELER_CHARGING -> new TwoWheelerWithChargingParkingSpot(basePrice, pricingType);
            case FOUR_WHEELER_CHARGING -> new FourWheelerWithChargingParkingSpot(basePrice, pricingType);
        };
    }
}
