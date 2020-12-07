package com.company;
import java.util.ArrayList;

public class Bishop extends Piece {

    // TYANG- ADDED CONSTRUCTOR LIKE OTHER PIECES
    public Bishop(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
    }

    private int X;
    private int Y;
    private ArrayList<int[]> range = new ArrayList<>();
    //private int getPiece(int x,int y) {return 0, 1, 2}

    public void getRange(ArrayList<Piece> arr){
        for (int x = this.getX() + 1, y = this.getY() + 1; x < 8 && y < 8; x++, y++) {
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

        for (int x = this.getX() - 1, y = this.getY() + 1; x > -1 && y < 8; x--, y++) {
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

        for (int x = this.getX() + 1, y = this.getY() - 1; x < 8 && y > -1; x++, y--) {
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

        for (int x = this.getX() - 1, y = this.getY() - 1; x > -1 && y > -1; x--, y--) {
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