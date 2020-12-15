package com.company;
import java.util.ArrayList;


public class Knight extends Piece {

    public Knight(){
        super();
    }

    public Knight(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
    }

    @Override
    public void getRange(ArrayList<Piece> arr){                             // TYANG ISSUES HERE -> returns own coordinates
        this.range.clear();

        int X = this.getX();
        int Y = this.getY();

        // 2-up/1-right
        if(getPiece(X + 1, Y + 2, arr) == 0 || getPiece(X + 1, Y + 2, arr) == 2){
            this.range.add(new int[] {X+1,Y+2});
        }
        // 1-up/2-right
        if(getPiece(X + 2, Y + 1, arr) == 0 || getPiece(X + 2, Y + 1, arr) == 2){
            this.range.add(new int[] {X+2,Y+1});
        }
        // 1-down/2-right
        if(getPiece(X + 2, Y - 1, arr) == 0 || getPiece(X + 2, Y - 1, arr) == 2){
            this.range.add(new int[] {X+2,Y-1});
        }
        // 2-down/1-right
        if(getPiece(X + 1, Y - 2, arr) == 0 || getPiece(X + 1, Y - 2, arr) == 2){
            this.range.add(new int[] {X+1,Y-2});
        }
        // 2-down/1-left
        if(getPiece(X - 1, Y - 2, arr) == 0 || getPiece(X - 1, Y - 2, arr) == 2){
            this.range.add(new int[] {X-1,Y-2});
        }
        // 1-down/2-left
        if(getPiece(X - 2, Y - 1, arr) == 0 || getPiece(X - 2, Y - 1, arr) == 2){
            this.range.add(new int[] {X-2,Y-1});
        }
        // 1-up/2-left
        if(getPiece(X - 2, Y + 1, arr) == 0 || getPiece(X - 2, Y + 1, arr) == 2){
            this.range.add(new int[] {X-2,Y+1});
        }
        // 2-up/1-left
        if(getPiece(X - 1, Y + 2, arr) == 0 || getPiece(X - 1, Y + 2, arr) == 2){
            this.range.add(new int[] {X-1,Y+2});
        }

    }
}