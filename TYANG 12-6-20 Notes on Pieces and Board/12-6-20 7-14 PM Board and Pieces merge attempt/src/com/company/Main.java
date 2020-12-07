// TYANG 12-6-20 7:14 PM merge attempt of Board + Pieces for testing, compatibility needed

package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
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
	}
}
