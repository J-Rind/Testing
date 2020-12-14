package com.company;
import java.util.ArrayList;


public class Rook extends Piece {


    public Rook(int x, int y, String t, Boolean white) {
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
                System.out.println(this.getName() + " Moved to: (" + this.getX() + "," + this.getY() + ")");
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
        for (int x = this.getX() + 1, y = this.getY(); x < 8; x++) {
            if (getPiece(x,y, arr) == 0) {
                range.add(new int[] {x,y});
            }
            else if (getPiece(x,y, arr) == 1) {
                break;
            }
            else if (getPiece(x,y, arr) == 2) {
                range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX() - 1, y = this.getY(); x > -1; x--) {
            if (getPiece(x,y,arr) == 0) {
                range.add(new int[] {x,y});
            }
            else if (getPiece(x,y,arr) == 1) {
                break;
            }
            else if (getPiece(x,y,arr) == 2) {
                range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX(), y = this.getY() + 1; y < 8; y++) {
            if (getPiece(x,y,arr) == 0) {
                range.add(new int[] {x,y});
            }
            else if (getPiece(x,y,arr) == 1) {
                break;
            }
            else if (getPiece(x,y,arr) == 2) {
                range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX(), y = this.getY() - 1; y > -1; y--) {
            if (getPiece(x, y,arr) == 0) {
                range.add(new int[]{x, y});
            } else if (getPiece(x, y,arr) == 1) {
                break;
            } else if (getPiece(x, y,arr) == 2) {
                range.add(new int[]{x, y});
                break;
            }
        }
    }
}