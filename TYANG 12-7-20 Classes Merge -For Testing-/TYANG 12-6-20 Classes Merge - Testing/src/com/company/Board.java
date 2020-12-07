// TYANG changes made to make it compatible with pieces class (for what is available)

package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Board {
    //2D array to make the 8 by 8 grid of the board
    Square [][] squares = new Square [8][8];

    //arraylist to store the black pieces
    ArrayList<Piece> blackPiece = new ArrayList<>();                    // TYANG - pieces are separate on Board
    //arraylist to store the white pieces                               // Would need to acknowledge this for pieces
    ArrayList<Piece> whitePiece = new ArrayList<>();                    // regarding range calculations/tracking
                                                                        // can be used to our advantage to speed up checks
    //board constructor
    public Board(){
        this.setBoard();
    }


    //sets the board at the beginning of the game
    public void setBoard(){
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

        // TYANG- merged duplicate cases, changed color string  -> boolean for pieces
        for(int x = 0; x< 8; x++){
            //switch to establish each row
            switch(x){
                case 0:
                    //setting back row for black side
                    setBack(x, blackPiece,false);
                    break;
                case 1:
                    //setting front row for black side
                    setFront(x, blackPiece, false);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    //setting blank rows
                    setBlanks(x);
                    break;
                case 6:
                    //setting front row for white side
                    setFront(x, whitePiece,true);
                    break;
                case 7:
                    //setting back row for white side
                    setBack(x, whitePiece, true);
                    break;
            }
        }


    }


    //sets the front row of pieces

    //TYANG - PLACEHOLDER FOR PAWNS = ROOKS, PAWNS = INCOMPATIBLE W/ PIECES CLASS FOR NOW
    // placeholder = to declare color since it's a boolean in Pieces class rather than a string
    public void setFront(int row, ArrayList<Piece> pieces, boolean color){

        // TYANG For declaring color since it's a boolean in Pieces ^^
        char placeholder;
        if (color == false)
        {
            placeholder = 'B';
        }else{
            placeholder = 'W';
        }

        for(int y = 0; y < 8; y++){
            //make piece object
            Rook thisPiece = new Rook(row,y,"--" + placeholder +"-PN-"+ row +"-" + y +"-",color);
            //calls function and passes piece object with coordinates
            setPieceOnSquare(thisPiece,row,y);
            //passes color and coordinates
            //thisPiece.setType("--" + color + "pawn-" +  row + "-" + y + "-");
            //keeps track of pieces in arraylist
            pieces.add(thisPiece);
        }
    }



    //sets the back row pieces
    //as the order of the back row is the same for both the black and white
    //the function just has to cycle through the same order for both sides of the board

    //TYANG = change to boolean, formatting was attempted
    // merged switch case statements
    // set.name no longer needed as it can be created on construction, also it's now getType
    // placeholder = to declare color since it's a boolean in Pieces class rather than a string
    public void setBack(int row, ArrayList<Piece> pieces, Boolean color){
        //the order of the back row is rook, knight, bishop, queen, king, bishop, knight, rook, from left to right
        //so we used a switch to build each specific piece as the for loop iterates through each square
        for(int y = 0; y < 8; y++){

            // TYANG For declaring color since it's a boolean in Pieces
            char placeholder;
            if (color == false)
            {
                placeholder = 'B';
            }else{
                placeholder = 'W';
            }

            switch(y){
                case 0:
                case 7:
                    // creates piece object
                    Rook rookPiece = new Rook(row,y,"--" + placeholder +"-RK-"+ row +"-" + y +"-",color);
                    // calls function to set piece on the square while passing the object and coordinate
                    setPieceOnSquare(rookPiece,row,y);
                    //sets the falue of the piece
                    //rookPiece.setName("--" + color + "-rk1-" + row + "-" + y + "-");
                    //keeps track of pieces in arraylist
                    pieces.add(rookPiece);
                    break;

                    //other cases do the same as this case, but for their respective pieces based on where they should be on the board
                case 1:
                case 6:
                    Knight knightPiece = new Knight(row,y,"--" + placeholder +"-KN-"+ row +"-" + y +"-",color);
                    setPieceOnSquare(knightPiece,row,y);
                    //knightPiece.setName("--" + color + "-kn1-" + row + "-" + y + "-");
                    pieces.add(knightPiece);
                    break;
                case 2:
                case 5:
                    Bishop bishopPiece = new Bishop(row,y,"--" + placeholder +"-BI-"+ row +"-" + y +"-",color);
                    setPieceOnSquare(bishopPiece,row,y);
                    //bishopPiece.setName("--" + color + "-bi1-" + row + "-" + y + "-");
                    pieces.add(bishopPiece);
                    break;
                case 3:
                    Queen queenPiece = new Queen(row,y,"--" + placeholder +"-QU-"+ row +"-" + y +"-",color);
                    setPieceOnSquare(queenPiece,row,y);
                    //queenPiece.setName("--" + color + "-qu1-" + row + "-" + y + "-");
                    pieces.add(queenPiece);
                    break;
                case 4:
                    King kingPiece = new King(row,y,"--" + placeholder +"-KG-"+ row +"-" + y +"-",color);
                    setPieceOnSquare(kingPiece,row,y);
                    //kingPiece.setName("--" + color + "-kg1-" + row + "-" + y + "-");
                    pieces.add(kingPiece);
                    break;
            }

        }
    }


    //sets blank rows at the beginning of the game

    //TYANG - PLACEHOLDER ROOK FOR EMPTY PIECE SINCE ABSTRACT PIECES
    // formatting attempted to follow
    public void setBlanks(int row){
        for(int y = 0; y < 8; y++) {
            //makes empty piece object
            Rook emptyPiece = new Rook(row,y,"____" + row + "-" + y + "____",false);
            //calls set function to pass empty piece and coordinates
            setPieceOnSquare(emptyPiece, row, y);
            //sets the "blank" value of the empty piece
            //emptyPiece.setName("____" + row + "--" + y + "____");
        }
    }


    //sets piece on square
    public void setPieceOnSquare(Piece piece, int x, int y) {
        //gets passed the piece and coordinates
        //then sets the the piece at the specific coordinate
        squares[x][y].setPiece(piece);
    }


    //remove pieces from board

    //TYANG - PLACEHOLDER DECLARATION OF EMPTY PIECE AS ROOK + NOT CHANGING ARRAY
    public void removePieceOnSpace(int x, int y){
        //gets passed coordinates to tell what square to remove piece from
        //makes new piece object
        Rook emptyPiece = new Rook(x,y,"____" + x + "-" + y + "____",false);
        emptyPiece.setIsAlive(false);
        //sets the object as blank instead of as a piece
        //emptyPiece.setName("__" + x + "-" + y + "__");
        //sets the blank object to the specific square
        squares[x][y].setPiece(emptyPiece);
    }

    //Display the board

    //TYANG - getName() -> getType()
    public ArrayList<Piece> showBoard(){
        ArrayList<Piece> tempList = new ArrayList<>();
        for(int x=0; x<8; x++){
            for(int y = 0; y<8; y++){
                //displays the square in each column
                System.out.print(squares[x][y].getPiece().getType());
                tempList.add(squares[x][y].getPiece());
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
}

