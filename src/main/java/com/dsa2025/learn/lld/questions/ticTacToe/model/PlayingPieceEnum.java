package com.dsa2025.learn.lld.questions.ticTacToe.model;

public enum PlayingPieceEnum {

    X('X'),
    O('O'),
    EMPTY(' ');

    private final char symbol;

    PlayingPieceEnum(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
