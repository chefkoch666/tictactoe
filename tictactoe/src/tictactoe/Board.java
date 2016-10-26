package tictactoe;

public interface Board {
	Object listMoves();
	void makeMove();
	void undoMove();
	void threeInARow();
}