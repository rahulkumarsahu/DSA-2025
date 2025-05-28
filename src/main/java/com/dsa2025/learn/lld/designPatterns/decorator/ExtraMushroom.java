package com.dsa2025.learn.lld.designPatterns.decorator;

public class ExtraMushroom extends ToppingDecorator {

    BasePizza basePizza;

    ExtraMushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    int cost() {
        return this.basePizza.cost() + 20;
    }

}
