package com.dsa2025.learn.lld.designPatterns.bridge;

public class BridgePattern {

    public static void main(String[] args) {
        LivingThings dog = new Dog(new LandBreatheImplementation());
        LivingThings fish = new Fish(new WaterBreatheImplementation());
        LivingThings tree = new Tree(new LeafBreatheImplementation());

        dog.breatheProcess();
        fish.breatheProcess();
        tree.breatheProcess();
    }

}
