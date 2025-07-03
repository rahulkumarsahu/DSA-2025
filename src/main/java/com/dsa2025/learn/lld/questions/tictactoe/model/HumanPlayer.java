package com.dsa2025.learn.lld.questions.tictactoe.model;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private final Scanner scanner;

    public HumanPlayer(String name, PlayingPiece piece) {
        super(name, piece);
        this.scanner = new Scanner(System.in);
    }

    // POLYMORPHISM - Override abstract method
    @Override
    public Move getMove(Board board) {
        while (true) {
            System.out.print(name + " (" + piece.getSymbol() + "), enter move (row col): ");
            try {
                String input = scanner.nextLine().trim();
                String[] parts = input.split("\\s+");

                if (parts.length != 2) {
                    System.out.println("Invalid format. Use: row col");
                    continue;
                }

                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);

                Move move = new Move(row, col);
                if (board.isValidMove(move)) {
                    return move;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter numbers only.");
            }
        }
    }
}
