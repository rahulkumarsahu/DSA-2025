package com.dsa2025.learn.lld.designPatterns.facade.example3;

public class FacadePatternExample {

    public static void main(String[] args) {
        // Create subsystem objects
        DVDPlayer dvd = new DVDPlayer();
        Amplifier amp = new Amplifier();
        Projector projector = new Projector();
        Lights lights = new Lights();
        PopcornPopper popper = new PopcornPopper();

        // Create facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                dvd, amp, projector, lights, popper);

        // Use simple interface instead of complex subsystem calls
        homeTheater.watchMovie("The Matrix");
        homeTheater.endMovie();
    }
}
