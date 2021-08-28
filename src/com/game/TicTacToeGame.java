package com.game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	private char[] board = new char[10];
	Random random = new Random();
	char userOption;
	char turnToPlay = 'P';
	char computerOption;
	int computerIndex;
	int flag = 0;
	int winnerStatus = 0 ;
	int tie = 0 ;
	int changeUserTurn = 0 ;
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
		if(turnToPlay == 'P') {
		int userIndex;
		System.out.println("Enter the index between 1-9");
		userIndex = scanner.nextInt();
		if (userIndex <= 0 || userIndex > 9)
			System.out.println("Enter valid index");
		else {
			checkEmpty(userIndex);
		}
	 }
  }

	/*
	 * usecase4 - Method to make computer move taking input from random function
	 * computer chooses index
	 */
	public void computerMove() {
		
		if(turnToPlay == 'C') {
		computerIndex = random.nextInt(9) + 1;
		if (board[computerIndex] == ' ') {
			System.out.println("Computer chose index "+computerIndex);
			board[computerIndex] = computerOption;
			//displayBoard();
			System.out.println();
		} 
		else {
			System.out.println("Sorry, Enter a different index number, this index number is not available.");
			computerMove();
		   }
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
	
	/*
	 * usecase 6 - method to perform toss and selecting whether user or computer plays first
	 * use random function to generate head or tail
	 */
	public void tossMethod()
	{
		System.out.println("1. Head\n2. Tail ");
		int userChoice=scanner.nextInt();							
		int toss = random.nextInt(2)+1;						
		
		if(userChoice == toss )
		{
			System.out.println("Player's Turn.");
			turnToPlay='P';
			userMove();
			turnToPlay='C';
			computerMove();

		}
		else
		{
			System.out.println("Computer's turn");
			turnToPlay = 'C';
			computerMove();
			turnToPlay='P';
			userMove();
			flag = 1;
			
		}
	}
	
	/* UseCase 7 - As player would expect the Tic Tac Toe App to determine after every move the winner or the tie or change the turn
	 * This method prints the Game statistics like the Winner, Tie or not and it helps in Changing the turn 
	 * Swapping is done in order to change the user turns.
	 */
	public void statistics()
	{
		Scanner sc = new Scanner(System.in);
		if(winnerStatus == 0)
			System.out.println("Winner: 0");
		else
			System.out.println("Winner: ");
		System.out.println("Tie Games: " + tie);
		System.out.println("Do you want to change turns? (Y/N):  ");
		char newUserOption = sc.next().charAt(0); 
		if(newUserOption == 'Y')
		{
			if(turnToPlay == 'P')
			{
				turnToPlay ='C';
				//Swapping userOption and ComputerOption
				int temp = userOption;
				userOption = computerOption;
				computerOption = userOption;
				displayBoard();
			}
			else
			{
				turnToPlay = 'P';
				//Swapping userOption and ComputerOption
				int temp = userOption;
				userOption = computerOption;
				computerOption = userOption;
				displayBoard();
			}
		}// end of 1st if
		
	}//end of method statistics
	 
}
