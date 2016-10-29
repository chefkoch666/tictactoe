package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard implements Board {

  private int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
  private List<Integer> moves = new ArrayList<Integer>();
  private int turn = +1;

  public TicTacToeBoard() {}

  public char getRepresentation(int r) {
    char ret = '0';
    if (r <= -1) {
      ret = 'o';
    }
    if (r >= +1) {
      ret = 'x';
    }
    return ret;
  }

  public String toString() {
    String str = "";
    for (int i = 0; i <= 6; i += 3) {
      str += "[" + this.getRepresentation(this.board[i]) + " "
          + this.getRepresentation(this.board[i + 1]) + " "
          + this.getRepresentation(this.board[i + 2]) + "]\n";
    }
    return str;
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
      System.exit(0);
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
    char ret = ' ';
    int countx = 0;
    int counto = 0;
    for (int i = 0; i < board.length; i += 3) {
      if ((this.getRepresentation(this.board[i]) == 'o')
          && (this.getRepresentation(this.board[i + 1]) == 'o')
          && (this.getRepresentation(this.board[i + 2]) == 'o')) {
        counto = 3;
      }
      if ((this.getRepresentation(this.board[i]) == 'x')
          && (this.getRepresentation(this.board[i + 1]) == 'x')
          && (this.getRepresentation(this.board[i + 2]) == 'x')) {
        countx = 3;
      }
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

  public char checkVertically() {
    char ret = ' ';
    int countx = 0;
    int counto = 0;
    for (int i = 0; i < board.length - 6; i++) {
      if ((this.getRepresentation(this.board[i]) == 'o')
          && (this.getRepresentation(this.board[i + 3]) == 'o')
          && (this.getRepresentation(this.board[i + 6]) == 'o')) {
        counto = 3;
      }
      if ((this.getRepresentation(this.board[i]) == 'x')
          && (this.getRepresentation(this.board[i + 3]) == 'x')
          && (this.getRepresentation(this.board[i + 6]) == 'x')) {
        countx = 3;
      }
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

  public char checkDiagonally() {
    char ret = ' ';
    int countx = 0;
    int counto = 0;
    if ((this.getRepresentation(this.board[0]) == 'o')
        && (this.getRepresentation(this.board[4]) == 'o')
        && (this.getRepresentation(this.board[8]) == 'o')
        || (this.getRepresentation(this.board[2]) == 'o')
            && (this.getRepresentation(this.board[4]) == 'o')
            && (this.getRepresentation(this.board[6]) == 'o')) {
      counto = 3;
    }
    if ((this.getRepresentation(this.board[0]) == 'x')
        && (this.getRepresentation(this.board[4]) == 'x')
        && (this.getRepresentation(this.board[8]) == 'x')
        || (this.getRepresentation(this.board[2]) == 'x')
            && (this.getRepresentation(this.board[4]) == 'x')
            && (this.getRepresentation(this.board[6]) == 'x')) {
      countx = 3;
    }
    if (counto == 3) {
      ret = 'o';
    }
    if (countx == 3) {
      ret = 'x';
    }

    return ret;
  }

  public static void main(String[] args) {
    TicTacToeBoard b = new TicTacToeBoard();
    System.out.println("Wir starten mit einem leeren Board. x beginnt.");
    // x wins horizontal in first line
    // b.makeMove(0);
    // b.makeMove(3);
    // b.makeMove(1);
    // b.makeMove(4);
    // b.makeMove(2);
    // b.checkThreeInARow();
    // b.makeMove(5);

    // x wins vertical in first column
    //    b.makeMove(0);
    //    b.makeMove(4);
    //    b.makeMove(3);
    //    b.makeMove(5);
    //    b.makeMove(6);
    //    b.checkThreeInARow();
    //    b.makeMove(7);
    
    // o wins diagonal 1
//    b.makeMove(1);
//    b.makeMove(0);
//    b.makeMove(3);
//    b.makeMove(4);
//    b.makeMove(7);
//    b.makeMove(8);
    
    // o wins diagonal 2
//    b.makeMove(1);
//    b.makeMove(2);
//    b.makeMove(3);
//    b.makeMove(4);
//    b.makeMove(7);
//    b.makeMove(6);
    
    // x wins diagonal 1
//    b.makeMove(0);
//    b.makeMove(2);
//    b.makeMove(4);
//    b.makeMove(1);
//    b.makeMove(7);
//    b.makeMove(6);
    
    // x wins diagonal 2
    b.makeMove(2);
    b.makeMove(1);
    b.makeMove(4);
    b.makeMove(5);
    b.makeMove(6);
    b.makeMove(0);

    // look at result board
    System.out.println(b.toString());
    /*
     * System.out.print(b.toString()); System.out.println(b.listMoves());
     * 
     * System.out.println("Erster Zug auf Array index 2."); b.makeMove(2);
     * System.out.print(b.toString()); System.out.println(b.listMoves());
     * 
     * System.out.println("Mache Zug rückgängig."); b.undoMove(); System.out.print(b.toString());
     * System.out.println(b.listMoves());
     * 
     * System.out.println("Mache Zug auf Array index 0."); b.makeMove(0);
     * System.out.print(b.toString()); System.out.println(b.listMoves());
     * 
     * System.out.println("Mache Zug auf Array index 4."); b.makeMove(4);
     * System.out.print(b.toString()); System.out.println(b.listMoves());
     */
  }

}
