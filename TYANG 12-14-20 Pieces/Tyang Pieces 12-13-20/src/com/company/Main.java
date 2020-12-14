//TYANG 12-13-20 Pieces Castling code bonanza

package com.company;

import java.util.ArrayList;

import java.security.PublicKey;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Piece> pieces = new ArrayList<Piece>();


        Pawn blackPawn1 = new Pawn(7,6,"bPawn1",false);
        Pawn blackPawn2 = new Pawn(2,6,"bPawn2",false);
        Rook bRook1 = new Rook(0,7,"bRook1",false);
        Rook bRook2 = new Rook(7,7,"bRook2",false);
        King bKing = new King(4,7,"bKing",false);
        //Queen bQueen = new Queen(3,7,"bQueen",false);
        //Bishop bBishop1 = new Bishop(2,7,"bBishop1",false);
        //Bishop bBishop2 = new Bishop(5,7,"bBishop2",false);
        //Knight bKnight1 = new Knight(0,1,"bKnight1",false);
        //Knight bKnight2 = new Knight(6,2,"bKnight2",false);



        //Pawn whitePawn1 = new Pawn(7,1,"wPawn1",true);
        //Pawn whitePawn2 = new Pawn(2,1,"wPawn2",true);
        Rook wRook1 = new Rook(0,0,"wRook1",true);
        Rook wRook2 = new Rook(7,0,"wRook2",true);
        King wKing = new King(4,0,"wKing",true);
        //Queen wQueen = new Queen(3,0,"wQueen",true);
        //Bishop wBishop1 = new Bishop(2,0,"wBishop1",true);
        //Bishop wBishop2 = new Bishop(5,0,"wBishop2",true);
        //Knight wKnight1 = new Knight(1,0,"WKnight1",true);
        //Knight wKnight2 = new Knight(6,0,"wKnight2",true);


        pieces.add(blackPawn1);
        pieces.add(blackPawn2);
        pieces.add(bKing);
        //pieces.add(bQueen);
        pieces.add(bRook1);
        pieces.add(bRook2);
        //pieces.add(bBishop1);
        //pieces.add(bBishop2);
        //pieces.add(bKnight1);
        //pieces.add(bKnight2);


       // pieces.add(whitePawn1);
        //pieces.add(whitePawn2);
        pieces.add(wKing);
        //pieces.add(wQueen);
        pieces.add(wRook1);
        pieces.add(wRook2);
        //pieces.add(wBishop1);
        //pieces.add(wBishop2);
        //pieces.add(wKnight1);
        //pieces.add(wKnight2);


        Piece.updateRange(pieces);


        for (Piece piece: pieces)
        {
            System.out.print("Piece: " + piece.getName());
            System.out.print(" Currently on: (" +piece.getX() +"," + piece.getY()+")");
            System.out.print(" Range: ");
            for (int[]i:piece.range)
            {
                System.out.print("(" + i[0] +"," + i[1] + ")");
            }
            System.out.println();
        }
        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************\n");

        // TESTS REQUIRE BACK ROW TO BE CLEARED/PLACED FOR CASTLING, bishop placement for restriction

/*
        //Test to see if attempting a blocked Castle will increment pMove
        // REQUIRES wBishop1
        wKing.moveTo(2,0,wKing,pieces);
        wKing.moveTo(6,0,wKing,pieces);

*/

/*
        //Test to see if King can Castle after ALREADY moving, Castling to the left (CHECK)
        wKing.moveTo(5,0,wKing,pieces);
        wKing.moveTo(4,1,wKing,pieces);
        wKing.moveTo(4,0,wKing,pieces);
        //wBishop1.moveTo(0,3,wKing,pieces);
        wKing.moveTo(2,0,wKing,pieces);
*/

/*
        //Test to see if Castling is possible if Rook moves, then a Castling to the right (CHECK)
        wRook1.moveTo(0,1,wKing,pieces);
        wRook1.moveTo(0,0,wKing,pieces);
        wKing.moveTo(2,0,wKing,pieces);
        //wKing.moveTo(7,0,wKing,pieces);
        //wKing.moveTo(6,0,wKing,pieces);
 */


