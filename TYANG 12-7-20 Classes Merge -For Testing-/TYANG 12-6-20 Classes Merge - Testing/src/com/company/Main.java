// TYANG 12-6-20 7:14 PM merge attempt of Board + Pieces for testing, compatibility needed
// EXAMPLE self test w/ botched merging of all code so we can test w/o "errors"

package com.company;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
    	/*
		Game game = new Game();
		game.start();
		*/


		Board board = new Board();
		board.showBoard();

		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		board.removePieceOnSpace(0,0);
		board.showBoard();

		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		board.resetBoard();
		board.showBoard();

		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		// error for out of bounds
		//int two = 9;
		int two = 2;
		Rook crook = new Rook(two,two,"--W-RK-"+ two +"-" + two +"-",true);
		board.setPieceOnSquare(crook,two,two);
		board.showBoard();

		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");


		for (Piece pieces : board.blackPiece){
			System.out.println(pieces.getType());
		}

		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		for (Piece pieces : board.whitePiece){
			System.out.println(pieces.getType());
		}

		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		for (int x = 0; x <8; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				board.removePieceOnSpace(x,y);
			}
		}
		board.showBoard();

		// Board doesn't keep track of deleting pieces just yet, so manual ArrayList of pieces
		ArrayList<Piece> pieces = new ArrayList<>();

		Rook rook = new Rook(4,3,"--B-RK-4-3-",false);
		board.setPieceOnSquare(rook,4,3);
		pieces.add(rook);
		rook.print();

		// range = [0] = x coord, [1] = y coord
		rook.getRange(pieces);
		for (int[] i: rook.range)
		{
			System.out.println(i[0] + "," + i[1]);
		}

		King king = new King(0,3,"--W-KG-0-3-",true);
		pieces.add(king);
		board.setPieceOnSquare(king,0,3);

		// King getRange checks outside of array box
		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		board.showBoard();
		king.print();
		king.getRange(pieces);
		for (int[] i: king.range)
		{
			System.out.println(i[0] + "," + i[1]);
		}


		// getRange does not clear range - mentioned from Adrian
		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		board.showBoard();
		rook.getRange(pieces);
		for (int[] i: rook.range)
		{
			System.out.println(i[0] + "," + i[1]);
		}
	}
}
