package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Board testBoard = new Board();
        testBoard.showBoard(); //==Doesn't display board in expected format. Just displays pieces objects.
        Piece myPiece = new Piece();
        myPiece.setName("_W01_");
       // testBoard.setPieceOnSquare(myPiece,10,12);
    }
}
