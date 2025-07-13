package com.dsa2025.learn.lld.designPatterns.decorator;

public class PepperoniDecorator extends PizzaDecorator {

    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", pepperoni";
    }

    public double getCost() {
        return pizza.getCost() + 3.0;
    }

}
