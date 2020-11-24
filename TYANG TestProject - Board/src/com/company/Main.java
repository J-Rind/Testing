//11-23-20 Tyler Yang Board Test
// ** Error handling that could be accounted for

package com.company;

public class Main {

    public static void main(String[] args) {

        // Default constructor sets board automatically
        Board newBoard = new Board();
        newBoard.showBoard();

        // Print out blackPiece and whitePiece ArrayLists
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        for (Piece piece: newBoard.blackPiece)
        {
            System.out.print(piece.getName() + ", ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        for (Piece piece: newBoard.whitePiece)
        {
            System.out.print(piece.getName() + ", ");
        }
        System.out.println();


        // Set board again
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        newBoard.setBoard();
        newBoard.showBoard();

        // Check Array list after again after setting the board
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        for (Piece piece: newBoard.blackPiece)
        {
            System.out.print(piece.getName() + ", ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        for (Piece piece: newBoard.whitePiece)
        {
            System.out.print(piece.getName() + ", ");
        }
        System.out.println();

        // Checking removing pieces
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        //newBoard.removePieceOnSpace(2,-1);         ** No error checking for out of bounds removal
        newBoard.removePieceOnSpace(0,0);
        newBoard.showBoard();

        // Checking piece placement
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        Piece testPiece = new Piece();
        testPiece.setName("--OP-0-");
        //newBoard.setPieceOnSquare(testPiece,-1,-2);      ** No Error checking for out of bounds placement
        newBoard.setPieceOnSquare(testPiece,2,0);
        newBoard.showBoard();

        // Checking remove all pieces and adding pieces to all squares
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        for (int x = 0; x <8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                newBoard.removePieceOnSpace(x,y);
            }
        }
        newBoard.showBoard();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        for (int x = 0; x <8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                newBoard.setPieceOnSquare(testPiece,x,y);
            }
        }
        newBoard.showBoard();

        // Check Array list after again after removal
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        for (Piece piece: newBoard.blackPiece)
        {
            System.out.print(piece.getName() + ", ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        for (Piece piece: newBoard.whitePiece)
        {
            System.out.print(piece.getName() + ", ");
        }
        System.out.println();
    }
}
