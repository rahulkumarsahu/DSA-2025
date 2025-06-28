package com.dsa2025.learn.lld.questions.parkingLot.constant;

public enum VehicleType {

    TWO_WHEELER("Two Wheeler", 10),
    FOUR_WHEELER("Four Wheeler", 20);

    private final String displayName;
    private final int basePrice;

    VehicleType(String displayName, int basePrice) {
        this.displayName = displayName;
        this.basePrice = basePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }
}
