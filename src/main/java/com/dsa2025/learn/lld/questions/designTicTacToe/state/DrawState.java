package com.dsa2025.learn.lld.questions.designTicTacToe.state;

import com.dsa2025.learn.lld.questions.designTicTacToe.game.Game;

public class DrawState implements GameState {

    @Override
    public void handleState(Game game) {
        game.getBoard().display();
        System.out.println("It's a draw!");
        game.setGameOver(true);
    }
}
