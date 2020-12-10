package com.company;
import java.util.ArrayList;


public class Pawn extends Piece {


    public Pawn(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
    }
    public int pMove = 0;

    @Override
    public void moveTo(int x, int y, King myKing, ArrayList<Piece> arr){

        int[] myCoords = new int[]{this.getX(), this.getY()};
        int moved = 0;

        updateRange(arr);

        for (int[] coordinate : this.range) {
            if (coordinate[0] == x && coordinate[1] == y) {
                this.setX(x);
                this.setY(y);
                System.out.println("Piece Moved to: (" + x + "," + y + ")");
                this.pMove++;
                moved++;
                break;
            }
        }

        updateRange(arr);

        if (myKing.kingCheck(arr) == true)
        {
            System.out.println("!! king is in check, moving piece back !!");
            this.setX(myCoords[0]);
            this.setY(myCoords[1]);
            this.pMove--;
        }

        if(moved != 1)
        {
            System.out.println("piece not moved, not in range");
        }
    }

    @Override
    public void getRange(ArrayList<Piece> arr){
        this.range.clear();

        int X = this.getX();
        int Y = this.getY();
        int moved = 0;

        // Moving 2 spaces for first move
        if (pMove == 0){                //??If piece has not been moved
            if (this.getColor()) {
                for (int x = X, y = Y + 1; y <= y + 2; y++) {                       // TYANG ISSUE HERE  -> should be 'y <= Y+2
                    if (getPiece(x, y, arr) == 0) {                                 // y is always <= y+2
                        this.range.add(new int[]{x, y});
                    } else if (getPiece(x, y, arr) == 1 || getPiece(x, y, arr) == 2) {
                        break;
                    }
                }
            }else if (this.getColor() == false) {
                for (int x = X, y = Y; y <= y - 2; y-- ) {                          // TYANG ISSUE HERE -> should be 'y = Y-1' and 'y >= Y-2'
                    if (getPiece(x, y, arr) == 0) {                                 // y is never <= y-2
                        this.range.add(new int[]{x, y});                            // AND it will always have a piece on (X,Y)
                    } else if (getPiece(x, y, arr) == 1 || getPiece(x, y, arr) == 2) {
                        break;
                    }
                }
            }
        }
        else {
            if (this.getColor()){                                          //TYANG movements aren't updated correctly
                // Up-Right                                                // it passes it's current position up
                if (this.getPiece(X + 1, Y + 1, arr) == 2){
                    this.range.add (new int [] {X, Y});
                }
                // Up-Left
                if (this.getPiece(X - 1, Y + 1, arr) == 2){
                    this.range.add (new int [] {X, Y});                     // TYANG ISSUES HERE -> should have {X,Y} -> X+# or Y+#
                }                                                           // CURRENTLY RETURNS OWN COORDINATES
                // Up
                if (this.getPiece(X, Y + 1, arr) == 0){
                    this.range.add (new int [] {X, Y});
                }
            }
            else if (!this.getColor()){
                // Down-Right
                if (this.getPiece(X + 1, Y - 1, arr) == 2){
                    this.range.add (new int [] {X, Y});
                }
                // Down-Left
                if (this.getPiece(X - 1, Y - 1, arr) == 2){
                    this.range.add (new int [] {X, Y});
                }
                // Down
                if (this.getPiece(X, Y + 1, arr) == 0){
                    this.range.add (new int [] {X, Y});
                }
            }
        }

    }
}