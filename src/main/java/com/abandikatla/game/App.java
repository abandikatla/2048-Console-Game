package com.abandikatla.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Amulya Bandikatla
 * 2048 Console Game
 */
public class App 
{
    public static void main( String[] args )
    {
     GameBoard game = new GameBoard(4, 2048);
     System.out.println("***************** INSTRUCTIONS **********************");
     System.out.println("1. The game begins with a 4x4 matrix, with all zeroes except one. When atleast one tile has 2048 value, the player wins.");
     System.out.println("2. The player is allowed 4 different types of moves : left, right, up or down. The move has to be typed in as string on the console. Enter \"exit\" to exit the game.");
     System.out.println("3. Refer https://gabrielecirulli.github.io/2048/ for further details.");
     System.out.println();
     System.out.println("******************** START *************************");
     game.printBoard();
     BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = bufferRead.readLine();
			while (input != null){
				boolean movePossible = false;
				if(input.equalsIgnoreCase("left")){
					movePossible = game.left();
				}else if(input.equalsIgnoreCase("right")){
					movePossible = game.right();
				}else if(input.equalsIgnoreCase("up")){
					movePossible = game.up();
				}else if(input.equalsIgnoreCase("down")){
					movePossible = game.down();
				}else if(input.equalsIgnoreCase("exit")){
					System.out.println("*************** Exiting the Game! ************");
					break;
				}else {
					System.out.println("Invalid input! Enter move again.");
					game.printBoard();
					input = bufferRead.readLine();
					continue;
				}
				System.out.println("*********************************************");
				if(movePossible){
					game.addNewNumber();
				}
				game.printBoard();
				if(game.isWin()){
					System.out.println("****************** WIN **********************");
					break;
				}else if(game.isFull() && !game.canMove()){
					System.out.println("****************** GAME OVER! LOST! **********************");
					break;
				}
				input = bufferRead.readLine();
			}
			game.printBoard();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
    }
    
}
