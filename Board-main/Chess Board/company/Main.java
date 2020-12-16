package com.company;

import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        Board myBoard = new Board();

        ArrayList<Piece> myList = new ArrayList<>();

        myList = myBoard.showBoard();


        System.out.println();
        for (Piece p: myList){
            System.out.println (p.getName());

        }


        //myBoard.saveBoard();


        //myBoard.loadBoard();
    }
}
