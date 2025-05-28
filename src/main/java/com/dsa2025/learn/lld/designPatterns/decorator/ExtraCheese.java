package com.dsa2025.learn.lld.designPatterns.decorator;

public class ExtraCheese extends ToppingDecorator {

    BasePizza basePizza;

    ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    int cost() {
        return this.basePizza.cost() + 10;
    }
}
