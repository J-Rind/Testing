package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Test array
        ArrayList<Piece> testPieces = new ArrayList<Piece>();

        Knight whiteKnight1 = new Knight(1,0,"WhiteKnight1",true);
        Knight whiteKnight2 = new Knight(6,0,"WhiteKnight2",true);
        Knight blackKnight1 = new Knight(1,7,"BlackKnight1",true);
        Knight blackKnight2 = new Knight(6,7,"BlackKnight2",false);


        Bishop whiteBishop1 = new Bishop(5,0,"WhiteBishop1",true);

        // Need a king object for testing MoveTo method
        King whiteKing = new King(4,0,"King",true);
        King blackKing = new King(4,7,"King",false);

        // Trying to move a knight again
        whiteKnight1.moveTo(0,2,whiteKing,testPieces);

        // Try to move a knight BEFORE creating a pawn
        whiteKnight1.moveTo(2,2,whiteKing,testPieces);

        // Trying to move a Knight to an INCORRECT coordinate
        // INCORRECT coordinate test, whiteKnight1.moveTo(1,1,whiteKing,testPieces);

        // Create a pawn to test if the knight can jump
        Pawn whitePawn1 = new Pawn(1,1,"WhitePawn1",true);
        whitePawn1.moveTo(1,3,whiteKing,testPieces);
        Pawn whitePawn2 = new Pawn(6,1,"WhitePawn2",true);

        Pawn whitePawn3 = new Pawn(2,1,"WhitePawn2",true);
        whitePawn3.moveTo(2,3,whiteKing,testPieces);

        // Test if the Knight can JUMP
        whiteKnight1.moveTo(2,2,whiteKing,testPieces);

        // Test if the knight can move to an invalid location
        whiteKnight1.moveTo(1,2,whiteKing,testPieces);

        // whiteBishop1.moveTo(7,2,whiteKing,testPieces);



        /*
        // Create the pieces objects
        Bishop whiteBishop1 = new Bishop(5,0,"WhiteBishop1",true);
        Bishop whiteBishop2 = new Bishop(2,0,"WhiteBishop2",true);
        Bishop blackBishop1 = new Bishop(5,7,"BlackBishop1",false);
        Bishop blackBishop2 = new Bishop(2,7,"BlackBishop2",false);

        // Need a king object for testing MoveTo method
        King whiteKing = new King(4,0,"King",true);
        King blackKing = new King(4,7,"King",false);

        // Add pieces to the array
        testPieces.add(whiteBishop1);
        testPieces.add(whiteBishop2);
        testPieces.add(blackBishop1);
        testPieces.add(blackBishop2);


        // Not expected to move
        whiteBishop1.moveTo(5,1, whiteKing, testPieces);

        // Expected to move
        whiteBishop1.moveTo(6,1, whiteKing, testPieces);

        // Not expected to move
        whiteBishop1.moveTo(5,1, whiteKing, testPieces);

        // Expected to move
        whiteBishop1.moveTo(5,0, whiteKing, testPieces);

        // Attempt to create conflicting moves (also checking if the piece can jump)
        blackBishop2.moveTo(7,2,blackKing,testPieces);
        whiteBishop1.moveTo(6,1, whiteKing, testPieces);
        blackBishop2.moveTo(5,0,blackKing,testPieces);

        whiteBishop1.moveTo(4,1, whiteKing, testPieces);
        blackBishop2.moveTo(5,0,blackKing,testPieces);
        whiteBishop1.moveTo(5,0, whiteKing, testPieces);

        // Try to print the details
        whiteBishop1.print();
        blackBishop2.print();

        // Try to destroy a piece
        blackBishop2.moveTo(5,0,blackKing,testPieces);

        // Try to print the details again, whiteBishop1 should have an isAlive status false.
        whiteBishop1.print();
        blackBishop2.print();


        /*

                Rook wRook1 = new Rook(0,0,"Rook",true);
        Rook wRook2 = new Rook(7,0,"Rook",true);
        King wKing = new King(4,0,"King",true);
        Rook bRook1 = new Rook(0,7,"Rook",false);
        Rook bRook2 = new Rook(7,7,"Rook",false);
        King bKing = new King(4,7,"King",false);
        Bishop wBishop1 = new Bishop(3,0,"Bishop",true);



        pieces.add(wRook1);
        pieces.add(wRook2);
        pieces.add(bRook1);
        pieces.add(bRook2);
        pieces.add(bKing);
        pieces.add(wKing);

        wKing.moveTo(3,0,wKing,pieces);
        bRook1.moveTo(3,7,bKing,pieces);
        if (wKing.kingCheck(pieces))
            System.out.println("White king in check!");

        wKing.moveTo(4,0,wKing,pieces);
        wRook2.moveTo(5,0,wKing,pieces);
        bKing.moveTo(5,7,bKing,pieces);
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
