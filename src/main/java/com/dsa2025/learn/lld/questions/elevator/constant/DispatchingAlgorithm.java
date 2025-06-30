package com.dsa2025.learn.lld.questions.elevator.constant;

public enum DispatchingAlgorithm {

    FIXED_FLOOR,    // Each elevator serves specific floors only
    ODD_EVEN,       // Odd elevators serve odd floors, even elevators serve even floors
    CLOSEST_CAR     // Dispatch to closest available elevator

}
