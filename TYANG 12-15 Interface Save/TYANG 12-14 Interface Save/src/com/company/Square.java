//This class contains the object square. To create a square you will need a string containing the color,
// separate x and y coordinates as integers and the piece object.
package com.company;

public class Square {
    Piece piece;                        //Piece should be further developed by piece team
    String color;
    int x;
    int y;


    public Piece getPiece(){            //Will return what piece is in the square
        return piece;
    }

    public void setPiece(Piece piece){  //Will set the desired piece in the square, requires the object Piece
        this.piece = piece;
    }


    public String getColor(){           //Will return the color of the square
        return color;
    }

    public void setColor(String color){ //Will set the color of the square, requires string for color
        this.color = color;             //shouldn't be needed if square was constructed properly
    }

    public int getX(){                  //Will return x coordinate of square
        return x;
    }

    public void setX(int x){            //Will set the x coordinate, requires an integer
        this.x = x;                     //shouldn't be needed if square was constructed properly
    }

    public int getY(){                  //Will return y coordinate of square
        return y;
    }

    public void setY(int y){            //Will set the y coordinate, requires an integer
        this.y = y;                     //shouldn't be needed if square was constructed properly
    }

    public Square(){
    }

    public Square(Piece piece, String color, int x, int y){
        this.piece = piece;
        this.color = color;
        this.x = x;
        this.y = y;
    }
}