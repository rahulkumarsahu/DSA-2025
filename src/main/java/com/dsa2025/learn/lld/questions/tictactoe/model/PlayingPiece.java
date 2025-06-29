package com.dsa2025.learn.lld.questions.tictactoe.model;

public class PlayingPiece {

    private PlayerPieceEnum type;

    public PlayingPiece(PlayerPieceEnum type) {
        this.type = type;
    }

    public PlayerPieceEnum getType() {
        return type;
    }

    public void setType(PlayerPieceEnum type) {
        this.type = type;
    }
}
