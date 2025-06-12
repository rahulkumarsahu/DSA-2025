package com.dsa2025.learn.lld.designPatterns.command;

public class Main {

    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner();

        // Create commands
        ICommand turnOnCommand = new TurnACOnCommand(ac);
        ICommand turnOffCommand = new TurnACOffCommand(ac);

        // Create invoker
        MyRemoteControl remote = new MyRemoteControl();

        // Turn on AC
        remote.setCommand(turnOnCommand);
        remote.pressButton();

        // Set temperature directly (optional: can create a SetTemperatureCommand for uniformity)
        ac.setTemperature(24);

        // Turn off AC
        remote.setCommand(turnOffCommand);
        remote.pressButton();
    }

}
