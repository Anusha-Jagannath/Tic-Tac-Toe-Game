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
	for(int i=1;i<10;i++) {
	System.out.println("Enter player's choice X or Y");
	char choice=sc.next().charAt(0);
	if(choice=='X'){
		board[i]='X';
		computerChoice='O';// if user has choosen x
		board[i+1]='O';
	}
	else{
		board[i]='Y';
		computerChoice='X';// if user has choosen
		board[i+1]='O';
	}
	System.out.println("Computer choice is "+computerChoice);
	}
	}
	public void displayBoard() {
		System.out.println("\n\t"+board[1]+" "+board[2]+" "+board[3]);
        System.out.println("\t"+board[4]+" "+board[5]+" "+board[6]);
        System.out.println("\t"+board[7]+" "+board[8]+" "+board[9]);
        System.out.println("\n---------------------");
		
	}
	
}
