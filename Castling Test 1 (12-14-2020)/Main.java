package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Test array
        ArrayList<Piece> testPieces = new ArrayList<Piece>();

        // Create rook pieces
        Rook whiteRook1 = new Rook(0,0,"White Rook 1", true);
        Rook whiteRook2 = new Rook(7,0,"White Rook 2", true);
        Rook blackRook1 = new Rook(0,7,"Black Rook 1", false);
        Rook blackRook2 = new Rook(7,7,"Black Rook 2", false);

        King whiteKing = new King(4,0,"King",true);
        King blackKing = new King(4,7,"King",false);


        testPieces.add(whiteRook1);
        testPieces.add(whiteRook2);
        testPieces.add(blackRook1);
        testPieces.add(blackRook2);
        testPieces.add(whiteKing);
        testPieces.add(blackKing);

        Piece.updateRange(testPieces);

        //blackRook2.moveTo(7,2,blackKing,testPieces);
        //blackRook2.moveTo(4,2,blackKing,testPieces);

        // whiteKing.moveTo(3,0,whiteKing,testPieces);
        whiteKing.validCastling(testPieces, whiteRook2);
        whiteKing.doCastling(testPieces,whiteRook2);

        blackKing.validCastling(testPieces,blackRook2);
        blackKing.doCastling(testPieces,blackRook2);
        // whiteRook1.print();
       // whiteKing.moveTo(6,0,whiteKing,testPieces);

        /*
        Board myBoard = new Board();

        myBoard.showBoard();

        /*
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

        /*
        // Test array
        ArrayList<Piece> testPieces = new ArrayList<Piece>();

        // Create rook pieces
        Rook whiteRook1 = new Rook(0,0,"White Rook 1", true);
        Rook whiteRook2 = new Rook(7,0,"White Rook 2", true);
        Rook blackRook1 = new Rook(0,7,"Black Rook 1", false);
        Rook blackRook2 = new Rook(7,7,"Black Rook 2", false);

        whiteRook1.updateRange(testPieces);
        whiteRook2.updateRange(testPieces);
        blackRook1.updateRange(testPieces);
        blackRook2.updateRange(testPieces);


        // Need a king object for testing MoveTo method
        King whiteKing = new King(4,0,"King",true);
        King blackKing = new King(4,7,"King",false);
        whiteKing.updateRange(testPieces);
        blackKing.updateRange(testPieces);


        testPieces.add(whiteRook1);
        testPieces.add(whiteRook2);
        testPieces.add(blackRook1);
        testPieces.add(blackRook2);
        testPieces.add(whiteKing);
        testPieces.add(blackKing);

        // NOT expected to move
        whiteRook1.moveTo(1,1,whiteKing,testPieces);

        // Expected to move since the board is empty and only contains the Rooks(not working)
        whiteRook1.moveTo(0,3,whiteKing,testPieces);
        blackRook1.moveTo(0,5,blackKing,testPieces);

        // Move the pieces back
        whiteRook1.moveTo(0,0,whiteKing,testPieces);

        whiteRook1.moveTo(0,2,whiteKing,testPieces);
        whiteRook1.moveTo(0,0,whiteKing,testPieces);

        blackRook1.moveTo(0,3,blackKing,testPieces);
        blackKing.updateRange(testPieces);

        whiteRook1.moveTo(0,3,whiteKing,testPieces);
        blackRook1.setIsAlive(false);

        blackRook1.print();
        whiteRook1.print();

        Knight whiteKnight1 = new Knight(1,0,"WhiteKnight1",true);
        Knight whiteKnight2 = new Knight(6,0,"WhiteKnight2",true);
        Knight blackKnight1 = new Knight(1,7,"BlackKnight1",false);
        Knight blackKnight2 = new Knight(6,7,"BlackKnight2",false);

        testPieces.add(whiteKnight1);
        whiteKnight1.updateRange(testPieces);
        testPieces.add(whiteKnight2);
        whiteKnight2.updateRange(testPieces);
        testPieces.add(blackKnight1);
        blackKnight1.updateRange(testPieces);
        testPieces.add(blackKnight2);
        blackKnight2.updateRange(testPieces);

        //Pawn blackPawn1 = new Pawn(6,6,"BlackPawn1",false);
        //testPieces.add(blackPawn1);
        Pawn whitePawn1 = new Pawn(6,6,"WhitePawn1",true);
        testPieces.add(whitePawn1);

        whiteKnight1.updateRange(testPieces);
        blackKnight2.updateRange(testPieces);


        whiteKnight1.moveTo(2,2,whiteKing,testPieces);
        whiteKnight1.moveTo(1,0,whiteKing,testPieces);


        blackKnight2.moveTo(5,5,blackKing,testPieces);
        blackKnight2.moveTo(6,7,blackKing,testPieces);

        /*
        blackKnight2.moveTo(6,7,blackKing,testPieces);
        blackKnight2.moveTo(7,5,blackKing,testPieces);



        /*
        // Not expected to move
        whiteRook1.moveTo(-1,0,whiteKing,testPieces);

        /*
        // Create a pawn to test to make sure the rook can not jump
        Pawn whitePawn1 = new Pawn(0,1,"WhitePawn1",true);
        testPieces.add(whitePawn1);
        whitePawn1.updateRange(testPieces);

        // Not expected to go through the pawn.
        whiteRook1.updateRange(testPieces);
        whiteRook1.moveTo(0,2,whiteKing,testPieces);





        /*
        Knight whiteKnight1 = new Knight(1,0,"WhiteKnight1",true);
        Knight whiteKnight2 = new Knight(6,0,"WhiteKnight2",true);
        Knight blackKnight1 = new Knight(1,7,"BlackKnight1",true);
        Knight blackKnight2 = new Knight(6,7,"BlackKnight2",false);


        Bishop whiteBishop1 = new Bishop(5,0,"WhiteBishop1",true);

        // Need a king object for testing MoveTo method
        King whiteKing = new King(4,0,"King",true);
        King blackKing = new King(4,7,"King",false);

        // Trying to move a knight again
        whiteKnight1.moveTo(1,2,whiteKing,testPieces);

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
