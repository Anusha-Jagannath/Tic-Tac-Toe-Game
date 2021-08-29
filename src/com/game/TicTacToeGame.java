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
	int userIndex;
	int flag = 0;
	int winnerStatus = 0;
	int tie = 0;
	int changeUserTurn = 0;
	int count = 0;
	int arrCorners[] = {1,3,7,9};
	int[] arrSides = { 2,4,6,8 };
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
		if (turnToPlay == 'P') {

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
//	public void computerMove() {
//		
//		if(turnToPlay == 'C') {
//		computerIndex = random.nextInt(9) + 1;
//		if (board[computerIndex] == ' ') {
//			System.out.println("Computer chose index "+computerIndex);
//			board[computerIndex] = computerOption;
//			//displayBoard();
//			System.out.println();
//		} 
//		else {
//			System.out.println("Sorry, Enter a different index number, this index number is not available.");
//			computerMove();
//		   }
//		}	
//
//	}

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
	 * usecase 6 - method to perform toss and selecting whether user or computer
	 * plays first use random function to generate head or tail
	 */
	public void tossMethod() {
		System.out.println("1. Head\n2. Tail ");
		int userChoice = scanner.nextInt();
		int toss = random.nextInt(2) + 1;

		if (userChoice == toss) {
			System.out.println("Player's Turn.");
			turnToPlay = 'P';
			//userMove();
			//turnToPlay = 'C';
			//computerMove();

		} else {
			System.out.println("Computer's turn");
			turnToPlay = 'C';
			//computerMove();
			//turnToPlay = 'P';
			//userMove();
			flag = 1;

		}
	}

	/*
	 * UseCase 7 - As player would expect the Tic Tac Toe App to determine after
	 * every move the winner or the tie or change the turn This method prints the
	 * Game statistics like the Winner, Tie or not and it helps in Changing the turn
	 * Swapping is done in order to change the user turns.
	 */
	public void statistics() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to change turns? (Y/N):  ");
		char newUserOption = sc.next().charAt(0);
		if (newUserOption == 'Y') {
			for (int row = 1; row < 9; row++) {
				String line = null;

				switch (row) {
				case 1:
					line = "" + board[1] + board[2] + board[3];
					break;
				case 2:
					line = "" + board[4] + board[5] + board[6];
					break;
				case 3:
					line = "" + board[7] + board[8] + board[9];
					break;
				case 4:
					line = "" + board[1] + board[4] + board[7];
					break;
				case 5:
					line = "" + board[2] + board[5] + board[8];
					break;
				case 6:
					line = "" + board[3] + board[5] + board[9];
					break;
				case 7:
					line = "" + board[1] + board[5] + board[9];
					break;
				case 8:
					line = "" + board[3] + board[5] + board[7];
					break;
				}
				// For winner
				if (line.equals("XXX") || line.equals("OOO")) {
					winnerStatus = 1;
				}

			}
			int i = 1;
			for (i = 1; i < board.length; i++) {
				if (board[i] == ' ')
					break;
			}
			if (i == 10)
				tie = 1;
			if (winnerStatus == 1) // check for winner
			{
				if (turnToPlay == 'C')
					System.out.println("Computer has won the game.");
				else
					System.out.println("Congratulations, You won the game");
			} else if (tie == 1) // check for tie
			{
				System.out.println("It's a draw.");
			} else // change the turn
			{
				if (turnToPlay == 'C') {
					turnToPlay = 'P';
					System.out.println("Player's turn to play");
					userMove();
				} else {
					turnToPlay = 'C';
					System.out.println("Computer's turn to play");
					computerMove();
				}

			}

		} // end of 1st if

	}// end of method statistics

	/*
	 * UseCase 8 - On Computer getting its turn would like the computer to play like
	 * me
	 * 
	 */
