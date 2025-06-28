package com.dsa2025.learn.lld.questions.parkingLot.factory;

import com.dsa2025.learn.lld.questions.parkingLot.constant.VehicleType;
import com.dsa2025.learn.lld.questions.parkingLot.cost.CostCalculation;
import com.dsa2025.learn.lld.questions.parkingLot.cost.FourWheelerCostCalculation;
import com.dsa2025.learn.lld.questions.parkingLot.cost.TwoWheelerCostCalculation;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.PricingStrategy;

public class CostComputationFactory {

    public static CostCalculation getCostCalculator(VehicleType vehicleType, PricingStrategy pricingStrategy) {
        return switch (vehicleType) {
            case TWO_WHEELER -> new TwoWheelerCostCalculation(pricingStrategy);
            case FOUR_WHEELER -> new FourWheelerCostCalculation(pricingStrategy);
        };
    }

}
