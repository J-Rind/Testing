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
        for(int x = 0; x< 8; x++){

            //switch to establish each row
            switch(x){
                case 0:
                    //setting back row for black side
                    setBack(x,blackPiece,"B", false);
                    break;
                case 1:
                    //setting front row for black side
                    setFront(x, blackPiece, "B", false);
                    break;
                case 2:
                    //setting blank rows ↓
                    setBlanks(x);
                    break;
                case 3:
                    setBlanks(x);
                    break;
                case 4:
                    setBlanks(x);
                    break;
                case 5:
                    //setting blank rows ↑
                    setBlanks(x);
                    break;
                case 6:
                    //setting front row for white side
                    setFront(x,whitePiece,"W", true);
                    break;
                case 7:
                    //setting back row for white side
                    setBack(x, whitePiece, "W", true);
                    break;
            }
        }


    }


    //sets the front row of pieces
    public void setFront(int row, ArrayList<Piece> pieces, String color, Boolean isWhite){

        char xcord = 0;
        char ycord = 0;

        for(int y = 0; y < 8; y++){

            if (row == 0)                                     //TYANG should be based on the X rather than y
            {
                ycord = '8';
                xcord = 'H';                                  // MERGED IF STATEMENTS ->
            }
            if (row == 1)
            {
                ycord = '7';
                xcord = 'G';
            }
            if (row == 2)
            {
                ycord = '6';
                xcord = 'F';
            }
            if (row == 3)
            {
                ycord = '5';
                xcord = 'E';
            }
            if (row == 4)
            {
                ycord = '4';
                xcord = 'D';
            }
            if (row == 5)
            {
                ycord = '3';
                xcord = 'C';
            }
            if (row == 6)
            {
                ycord = '2';
                xcord = 'B';
            }
            if (row == 7)
            {
                ycord = '1';
                xcord = 'A';

            }

                                                // TYANG Pawns need to be created like other pieces (UNKOWN AT THE TIME)

            //make piece object
            Pawn pawnPiece = new Pawn(row, y,"--" + color + "pawn-" +  xcord + "-" + ycord + "-",isWhite);
            //calls function and passes piece object with coordinates
            setPieceOnSquare(pawnPiece,row,y);
            //passes color and coordinates
            //thisPiece.setName("--" + color + "pawn-" +  xcord + "-" + ycord + "-");
            //keeps track of pieces in arraylist
            pieces.add(pawnPiece);
        }
    }



    //sets the back row pieces
    //as the order of the back row is the same for both the black and white
    //the function just has to cycle through the same order for both sides of the board
    public void setBack(int row, ArrayList<Piece> pieces, String color, Boolean isWhite){



        char xcord = 0;
        char ycord = 0;

        //the order of the back row is rook, knight, bishop, queen, king, bishop, knight, rook, from left to right
        //so we used a switch to build each specific piece as the for loop iterates through each square
        for(int y = 0; y < 8; y++){

            if (row == 0)                                     //TYANG should be based on the X rather than y
            {
                ycord = '8';
                xcord = 'H';                                  // MERGED IF STATEMENTS ->
            }
            if (row == 1)
            {
                ycord = '7';
                xcord = 'G';
            }
            if (row == 2)
            {
                ycord = '6';
                xcord = 'F';
            }
            if (row == 3)
            {
                ycord = '5';
                xcord = 'E';
            }
            if (row == 4)
            {
                ycord = '4';
                xcord = 'D';
            }
            if (row == 5)
            {
                ycord = '3';
                xcord = 'C';
            }
            if (row == 6)
            {
                ycord = '2';
                xcord = 'B';
            }
            if (row == 7)
            {
                ycord = '1';
                xcord = 'A';

            }

            switch(y){
                case 0:
                    // creates piece object
                    Rook rookPiece = new Rook(row, y, "--" + color + "-rk1-" + xcord + "-" + ycord + "-", isWhite);
                    // calls function to set piece on the square while passing the object and coordinate
                    setPieceOnSquare(rookPiece,row,y);
                    //keeps track of pieces in arraylist
                    pieces.add(rookPiece);
                    break;

                //other cases do the same as this case, but for their respective pieces based on where they should be on the board
                case 1:
                    Knight knightPiece = new Knight(row, y, "--" + color + "-kn1-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(knightPiece,row,y);
                    //knightPiece.setName("--" + color + "-kn1-" + xcord + "-" + ycord + "-");
                    pieces.add(knightPiece);
                    break;
                case 2:
                    Bishop bishopPiece = new Bishop(row, y, "--" + color + "-bi1-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(bishopPiece,row,y);
                    //bishopPiece.setName("--" + color + "-bi1-" + xcord + "-" + ycord + "-");
                    pieces.add(bishopPiece);
                    break;
                case 3:
                    Queen queenPiece = new Queen(row, y, "--" + color + "-qu1-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(queenPiece,row,y);
                    //queenPiece.setName("--" + color + "-qu1-" + xcord + "-" + ycord + "-");
                    pieces.add(queenPiece);
                    break;
                case 4:
                    King kingPiece = new King(row, y, "--" + color + "-kg1-" + xcord + "-" + ycord + "-" , isWhite);
                    setPieceOnSquare(kingPiece,row,y);
                    //kingPiece.setName("--" + color + "-kg1-" + xcord + "-" + ycord + "-");
                    pieces.add(kingPiece);
                    break;
                case 5:
                    Bishop bishopPiece1 = new Bishop(row, y, "--" + color + "-bi2-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(bishopPiece1,row,y);
                    //bishopPiece1.setName("--" + color + "-bi2-" + xcord + "-" + ycord + "-");
                    pieces.add(bishopPiece1);
                    break;
                case 6:
                    Knight knightPiece1 = new Knight(row, y, "--" + color + "-kn2-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(knightPiece1,row,y);
                    //knightPiece1.setName("--" + color + "-kn2-" + xcord + "-" + ycord + "-");
                    pieces.add(knightPiece1);
                    break;
                case 7:
                    Rook rookPiece1 = new Rook(row, y, "--" + color + "-rk2-" + xcord + "-" + ycord + "-", isWhite);
                    setPieceOnSquare(rookPiece1,row,y);
                    //rookPiece1.setName("--" + color + "-rk2-" + xcord + "-" + ycord + "-");
                    pieces.add(rookPiece1);
                    break;
            }

        }
    }


    //sets blank rows at the beginning of the game
    public void setBlanks(int row){

        char xcord = 0;
        char ycord = 0;

        for(int y = 0; y < 8; y++) {

            if (row == 0)                                     //TYANG should be based on the X rather than y
            {
                ycord = '8';
                xcord = 'H';                                  // MERGED IF STATEMENTS ->
            }
            if (row == 1)
            {
                ycord = '7';
                xcord = 'G';
            }
            if (row == 2)
            {
                ycord = '6';
                xcord = 'F';
            }
            if (row == 3)
            {
                ycord = '5';
                xcord = 'E';
            }
            if (row == 4)
            {
                ycord = '4';
                xcord = 'D';
            }
            if (row == 5)
            {
                ycord = '3';
                xcord = 'C';
            }
            if (row == 6)
            {
                ycord = '2';
                xcord = 'B';
            }
            if (row == 7)
            {
                ycord = '1';
                xcord = 'A';

            }


            //makes empty piece object                                                          // TYANG ISSUES HERE
            Piece emptyPiece = new Piece(row,y,"____" + xcord + "--" + ycord + "____",false);
            //calls set function to pass empty piece and coordinates                            // can't be entirely null
            setPieceOnSquare(emptyPiece, row, y);                                               // since getName() is used to show board
            //sets the "blank" value of the empty piece
            //emptyPiece.setName("____" + xcord + "--" + ycord + "____");
                                                                                                //emptyPiece.setIsAlive(false);
        }
    }

    public int receiveMove(Piece piece, String input){
        int x = 0;
        int y = 0;








        return x + y;
    }


    //sets piece on square
    public void setPieceOnSquare(Piece piece, int x, int y) {
        //gets passed the piece and coordinates
        //then sets the the piece at the specific coordinate
        squares[x][y].setPiece(piece);
    }


    //remove pieces from board
    public void removePieceOnSpace(int x, int y){


        char xcord = 0;
        char ycord = 0;

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

        if (y == 0)
        {
            ycord = '1';
        }
        if (y == 1)
        {
            ycord = '2';
        }
        if (y == 2)
        {
            ycord = '3';
        }
        if (y == 3)
        {
            ycord = '4';
        }
        if (y == 4)
        {
            ycord = '5';
        }
        if (y == 5)
        {
            ycord = '6';
        }
        if (y == 6)
        {
            ycord = '7';
        }
        if (y == 7)
        {
            ycord = '8';
        }

        try {
            //gets passed coordinates to tell what square to remove piece from
            //makes new piece object
            Piece emptyPiece = new Piece();
            //sets the object as blank instead of as a piece
            emptyPiece.setName("__" + xcord + "-" + ycord + "__");
                                                                                    // TYANG - Issue w/ isAlive() status
            emptyPiece.setIsAlive(false);                                           // Would also need to set to false
            //sets the blank object to the specific square
            squares[x][y].setPiece(emptyPiece);
        } catch(ArrayIndexOutOfBoundsException e){

        }
    }

    //TYANG Display Board doesn't work, not sure what it's meant to be doing

    //Display the board
    public ArrayList<Piece> showBoard(){


        ArrayList<Piece> tempList = new ArrayList<>();
        for(int x=0; x<8; x++){
            for(int y = 0; y<8; y++){
                //displays the square in each column
                //System.out.print(squares[x][y].getPiece().getName());


                System.out.print(squares[x][y].getPiece().getName());             //TYANG ISSUES HERE
                if (squares[x][y].getPiece().getAlive() == true) {                // Need to declare what "piece"
                    tempList.add(squares[x][y].getPiece());                       // Can't directly access isAlive -> use piece.getAlive()
                }                                                                 // Unable to show Null, empty pieces
            }
            //displays the square in each row
            //starts displaying a  new row of squares once
            // all previous squares were displayed in the previous row
            System.out.println();
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

