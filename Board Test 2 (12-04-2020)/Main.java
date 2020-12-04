package com.company;

public class Main {

    public static void main(String[] args) {

        Board myBoard = new Board();

        myBoard.showBoard();

        // Remove piece on space
        // No exception handling for users trying to remove a piece from a space that doesn't exist
        // Throws an array index out of bounds exception
        myBoard.removePieceOnSpace(12, 44);

        Piece myPiece = new Piece();
        myPiece.setName("_B12_");

        // Set piece on square
        // No exception handling for users trying to remove a piece from a space that doesn't exist
        // Throws an array index out of bounds exception
        myBoard.setPieceOnSquare(myPiece,43, 32);
    }
}
