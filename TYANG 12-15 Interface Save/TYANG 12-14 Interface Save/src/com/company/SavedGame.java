package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class SavedGame implements Serializable {
    private Board board;
    private int turn;
    private Player whitePlayer;
    private Player blackPlayer;
    private King whiteKing;
    private King blackKing;
    private ArrayList<Piece> pieces;

    public int getTurn() {
        return turn;
    }

    public Board getBoard() {
        return board;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setWhitePlayer(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public void setBlackPlayer(Player blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public void setWhiteKing(King whiteKing) {
        this.whiteKing = whiteKing;
    }

    public void setBlackKing(King blackKing) {
        this.blackKing = blackKing;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public King getWhiteKing() {
        return whiteKing;
    }

    public King getBlackKing() {
        return blackKing;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }


    public SavedGame(Board board, int turn, Player whitePlayer, Player blackPlayer, King whiteKing, King blackKing, ArrayList<Piece> pieces){
        this.board = board;
        this.turn = turn;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.whiteKing = whiteKing;
        this.blackKing = blackKing;
        this.pieces = pieces;
    }


    public SavedGame(){
    }
}
