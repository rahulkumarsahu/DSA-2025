package com.dsa2025.learn.lld.designPatterns.adapterPattern.music;

public class AdvancedMediaPlayer {

    void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }

    void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }

}
