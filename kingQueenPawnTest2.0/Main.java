package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Piece> pieces = new ArrayList<Piece>();

        King wKing = new King(4,0,"King",true);
        Pawn wPawn = new Pawn(4,1,"Pawn",true);
        Queen wQueen = new Queen(3,0,"Queen",true);

        pieces.add(wKing);
        pieces.add(wQueen);
        pieces.add(wPawn);


        //output shows the open spaces for the king to move
        System.out.println("king test");
        wKing.getRange(pieces);
        for(int[]i: wKing.range)
        {
            System.out.println(i[0]+","+i[1]);
        }


        //output shows the open spaces for the queen to move
        System.out.println("queen test");
        wQueen.getRange(pieces);
        for(int[]i: wQueen.range)
        {
            System.out.println(i[0]+","+i[1]);
        }

        //output shows the open spaces for the queen to move
        System.out.println("Pawn test");
        wPawn.getRange(pieces);
        for(int[]i: wPawn.range)
        {
            System.out.println(i[0]+","+i[1]);
        }

        wPawn.moveTo(4,3,wKing,pieces);

        //Pawn test after moving
        System.out.println("Pawn test2");
        wPawn.getRange(pieces);
        for(int[]i: wPawn.range)
        {
            System.out.println(i[0]+","+i[1]);
        }

        // ********STILL TESTING*********
        //Creating Black Pawn to Test White Pawns Kill
        Pawn bPawn = new Pawn(5,3,"bPawn",false);
        pieces.add(bPawn);

        //White Pawn Kill Test
        System.out.println("Black Pawn Move Test");
        bPawn.getRange(pieces);
        for(int[]i: bPawn.range)
        {
            System.out.println(i[0]+","+i[1]);
        }


        //White Pawn Kill Test
        System.out.println("Pawn Kill Test");
        wPawn.getRange(pieces);
        for(int[]i: wPawn.range)
        {
            System.out.println(i[0]+","+i[1]);
        }



    }
}
