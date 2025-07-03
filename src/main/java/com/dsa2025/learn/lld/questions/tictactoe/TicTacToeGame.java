package com.dsa2025.learn.lld.questions.tictactoe;

import com.dsa2025.learn.lld.questions.tictactoe.game.Game;

public class TicTacToeGame {

    // here we are using deque because we can bring out from list and add it back to the list at last
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
