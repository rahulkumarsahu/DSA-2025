package com.dsa2025.learn.lld.designPatterns.decorator;

public class Main {

    public static void main(String[] args) {
        BasePizza pizza = new Margherita();
        pizza = new ExtraCheese(pizza);
        pizza = new ExtraMushroom(pizza);
        //BasePizza pizza = new ExtraMushroom(new ExtraCheese(new Margherita()));
        System.out.println(pizza.cost());
    }
}
