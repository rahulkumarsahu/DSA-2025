package com.dsa2025.learn.lld.questions.snakeAndLadder;

import com.dsa2025.learn.lld.questions.snakeAndLadder.game.Game;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.setupPlayers();
        game.startGame();
    }
}
