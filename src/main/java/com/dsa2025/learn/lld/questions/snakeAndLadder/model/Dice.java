package com.dsa2025.learn.lld.questions.snakeAndLadder.model;

import java.util.Random;

public class Dice {

    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }
}
