package com.dsa2025.learn.lld.questions.designTicTacToe.state;

import com.dsa2025.learn.lld.questions.designTicTacToe.game.Game;
import com.dsa2025.learn.lld.questions.designTicTacToe.model.Player;

public class WinnerState implements GameState {
    private final Player winner;

    public WinnerState(Player winner) {
        this.winner = winner;
    }

    @Override
    public void handleState(Game game) {
        game.getBoard().display();
        System.out.println(winner.getName() + " wins!");
        game.setGameOver(true);
    }
}
