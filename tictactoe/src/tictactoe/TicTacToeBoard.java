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
	
	public char getRepresentation(int r) {
		char ret = '0';
		if (r <= -1 ) ret = 'o';
		if (r >= +1)  ret = 'x';
		return ret;
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i <= 6; i+=3) {
			str += "[" + this.getRepresentation(this.board[i]) + " " +
			       this.getRepresentation(this.board[i+1]) + " " +
			       this.getRepresentation(this.board[i+2]) + "]\n";
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
		checkThreeInARow();
	}
	
	public void undoMove () {
		System.out.println("undoMove: Value moves.get(moves.size()-1) is : " + moves.get(moves.size()-1));
		this.board[moves.get(moves.size()-1)] = 0;
		moves.remove(moves.size()-1);
		turn = -turn;
	}
	
	public void checkThreeInARow () {
		char theWinner = ' ';
		theWinner = checkHorizontally();
		// check horizontal, vertical, diagonal
		if (theWinner != ' ') {
			System.out.println("Houston, we have a winner! It's : " + theWinner);
			System.out.println(this.toString());
		  System.exit(0);
		}
	}

	public char checkHorizontally () {
		char ret = ' ';
		int countx = 0;
		int counto = 0;
		for (int i = 0; i < board.length; i+=3) {
			if (this.getRepresentation(this.board[i]) == 'o') counto+=1;
			if (this.getRepresentation(this.board[i+1]) == 'o') counto+=1;
			if (this.getRepresentation(this.board[i+2]) == 'o') counto+=1;
			if (this.getRepresentation(this.board[i]) == 'x') countx+=1;
			if (this.getRepresentation(this.board[i+1]) == 'x') countx+=1;
			if (this.getRepresentation(this.board[i+2]) == 'x') countx+=1;
			if (counto == 3) { 
				ret = 'o';
				break;
			}
			if (countx == 3) {
				ret = 'x';
				break;
			}
		}
		
		return ret;
	}

	public void checkVertically () {
		
	}
	
	public void checkDiagonally () {
		
	}
	
	public static void main(String[] args) {
		TicTacToeBoard b = new TicTacToeBoard();
		System.out.println("Wir starten mit einem leeren Board. x beginnt.");
		b.makeMove(0);
		b.makeMove(3);
		b.makeMove(1);
		b.makeMove(4);
		b.makeMove(2);
		b.checkThreeInARow();
		b.makeMove(5);
		System.out.println(b.toString());
/*  
		System.out.print(b.toString());
		System.out.println(b.listMoves());
		
		System.out.println("Erster Zug auf Array index 2.");
		b.makeMove(2);
		System.out.print(b.toString());
		System.out.println(b.listMoves());

		System.out.println("Mache Zug rückgängig.");
		b.undoMove();
		System.out.print(b.toString());
		System.out.println(b.listMoves());
		
		System.out.println("Mache Zug auf Array index 0.");
		b.makeMove(0);
		System.out.print(b.toString());
		System.out.println(b.listMoves());
		
		System.out.println("Mache Zug auf Array index 4.");
		b.makeMove(4);
		System.out.print(b.toString());
		System.out.println(b.listMoves());		
*/
		}

}
