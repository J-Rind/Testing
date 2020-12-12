package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Piece> pieces = new ArrayList<>();

        Board board = new Board();
        pieces=board.showBoard();


        for (Piece piece: pieces)
        {
            System.out.println(piece.getName() + "on coordinates: (" + piece.getX()+ "," + piece.getY()+")");
            System.out.print("Range: ");
            for (int[] i: piece.range)
            {

                System.out.print("(" + i[0] +","+ i[1] +") ");
            }
            System.out.println();
        }

        char a =0;
        int index = 6;
        for(int y=7; y>=0; y--){                                                             //TYANG (0,7) start
            switch(y){
                case 0:
                    a = 'A';
                    break;
                case 1:
                    a = 'B';
                    break;
                case 2:
                    a = 'C';
                    break;
                case 3:
                    a = 'D';
                    break;
                case 4:
                    a = 'E';
                    break;
                case 5:
                    a = 'F';
                    break;
                case 6:
                    a = 'G';
                    break;
                case 7:
                    a = 'H';
                    break;
            }
            for(int x = 7; x>=0; x--){

                if (index>=y){
                    index--;
                    System.out.println();
                }
                System.out.print("("+a+","+(x+1)+")");
            }
        }



        //expected output and loop


        /*
        int x = 1;
        for (Piece piece: pieces)
        {
            if (x == piece.getX()){
                System.out.println();
                x++;
            }
            System.out.print("(" + piece.getX()+ "," + piece.getY()+")");

        }
         */
        System.out.println();



        Game game = new Game();
        game.start();




    }
}