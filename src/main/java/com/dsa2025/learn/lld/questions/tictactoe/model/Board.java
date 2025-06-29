package com.dsa2025.learn.lld.questions.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public void setBoard(PlayingPiece[][] board) {
        this.board = board;
    }

    /**
     * This method will check if the place is empty or not if it is emptier than player can play his move and keep its piece
     * @param row row
     * @param column column
     * @param playingPiece playingPiece
     * @return boolean
     */
    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {

        if(board[row][column] != null) {
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

    /**
     * This method will return the free cells where player can play his move
     * @return List<Cell>
     */
    public List<Cell> getFreeCells() {
        List<Cell> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Cell cell = new Cell(i, j);
                    freeCells.add(cell);
                }
            }
        }

        return freeCells;
    }

    /**
     * This method will be used to print the board after one move
     */
    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getType().name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

}
