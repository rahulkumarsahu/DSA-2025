package com.dsa2025.learn.lld.designPatterns.command;

public class TurnACOnCommand implements ICommand {
    AirConditioner ac;

    public TurnACOnCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOnAC();
    }

}
