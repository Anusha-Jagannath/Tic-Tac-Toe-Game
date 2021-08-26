package com.game;

import java.util.Scanner;

public class TicTacToeGame {
	private char[] board=new char[10];
	public void createBoard() {
		for(int i=1;i<10;i++)
			board[i]=' ';
	}
	public void playerChoice() {
	//ask for user inputs
	char computerChoice;
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter player name : ");
	String name=sc.nextLine();
	System.out.println("Enter player's choice X or Y");
	char choice=sc.next().charAt(0);
	if(choice=='X'){
		computerChoice='O';// if user has choosen x
	}
	else{
		computerChoice='X';// if user has choosen 
	}
	System.out.println("Computer choice is "+computerChoice);
      sc.close();
	}
	
}
