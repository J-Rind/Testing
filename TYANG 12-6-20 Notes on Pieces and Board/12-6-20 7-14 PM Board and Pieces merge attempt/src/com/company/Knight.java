package com.company;
import java.util.ArrayList;

public class Knight extends Piece {

    //TYANG - ADDED CONSTRUCTOR LIKE OTHER PIECES
    public Knight(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
    }

    private int X;
    private int Y;
    private ArrayList<int[]> range = new ArrayList<>();

    public void getRange(ArrayList<Piece> arr){
        if(getPiece(this.X + 1, this.Y + 2, arr) == 0 || getPiece(this.X + 1, this.Y + 2, arr) == 1){
            range.add(new int[] {X,Y});
        }

        if(getPiece(this.X + 2, this.Y + 1, arr) == 0 || getPiece(this.X + 2, this.Y + 1, arr) == 1){
            range.add(new int[] {X,Y});
        }

        if(getPiece(this.X + 2, this.Y - 1, arr) == 0 || getPiece(this.X + 2, this.Y - 1, arr) == 1){
            range.add(new int[] {X,Y});
        }

        if(getPiece(this.X + 1, this.Y - 2, arr) == 0 || getPiece(this.X + 1, this.Y - 2, arr) == 1){
            range.add(new int[] {X,Y});
        }

        if(getPiece(this.X - 1, this.Y - 2, arr) == 0 || getPiece(this.X - 1, this.Y - 2, arr) == 1){
            range.add(new int[] {X,Y});
        }

        if(getPiece(this.X - 2, this.Y - 1, arr) == 0 || getPiece(this.X - 2, this.Y - 1, arr) == 1){
            range.add(new int[] {X,Y});
        }

        if(getPiece(this.X - 2, this.Y + 1, arr) == 0 || getPiece(this.X - 2, this.Y + 1, arr) == 0){
            range.add(new int[] {X,Y});
        }

        if(getPiece(this.X - 1, this.Y + 2, arr) == 0 || getPiece(this.X - 1, this.Y + 2, arr) == 0){
            range.add(new int[] {X,Y});
        }

        }
    }
