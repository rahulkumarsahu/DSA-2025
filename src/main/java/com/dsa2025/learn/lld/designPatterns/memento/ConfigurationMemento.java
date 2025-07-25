package com.dsa2025.learn.lld.designPatterns.memento;

public class ConfigurationMemento {

    int height;
    int width;

    public ConfigurationMemento(int height, int width){
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
