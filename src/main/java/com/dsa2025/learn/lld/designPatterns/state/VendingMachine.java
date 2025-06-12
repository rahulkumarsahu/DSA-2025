package com.dsa2025.learn.lld.designPatterns.state;

public class VendingMachine {

    VendingState currentState;

    public VendingState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingState currentState) {
        this.currentState = currentState;
    }

}
