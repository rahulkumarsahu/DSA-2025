package com.dsa2025.learn.lld.designPatterns.bridge;

public class Fish extends LivingThings {

    public Fish(BreatheImplementor impl) {
        super(impl);
    }

    public void breatheProcess() {
        breatheImplementor.breathe();
    }

}
