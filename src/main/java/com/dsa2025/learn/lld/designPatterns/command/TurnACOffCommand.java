package com.dsa2025.learn.lld.designPatterns.command;

public class TurnACOffCommand implements ICommand {
    AirConditioner ac;

    public TurnACOffCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOffAC();
    }
}
