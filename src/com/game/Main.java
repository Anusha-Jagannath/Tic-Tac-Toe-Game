package com.game;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe game");
		TicTacToeGame game=new TicTacToeGame();
		game.createBoard();
		game.playerChoice();
		game.tossMethod();
		game.displayBoard();
		game.statistics();
//		game.userMove();
//		game.computerMove();
	}
}
