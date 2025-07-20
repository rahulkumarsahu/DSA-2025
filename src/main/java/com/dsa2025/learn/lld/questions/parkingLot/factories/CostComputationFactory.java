package com.dsa2025.learn.lld.questions.parkingLot.factories;

import com.dsa2025.learn.lld.questions.parkingLot.models.constant.CostCalculationType;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.cost.CostComputation;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.cost.WithChargingCostComputation;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.cost.WithoutChargingCostComputation;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.pricing.PricingStrategy;

public class CostComputationFactory {

    public static CostComputation getCostCalculator(CostCalculationType costCalculationType,
                                                    PricingStrategy pricingStrategy) {
        return switch (costCalculationType) {
            case WITH_CHARGING -> new WithChargingCostComputation(pricingStrategy);
            case WITHOUT_CHARGING -> new WithoutChargingCostComputation(pricingStrategy);
        };
    }
}
