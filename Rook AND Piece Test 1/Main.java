package com.company;

public class Main {

    public static void main(String[] args) {

        Board myBoard = new Board();

        myBoard.showBoard();

        // Remove piece on space
        // No exception handling for users trying to remove a piece from a space that doesn't exist
        // Throws an array index out of bounds exception
        myBoard.removePieceOnSpace(12, 44);

        Rook wr1 = new Rook(0,0,"White Rook 1", true);
        Rook wr2 = new Rook(4,0,"White Rook 2", true);
        Rook br1 = new Rook(4,0,"White Rook 2", false);
        Rook br2 = new Rook(4,0,"White Rook 2", false);


        wr1.name = "White Rook 1";
        wr2.getAlive();
        /*
        Piece myPiece = new Piece();
        myPiece.setName("_B12_");
        // Set piece on square
        // No exception handling for users trying to remove a piece from a space that doesn't exist
        // Throws an array index out of bounds exception
        myBoard.setPieceOnSquare(myPiece,43, 32);

         */
    }
}
