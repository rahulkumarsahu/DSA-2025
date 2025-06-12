package com.dsa2025.learn.lld.designPatterns.memento;

public class Client {

    public static void main(String[] args) {
        ConfigurationCareTaker careTakerObject = new ConfigurationCareTaker();

        // Initial state of the originator
        ConfigurationOriginator originatorObject = new ConfigurationOriginator(5, 10);
        System.out.println("Initial state: height = " + originatorObject.height + ", width = " + originatorObject.width);

        // Save initial state
        ConfigurationMemento snapshot1 = originatorObject.createMemento();
        careTakerObject.addMemento(snapshot1);

        // Change to new state
        originatorObject.setHeight(7);
        originatorObject.setWidth(12);
        System.out.println("Changed to: height = " + originatorObject.height + ", width = " + originatorObject.width);

        // Save second state
        ConfigurationMemento snapshot2 = originatorObject.createMemento();
        careTakerObject.addMemento(snapshot2);

        // Change to another new state
        originatorObject.setHeight(9);
        System.out.println("Changed to: height = " + originatorObject.height + ", width = " + originatorObject.width);

        // Undo to previous state
        ConfigurationMemento restored = careTakerObject.undo();
        if (restored != null) {
            originatorObject.restoreMemento(restored);
            System.out.println("After undo: height = " + originatorObject.height + ", width = " + originatorObject.width);
        }
    }
}