//	public void computerMove()
//	{
//		computerIndex = random.nextInt(9) + 1;
//		count=1;
//		do {
//			occupyCorner();
//		} while (board[computerIndex]!=' ');
//
//		board[computerIndex] = computerOption;
//		displayBoard();
//		userMove();
//    }  

	/*
	 * UseCase 8 - On Computer getting its turn would like the computer to play like
	 * me UseCase 9 - computer blocking cells by not allowing player to win
	 */
	public void computerMove() {
		if ((board[1] == ' ') && (board[2] == board[3] && board[2] == computerOption)
				|| (board[4] == board[7] && board[4] == computerOption)
				|| (board[5] == board[9] && board[5] == computerOption)) {
			board[1] = computerOption;
			System.out.println("Computer chose index 1");

		} else if ((board[2] == ' ') && (board[1] == board[3] && board[1] == computerOption)
				|| (board[5] == board[8] && board[8] == computerOption)) {
			board[2] = computerOption;
			System.out.println("Computer chose index 2");

		} else if ((board[3] == ' ') && (board[2] == board[1] && board[2] == computerOption)
				|| (board[5] == board[7] && board[5] == computerOption)
				|| (board[6] == board[9] && board[6] == computerOption)) {
			board[3] = computerOption;
			System.out.println("Computer chose index 3");

		} else if ((board[4] == ' ') && (board[1] == board[7] && board[1] == computerOption)
				|| (board[5] == board[6] && board[5] == computerOption)) {
			board[4] = computerOption;
			System.out.println("Computer chose index 4");

		} else if ((board[5] == ' ') && (board[2] == board[8] && board[2] == computerOption)
				|| (board[4] == board[6] && board[4] == computerOption)
				|| (board[1] == board[9] && board[9] == computerOption)
				|| (board[7] == board[3] && board[3] == computerOption)) {
			board[5] = computerOption;
			System.out.println("Computer chose index 5");

		} else if ((board[6] == ' ') && (board[9] == board[3] && board[3] == computerOption)
				|| (board[4] == board[5] && board[4] == computerOption)) {
			board[6] = computerOption;
			System.out.println("Computer chose index 6");

		} else if ((board[7] == ' ') && (board[1] == board[4] && board[1] == computerOption)
				|| (board[5] == board[3] && board[3] == computerOption)
				|| (board[8] == board[9] && board[9] == computerOption)) {
			board[7] = computerOption;
			System.out.println("Computer chose index 7");

		} else if ((board[8] == ' ') && (board[2] == board[5] && board[2] == computerOption)
				|| (board[9] == board[7] && board[7] == computerOption)) {
			board[8] = computerOption;
			System.out.println("Computer chose index 8");

		} else if ((board[9] == ' ') && (board[6] == board[3] && board[3] == computerOption)
				|| (board[8] == board[7] && board[7] == computerOption)
				|| (board[5] == board[1] && board[5] == computerOption)) {
			board[9] = computerOption;
			System.out.println("Computer chose index 9");

		}
		//usecase 10 - neither of us are winning then computer should take one of the available corners
		else
		{
			//checking for corner values usecase10
			
			int flag1 = 0;
			for(int i=0;i<4;i++)
			{
				if(board[arrCorners[i]]==' ')
					{
					board[arrCorners[i]]=computerOption;
					System.out.println("Computer chose index "+i);
					flag1=1;
					break;
					}
			}
			
			//checking for center and remaining values usecase11
			if(flag1==0 )
				{
				if(board[5]==' ')
					board[5]=computerOption;
				else
				{
					
					for(int i=0;i<4;i++)
					{
						if(board[arrSides[i]]==' ')
							{
							board[arrSides[i]]=computerOption;
							System.out.println("Computer chose index "+i);
							break;
							}
					}//end of for
				}
			}//end of if of UC11
		}//end of main else
	}
		
	// This method defines the conditions for a win
	public char getWinner() {
		String line = null;

		// to check if there is an winning situation
		for (int a = 1; a < 10; a++) {

			switch (a) {
			case 1:
				line = "" + board[1] + board[2] + board[3];
				break;
			case 2:
				line = "" + board[4] + board[5] + board[6];
				break;
			case 3:
				line = "" + board[7] + board[8] + board[9];
				break;
			case 4:
				line = "" + board[1] + board[4] + board[7];
				break;
			case 5:
				line = "" + board[2] + board[5] + board[8];
				break;
			case 6:
				line = "" + board[3] + board[6] + board[9];
				break;
			case 7:
				line = "" + board[1] + board[5] + board[9];
				break;
			case 8:
				line = "" + board[3] + board[5] + board[7];
				break;
			}
			// For X winner
			if (line.equals("XXX")) {
				return 'X';
			}

			// For O winner
			else if (line.equals("OOO")) {
				return 'O';
			}
		}
		int check1;
		for (check1 = 1; check1 < 10; check1++) {
			if (board[check1] == ' ') {
				break;
			}
		}
		if (check1 == 10)
			return 't';
		else
			return 'n';
	}

	// method to display winner
	public void displayWinner() {

		char win = getWinner();
		if (win == userOption) {
			System.out.println("\n Congratulations, You won");
			winnerStatus = 1;
		} else if (win == computerOption) {
			System.out.println("\n Computer wins!");
			winnerStatus = 1;
		} else if (win == 't') {
			System.out.println("TIE.");
			winnerStatus = 1;
		}
	}

	// helps in defining the game flow
	public void gameFlow() {
		createBoard();
		playerChoice();
		tossMethod();

		while (winnerStatus == 0) {

			if (turnToPlay == 'C') {
				computerMove();
				//displayBoard();
				displayWinner();
				turnToPlay = 'P';
				//userMove();
			} else if (turnToPlay == 'P') {
				userMove();
				displayWinner();
				//showBoard();
				turnToPlay = 'C';
				//computerMove();

			}
			displayBoard();
			System.out.println();
		}
	}

}
