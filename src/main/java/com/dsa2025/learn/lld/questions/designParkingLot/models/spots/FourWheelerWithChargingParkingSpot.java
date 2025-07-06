package com.dsa2025.learn.lld.questions.designParkingLot.models.spots;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingLotStatus;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingSpotType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.PricingType;
import com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.Vehicle;

public class FourWheelerWithChargingParkingSpot extends ParkingSpot {

    public FourWheelerWithChargingParkingSpot(double basePrice, PricingType pricingType) {
        super(ParkingSpotType.FOUR_WHEELER_CHARGING, basePrice, pricingType);
    }
}
