package com.dsa2025.learn.lld.questions.snakeAndLadder;

import java.util.*;

public class Game {

    private final Queue<Player> playerQueue;
    private final List<Player> allPlayers;
    private final Board board;
    private final Dice dice;
    private final Scanner scanner;
    private boolean gameOver;

    public Game() {
        this.playerQueue = new LinkedList<>();
        this.allPlayers = new ArrayList<>();
        this.board = new Board();
        this.dice = new Dice();
        this.scanner = new Scanner(System.in);
        this.gameOver = false;
    }

    public void addPlayer(String name) {
        Player player = new Player(name, allPlayers.size() + 1);
        allPlayers.add(player);
        playerQueue.offer(player);
    }

    public void startGame() {
        System.out.println("🎲 Welcome to Snake and Ladder Game! 🎲");
        board.displayBoard();

        while (!gameOver) {
            playTurn();
        }

        scanner.close();
    }

    private void playTurn() {
        Player currentPlayer = playerQueue.poll(); // Remove from front

        System.out.println("───────────────────────────────────");
        assert currentPlayer != null;
        System.out.println("🎯 " + currentPlayer.getName() + "'s turn");
        System.out.println("Current position: " + currentPlayer.getPosition());
        System.out.print("Press Enter to roll dice...");
        scanner.nextLine();

        int diceValue = dice.roll();
        System.out.println("🎲 Rolled: " + diceValue);

        int oldPosition = currentPlayer.getPosition();
        int newPosition = board.movePlayer(oldPosition, diceValue);
        currentPlayer.setPosition(newPosition);

        System.out.println("📍 Moved from " + oldPosition + " to " + newPosition);

        // Check win condition
        if (board.isWinningPosition(newPosition)) {
            System.out.println("🏆 " + currentPlayer.getName() + " WINS! 🏆");
            gameOver = true;
            return;
        }

        // Show all players' positions
        displayGameStatus();

        // Add player back to the end of queue for next turn
        playerQueue.offer(currentPlayer);

        // Add small delay for better UX
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void displayGameStatus() {
        System.out.println("\n📊 Current Game Status:");
        for (Player player : allPlayers) {
            System.out.println("   " + player);
        }
        System.out.println();
    }

    public void setupPlayers() {
        System.out.print("Enter number of players (2-4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Invalid number of players. Setting to 2.");
            numPlayers = 2;
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                name = "Player " + (i + 1);
            }
            addPlayer(name);
        }

        System.out.println("\n✅ Players added successfully!");
        for (Player player : allPlayers) {
            System.out.println("   " + player.getName());
        }
    }

}
