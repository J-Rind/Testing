package com.company;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private boolean turn = false;
    private boolean isWhite;
    private boolean won;

    // constructor
    public Player() {
    }

    // colors, true or false
    public Player(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public Player(boolean isWhite, String name) {
        this.isWhite = isWhite;
        this.name = name;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;

    }

    public boolean getIsWhite() {
        return isWhite;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public void whoseTurn() {
        turn = !turn;
    }

}
