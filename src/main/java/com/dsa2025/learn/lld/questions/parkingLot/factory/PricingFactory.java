package com.dsa2025.learn.lld.questions.parkingLot.factory;

import com.dsa2025.learn.lld.questions.parkingLot.constant.PricingStrategyEnum;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.DefaultPrice;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.HourPricing;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.MinutePrice;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.PricingStrategy;

public class PricingFactory {

    public static PricingStrategy getPricingStrategy(PricingStrategyEnum pricingEnum) {
        return switch (pricingEnum) {
            case HOURLY -> new HourPricing();
            case MINUTE -> new MinutePrice();
            case DEFAULT -> new DefaultPrice();
        };
    }

}
