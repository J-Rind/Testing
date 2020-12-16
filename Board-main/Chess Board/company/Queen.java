package com.company;
import java.util.ArrayList;


public class Queen extends Piece {


    public Queen(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
    }

    @Override
    public void getRange(ArrayList<Piece> arr){
        this.range.clear();

        for (int x = this.getX() + 1, y = this.getY(); x < 8; x++) {
            if (getPiece(x,y, arr) == 0) {
                this.range.add(new int[] {x,y});
            }
            else if (getPiece(x,y, arr) == 1) {
                break;
            }
            else if (getPiece(x,y, arr) == 2) {
                this.range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX() - 1, y = this.getY(); x > -1; x--) {
            if (getPiece(x,y,arr) == 0) {
                this.range.add(new int[] {x,y});
            }
            else if (getPiece(x,y,arr) == 1) {
                break;
            }
            else if (getPiece(x,y,arr) == 2) {
                this.range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX(), y = this.getY() + 1; y < 8; y++) {
            if (getPiece(x,y,arr) == 0) {
                this.range.add(new int[] {x,y});
            }
            else if (getPiece(x,y,arr) == 1) {
                break;
            }
            else if (getPiece(x,y,arr) == 2) {
                this.range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX(), y = this.getY() - 1; y > -1; y--) {
            if (getPiece(x, y,arr) == 0) {
                this.range.add(new int[]{x, y});
            } else if (getPiece(x, y,arr) == 1) {
                break;
            } else if (getPiece(x, y,arr) == 2) {
                this.range.add(new int[]{x, y});
                break;
            }
        }

        for (int x = this.getX() + 1, y = this.getY() + 1; x < 8 && y < 8; x++, y++) {
            if (getPiece(x,y, arr) == 0) {
                this.range.add(new int[] {x,y});
            }
            else if (getPiece(x,y, arr) == 1) {
                break;
            }
            else if (getPiece(x,y, arr) == 2) {
                this.range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX() - 1, y = this.getY() + 1; x > -1 && y < 8; x--, y++) {
            if (getPiece(x,y,arr) == 0) {
                this.range.add(new int[] {x,y});
            }
            else if (getPiece(x,y,arr) == 1) {
                break;
            }
            else if (getPiece(x,y,arr) == 2) {
                this.range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX() + 1, y = this.getY() - 1; x < 8 && y > -1; x++, y--) {
            if (getPiece(x,y,arr) == 0) {
                this.range.add(new int[] {x,y});
            }
            else if (getPiece(x,y,arr) == 1) {
                break;
            }
            else if (getPiece(x,y,arr) == 2) {
                this.range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX() - 1, y = this.getY() - 1; x > -1 && y > -1; x--, y--) {
            if (getPiece(x, y,arr) == 0) {
                this.range.add(new int[]{x, y});
            } else if (getPiece(x, y,arr) == 1) {
                break;
            } else if (getPiece(x, y,arr) == 2) {
                this.range.add(new int[]{x, y});
                break;
            }
        }
    }
}