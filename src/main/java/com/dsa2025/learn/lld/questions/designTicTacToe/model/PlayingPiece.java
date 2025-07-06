package com.dsa2025.learn.lld.questions.designTicTacToe.model;

public class PlayingPiece {

    protected PlayingPieceEnum pieceType;

    public PlayingPiece(PlayingPieceEnum pieceType) {
        this.pieceType = pieceType;
    }

    public PlayingPieceEnum getPieceType() {
        return pieceType;
    }

    public char getSymbol() {
        return pieceType.getSymbol();
    }
}
