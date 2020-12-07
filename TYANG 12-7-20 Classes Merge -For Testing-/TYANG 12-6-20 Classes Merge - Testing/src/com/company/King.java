package com.company;

import java.util.ArrayList;

class King extends Piece {
    public King(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
    }

    // Params:
    // ArrayList<Piece> pieces: An ArrayList of all the pieces on the board
    // Desc:
    // Checks the valid move range for a piece on an open board, checks to see if pieces are in that square,
    // if they are not or are an enemy, the range is updated to add the new piece.
    @Override
    public void getRange(ArrayList<Piece> pieces){
        this.range.clear();
        int  pieceX = this.getX(); int pieceY = this.getY(); // X and Y coordinates for the king piece

        //Up
        if (this.getPiece(pieceX, pieceY+1, pieces) == 0 || this.getPiece(pieceX, pieceY+1, pieces) == 2)
            this.range.add(new int[] {pieceX, pieceY+1});

        //Up-right
        if (this.getPiece(pieceX+1, pieceY+1, pieces) == 0 || this.getPiece(pieceX+1, pieceY+1, pieces) == 2)
            this.range.add(new int[] {pieceX+1, pieceY+1});

        //Right
        if (this.getPiece(pieceX+1, pieceY, pieces) == 0 || this.getPiece(pieceX+1, pieceY, pieces) == 2)
            this.range.add(new int[] {pieceX+1, pieceY});

        //Down-right
        if (this.getPiece(pieceX+1, pieceY-1, pieces) == 0 || this.getPiece(pieceX+1, pieceY-1, pieces) == 2)
            this.range.add(new int[] {pieceX+1, pieceY-1});

        //Down
        if (this.getPiece(pieceX, pieceY-1, pieces) == 0 || this.getPiece(pieceX, pieceY-1, pieces) == 2)
            this.range.add(new int[] {pieceX, pieceY-1});

        //Down-left
        if (this.getPiece(pieceX-1, pieceY-1, pieces) == 0 || this.getPiece(pieceX-1, pieceY-1, pieces) == 2)
            this.range.add(new int[] {pieceX-1, pieceY-1});

        //Left
        if (this.getPiece(pieceX-1, pieceY, pieces) == 0 || this.getPiece(pieceX-1, pieceY, pieces) == 2)
            this.range.add(new int[] {pieceX-1, pieceY});

        //Up-left
        if (this.getPiece(pieceX-1, pieceY+1, pieces) == 0 || this.getPiece(pieceX-1, pieceY+1, pieces) == 2)
            this.range.add(new int[] {pieceX-1, pieceY+1});
    }

    // Params:
    // ArrayList<Piece> pieces: An ArrayList of all the pieces on the board
    // Returns:
    // boolean check: true = in-check; false = out-of-check
    public boolean kingCheck(ArrayList<Piece> pieces) {
        boolean check = false;
        int[] kingCoords = new int[]{this.getX(), this.getY()};

        for (Piece piece : pieces) {
            if (piece.getColor() != this.getColor()) { // If the color does not match the king's color...
                for (int[] coordinate : piece.range) {
                    if (coordinate[0] == kingCoords[0] && coordinate[1] == kingCoords[1]) { // Checks to see if the king is in range of enemy pieces
                        check = true;
                        break;
                    }
                }
            }
        }
        return check;
    }
}