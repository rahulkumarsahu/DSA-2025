package com.dsa2025.learn.lld.questions.designParkingLot.models.constant;

public class ParkingLotConstants {

    private ParkingLotConstants() {
        throw new RuntimeException("Class object cannot be created");
    }

    public final double BIKE_SPOT_FIXED_PRICE = 80;
    public final double CAR_SPOT_FIXED_PRICE = 100;
    public final double CAR_CHARGING_SPOT_FIXED_PRICE = 100;
    public final double BIKE_CHARGING_SPOT_FIXED_PRICE = 80;

    public final double BIKE_SPOT_HOUR_PRICE = 10;
    public final double CAR_SPOT_HOUR_PRICE = 20;
    public final double CAR_CHARGING_SPOT_HOUR_PRICE = 10;
    public final double BIKE_CHARGING_SPOT_HOUR_PRICE = 20;

}
