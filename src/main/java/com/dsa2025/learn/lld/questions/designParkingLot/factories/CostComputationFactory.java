package com.dsa2025.learn.lld.questions.designParkingLot.factories;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.CostCalculationType;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.cost.CostComputation;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.cost.WithChargingCostComputation;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.cost.WithoutChargingCostComputation;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing.PricingStrategy;

public class CostComputationFactory {

    public static CostComputation getCostCalculator(CostCalculationType costCalculationType,
                                                    PricingStrategy pricingStrategy) {
        return switch (costCalculationType) {
            case WITH_CHARGING -> new WithChargingCostComputation(pricingStrategy);
            case WITHOUT_CHARGING -> new WithoutChargingCostComputation(pricingStrategy);
        };
    }
}
