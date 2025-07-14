package com.dsa2025.learn.lld.designPatterns.facade.example3;

public class HomeTheaterFacade {
    private final DVDPlayer dvdPlayer;
    private final Amplifier amplifier;
    private final Projector projector;
    private final Lights lights;
    private final PopcornPopper popper;

    public HomeTheaterFacade(DVDPlayer dvd, Amplifier amp, Projector proj,
                             Lights lights, PopcornPopper popper) {
        this.dvdPlayer = dvd;
        this.amplifier = amp;
        this.projector = proj;
        this.lights = lights;
        this.popper = popper;
    }

    // Simple method that coordinates complex operations
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        projector.on();
        projector.setInput("DVD");
        amplifier.on();
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
        System.out.println("Movie started!\n");
    }

    public void endMovie() {
        System.out.println("Shutting down movie theater...");
        popper.off();
        lights.on();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.off();
        System.out.println("Movie theater is off.\n");
    }

}
