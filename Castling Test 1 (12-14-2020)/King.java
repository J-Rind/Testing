package com.company;

import java.util.ArrayList;

class King extends Piece {
    public King(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
    }
    public int pMove = 0; // Required for castling, piece cannot have moved; 0 = false; >0 = true;

    // Params:
    // ArrayList<Piece> pieces: An ArrayList of all the pieces on the board
    // Desc:
    // Checks the valid move range for a piece on an open board, checks to see if pieces are in that square,
    // if they are not or are an enemy, the range is updated to add the new piece.
    @Override
    public void getRange(ArrayList<Piece> pieces){
        this.range.clear();
        int  pieceX = this.getX(); int pieceY = this.getY(); // X and Y coordinates for the king piece

        // getPiece: 0 = empty; 1 = same color; 2 = opposite color
        //Up
        if(pieceX < 8 && pieceY+1 < 8 && pieceX > -1 && pieceY+1 > -1)
            if (this.getPiece(pieceX, pieceY+1, pieces) == 0 || this.getPiece(pieceX, pieceY+1, pieces) == 2)
                this.range.add(new int[] {pieceX, pieceY+1}); // Return int[] of tested coordinates

        //Up-right
        if(pieceX+1 < 8 && pieceY+1 < 8 && pieceX+1 > -1 && pieceY+1 > -1)
            if (this.getPiece(pieceX+1, pieceY+1, pieces) == 0 || this.getPiece(pieceX+1, pieceY+1, pieces) == 2)
                this.range.add(new int[] {pieceX+1, pieceY+1}); // Return int[] of tested coordinates

        //Right
        if(pieceX+1 < 8 && pieceY < 8 && pieceX+1 > -1 && pieceY > -1)
            if (this.getPiece(pieceX+1, pieceY, pieces) == 0 || this.getPiece(pieceX+1, pieceY, pieces) == 2)
                this.range.add(new int[] {pieceX+1, pieceY}); // Return int[] of tested coordinates

        //Down-right
        if(pieceX+1 < 8 && pieceY-1 < 8 && pieceX+1 > -1 && pieceY-1 > -1)
            if (this.getPiece(pieceX+1, pieceY-1, pieces) == 0 || this.getPiece(pieceX+1, pieceY-1, pieces) == 2)
                this.range.add(new int[] {pieceX+1, pieceY-1}); // Return int[] of tested coordinates

        //Down
        if(pieceX < 8 && pieceY-1 < 8 && pieceX > -1 && pieceY-1 > -1)
            if (this.getPiece(pieceX, pieceY-1, pieces) == 0 || this.getPiece(pieceX, pieceY-1, pieces) == 2)
                this.range.add(new int[] {pieceX, pieceY-1}); // Return int[] of tested coordinates

        //Down-left
        if(pieceX-1 < 8 && pieceY-1 < 8 && pieceX-1 > -1 && pieceY-1 > -1)
            if (this.getPiece(pieceX-1, pieceY-1, pieces) == 0 || this.getPiece(pieceX-1, pieceY-1, pieces) == 2)
                this.range.add(new int[] {pieceX-1, pieceY-1}); // Return int[] of tested coordinates

        //Left
        if(pieceX-1 < 8 && pieceY < 8 && pieceX-1 > -1 && pieceY > -1)
            if (this.getPiece(pieceX-1, pieceY, pieces) == 0 || this.getPiece(pieceX-1, pieceY, pieces) == 2)
                this.range.add(new int[] {pieceX-1, pieceY}); // Return int[] of tested coordinates

        //Up-left
        if(pieceX-1 < 8 && pieceY+1 < 8 && pieceX-1 > -1 && pieceY+1 > -1)
            if (this.getPiece(pieceX-1, pieceY+1, pieces) == 0 || this.getPiece(pieceX-1, pieceY+1, pieces) == 2)
                this.range.add(new int[] {pieceX-1, pieceY+1}); // Return int[] of tested coordinates

        //Castling
        for (Piece piece : pieces) {
            if (piece instanceof Rook) {
                if (piece.getColor() == this.getColor()) {
                    if (validCastling(pieces, (Rook)piece)) {
                        int targetX = (piece.getX() < getX()) ? (this.getX() - 2) : (this.getX() + 2);
                        this.range.add(new int[] {targetX, this.getY()});
                    }
                }
            }
        }
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

    @Override
    public void moveTo(int x, int y, King myKing, ArrayList<Piece> arr){

        int[] myCoords = new int[]{this.getX(), this.getY()};
        int moved = 0;

        updateRange(arr);

        for (int[] coordinate : this.range) {
            if (coordinate[0] == x && coordinate[1] == y) {
                if(x == this.getX()+2 || x == this.getX()-2) { // If castling coordinate
                    for (Piece piece : arr) {
                        if (piece instanceof Rook) { // If the piece is a Rook
                            if (piece.getColor() == this.getColor()) {
                                if ((x < this.getX()) && (piece.getX() < this.getX())) {
                                    if(doCastling(arr, (Rook)piece)) // Cast Rook onto piece because we know it is a Rook
                                        moved++;
                                    break;
                                }
                                else if ((x > this.getX()) && (piece.getX() > this.getX())) {
                                    doCastling(arr, (Rook)piece); // Cast Rook onto piece because we know it is a Rook
                                    moved++;
                                    break;
                                }
                            }
                        }
                    }
                } else { // If not castling coordinate
                    this.setX(x);
                    this.setY(y);
                    System.out.println(this.getName() + " Moved to: (" + x + "," + y + ")");
                    this.pMove++;
                    moved++;
                    break;
                }
            }
        }

        updateRange(arr);

        if (myKing.kingCheck(arr) == true && moved == 1)
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

    // Ranjit's Castling Code (CC - Edited to implement and fix king/rook-moved check)
    public boolean validCastling(ArrayList<Piece> pieces, Rook k) {
        // must be same color, same row
        if (k.getColor() != getColor() || k.getY() != getY())
            return false;
        // already moved
        if (k.pMove > 0 || pMove > 0) // Changed to "> 0" from "== 1" to adjust for moveTo increment
            return false;

        // is any piece blocking?
        for (Piece piece : pieces) {
            if (piece.getY() == getY() &&
                    (
                            (piece.getX() > k.getX() && piece.getX() < getX()) ||
                                    (piece.getX() < k.getX() && piece.getX() > getX())
                    ) )
                return false;
        }

        if (kingCheck(pieces))
            return false;

        // try moved and test checking
        int orgX = getX();
        int targetX = (k.getX() < getX()) ? (orgX - 2) : (orgX + 2);
        int step = (targetX < orgX) ? -1 : 1;

        int x = orgX;
        boolean checked = false;
        do
        {
            x += step;
            setX(x);
            if (kingCheck(pieces))
            {
                checked = true;
                break;
            }

        } while (x != (targetX+step)); // CC - Fixed to check target square before check is done
        setX(orgX);
        return !checked;
    }

    public boolean doCastling(ArrayList<Piece> pieces, Rook k) {
        if (!validCastling(pieces, k))
            return false;

        if (k.getX() < getX()) {
            setX(getX() - 2);
            System.out.println(this.getName() + " Moved to: (" + this.getX() + "," + this.getY() + ")");
            k.setX(getX() + 1);
            System.out.println(k.getName() + " Moved to: (" + k.getX() + "," + k.getY() + ")");
        } else {
            setX(getX() + 2);
            System.out.println(this.getName() + " Moved to: (" + this.getX() + "," + this.getY() + ")");
            k.setX(getX() - 1);
            System.out.println(k.getName() + " Moved to: (" + k.getX() + "," + k.getY() + ")");
        }

        k.pMove = 1;
        pMove = 1;
        return true;
    }
}