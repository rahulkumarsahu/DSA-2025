package com.dsa2025.learn.lld.questions.ticTacToe.state;

import com.dsa2025.learn.lld.questions.ticTacToe.game.Game;
import com.dsa2025.learn.lld.questions.ticTacToe.model.Move;
import com.dsa2025.learn.lld.questions.ticTacToe.model.Player;

public class PlayingState implements GameState {

    @Override
    public void handleState(Game game) {
        Player currentPlayer = game.getCurrentPlayer();
        Move move = currentPlayer.getMove(game.getBoard());
        game.getBoard().makeMove(move, currentPlayer.getPieceType());

        if (game.getBoard().hasWinner(currentPlayer.getPieceType())) {
            game.setState(new WinnerState(currentPlayer));
        } else if (game.getBoard().isFull()) {
            game.setState(new DrawState());
        } else {
            game.switchPlayer();
        }
    }

}
