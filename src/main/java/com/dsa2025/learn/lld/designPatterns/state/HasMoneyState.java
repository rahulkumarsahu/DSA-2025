package com.dsa2025.learn.lld.designPatterns.state;

public class HasMoneyState implements VendingState {
    @Override
    public void dispense(VendingMachine product) {
        System.out.println("Dispensing item...");
        // changing another state...
        product.setCurrentState(new ItemDispensedState());
    }
}
