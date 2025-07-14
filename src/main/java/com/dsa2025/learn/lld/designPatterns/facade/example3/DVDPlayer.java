package com.dsa2025.learn.lld.designPatterns.facade.example3;

public class DVDPlayer {

    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("DVD Player stopped");
    }

    public void off() {
        System.out.println("DVD Player is OFF");
    }

}
