package com.company;
import java.util.ArrayList;


public class Piece {
    private int X;
    private int Y;
    private String name;
    private Boolean isAlive;
    private Boolean isWhite;
    public ArrayList<int[]> range = new ArrayList<>();

    Piece(int x, int y, String t, Boolean white)
    {
        X = x;
        Y = y;
        name = t;
        isAlive = Boolean.TRUE;
        isWhite = white;
        range = new ArrayList<>();
    }

    Piece()
    {}

    public static void updateRange(ArrayList<Piece> arr){
        for(int i = 0;i < arr.size(); i++){
            arr.get(i).getRange(arr);
        }
    }

    public void moveTo(int x, int y, King myKing, ArrayList<Piece> arr){

        int[] myCoords = new int[]{this.getX(), this.getY()};
        int moved = 0;

        updateRange(arr);

        for (int[] coordinate : this.range) {
            if (coordinate[0] == x && coordinate[1] == y) {
                this.setX(x);
                this.setY(y);
                System.out.println(this.getName() + " Moved to: (" + this.getX() + "," + this.getY() + ")");

                moved++;
                break;
            }
        }

        updateRange(arr);

        if (myKing.kingCheck(arr) == true)
        {
            System.out.println("!! king is in check, moving piece back !!");
            this.setX(myCoords[0]);
            this.setY(myCoords[1]);
        }

        if(moved != 1)
        {
            System.out.println("piece not moved, not in range");
        }



    } //function should change piece coordinates after error checking*/

    public void getRange(ArrayList<Piece> arr){};

    public boolean kingCheck(){return true;} //returns if this move will place the current player's king in check.

    public void print(){
        System.out.println("Coordinate: (" + X + "," + Y + ")");
        System.out.println("isWhite: " + isWhite);
        System.out.println("Name: " + name);
        System.out.println("Status: " + isAlive);



    }

    public int getPiece(int dX, int dY,ArrayList<Piece> arr)
    {
        for (int i =0; i < arr.size(); i++){
            if (arr.get(i).getX() == dX && arr.get(i).getY() == dY )
            {
                if (arr.get(i).getColor() == this.isWhite)
                {return 1;}
                else {return 2;}
            }


        }
        return 0;

    }

    public int getX(){return X;}
    public int getY(){return Y;}
    public String getName(){return name;}
    public Boolean getAlive(){return isAlive;}
    public Boolean getColor(){return isWhite;}

    public void setX(int x){X = x;}
    public void setY(int y){Y = y;}
    public void setName(String t){name = t;}
    public void setIsAlive(Boolean s){isAlive = s;}
    public void setIsWhite(Boolean a){isWhite = a;}
}