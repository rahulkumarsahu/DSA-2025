package com.dsa2025.learn.lld.questions.snakeAndLadder.model;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private static final int BOARD_SIZE = 100;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board() {
        initializeSnakes();
        initializeLadders();
    }

    private void initializeSnakes() {
        snakes = new HashMap<>();
        snakes.put(99, 78);
        snakes.put(95, 75);
        snakes.put(92, 88);
        snakes.put(89, 68);
        snakes.put(74, 53);
        snakes.put(64, 60);
        snakes.put(62, 19);
        snakes.put(46, 25);
        snakes.put(37, 3);
        snakes.put(27, 1);
    }

    private void initializeLadders() {
        ladders = new HashMap<>();
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 21);
        ladders.put(16, 66);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);
    }

    public int movePlayer(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;

        // Can't go beyond 100
        if (newPosition > BOARD_SIZE) {
            return currentPosition;
        }

        // Check for a ladder
        if (ladders.containsKey(newPosition)) {
            int ladderTop = ladders.get(newPosition);
            System.out.println("🪜 Climbed ladder from " + newPosition + " to " + ladderTop);
            return ladderTop;
        }

        // Check for snake
        if (snakes.containsKey(newPosition)) {
            int snakeTail = snakes.get(newPosition);
            System.out.println("🐍 Snake bite! Slid from " + newPosition + " to " + snakeTail);
            return snakeTail;
        }

        return newPosition;
    }

    public boolean isWinningPosition(int position) {
        return position == BOARD_SIZE;
    }

    public void displayBoard() {
        System.out.println("\n=== BOARD LAYOUT ===");
        System.out.println("🪜 Ladders:");
        for (Map.Entry<Integer, Integer> entry : ladders.entrySet()) {
            System.out.println("   " + entry.getKey() + " → " + entry.getValue());
        }
        System.out.println("🐍 Snakes:");
        for (Map.Entry<Integer, Integer> entry : snakes.entrySet()) {
            System.out.println("   " + entry.getKey() + " → " + entry.getValue());
        }
        System.out.println("===================\n");
    }

}
