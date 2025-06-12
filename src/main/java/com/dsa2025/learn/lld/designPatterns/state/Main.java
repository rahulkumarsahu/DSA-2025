package com.dsa2025.learn.lld.designPatterns.state;

public class Main {

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.setCurrentState(new IdleState());

        machine.getCurrentState().dispense(machine); // Insert coin
        machine.getCurrentState().dispense(machine); // Dispense item
        machine.getCurrentState().dispense(machine); // Reset to idle
    }

}
