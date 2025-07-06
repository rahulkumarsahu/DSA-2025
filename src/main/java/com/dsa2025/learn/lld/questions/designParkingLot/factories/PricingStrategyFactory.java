package com.dsa2025.learn.lld.questions.designParkingLot.factories;


import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.PricingType;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing.FixedPricingStrategy;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing.HourlyPricingStrategy;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing.PricingStrategy;

public class PricingStrategyFactory {

    public static PricingStrategy getPricingStrategy(PricingType pricingEnum) {
        return switch (pricingEnum) {
            case HOURLY -> new HourlyPricingStrategy();
            case FIXED -> new FixedPricingStrategy();
        };
    }
}
