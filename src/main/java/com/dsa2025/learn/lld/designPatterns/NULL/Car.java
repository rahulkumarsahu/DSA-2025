package com.dsa2025.learn.lld.designPatterns.NULL;

public class Car implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 45;
    }

    @Override
    public int getSeatingCapacity() {
        return 5;
    }
}
