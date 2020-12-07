package com.company;

import java.util.ArrayList;

public class WinCheck {

    ArrayList<Piece> whitePieces;                               // TYANG array list is also separate here
    ArrayList<Piece> blackPieces;

    ArrayList<Piece> whiteValidMoves;
    ArrayList<Piece> blackValidMoves;

    Board myBoard;

    Piece blackKing;
    Piece whiteKing;


    public WinCheck(ArrayList<Piece> whitePieces, ArrayList<Piece> blackPieces,
                    ArrayList<Piece> whiteValidMoves, ArrayList<Piece> blackValidMoves,
                    Board myBoard){
     this.whitePieces = whitePieces;
     this.blackPieces = blackPieces;
     this.whiteValidMoves = whiteValidMoves;
     this.blackValidMoves = blackValidMoves;
     this.myBoard = myBoard;

    for (Piece p : whitePieces){
        // Find the whiteKing within whitePieces
        // Store the X and Y coordinates of the whiteKing
    }

    for (Piece p : blackPieces){
        // Find the blackKing within blackPieces
        // Store the X and Y coordinates of the whiteKing
    }

    }

    public boolean isWhiteInCheck(){
        // Check if blackValidMoves matches the coordinates of the whiteKing
        // If so, isWhiteInCheck = true;
        return false;
    }

    public boolean isBlackInCheck(){
        // Check if whiteValidMoves matches the coordinates of the blackKing
        // If so, isBlackInCheck = true;
        return false;
    }

    public boolean whiteCheckMate(){
        // If the whiteKing cannot move or cannot move any white pieces
        // to block the check, then white is checkmated
        return false;
    }

    public boolean blackCheckMate(){
        // if the blackKing cannot move or cannot move any black pieces
        // to block the check, then black is checkmated
        return false;
    }

}
