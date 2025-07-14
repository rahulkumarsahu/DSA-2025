package com.dsa2025.learn.lld.designPatterns.facade.example3;

public class Amplifier {

    public void on() {
        System.out.println("Amplifier is ON");
    }

    public void setVolume(int level) {
        System.out.println("Amplifier volume set to " + level);
    }

    public void off() {
        System.out.println("Amplifier is OFF");
    }

}
