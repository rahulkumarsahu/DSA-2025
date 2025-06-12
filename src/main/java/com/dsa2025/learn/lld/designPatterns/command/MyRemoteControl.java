package com.dsa2025.learn.lld.designPatterns.command;

//Sender
public class MyRemoteControl {

    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}
