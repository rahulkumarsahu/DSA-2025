package com.dsa2025.learn.lld.designPatterns.decorator;

public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", extra cheese";
    }

    public double getCost() {
        return pizza.getCost() + 2.0;
    }

}
