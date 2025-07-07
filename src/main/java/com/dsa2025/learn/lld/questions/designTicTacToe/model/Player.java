package com.dsa2025.learn.lld.questions.designTicTacToe.model;

/**
 * Tic Tac Toe Game demonstrating OOP concepts
 * - Encapsulation, Inheritance, Polymorphism, Abstraction
 */

// ABSTRACTION - Abstract base class for different types of players
public abstract class Player {
    protected String name;
    protected PlayingPiece piece;

    public Player(String name, PlayingPiece piece) {
        this.name = name;
        this.piece = piece;
    }

    // Abstract method - forces subclasses to implement
    public abstract Move getMove(Board board);

    // Getters - ENCAPSULATION
    public String getName() { return name; }
    public PlayingPieceEnum getPieceType() { return piece.getPieceType(); }
}
