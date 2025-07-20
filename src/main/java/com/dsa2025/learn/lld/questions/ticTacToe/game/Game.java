package com.dsa2025.learn.lld.questions.ticTacToe.game;

import com.dsa2025.learn.lld.questions.ticTacToe.model.*;
import com.dsa2025.learn.lld.questions.ticTacToe.state.GameState;
import com.dsa2025.learn.lld.questions.ticTacToe.state.PlayingState;

public class Game {

    private final Board board;
    private final Player[] players;
    private int currentPlayerIndex;
    private GameState state;
    private boolean gameOver;

    public Game() {
        this.board = new Board();
        this.players = new Player[2];
        this.players[0] = new HumanPlayer("Player 1", new PlayingPieceX());
        this.players[1] = new HumanPlayer("Player 2", new PlayingPieceO());
        this.currentPlayerIndex = 0;
        this.state = new PlayingState();
        this.gameOver = false;
    }

    // ENCAPSULATION - Controlled access to internal state
    public Board getBoard() { return board; }
    public Player getCurrentPlayer() { return players[currentPlayerIndex]; }
    public void setState(GameState state) { this.state = state; }
    public void setGameOver(boolean gameOver) { this.gameOver = gameOver; }

    public void switchPlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex;
    }

    public void start() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Enter positions as 'row col' (0-2)");

        while (!gameOver) {
            board.display();
            state.handleState(this);
        }
    }

}
