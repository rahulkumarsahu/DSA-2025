package com.dsa2025.learn.lld.questions.snakeAndLadder.model;

public class Player {

    private final String name;
    private int position;
    private final int id;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        this.position = 0;
    }

    public String getName() { return name; }
    public int getPosition() { return position; }
    public int getId() { return id; }
    public void setPosition(int position) { this.position = position; }

    @Override
    public String toString() {
        return name + " (Position: " + position + ")";
    }

}
