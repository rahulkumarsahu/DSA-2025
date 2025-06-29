package com.dsa2025.learn.lld.questions.tictactoe.model;

public class Cell {

    public final int row;
    public final int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }

}
