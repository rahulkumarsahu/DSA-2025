package com.dsa2025.learn.lld.designPatterns.facade.example3;

public class Lights {
    public void dim(int level) {
        System.out.println("Lights dimmed to " + level + "%");
    }

    public void on() {
        System.out.println("Lights are ON");
    }
}
