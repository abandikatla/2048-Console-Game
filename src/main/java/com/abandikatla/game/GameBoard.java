package com.abandikatla.game;

import java.util.Random;

/**
 * @author Amulya Bandikatla
 * 2048 Game Board
 */

public class GameBoard {
	
	private int[][] board ;
	private int boardSize;
	private int target;
	
	public void printBoard(){
		for(int i=0 ; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				System.out.print(board[i][j]);
				if(j+1 < boardSize)
					System.out.print(" *** ");
			}
			System.out.println();
		}
	}
	
	public GameBoard(int N, int target) {
		this.boardSize = N;
		board = new int[N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				board[i][j] = 0;
			}
		}
		this.target = target;
		addNewNumber();
	}
	
	public void addNewNumber(){
		if(!isFull()){
			Random ir = new Random();
			Random jr = new Random();
			int i = ir.nextInt(boardSize);
			int j = jr.nextInt(boardSize);
			while(board[i][j] != 0){
				i = ir.nextInt(boardSize);
				j = jr.nextInt(boardSize);
			}
			int x = new Random().nextInt(4);
			if( x%2 == 0){
				board[i][j] = 2;
			}else {
				board[i][j] = 4;
			}
		}
	}
	
	public boolean left(){
		boolean movePossible = false;
		for(int i=0 ; i<boardSize; i++){
			int prevj = -1;
			for(int j=0; j<boardSize; j++){
				if ((prevj == -1 && board[i][j] != 0)
						|| (prevj != -1 && board[i][j] != board[i][prevj])){
					prevj = j;
				}
				else if(prevj != -1 && board[i][j] == board[i][prevj]){
					if( board[i][j] != 0){
						movePossible = true;
					}
					board[i][prevj] *= 2;
					board[i][j] = 0;
					prevj = -1;
				}
			}
			prevj = 0;
			for(int j=0; j<boardSize; j++){
				if(board[i][j] != 0){
					if(prevj != j){
						if( board[i][j] != 0){
							movePossible = true;
						}
						board[i][prevj] = board[i][j];
						board[i][j] = 0;
					}
					prevj++;
				}
			}
		}
		return movePossible;
	}
	
	public boolean right(){
		boolean movePossible = false;
		for(int i=0 ; i<boardSize; i++){
			int nextj = -1;
			for(int j=boardSize-1; j>=0; j--){
				if ((nextj == -1 && board[i][j] != 0)
						|| (nextj != -1 && board[i][j] != board[i][nextj])){
					nextj = j;
				}
				else if(nextj != -1 && board[i][j] == board[i][nextj]){
					if( board[i][j] != 0){
						movePossible = true;
					}
					board[i][nextj] *= 2;
					board[i][j] = 0;
					nextj = -1;
				}
			}
			nextj = boardSize-1;
			for(int j=boardSize-1; j>=0; j--){
				if(board[i][j] != 0){
					if(nextj != j){
						board[i][nextj] = board[i][j];
						board[i][j] = 0;
						movePossible = true;
					}
					nextj--;
				}
			}
		}
		return movePossible;
	}
	
	public boolean up() {
		boolean movePossible = false;
		for(int j=0 ; j<boardSize; j++){
			int previ = -1;
			for(int i=0; i<boardSize; i++){
				if ((previ == -1 && board[i][j] != 0)
						|| (previ != -1 && board[i][j] != board[previ][j])){
					previ = i;
				}
				else if(previ != -1 && board[i][j] == board[previ][j]){
					if( board[i][j] != 0){
						movePossible = true;
					}
					board[previ][j] *= 2;
					board[i][j] = 0;
					previ = -1;
				}
			}
			previ = 0;
			for(int i=0; i<boardSize; i++){
				if(board[i][j] != 0){
					if(previ != i){
						board[previ][j] = board[i][j];
						board[i][j] = 0;
						movePossible = true;
					}
					previ++;
				}
			}
		}
		return movePossible;
	}

	public boolean down() {
		boolean movePossible = false;
		for(int j=0 ; j<boardSize; j++){
			int nexti = -1;
			for(int i=boardSize-1; i>=0; i--){
				if ((nexti == -1 && board[i][j] != 0)
						|| (nexti != -1 && board[i][j] != board[nexti][j])){
					nexti = i;
				}
				else if(nexti != -1 && board[i][j] == board[nexti][j]){
					if( board[i][j] != 0){
						movePossible = true;
					}
					board[nexti][j] *= 2;
					board[i][j] = 0;
					nexti = -1;
					
				}
			}
			nexti = boardSize-1;
			for(int i=boardSize-1; i>=0; i--){
				if(board[i][j] != 0){
					if(nexti != i){
						board[nexti][j] = board[i][j];
						board[i][j] = 0;
						movePossible = true;
					}
					nexti--;
				}
			}
		}
		return movePossible;
	}
	
	public boolean canMove(){
		if(!isFull()){
			return true;
		}
		for(int i=0 ; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				if( ( (i+1<boardSize) && (board[i][j] == board[i+1][j]) )
						|| ((j+1<boardSize) && (board[i][j] == board[i][j+1]) ))
					return true;
			}
		}
		return false;
	}

	public boolean isWin(){
		for(int i=0 ; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				if(board[i][j] == target)
					return true;
			}
		}
		return false;
	}
	
	public boolean isFull(){
		for(int i=0 ; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				if(board[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
