package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Board implements Serializable {

    //2D array to make the 8 by 8 grid of the board
    Square [][] squares = new Square [8][8];

    //arraylist to store the black pieces
    ArrayList<Piece> blackPiece = new ArrayList<>();
    //arraylist to store the white pieces
    ArrayList<Piece> whitePiece = new ArrayList<>();



    //board constructor
    public Board(){
        this.setBoard();
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public ArrayList<Piece> getBlackPiece() {
        return blackPiece;
    }

    public void setBlackPiece(ArrayList<Piece> blackPiece) {
        this.blackPiece = blackPiece;
    }

    public ArrayList<Piece> getWhitePiece() {
        return whitePiece;
    }

    public void setWhitePiece(ArrayList<Piece> whitePiece) {
        this.whitePiece = whitePiece;
    }

    //sets the board at the beginning of the game
    public void setBoard(){
        char xcord = 0;
        char ycord = 0;

        // need 8x8 grid of squares
        //for loop builds columns
        for(int x = 0; x <8; x++){
            //nested for loop builds rows
            for(int y = 0; y < 8; y++){




                //2d array of squares using 8x8 grid makes board
                //using each square made by the for loop and nested for loop to iterate through
                //all 64 squares of the board
                squares[x][y] = new Square();
            }
        }

        //for loop to cycle through rows to establish setup of board
        for(int x = 7; x >=0; x--){                                              //TYANG x = should act as rows
            //switch to establish each row                                      // Gets confused up in setting rows and etc
            switch(x){								//Rows stay the same!
                case 7:
                    //setting back row for black side
                    setBack(x, blackPiece,"B", false);
                    break;
                case 6:
                    //setting front row for black side
                    setFront(x, blackPiece, "B", false);
                    break;
                case 5:
                    //setting blank rows ↓
                    setBlanks(x);
                    break;
                case 4:
                    setBlanks(x);
                    break;
                case 3:
                    setBlanks(x);
                    break;
                case 2:
                    //setting blank rows ↑
                    setBlanks(x);
                    break;
                case 1:
                    //setting front row for white side
                    setFront(x, whitePiece,"W", true);
                    break;
                case 0:
                    //setting back row for white side
                    setBack(x, whitePiece, "W", true);
                    break;
            }
        }


    }


    //sets the front row of pieces
    public void setFront(int row, ArrayList<Piece> pieces, String color, Boolean isWhite){

        int xcord = row+1;
        char ycord = 0;

        /*
        if (row == 7)                                                           //TYANG Row = numbers not letters
        {
            ycord = 7;
        }
        if (row == 6)
        {
            ycord = 6;
        }
        if (row == 5)
        {
            ycord = 'C';
        }
        if (row == 4)
        {
            ycord = 'D';
        }
        if (row == 3)
        {
            ycord = 'E';
        }
        if (row == 2)
        {
            ycord = 'F';
        }
        if (row == 1)
        {
            ycord = 'G';
        }
        if (row == 0)
        {
            ycord = 'H';
        }
         */

        for(int y = 0; y <=7; y++){                                                     // TYANG increases from 0


            if (y == 0)                                                                 // Collumns = letters not numbers
            {
                ycord = 'A';
            }
            if (y == 1)
            {
                ycord = 'B';
            }
            if (y == 2)
            {
                ycord = 'C';
            }
            if (y == 3)
            {
                ycord = 'D';
            }
            if (y == 4)
            {
                ycord = 'E';
            }
            if (y == 5)
            {
                ycord = 'F';
            }
            if (y == 6)
            {
                ycord = 'G';
            }
            if (y == 7)
            {
                ycord = 'H';
            }



            //make piece object
            Pawn pawnPiece = new Pawn(y, row,"--" + color + "pawn-" +  ycord + "-" + xcord + "-",isWhite);
            //calls function and passes piece object with coordinates
            setPieceOnSquare(pawnPiece,y,row);
            //passes color and coordinates
            //thisPiece.setName("--" + color + "pawn-" +  ycord + "-" + xcord + "-");
            //keeps track of pieces in arraylist
            pieces.add(pawnPiece);
        }
    }



    //sets the back row pieces
    //as the order of the back row is the same for both the black and white
    //the function just has to cycle through the same order for both sides of the board
    public void setBack(int row, ArrayList<Piece> pieces, String color, Boolean isWhite){



        int ycord = row+1;
        char xcord = 0;

        /*
        if (row == 0)								//TYANG row = number
        {
            xcord = 'A';
        }
        if (row == 1)
        {
            xcord = 'B';
        }
        if (row == 2)
        {
            xcord = 'C';
        }
        if (row == 3)
        {
            xcord = 'D';
        }
        if (row == 4)
        {
            xcord = 'E';
        }
        if (row == 5)
        {
            xcord = 'F';
        }
        if (row == 6)
        {
            xcord = 'G';
        }
        if (row == 7)
        {
            xcord = 'H';
        }


         */


        //the order of the back row is rook, knight, bishop, queen, king, bishop, knight, rook, from left to right
        //so we used a switch to build each specific piece as the for loop iterates through each square
        for(int y = 0; y <=7; y++){                                                     // TYANG increases from 0

            if (y == 0)                                                                 // Collumns = letters not numbers
            {
                xcord = 'A';
            }
            if (y == 1)
            {
                xcord = 'B';
            }
            if (y == 2)
            {
                xcord = 'C';
            }
            if (y == 3)
            {
                xcord = 'D';
            }
            if (y == 4)
            {
                xcord = 'E';
            }
            if (y == 5)
            {
                xcord = 'F';
            }
            if (y == 6)
            {
                xcord = 'G';
            }
            if (y == 7)
            {
                xcord = 'H';
            }

            switch(y){
                case 0:
                    // creates piece object
                    Rook rookPiece = new Rook(y, row, "--" + color + "-rk1-" + xcord + "-" + ycord + "-", isWhite);
                    // calls function to set piece on the square while passing the object and coordinate
                    setPieceOnSquare(rookPiece,y, row);
                    //keeps track of pieces in arraylist
                    pieces.add(rookPiece);
                    break;

                //other cases do the same as this case, but for their respective pieces based on where they should be on the board
                case 1:
                    Knight knightPiece = new Knight(y, row, "--" + color + "-kn1-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(knightPiece,y, row);
                    //knightPiece.setName("--" + color + "-kn1-" + xcord + "-" + ycord + "-");
                    pieces.add(knightPiece);
                    break;
                case 2:
                    Bishop bishopPiece = new Bishop(y, row, "--" + color + "-bi1-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(bishopPiece,y, row);
                    //bishopPiece.setName("--" + color + "-bi1-" + xcord + "-" + ycord + "-");
                    pieces.add(bishopPiece);
                    break;
                case 3:
                    Queen queenPiece = new Queen(y, row, "--" + color + "-qu1-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(queenPiece,y, row);
                    //queenPiece.setName("--" + color + "-qu1-" + xcord + "-" + ycord + "-");
                    pieces.add(queenPiece);
                    break;
                case 4:
                    King kingPiece = new King(y, row, "--" + color + "-kg1-" + xcord + "-" + ycord + "-" , isWhite);
                    setPieceOnSquare(kingPiece,y, row);
                    //kingPiece.setName("--" + color + "-kg1-" + xcord + "-" + ycord + "-");
                    pieces.add(kingPiece);
                    break;
                case 5:
                    Bishop bishopPiece1 = new Bishop(y, row, "--" + color + "-bi2-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(bishopPiece1,y, row);
                    //bishopPiece1.setName("--" + color + "-bi2-" + xcord + "-" + ycord + "-");
                    pieces.add(bishopPiece1);
                    break;
                case 6:
                    Knight knightPiece1 = new Knight(y, row, "--" + color + "-kn2-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(knightPiece1,y, row);
                    //knightPiece1.setName("--" + color + "-kn2-" + xcord + "-" + ycord + "-");
                    pieces.add(knightPiece1);
                    break;
                case 7:
                    Rook rookPiece1 = new Rook(y, row, "--" + color + "-rk2-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(rookPiece1,y, row);
                    //rookPiece1.setName("--" + color + "-rk2-" + xcord + "-" + ycord + "-");
                    pieces.add(rookPiece1);
                    break;
            }

        }
    }


    //sets blank rows at the beginning of the game
    public void setBlanks(int row){

        int ycord = row+1;
        char xcord = 0;

        /*
        if (row == 0)								// TYANG row = number
        {
            ycord = 'A';
        }
        if (row == 1)
        {
            ycord = 'B';
        }
        if (row == 2)
        {
            ycord = 'C';
        }
        if (row == 3)
        {
            ycord = 'D';
        }
        if (row == 4)
        {
            ycord = 'E';
        }
        if (row == 5)
        {
            ycord = 'F';
        }
        if (row == 6)
        {
            ycord = 'G';
        }
        if (row == 7)
        {
            ycord = 'H';
        }
         */
        for(int y = 0; y <=7; y++){                                                     // TYANG increases from 0


            if (y == 0)                                                                 // Collumns = letters not numbers
            {
                xcord = 'A';
            }
            if (y == 1)
            {
                xcord = 'B';
            }
            if (y == 2)
            {
                xcord = 'C';
            }
            if (y == 3)
            {
                xcord = 'D';
            }
            if (y == 4)
            {
                xcord = 'E';
            }
            if (y == 5)
            {
                xcord = 'F';
            }
            if (y == 6)
            {
                xcord = 'G';
            }
            if (y == 7)
            {
                xcord = 'H';
            }


            //makes empty piece object                                                              // TYANG piece coord =
            Piece emptyPiece = new Piece(y, row,"____" + xcord + "--" + ycord + "____",false);
            //calls set function to pass empty piece and coordinates                            // can't be entirely null
            setPieceOnSquare(emptyPiece, y, row);                                               // since getName() is used to show board
            //sets the "blank" value of the empty piece
            //emptyPiece.setName("____" + ycord + "--" + xcord + "____");
            emptyPiece.setIsAlive(false);
        }
    }

    public int receiveMove(Piece piece, String input){
        int x = 0;
        int y = 0;

        return x + y;
    }


    //sets piece on square
    public void setPieceOnSquare(Piece piece, int x, int y) {           //TYNAG just understand where the piece is being placed
        //gets passed the piece and coordinates
        //then sets the the piece at the specific coordinate
        squares[x][y].setPiece(piece);                                  //
    }


    //remove pieces from board
    public void removePieceOnSpace(int x, int y){

        //TYANG remove pieces worked since
        char xcord = 0;                                                     // row wasn't confused
        int ycord = y+1;

        if (x == 0)
        {
            xcord = 'A';
        }
        if (x == 1)
        {
            xcord = 'B';
        }
        if (x == 2)
        {
            xcord = 'C';
        }
        if (x == 3)
        {
            xcord = 'D';
        }
        if (x == 4)
        {
            xcord = 'E';
        }
        if (x == 5)
        {
            xcord = 'F';
        }
        if (x == 6)
        {
            xcord = 'G';
        }
        if (x == 7)
        {
            xcord = 'H';
        }
        // TYANG issue resolved, reverted modified code
        try {
            //gets passed coordinates to tell what square to remove piece from
            //makes new piece object
            Piece emptyPiece = new Piece(x,y,"____" + xcord + "--" + ycord + "____",false);
            //calls set function to pass empty piece and coordinates                         // TYANG can't be entirely null
            setPieceOnSquare(emptyPiece,x, y);
            //sets the "blank" value of the empty piece
            //emptyPiece.setName("____" + xcord + "--" + ycord + "____");
            emptyPiece.setIsAlive(false);
            squares[x][y].setPiece(emptyPiece);
        } catch(ArrayIndexOutOfBoundsException e){

        }
    }

    //Display the board
    public ArrayList<Piece> showBoard(){


        ArrayList<Piece> tempList = new ArrayList<>();
        for(int y=7; y>=0; y--){                                                             //TYANG (0,7) start
            for(int x = 0; x<=7; x++){
                //displays the square in each column
                //System.out.print(squares[x][y].getPiece().getName());



                System.out.print(squares[x][y].getPiece().getName());
                if (squares[x][y].getPiece().getAlive() == true) {                // Need to declare what "piece"
                    tempList.add(squares[x][y].getPiece());                       // Can't directly access isAlive -> use piece.getAlive()
                }
            }
            //displays the square in each row
            //starts displaying a  new row of squares once
            // all previous squares were displayed in the previous row
            System.out.println();


            Piece piece = new Piece();                                          //TYANG NEED MANUAL RANGE UPDATE
            piece.updateRange(tempList);
        }
        return tempList;
    }


    public void resetBoard(){
        for(int x = 0; x <8; x++){
            //nested for loop to cycle through all rows and columns of board
            for(int y = 0; y < 8; y++){
                //remove all pieces on the board
                removePieceOnSpace(x, y);
            }
        }

        //set board back to beginning
        setBoard();
    }


    public void saveBoard(){
        ArrayList<Piece> tempList = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                tempList.add(squares[x][y].getPiece());
            }
        }
        try {
            XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("XMLFile.xml")));

            enc.writeObject(tempList);

            enc.close();
        } catch (Exception e) {
            System.out.println("Error occurred writing to file");
        }

    }

    public void loadBoard(){
        //Board boardReader = new Board();
        try {
            XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream("XMLFile.xml")));

            Board boardReader = (Board) dec.readObject();
            System.out.println();
            dec.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