/*
        //Testing bKing in check, can it castle             (CHECK, can't)
        // REQUIRES wBishop2
        wBishop2.moveTo(1,4,wKing,pieces);
        bKing.moveTo(2,7,bKing,pieces);

        // moving King normally                             (CHECK, can move from check)
        bKing.moveTo(6,7,bKing,pieces);
 */
/*
        //Testing to see if King can castle INTO a check    (CHECK)
        // Requires wBishop2
        wBishop2.moveTo(0,5,wKing,pieces);
        bKing.moveTo(2,7,bKing,pieces);
        bKing.moveTo(6,7,bKing,pieces);
 */


        //Testing to see if a Pawn can trigger check - and disrupt castling                 (ISSUE)
        // ISSUE FOUND  If King attempts to move into a check against a Pawn
        // KING IS MOVED INTO CHECK
        // AND THE ROOK IS MOVED TO (0,3)
        blackPawn1.moveTo(7,4,bKing,pieces);

        blackPawn1.moveTo(7,3,bKing,pieces);
        blackPawn1.moveTo(7,2,bKing,pieces);
        blackPawn1.moveTo(7,1,bKing,pieces);

        System.out.print("Piece: " + wKing.getName());
        System.out.print(" Currently on: (" +wKing.getX() +"," + wKing.getY()+")");
        System.out.print(" Range: ");
        for (int[]i:wKing.range)
        {
            System.out.print("(" + i[0] +"," + i[1] + ")");
        }
        System.out.println();

        wKing.moveTo(6,0,wKing,pieces);
        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************\n");

        for (Piece piece: pieces)
        {
            System.out.print("Piece: " + piece.getName());
            System.out.print(" Currently on: (" +piece.getX() +"," + piece.getY()+")");
            System.out.print(" Range: ");
            for (int[]i:piece.range)
            {
                System.out.print("(" + i[0] +"," + i[1] + ")");
            }
            System.out.println();
        }
        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************\n");

        System.out.println("wKing pMove:" + wKing.pMove);
        System.out.println("wRook1 pMove: " + wRook1.pMove);
        wKing.moveTo(2,0,wKing,pieces);

/*
        //Attempting to recreate above issue against bKing instead - Castling through a check (CHECK)
        whitePawn2.moveTo(2,3,wKing,pieces);
        whitePawn2.moveTo(2,4,wKing,pieces);
        whitePawn2.moveTo(2,5,wKing,pieces);
        whitePawn2.moveTo(2,6,wKing,pieces);

        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************\n");

        for (Piece piece: pieces)
        {
            System.out.print("Piece: " + piece.getName());
            System.out.print(" Currently on: (" +piece.getX() +"," + piece.getY()+")");
            System.out.print(" Range: ");
            for (int[]i:piece.range)
            {
                System.out.print("(" + i[0] +"," + i[1] + ")");
            }
            System.out.println();
        }
        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************\n");

        bKing.moveTo(2,7,bKing,pieces);
 */
/*
        //Attempting to recreate above issue with bKing Castling into a pawn check      (ISSUE FOUND)
        // Error also occurs here
        whitePawn1.moveTo(7,3,wKing,pieces);
        whitePawn1.moveTo(7,4,wKing,pieces);
        whitePawn1.moveTo(7,5,wKing,pieces);
        whitePawn1.moveTo(7,6,wKing,pieces);

        bKing.moveTo(6,7,bKing,pieces);
        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************\n");

        for (Piece piece: pieces)
        {
            System.out.print("Piece: " + piece.getName());
            System.out.print(" Currently on: (" +piece.getX() +"," + piece.getY()+")");
            System.out.print(" Range: ");
            for (int[]i:piece.range)
            {
                System.out.print("(" + i[0] +"," + i[1] + ")");
            }
            System.out.println();
        }
        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************\n");

        System.out.println("bKing pMove:" + bKing.pMove);
        System.out.println("bRook2 pMove: " + bRook2.pMove);
 */

