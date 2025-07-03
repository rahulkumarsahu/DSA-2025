package com.dsa2025.learn.lld.questions.tictactoe.model;

public class Board {

    private static final int SIZE = 3;

    private final PlayingPieceEnum[][] grid;

    public Board() {
        this.grid = new PlayingPieceEnum[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = PlayingPieceEnum.EMPTY;
            }
        }
    }

    public void display() {
        System.out.println("\n  0   1   2");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j].getSymbol());
                if (j < SIZE - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < SIZE - 1) System.out.println("  ---------");
        }
        System.out.println();
    }

    public boolean isValidMove(Move move) {
        int row = move.row();
        int col = move.col();

        return row >= 0 && row < SIZE &&
                col >= 0 && col < SIZE &&
                grid[row][col] == PlayingPieceEnum.EMPTY;
    }

    public void makeMove(Move move, PlayingPieceEnum pieceType) {
        if (isValidMove(move)) {
            grid[move.row()][move.col()] = pieceType;
        }
    }

    public boolean hasWinner(PlayingPieceEnum pieceType) {
        return checkRows(pieceType) || checkColumns(pieceType) || checkDiagonals(pieceType);
    }

    private boolean checkRows(PlayingPieceEnum pieceType) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] == pieceType && grid[i][1] == pieceType && grid[i][2] == pieceType) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(PlayingPieceEnum pieceType) {
        for (int j = 0; j < SIZE; j++) {
            if (grid[0][j] == pieceType && grid[1][j] == pieceType && grid[2][j] == pieceType) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(PlayingPieceEnum pieceType) {
        // Main diagonal
        boolean mainDiagonal = grid[0][0] == pieceType && grid[1][1] == pieceType && grid[2][2] == pieceType;

        // Anti-diagonal
        boolean antiDiagonal = grid[0][2] == pieceType && grid[1][1] == pieceType && grid[2][0] == pieceType;

        return mainDiagonal || antiDiagonal;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == PlayingPieceEnum.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}
