package tictactoe;

public class TicTacToeBoard implements Board {

	private int[] board = {0,0,0,0,0,0,0,0,0};
	private String moves = "-";
	private int turn = +1;

	public TicTacToeBoard() {
	}

/*
	public String getMoves() {
		return moves;
	}
*/
	
	public String toString() {
		String str = "";
		for (int i = 0; i <= 6; i+=3) {
			str += "[" + this.board[i] + " " + this.board[i+1] + " " + this.board[i+2] + "]\n";
		}
		return str;
	}
	
	public String listMoves () {
		return moves;
	}
	
	public void makeMove () {
		
	}
	
	public void undoMove () {
		
	}
	
	public void threeInARow () {
		
	}
	
	public static void main(String[] args) {
		TicTacToeBoard b = new TicTacToeBoard();
		System.out.print(b.toString());
		System.out.println(b.listMoves());
		System.out.println(b.turn);
		b.turn = -b.turn;
		System.out.println(b.turn);
		b.turn = -b.turn;
		System.out.println(b.turn);
	}

}
