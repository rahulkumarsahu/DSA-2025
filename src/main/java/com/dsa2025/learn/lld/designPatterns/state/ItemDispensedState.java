package com.dsa2025.learn.lld.designPatterns.state;

public class ItemDispensedState implements VendingState {

    @Override
    public void dispense(VendingMachine product) {
        System.out.println("Take your item. Going back to idle.");
        product.setCurrentState(new IdleState());
    }
}
