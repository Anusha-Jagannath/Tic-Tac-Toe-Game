package com.game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	private char[] board = new char[10];
	char userOption;
	char computerOption;
	Scanner scanner = new Scanner(System.in);

	public void createBoard() {
		for (int i = 1; i < 10; i++)
			board[i] = ' ';
	}

	public void playerChoice() {
		// ask for user inputs
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter player name : ");
		String name = sc.nextLine();
		System.out.println("Enter player's choice X or Y");
		userOption = sc.next().charAt(0);
		if (userOption == 'X' || userOption == 'x') {
			userOption = 'X';
			computerOption = 'O';
			System.out.println("Player Team: " + userOption);
			System.out.println("Computer Team: " + computerOption);
		} else {
			userOption = 'O';
			computerOption = 'X';
			System.out.println("Player Team: " + userOption);
			System.out.println("Computer Team: " + computerOption);
		}
	}

	/*
	 * UseCase 3 - Method to display the board For loop helps in displaying the
	 * available spaces for the user to make a move
	 */
	public void displayBoard() {
		for (int i = 1; i < 10; i += 3) {
			System.out.println(board[i] + " | " + board[i + 1] + " | " + board[i + 2]);
			System.out.println("--------- ");
		}
	}

	/*
	 * usecase4 - Method to make user move taking index value from the user checking
	 * if index value is valid or not
	 */
	public void userMove() {
		int userIndex;
		System.out.println("Enter the index between 1-9");
		userIndex = scanner.nextInt();
		if (userIndex <= 0 || userIndex > 9)
			System.out.println("Enter valid index");
		else {
			checkEmpty(userIndex);
		}
	}

	/*
	 * usecase4 - Method to make computer move taking input from random function
	 * computer chooses index
	 */
	public void computerMove() {
		Random random = new Random();
		int computerIndex = random.nextInt(9) + 1;
		if (board[computerIndex] == ' ') {
			System.out.println("Computer chose index "+computerIndex);
			board[computerIndex] = computerOption;
			displayBoard();
			System.out.println();
		} else {
			System.out.println("Sorry, Enter a different index number, this index number is not available.");
			computerMove();
		}

	}

	/*
	 * usecase 5 - method to check if cell is free or not cell is free then assign
	 * user option else ask for input again
	 */
	public void checkEmpty(int indexNumber) {
		if (board[indexNumber] == ' ') {
			board[indexNumber] = userOption;
		} else {
			System.out.println("Sorry, Enter a different index number, this index number is not available.");
			userMove();
		}
		
	}
}
