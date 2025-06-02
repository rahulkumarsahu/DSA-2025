package com.dsa2025.learn.lld.designPatterns.bridge;

public class Dog extends LivingThings {

    public Dog(BreatheImplementor impl) {
        super(impl);
    }

    public void breatheProcess() {
        breatheImplementor.breathe();
    }

}
