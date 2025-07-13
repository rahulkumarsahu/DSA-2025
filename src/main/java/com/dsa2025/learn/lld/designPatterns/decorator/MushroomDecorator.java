package com.dsa2025.learn.lld.designPatterns.decorator;

public class MushroomDecorator extends PizzaDecorator {

    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", mushrooms";
    }

    public double getCost() {
        return pizza.getCost() + 1.5;
    }

}
