//TYANG 12-9-20 Pieces self test

package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;

import java.security.PublicKey;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Piece> pieces = new ArrayList<Piece>();


        Rook wRook1 = new Rook(0,0,"wRook1",true);
        Rook wRook2 = new Rook(7,0,"wRook2",true);
        Knight wKnight1 = new Knight(1,0,"wKnight1",true);
        Knight wKnight2 = new Knight(6,0,"wKnight2",true);
        Bishop wBishop1 = new Bishop(2,0,"wBishop1",true);
        Bishop wBishop2 = new Bishop(5,0,"wBishop2",true);
        King wKing = new King(4,0,"wKing",true);
        Queen wQueen = new Queen(3,0,"wQueen",true);



        Rook bRook1 = new Rook(0,7,"bRook1",false);
        Rook bRook2 = new Rook(7,7,"bRook2",false);
        Knight bKnight1 = new Knight(1,7,"bKnight1",false);
        Knight bKnight2 = new Knight(6,7,"bKnight2",false);
        Bishop bBishop1 = new Bishop(2,7,"bBishop1",false);
        Bishop bBishop2 = new Bishop(5,7,"bBishop2",false);
        King bKing = new King(4,7,"bKing",false);
        Queen bQueen = new Queen(3,7,"bQueen",false);


        // Adding back row of White pieces
        pieces.add(wRook1);
        pieces.add(wRook2);
        pieces.add(wKnight1);
        pieces.add(wKnight2);
        pieces.add(wBishop1);
        pieces.add(wBishop2);
        pieces.add(wKing);
        pieces.add(wQueen);



        //Adding back row of Black Pieces
        pieces.add(bRook1);
        pieces.add(bRook2);
        pieces.add(bKnight1);
        pieces.add(bKnight2);
        pieces.add(bBishop1);
        pieces.add(bBishop2);
        pieces.add(bKing);
        pieces.add(bQueen);


        // *************************************TESTING w/ NO PAWNS IN THE WAY******************************************
        /*

        // Mass piece range update           ***COPY AND PASTE WHERE NEEDED***
        for (Piece piece: pieces){
            piece.getRange(pieces);
        }

        USE getUpdate() instead


        // List all possible moves           ***COPY AND PASTE WHERE NEEDED***
        for( Piece piece: pieces)
        {
            System.out.println(piece.getName() + " - Current position: " + piece.getX() + ", " + piece.getY());
            System.out.println("Range/available moves:");
            for (int[] i: piece.range)
            {
                System.out.print("(" + i[0] + "," + i[1] + ") ");
            }

            System.out.println("\n---------------------------------------------------------------------------------");
        }


        System.out.println("Attempting to move wKnight 1 on 1,0 -> 2,2");
        wKnight1.moveTo(2,2,wKing,pieces);

        System.out.println();
        System.out.println("Attempting to move wKing on 4,0 -> 5,-1");
        wKing.moveTo(5,-1,wKing,pieces);
        System.out.println(wKing.getX() + ", "+ wKing.getY());
        wKing.moveTo(4,0,wKing,pieces);

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Adding Pawns to the mix");
        */


        Pawn bPawn1 = new Pawn(0,6,"bPawn1",false);
        Pawn bPawn2 = new Pawn(1,1,"bPawn2",false);
        Pawn bPawn3 = new Pawn(2,6,"bPawn3",false);
        Pawn bPawn4 = new Pawn(3,6,"bPawn4",false);
        Pawn bPawn5 = new Pawn(4,6,"bPawn5",false);
        Pawn bPawn6 = new Pawn(5,6,"bPawn6",false);
        Pawn bPawn7 = new Pawn(6,1,"bPawn7",false);
        Pawn bPawn8 = new Pawn(7,6,"bPawn8",false);


        Pawn wPawn1 = new Pawn(0,1,"wPawn1",true);
        Pawn wPawn2 = new Pawn(1,6,"wPawn2",true);
        Pawn wPawn3 = new Pawn(2,1,"wPawn3",true);
        Pawn wPawn4 = new Pawn(3,1,"wPawn4",true);
        Pawn wPawn5 = new Pawn(4,1,"wPawn5",true);
        Pawn wPawn6 = new Pawn(5,1,"wPawn6",true);
        Pawn wPawn7 = new Pawn(6,6,"wPawn7",true);
        Pawn wPawn8 = new Pawn(7,1,"wPawn8",true);

        wPawn7.pMove = 6;
        pieces.add(wPawn1);
        pieces.add(wPawn2);
        pieces.add(wPawn3);
        pieces.add(wPawn4);
        pieces.add(wPawn5);
        pieces.add(wPawn6);
        pieces.add(wPawn7);
        pieces.add(wPawn8);
        pieces.add(bPawn1);
        pieces.add(bPawn2);
        pieces.add(bPawn3);
        pieces.add(bPawn4);
        pieces.add(bPawn5);
        pieces.add(bPawn6);
        pieces.add(bPawn7);
        pieces.add(bPawn8);



        // Mass piece range update
        wKing.updateRange(pieces);

        /*
        for (Piece piece: pieces){
            piece.getRange(pieces);
        }
         */

        // List all possible moves ***COPY AND PASTE WHERE NEEDED***
        for( Piece piece: pieces)
        {
            System.out.println(piece.getName() + " - Current position: " + piece.getX() + ", " + piece.getY());
            System.out.println("Range/available moves:");
            for (int[] i: piece.range)
            {
                System.out.print("(" + i[0] + "," + i[1] + ") ");
            }

            System.out.println("\n---------------------------------------------------------------------------------");
        }

        wKnight1.moveTo(2,2,wKing,pieces);
        wKnight1.moveTo(1,0,wKing,pieces);

        wKnight2.moveTo(5,2,wKing,pieces);
        wKnight2.moveTo(6,0,wKing,pieces);

        bKnight1.moveTo(2,5,bKing,pieces);
        //bKnight1.moveTo(1,7,bKing,pieces);

        bKnight2.moveTo(5,5,bKing,pieces);
        //bKnight2.moveTo(6,7,bKing,pieces);

        for( Piece piece: pieces)
        {
            System.out.println(piece.getName() + " - Current position: " + piece.getX() + ", " + piece.getY());
            System.out.println("Range/available moves:");
            for (int[] i: piece.range)
            {
                System.out.print("(" + i[0] + "," + i[1] + ") ");
            }

            System.out.println("\n---------------------------------------------------------------------------------");
        }

        // **********************TESTING MOVEMENT w/ PAWNS *REQUIRES CHANGING PAWN CODE*******************
        /*
        System.out.println("attempting to move wPawn1 on 0,1 -> 0,5");
        wPawn1.moveTo(0,5,wKing,pieces);

        System.out.println("Moving wPawn1 on 0,1 -> 0,3");
        wPawn1.moveTo(0,3,wKing,pieces);

        System.out.println("Moving bPawn2 on 1,6 -> 1,4");
        bPawn2.moveTo(1,4,wKing,pieces);

        System.out.println("\n Printing wPawn1's range/valid moves");
        for (int[] i: wPawn1.range)
        {
            System.out.print("(" + i[0] + "," + i[1] + ") ");
        }

         */

        /*
        System.out.println("\n Printing bPawn2's range/valid moves");
        for (int[] i: bPawn2.range)
        {
            System.out.print("(" + i[0] + "," + i[1] + ") ");
        }
        System.out.println("\n---------------------------------------------------------------------------------");
         */

        // *************************************TESTING ROOK MOVEMENT + RANGE UPDATE**********************************8
        /*
        System.out.println("Moving wRook1 on 0,0 -> 0,2");
        wRook1.moveTo(0,2,wKing,pieces);
        System.out.println("\nPrinting wRook1's new range (automatic"+ " - Current position: " + wRook1.getX() + ", " + wRook1.getY());
        for (int[] i: wRook1.range)
        {
            System.out.print("(" + i[0] + "," + i[1] + ") ");
        }
        System.out.println("\n");
         */

        // ********************************TESTING ATTACK OF PAWNS + MANUAL REMOVAL TEST****************************8***
        /*
        System.out.println("Printing wPawn1's range: " + " - Current position: " + wPawn1.getX() + ", " + wPawn1.getY());
        for (int[] i: wPawn1.range)
        {
            System.out.print("(" + i[0] + "," + i[1] + ") ");
        }
        System.out.println("\n");


        System.out.println("Printing bPawn2's range: "+ " - Current position: " + bPawn2.getX() + ", " + bPawn2.getY());
        for (int[] i: bPawn2.range)
        {
            System.out.print("(" + i[0] + "," + i[1] + ") ");
        }
        System.out.println("\n");

        System.out.println("\nMoving wPawn1 to 1,4 and removing bPawn2");
        wPawn1.moveTo(1,4,wKing,pieces);

        for (Piece piece : pieces)
        {
            System.out.print(piece.getName() + ", ");
        }
        System.out.println('\n');

        int index=0;
        for (Piece piece: pieces)
        {
            if (piece.getName() == bPawn2.getName())
            {
                piece.setIsAlive(false);
                index = pieces.indexOf(piece);
            }
        }
        pieces.remove(index);
        for (Piece piece : pieces)
        {
            System.out.print(piece.getName() + ", ");
        }
        System.out.println('\n');
         */


        // ******************************************TESTING KING CHECK*************************************************
        /*
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Manually placing bKing -> 2,5 in range of pawn");
        bKing.setX(2);
        bKing.setY(5);
        bKing.getRange(pieces);

        System.out.println("Printing bKing range: "+ " - Current position: " + bKing.getX() + ", " + bKing.getY());
        for (int[] i: bKing.range)
        {
            System.out.print("(" + i[0] + "," + i[1] + ") ");
        }
        System.out.println("\n");

        System.out.println("---------------------------------------------------------------------------------");
        */

        /*
        System.out.println("Attempting to move another piece even with check");
        bPawn8.moveTo(7,5,bKing,pieces);
        System.out.println("Coordinates of bPawn8: " + bPawn8.getX() + "," + bPawn8.getY());

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Attempting to move bKing out of check");
        bKing.moveTo(1,4,bKing,pieces);

        wKnight1.moveTo(1,0,wKing,pieces);
         */

    }
}

