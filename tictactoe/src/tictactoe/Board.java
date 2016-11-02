package tictactoe;

public interface Board {
  String listMoves();
  
  void makeMove(int move);
  
  void undoMove();
  
  void checkThreeInARow();
}