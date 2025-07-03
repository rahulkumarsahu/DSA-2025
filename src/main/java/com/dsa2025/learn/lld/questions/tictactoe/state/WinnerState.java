package com.dsa2025.learn.lld.questions.tictactoe.state;

import com.dsa2025.learn.lld.questions.tictactoe.game.Game;
import com.dsa2025.learn.lld.questions.tictactoe.model.Player;

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
