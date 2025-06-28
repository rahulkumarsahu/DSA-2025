package com.dsa2025.learn.lld.questions.parkingLot.constant;

import java.time.temporal.ChronoUnit;

public enum PricingStrategyEnum {
    HOURLY("Per Hour", ChronoUnit.HOURS),
    MINUTE("Per Minute", ChronoUnit.MINUTES),
    DEFAULT("Daily Fixed", ChronoUnit.DAYS);

    private final String displayName;
    private final ChronoUnit unit;

    PricingStrategyEnum(String displayName, ChronoUnit unit) {
        this.displayName = displayName;
        this.unit = unit;
    }

}
