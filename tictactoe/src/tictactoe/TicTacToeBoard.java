package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard implements Board {

  private int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
  private List<Integer> moves = new ArrayList<Integer>();
  private int turn = +1;

  public TicTacToeBoard() {}

  public char getRepresentation(int position) {
    char ret = '0';
    if (position <= -1) {
      ret = 'o';
    }
    if (position >= +1) {
      ret = 'x';
    }
    return ret;
  }

  public String toString() {
    StringBuffer str = new StringBuffer("");
    for (int i = 0; i <= 6; i += 3) {
      str.append("[" + this.getRepresentation(this.board[i]) + " "
          + this.getRepresentation(this.board[i + 1]) + " "
          + this.getRepresentation(this.board[i + 2]) + "]\n");
    }
    return str.toString();
  }

  public String listMoves() {
    return moves.toString();
  }

  public void makeMove(int move) {
    moves.add(move);
    this.board[move] = turn;
    turn = -turn;
    checkThreeInARow();
  }

  public void undoMove() {
    System.out
        .println("undoMove: Value moves.get(moves.size()-1) is : " + moves.get(moves.size() - 1));
    this.board[moves.get(moves.size() - 1)] = 0;
    moves.remove(moves.size() - 1);
    turn = -turn;
  }

  public void checkForWinner(char theWinner) {
    if (theWinner != ' ') {
      System.out.println("Houston, we have a winner! It's : " + theWinner);
    }
  }

  public void checkThreeInARow() {
    char theWinner = ' ';
    theWinner = checkHorizontally();
    theWinner = checkVertically();
    theWinner = checkDiagonally();
    checkForWinner(theWinner);
  }

  public char checkHorizontally() {
    char winner = ' ';
    for (int i = 0; i < board.length; i += 3) {
      if ((this.getRepresentation(this.board[i]) == 'o')
          && (this.getRepresentation(this.board[i + 1]) == 'o')
          && (this.getRepresentation(this.board[i + 2]) == 'o')) {
        winner = 'o';
      }
      if ((this.getRepresentation(this.board[i]) == 'x')
          && (this.getRepresentation(this.board[i + 1]) == 'x')
          && (this.getRepresentation(this.board[i + 2]) == 'x')) {
        winner = 'x';
      }
    }

    return winner;
  }

  public char checkVertically() {
    char winner = ' ';
    for (int i = 0; i < board.length - 6; i++) {
      if ((this.getRepresentation(this.board[i]) == 'o')
          && (this.getRepresentation(this.board[i + 3]) == 'o')
          && (this.getRepresentation(this.board[i + 6]) == 'o')) {
        winner = 'o';
      }
      if ((this.getRepresentation(this.board[i]) == 'x')
          && (this.getRepresentation(this.board[i + 3]) == 'x')
          && (this.getRepresentation(this.board[i + 6]) == 'x')) {
        winner = 'x';
      }
    }

    return winner;
  }

  public char checkDiagonally() {
    char winner = ' ';
    if ((this.getRepresentation(this.board[0]) == 'o')
        && (this.getRepresentation(this.board[4]) == 'o')
        && (this.getRepresentation(this.board[8]) == 'o')
        || (this.getRepresentation(this.board[2]) == 'o')
            && (this.getRepresentation(this.board[4]) == 'o')
            && (this.getRepresentation(this.board[6]) == 'o')) {
      winner = 'o';
    }
    if ((this.getRepresentation(this.board[0]) == 'x')
        && (this.getRepresentation(this.board[4]) == 'x')
        && (this.getRepresentation(this.board[8]) == 'x')
        || (this.getRepresentation(this.board[2]) == 'x')
            && (this.getRepresentation(this.board[4]) == 'x')
            && (this.getRepresentation(this.board[6]) == 'x')) {
      winner = 'x';
    }

    return winner;
  }

  public static void main(String[] args) {
    TicTacToeBoard gameBoard = new TicTacToeBoard();
    System.out.println("Wir starten mit einem leeren Board. x beginnt.");
    // x wins horizontal in first line
     gameBoard.makeMove(0);
     gameBoard.makeMove(3);
     gameBoard.makeMove(1);
     gameBoard.makeMove(4);
     gameBoard.makeMove(2);
     gameBoard.makeMove(5);

    // x wins vertical in first column, checkVertically() is not working
    // this.board[i +3] <--- expression is not evaluated, rather the value of i is used
//     gameBoard.makeMove(0);
//     gameBoard.makeMove(4);
//     gameBoard.makeMove(3);
//     gameBoard.makeMove(5);
//     gameBoard.makeMove(6);
//     gameBoard.makeMove(7);

    // o wins diagonal 1
//     gameBoard.makeMove(1);
//     gameBoard.makeMove(0);
//     gameBoard.makeMove(3);
//     gameBoard.makeMove(4);
//     gameBoard.makeMove(7);
//     gameBoard.makeMove(8);

    // o wins diagonal 2
    // gameBoard.makeMove(1);
    // gameBoard.makeMove(2);
    // gameBoard.makeMove(3);
    // gameBoard.makeMove(4);
    // gameBoard.makeMove(7);
    // gameBoard.makeMove(6);

    // x wins diagonal 1
//     gameBoard.makeMove(0);
//     gameBoard.makeMove(2);
//     gameBoard.makeMove(4);
//     gameBoard.makeMove(1);
//     gameBoard.makeMove(8);
//     gameBoard.makeMove(6);

    // x wins diagonal 2
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//    gameBoard.makeMove(2);
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//    gameBoard.makeMove(1);
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//    gameBoard.makeMove(4);
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//    gameBoard.makeMove(5);
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//    gameBoard.makeMove(6);
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//    gameBoard.makeMove(0);
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//    // six moves so far
//    
//    // 7th move
//    gameBoard.makeMove(3);
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//    
//    // 8th move
//    gameBoard.makeMove(7); // o
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//    
//    // 9th / last possible move
//    gameBoard.makeMove(7); // x
//    System.out.println(gameBoard.listMoves());
//    System.out.println(gameBoard.moves.size());
//
     
     
     
    // look at result board
    System.out.println(gameBoard.toString());
  }

}
