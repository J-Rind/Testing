package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println();
        System.out.println();

        ArrayList<Piece> pieces = new ArrayList<Piece>();

        King wKing = new King(4,0,"King",true);

        Queen wQueen = new Queen(3,0,"Queen",true);

        pieces.add(wKing);
        pieces.add(wQueen);

        //testing the king & queen position
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




        System.out.println();
        System.out.println();
    }
}
