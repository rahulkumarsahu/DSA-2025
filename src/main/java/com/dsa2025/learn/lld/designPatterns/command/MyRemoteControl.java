package com.dsa2025.learn.lld.designPatterns.command;

//Sender :- doesnot worry about how to start tha AC just in press button it says command.execute()
public class MyRemoteControl {

    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}
