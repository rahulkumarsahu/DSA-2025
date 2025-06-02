package com.dsa2025.learn.lld.designPatterns.bridge;

public class Tree extends LivingThings {

    public Tree(BreatheImplementor impl) {
        super(impl);
    }

    public void breatheProcess() {
        breatheImplementor.breathe();
    }

}
