package com.dsa2025.learn.lld.designPatterns.facade.example3;

public class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to " + input);
    }

    public void off() {
        System.out.println("Projector is OFF");
    }
}
