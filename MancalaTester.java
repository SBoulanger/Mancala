package mancala;

import java.util.Scanner;

public class MancalaTester {
	public MancalaTester(){
		
	}
	
	public static void main (String args[]){
		System.out.println("Hi, Welcome to Mancala!");
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many stones would you like to start with? 3 or 4?");
		int amtStart = scanner.nextInt();
		
		//if(amtStart == 3)
			//Board board = new Board(3);
		//if(amtStart == 4)
			//Board board = new Board(4);
	}
}
