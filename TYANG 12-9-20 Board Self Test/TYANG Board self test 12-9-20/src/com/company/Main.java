//TYANG 12-10-20 Board code self test

package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Board bo = new Board();
        bo.showBoard();
        bo.removePieceOnSpace(8,66);


        System.out.println("----------------------------------------------------------------------------------------");
        Pawn pawn1 = new Pawn(4,4,"--WPawn-D-4-",true);
        //bo.setPieceOnSquare(pawn,-1242,-3231)
        bo.setPieceOnSquare(pawn1,4,4);
        bo.showBoard();


        System.out.println("----------------------------------------------------------------------------------------");
        ArrayList<Piece> alive = new ArrayList<>();
        alive = bo.showBoard();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("\nListing pieces that are alive (I AM ALIVE)");
        for (Piece piece: alive)
        {
            System.out.print(piece.getName() +", ");
        }
        System.out.printf("\n");

        /*
        char d = 65;
        System.out.println(d);
        d++;
        System.out.println(d);
         */
        System.out.println("----------------------------------------------------------------------------------------");
        bo.loadBoard();
        bo.showBoard();
        bo.saveBoard();
        bo.resetBoard();

        bo.showBoard();
        bo.loadBoard();
        bo.showBoard();
    }
}
