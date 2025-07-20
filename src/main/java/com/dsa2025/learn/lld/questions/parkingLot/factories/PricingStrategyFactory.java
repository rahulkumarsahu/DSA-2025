package com.dsa2025.learn.lld.questions.parkingLot.factories;


import com.dsa2025.learn.lld.questions.parkingLot.models.constant.PricingType;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.pricing.FixedPricingStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.pricing.HourlyPricingStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.pricing.PricingStrategy;

public class PricingStrategyFactory {

    public static PricingStrategy getPricingStrategy(PricingType pricingEnum) {
        return switch (pricingEnum) {
            case HOURLY -> new HourlyPricingStrategy();
            case FIXED -> new FixedPricingStrategy();
        };
    }
}
