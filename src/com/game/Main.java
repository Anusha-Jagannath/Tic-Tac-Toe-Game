package com.game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe game");
		TicTacToeGame game=new TicTacToeGame();
		game.gameFlow();
//		game.createBoard();
//		game.playerChoice();
//		game.tossMethod();
//		game.displayBoard();
//		game.statistics();
//		game.userMove();
//		game.computerMove();
		System.out.println("Want to play the again ?\n1. Yes\n2. No");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if(choice == 1)
			game.gameFlow();
		else
			System.out.println("Thank you for playing");
	}
}
