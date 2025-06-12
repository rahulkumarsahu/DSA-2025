package com.dsa2025.learn.lld.designPatterns.command;

public class TurnACOnCommand implements ICommand {
    AirConditioner ac;

    public TurnACOnCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        // here 1 or 10 steps can be possible to turn on AC if any things get change sender or receiver will not change
        ac.turnOnAC();
    }

}