/*
        //Attempting to test Knights with these cases                       (PASS)
        // MANUALLY PLACED bKnight1 -> (0,1)    bKnight2 -> (6,2)
        wKing.moveTo(2,0,wKing,pieces);
        wKing.moveTo(6,0,wKing,pieces);

 */
/*
        //Attempting to recreate above issue with bQueen  - Not an issue with Queen  (Pass)
        // Requires bQueen
        bQueen.moveTo(2,6,bKing,pieces);
        wKing.moveTo(2,0,wKing,pieces);
        wKing.moveTo(6,0,wKing,pieces);
 */
/*
        //Attempting to recreate above issue with bKing?  - Not an issue with the bKing  (Pass)
        bKing.moveTo(3,6,bKing,pieces);
        bKing.moveTo(2,5,bKing,pieces);
        bKing.moveTo(1,4,bKing,pieces);
        bKing.moveTo(1,3,bKing,pieces);
        bKing.moveTo(1,2,bKing,pieces);
        bKing.moveTo(1,1,bKing,pieces);

        wKing.moveTo(2,0,wKing,pieces);
        wKing.moveTo(6,0,wKing,pieces);
 */
/*
        //Attempting to recreate above issue with Pawn + wKing pasing through a check   (Pass)
        blackPawn2.moveTo(2,4,bKing,pieces);
        blackPawn2.moveTo(2,3,bKing,pieces);
        blackPawn2.moveTo(2,2,bKing,pieces);
        blackPawn2.moveTo(2,1,bKing,pieces);

        System.out.print("Piece: " + wKing.getName());
        System.out.print(" Currently on: (" +wKing.getX() +"," + wKing.getY()+")");
        System.out.print(" Range: ");

        for (int[]i:wKing.range)
        {
            System.out.print("(" + i[0] +"," + i[1] + ")");
        }
        System.out.println();

        wKing.moveTo(2,0,wKing,pieces);

 */
/*
        // Checking if can Castle through a check, Queen on (3,7) -> (3,0)      (CHECK, can't castle)
        // REQUIRES bQueen                                                      ( Won't deny other castling)
        wKing.moveTo(2,0,wKing,pieces);
        wKing.moveTo(6,0,wKing,pieces);
 */



        //------------------------------------------------------------------------------------------------------
        //----------------------------------------TYANG EXTRA TESTS---------------------------------------------

        /*
        // Pawn movement testing for concern                (ISSUE but easy fix)
        whitePawn1.moveTo(1,3,wKing,pieces);
        whitePawn1.moveTo(1,4,wKing,pieces);        //TYANG can't move after first move

        System.out.println("Piece: " + whitePawn1.getName());
        System.out.println("Currently on: (" +whitePawn1.getX() +"," + whitePawn1.getY()+")");
        System.out.print("Range: ");
        for (int[]i:whitePawn1.range)
        {
            System.out.print("(" + i[0] +"," + i[1] + ")");
        }
        System.out.println();
         */


        //Testing pieces more thoroughly (aware of King and Knight out of bounds movement)

        /*
        // Noticed an interesting event
        // if Queen of opposite color has king in check, it can't move in closer unless
        // it goes in for the kill or just misses complete
        wQueen.moveTo(4,1,wKing,pieces);
        wQueen.moveTo(4,4,bKing,pieces);
        wQueen.moveTo(3,0,bKing,pieces);

         */

        /*
        //wBishop2 can check a king, and still move closer to it
        blackPawn1.moveTo(3,5,bKing,pieces);

        wBishop2.moveTo(1,4,wKing,pieces);
        bRook1.moveTo(0,1,bKing,pieces);
        wBishop2.moveTo(2,3,wKing,pieces);


        bBishop1.moveTo(0,5,bKing,pieces);
        //bQueen.moveTo(0,4,bKing,pieces);
        //bKnight1.moveTo(2,5,bKing,pieces);

        // Safe move
        //bKing.moveTo(3,6,bKing,pieces);
        //bKing.moveTo(4,7,bKing,pieces);

         */

    }
}

