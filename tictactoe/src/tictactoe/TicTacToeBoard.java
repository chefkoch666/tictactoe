/**
 * Class TicTacToeBoard
 * 
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 *  will be displayed as the class summary on the Javadoc package page.]
 *  
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 *  about desired improvements, etc.]
 *  
 *  @author <A HREF="mailto:[koch@physik.uni-kiel.de]">[Marek Koch]</A>
 *  @version $Revision: 1.0 $ $Date: 2016/11/02 09:36:00 $
 *  @see [String]
 *  @see [URL]
 *  @see [TicTacToeBoard]
 */

package tictactoe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard implements Board {

  /**
   * One dimensional presentation of the game board.
   */
  private int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
  
  /**
   * Saves the moves of all players.
   */
  private final List<Integer> moves = new ArrayList<Integer>(0);
  
  /**
   * Toggles whose turn it is. 
   */
  private int turn = +1;
  
  /**
   * Proper logging to avoid System.out.println()
   */
  private static final Logger LOG = LogManager.getLogger(TicTacToeBoard.class 
      .getName());

  public TicTacToeBoard() {}

  /**
   * Get representation at a specific position on the gameBoard.
   *
   * @param position to get representation of on the gameBoard
   * @return the representation's char
   */
  public char getRepresentation(final int position) {
    char representation = '0';
    if (position == -1) {
      representation = 'o';
    }
    if (position == +1) {
      representation = 'x';
    }
    return representation;
  }

  public String toString() {
    final StringBuffer str = new StringBuffer("");
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

  public void makeMove(final int atPosition) {
    moves.add(atPosition);
    this.board[atPosition] = turn;
    turn = -turn;
  }

  public void undoMove() {
    System.out
        .println("undoMove: Value moves.get(moves.size()-1) is : " + moves.get(moves.size() - 1));
    this.board[moves.get(moves.size() - 1)] = 0;
    moves.remove(moves.size() - 1);
    turn = -turn;
  }

  public void checkForWinner(final char theWinner) {
    if (Character.isWhitespace(theWinner)) {
      System.out.println("Houston, we have a winner! The winner is : " + theWinner);
    }
  }

  public void checkThreeInARow() {
    char theWinner = ' ';
    theWinner = checkHorizontally();
    checkForWinner(theWinner);
    theWinner = checkVertically();
    checkForWinner(theWinner);
    theWinner = checkDiagonally();
    checkForWinner(theWinner);
  }

  public char checkHorizontally() {
    char playerWon = ' ';
    for (int i = 0; i < board.length; i += 3) {
      if (this.getRepresentation(this.board[i]) == 'o'
          && this.getRepresentation(this.board[i + 1]) == 'o'
          && this.getRepresentation(this.board[i + 2]) == 'o') {
        playerWon = 'o';
      }
      if (this.getRepresentation(this.board[i]) == 'x'
          && this.getRepresentation(this.board[i + 1]) == 'x'
          && this.getRepresentation(this.board[i + 2]) == 'x') {
        playerWon = 'x';
      }
    } // end for

    return playerWon;
  }

  public char checkVertically() {
    char playerWon = ' ';
    for (int i = 0; i < board.length - 6; i++) {
      if (this.getRepresentation(this.board[i]) == 'o'
          && this.getRepresentation(this.board[i + 3]) == 'o'
          && this.getRepresentation(this.board[i + 6]) == 'o') {
        playerWon = 'o';
      }
      if (this.getRepresentation(this.board[i]) == 'x'
          && this.getRepresentation(board[i + 3]) == 'x'
          && this.getRepresentation(this.board[i + 6]) == 'x') {
        playerWon = 'x';
      }
    } // end for

    return playerWon;
  }

  public char checkDiagonally() {
    char playerWon = ' ';
    if ((this.getRepresentation(this.board[0]) == 'o')
        && (this.getRepresentation(this.board[4]) == 'o')
        && (this.getRepresentation(this.board[8]) == 'o')
        || (this.getRepresentation(this.board[2]) == 'o')
            && (this.getRepresentation(this.board[4]) == 'o')
            && (this.getRepresentation(this.board[6]) == 'o')) {
      playerWon = 'o';
    }
    if ((this.getRepresentation(this.board[0]) == 'x')
        && (this.getRepresentation(this.board[4]) == 'x')
        && (this.getRepresentation(this.board[8]) == 'x')
        || (this.getRepresentation(this.board[2]) == 'x')
            && (this.getRepresentation(this.board[4]) == 'x')
            && (this.getRepresentation(this.board[6]) == 'x')) {
      playerWon = 'x';
    }

    return playerWon;
  }

  public static void main(final String[] args) {
    final TicTacToeBoard gameBoard = new TicTacToeBoard();
    System.out.println("Wir starten mit einem leeren Board. x beginnt.");
    LOG.error("x beginnt das Spiel.");
    // x wins horizontal in first line
    gameBoard.makeMove(0);
    gameBoard.makeMove(3);
    gameBoard.makeMove(1);
    gameBoard.makeMove(4);
    gameBoard.makeMove(2);
    gameBoard.makeMove(5);

    // x wins vertical in first column
    gameBoard.makeMove(0);
    gameBoard.makeMove(4);
    gameBoard.makeMove(3);
    gameBoard.makeMove(5);
    gameBoard.makeMove(6);
    gameBoard.checkThreeInARow();
    gameBoard.checkVertically();
    
		// o wins diagonal 1
		//    gameBoard.makeMove(1);
		//    gameBoard.makeMove(0);
		//    gameBoard.makeMove(3);
		//    gameBoard.makeMove(4);
		//    gameBoard.makeMove(7);
		//    gameBoard.makeMove(8);
		    
		// o wins diagonal 2
		//    gameBoard.makeMove(1);
		//    gameBoard.makeMove(2);
		//    gameBoard.makeMove(3);
		//    gameBoard.makeMove(4);
		//    gameBoard.makeMove(7);
		//    gameBoard.makeMove(6);
		    
		// x wins diagonal 1
		//    gameBoard.makeMove(0);
		//    gameBoard.makeMove(2);
		//    gameBoard.makeMove(4);
		//    gameBoard.makeMove(1);
		//    gameBoard.makeMove(7);
		//    gameBoard.makeMove(6);
    
    // x wins diagonal 2
//    gameBoard.makeMove(2);
//    gameBoard.makeMove(1);
//    gameBoard.makeMove(4);
//    gameBoard.makeMove(5);
//    gameBoard.makeMove(6);
//    gameBoard.makeMove(0);
     
    // look at result board
    System.out.println(gameBoard.toString());
  } // end public static void main() 

} // end class TicTacToeBoard
