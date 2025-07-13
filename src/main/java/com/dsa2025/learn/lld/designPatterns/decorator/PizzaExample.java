package com.dsa2025.learn.lld.designPatterns.decorator;

public class PizzaExample {

    public static void main(String[] args) {
        Pizza pizza = new MargheritaPizza();
        System.out.println(pizza.getDescription() + ": $" + pizza.getCost());

        // Add toppings
        pizza = new CheeseDecorator(pizza);
        pizza = new PepperoniDecorator(pizza);
        pizza = new MushroomDecorator(pizza);

        System.out.println(pizza.getDescription() + ": $" + pizza.getCost());
    }
}
