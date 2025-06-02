package com.dsa2025.learn.lld.designPatterns.bridge;

public abstract class LivingThings {

    BreatheImplementor breatheImplementor;

    public LivingThings(BreatheImplementor breatheImplementor) {
        this.breatheImplementor = breatheImplementor;
    }

    public abstract void breatheProcess();

}
