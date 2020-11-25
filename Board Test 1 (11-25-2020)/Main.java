package com.company;

public class Main {

    public static void main(String[] args) {

        // Creating a new board and attempting to print it
        Board board1 = new Board();
        board1.showBoard();

        // ERROR: Remove pieces on space and set pieces on space allows users to assign values out of the board
        // See Testing Notes for more details.
        board1.removePieceOnSpace(12,44);

        // Testing the pieces
        Piece myPiece = new Piece();
        myPiece.setName("_B12_");
        System.out.println(myPiece.getName());
        System.out.println(myPiece.name);
    }
}
