package com.dsa2025.learn.lld.designPatterns.state;

public class IdleState implements VendingState {

    @Override
    public void dispense(VendingMachine product) {
        System.out.println("Please insert coin first.");
        // changing the state from 1 to 2
        product.setCurrentState(new HasMoneyState());
    }

}
