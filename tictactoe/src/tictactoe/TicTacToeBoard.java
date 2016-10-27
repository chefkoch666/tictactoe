package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard implements Board {

	private int[] board = {0,0,0,0,0,0,0,0,0};
	private List<Integer> moves = new ArrayList<Integer>();
	private int turn = +1;
	private char[] repr = {'o', 'x'};

	public TicTacToeBoard() {
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i <= 6; i+=3) {
			System.out.print("Value of for i is : " + i);
			str += "[" + repr[this.board[i]] + " " + repr[this.board[i+1]] + " " + repr[this.board[i+2]] + "]\n";
		}
		return str;
	}
	
	public String listMoves () {
		return moves.toString() ;
	}
	
	public void makeMove (int move) {
		moves.add(move);
		this.board[move] = turn;
		turn = -turn;
	}
	
	public void undoMove () {
		System.out.println("undoMove: Value moves.get(moves.size()-1) is : " + moves.get(moves.size()-1));
		this.board[moves.get(moves.size()-1)] = 0;
		moves.remove(moves.size()-1);
		turn = -turn;
	}
	
	public void threeInARow () {
		
	}
	
	public static void main(String[] args) {
		TicTacToeBoard b = new TicTacToeBoard();
		System.out.print(b.toString());
		System.out.println(b.listMoves());
		
		b.makeMove(5);
		System.out.print(b.toString());
		System.out.println(b.listMoves());

		b.undoMove();
		System.out.print(b.toString());
		System.out.println(b.listMoves());
		
		b.makeMove(0);
		System.out.print(b.toString());
		System.out.println(b.listMoves());
		
		b.makeMove(2);
		System.out.print(b.toString());
//		System.out.println(b.listMoves());		
	}

}
