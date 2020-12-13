package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private String input;
    public Scanner scan;
    Piece piece;
    Player player;

    public Input(Player player){
        this.player = player;
    }
    public Input(){
    }
    public String getInput(ArrayList<Piece> arr, Board board, King myKing) {
        scan = new Scanner(System.in);
        System.out.print(this.player.getName() +" User Input: ");
        this.input = scan.nextLine();
        boolean validCheck = false;
        boolean validMove = false;
        validCheck = validInput(this.input);
        if(validCheck){
            validMove = isValidMove(arr, board, this.input, myKing);
        }
        while(!validCheck || !validMove){
            System.out.print(this.player.getName() +" User Input: ");
            this.input = scan.nextLine();
            validCheck = validInput(this.input);
            if(validCheck){
                validMove = isValidMove(arr, board, this.input, myKing);
            }
            
        }
        
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }
    

    public boolean validInput(String input) {
        //testing if length of input is not equal to 4 (should be coord 1 then coord 2, aka e2e4 a2c3, etc), OR if the letters are not between a and h, OR if the numbers are not between 1 and 8
        if (input.length() != 4){
            System.out.print("\nInvalid Input\n\n");
            return false;
        }
        //using ascii code for this part
        else if (input.charAt(0) < 97 || input.charAt(0) > 104 || input.charAt(1) < 49 || input.charAt(1) > 56 || input.charAt(2) < 97 || input.charAt(2) > 104 || input.charAt(3) < 49 || input.charAt(3) > 56){
            System.out.print("\nInvalid Input\n\n");
            return false;
        }
        else {
            //printing out coords
            //System.out.print("\nX COORD 1: " + (input.charAt(0) - 97) + "\nY COORD 1: " + (input.charAt(1) - 49) + "\nX COORD 2: " + (input.charAt(2) - 97) + "\nY COORD 2: " + (input.charAt(3) - 49) + "\n");
            return true;
        }
    }

    public boolean isValidMove(ArrayList<Piece> arr, Board board, String input, King myKing){
        int[] inverseBoard = new int[]{7,6,5,4,3,2,1,0};                //7,6,5,4,3,2,1,0

        System.out.println(input);
        int value1 = input.charAt(0) - 97;
        int value2 = input.charAt(1) - 49;
        int value3 = input.charAt(2) - 97;
        int value4 = input.charAt(3) - 49;
        System.out.println(value1+" " + value2 +" "+ value3 +" "+ value4);

        Boolean valid = false;
        // Initial location of the piece
        int xCoordOne = inverseBoard[value2];
        int yCoordOne = value1;
        // Final location of the piece
        int xCoordTwo = inverseBoard[value4];
        int yCoordTwo = value3;
        System.out.println(xCoordOne +" "+ yCoordOne +" "+ xCoordTwo +" "+ yCoordTwo);

        // Finding the piece
        Piece myPiece = new Piece();
        myPiece = board.squares[xCoordOne][yCoordOne].getPiece();

        myPiece.updateRange(arr);

        for (int[] coordinate : myPiece.range) {
            if (coordinate[0] == xCoordTwo && coordinate[1] == yCoordTwo) {
                if(board.squares[xCoordOne][yCoordOne].getPiece().getColor() == this.player.getIsWhite())
                    valid = true;
                else{System.out.println("Not your piece");}
                
            }
        }
        myPiece.updateRange(arr);

        if (myKing.kingCheck(arr) == true)
        {
            System.out.println("Invalid move, king will be in check");
            valid = false;
        }                                               //TYANG whitePiece is never updated on Board side, only temporary array at show board
        if(board.whitePiece.contains(piece)){

        }

        if(valid == false){
            System.out.println("move not in range");
        }
        return valid;
    }

    public void updateBoard(ArrayList<Piece> arr, Board board, King myKing){
        int[] inverseBoard = new int[]{7,6,5,4,3,2,1,0};
        int value1 = input.charAt(0) - 97;
        int value2 = input.charAt(1) - 49;
        int value3 = input.charAt(2) - 97;
        int value4 = input.charAt(3) - 49;

        // Initial location of the piece
        int xCoordOne = inverseBoard[value2];
        int yCoordOne = value1;
        // Final location of the piece
        int xCoordTwo = inverseBoard[value4];
        int yCoordTwo = value3;
                                                                            // TYANG name of piece is not updated
        Piece myPiece = new Piece();
        myPiece = board.squares[xCoordOne][yCoordOne].getPiece();
        myPiece.moveTo(xCoordTwo, yCoordTwo, myKing, arr);
        board.setPieceOnSquare(myPiece, xCoordTwo, yCoordTwo);
        board.removePieceOnSpace(xCoordOne, yCoordOne);

        
    } 
}
