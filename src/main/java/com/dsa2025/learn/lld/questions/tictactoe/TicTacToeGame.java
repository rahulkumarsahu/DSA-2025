package com.dsa2025.learn.lld.questions.tictactoe;

import com.dsa2025.learn.lld.questions.tictactoe.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    // here we are using deque because we can bring out from list and add it back to the list at last
    private Deque<Player> players;
    private Board gameBoard;

    public void initializeGame() {
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        //initializeBoard
        gameBoard = new Board(3);
    }


    public String startGame() {

        boolean noWinner = true;

        while (noWinner) {

            // 🔁 Get the current player and remove from the front of the queue
            Player playerTurn = players.removeFirst();

            // 🧾 Show current state of the board
            gameBoard.printBoard();

            // 📦 Get available cells on the board
            List<Cell> freeSpaces = gameBoard.getFreeCells();

            if (freeSpaces.isEmpty()) {
                // 🛑 No moves left - game is a tie
                noWinner = false;
                continue;
            }

            // 📥 Read player input
            System.out.print("Player: " + playerTurn.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");

            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            // ⚙️ Try to place the player's piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.getPiece());

            if (!pieceAddedSuccessfully) {
                // ❌ Invalid position - re-add player to front of queue
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }

            // ✅ Valid move - push player to the back of the queue
            players.addLast(playerTurn);

            // 🏆 Check if this move wins the game
            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPiece().getType());

            if (winner) {
                return playerTurn.getName();
            }
        }

        return "tie"; // 🤝 No winner found
    }

    public boolean isThereWinner(int row, int column, PlayerPieceEnum pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // ✅ Check the entire row
        for (int i = 0; i < gameBoard.getSize(); i++) {
            // If any cell is empty or not of the same type, row does not match
            if (gameBoard.getBoard()[row][i] == null || gameBoard.getBoard()[row][i].getType() != pieceType) {
                rowMatch = false;
            }
        }

        // ✅ Check entire column
        for (int i = 0; i < gameBoard.getSize(); i++) {
            if (gameBoard.getBoard()[i][column] == null || gameBoard.getBoard()[i][column].getType() != pieceType) {
                columnMatch = false;
            }
        }

        // ✅ Check main diagonal (top-left to bottom-right)
        for (int i = 0, j = 0; i < gameBoard.getSize(); i++, j++) {
            if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getType() != pieceType) {
                diagonalMatch = false;
            }
        }

        // ✅ Check anti-diagonal (top-right to a bottom-left)
        for (int i = 0, j = gameBoard.getSize() - 1; i < gameBoard.getSize(); i++, j--) {
            if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getType() != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        // If any of the checks passed, the player has won
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


}
