package com.dsa2025.learn.lld.questions.parkingLot.constant;

public enum ParkingStrategyType {

    NEAR_TO_ENTRANCE("Near to Entrance Parking Spot"),
    NEAR_TO_ENTRANCE_AND_ELEVATOR("Near to Entrance and Elevator Parking Spot"),
    RANDOM("ANY Parking Slot");

    private final String displayName;

    ParkingStrategyType(String displayName) {
        this.displayName = displayName;
    }

}
