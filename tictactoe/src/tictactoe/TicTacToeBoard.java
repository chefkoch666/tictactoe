/**
 * Class TicTacToeBoard
 * 
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 *  will be displayed as the class summary on the Javadoc package page.]
 *  
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 *  about desired improvements, etc.]
 *  
 *  @author <A HREF="mailto:[marek.koch@stud.fh-luebeck.de]">[Marek Koch]</A>
 *  @version $Revision: 1.1 $ $Date: 2016/11/11 10:04 $
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
  // package access
  static int[] board;
  
  /**
   * Saves the moves of all players.
   */
  private static final List<Integer> moves = new ArrayList<Integer>(0);
  
  /**
   * Toggles whose turn it is. 
   */
  private static int turn;
  
  /**
   * Proper logging to avoid System.out.println()
   */
  private static final Logger LOG = LogManager.getLogger(TicTacToeBoard.class 
      .getName());

  /**
   * Initialize a new game.
   */
  public void init() {
    board = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
    turn = +1;
    moves.clear();
    LOG.info("x beginnt das Spiel.");
  }

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

  /**
   * Prints board in a human readable way.
   *
   * @return board's human readable representation
   */
  @Override
  public String toString() {
    final StringBuffer outputBoard = new StringBuffer("\n");
    for (int i = 0; i <= 6; i += 3) {
      outputBoard.append("[" + this.getRepresentation(board[i]) + " "
          + this.getRepresentation(board[i + 1]) + " "
          + this.getRepresentation(board[i + 2]) + "]\n");
    }
    return outputBoard.toString();
  }

  /**
   * Lists moves on board made so far.
   *
   * @return moves on board
   */
  public String listMoves() {
    return moves.toString();
  }

  /**
   * Make move atPosition on board.
   *
   * @param atPosition Mark position on board.
   */
  public void makeMove(final int atPosition) {
    moves.add(atPosition);
    board[atPosition] = turn;
    turn = -turn;
  }

  /**
   * Undo last move.
   */
  public void undoMove() {
    LOG.info("undoMove: Value moves.get(moves.size()-1) is : " + moves.get(moves.size() - 1));
    board[moves.get(moves.size() - 1)] = 0;
    moves.remove(moves.size() - 1);
    turn = -turn;
  }

  /**
   * Checks for a winner.
   *
   * @param theWinner Check if this player is the winner.
   */
  public void checkForWinner(final char theWinner) {
    if (Character.isLetter(theWinner)) {
      LOG.info("The winner is : " + theWinner);
    }
  }

  /**
   * Checks for three in a row.
   */
  public void checkThreeInARow() {
    char theWinner = ' ';
    theWinner = checkHorizontally();
    checkForWinner(theWinner);
    theWinner = checkVertically();
    checkForWinner(theWinner);
    theWinner = checkDiagonally();
    checkForWinner(theWinner);
  }

  /**
   * Checks for three in a row horizontally.
   * 
   * @return playerWon contains player symbol who has won. 
   */
  public char checkHorizontally() {
    char playerWon = ' ';
    for (int i = 0; i < board.length; i += 3) {
      if (this.getRepresentation(board[i]) == 'o'
          && this.getRepresentation(board[i + 1]) == 'o'
          && this.getRepresentation(board[i + 2]) == 'o') {
        playerWon = 'o';
      }
      if (this.getRepresentation(board[i]) == 'x'
          && this.getRepresentation(board[i + 1]) == 'x'
          && this.getRepresentation(board[i + 2]) == 'x') {
        playerWon = 'x';
      }
    } // end for

    return playerWon;
  }
  
  /**
   * Checks for three in a row vertically.
   * 
   * @return playerWon contains player symbol who has won. 
   */
  public char checkVertically() {
    char playerWon = ' ';
    for (int i = 0; i < board.length - 6; i++) {
      if (this.getRepresentation(board[i]) == 'o'
          && this.getRepresentation(board[i + 3]) == 'o'
          && this.getRepresentation(board[i + 6]) == 'o') {
        playerWon = 'o';
      }
      if (this.getRepresentation(board[i]) == 'x'
          && this.getRepresentation(board[i + 3]) == 'x'
          && this.getRepresentation(board[i + 6]) == 'x') {
        playerWon = 'x';
      }
    } // end for

    return playerWon;
  }

  /**
   * Checks for three in a row diagonally.
   * 
   * @return playerWon contains player symbol who has won. 
   */
  public char checkDiagonally() {
    char playerWon = ' ';
    if ((this.getRepresentation(board[0]) == 'o')
        && (this.getRepresentation(board[4]) == 'o')
        && (this.getRepresentation(board[8]) == 'o')
        || (this.getRepresentation(board[2]) == 'o')
            && (this.getRepresentation(board[4]) == 'o')
            && (this.getRepresentation(board[6]) == 'o')) {
      playerWon = 'o';
    }
    if ((this.getRepresentation(board[0]) == 'x')
        && (this.getRepresentation(board[4]) == 'x')
        && (this.getRepresentation(board[8]) == 'x')
        || (this.getRepresentation(board[2]) == 'x')
            && (this.getRepresentation(board[4]) == 'x')
            && (this.getRepresentation(board[6]) == 'x')) {
      playerWon = 'x';
    }

    return playerWon;
  }

  /**
   * Main program: Make/undo moves; Check for three in a row.
   * 
   * @param args Received on call/command line.
   */
  /*
  public static void main(final String[] args) {
    final TicTacToeBoard gameBoard = new TicTacToeBoard();
    gameBoard.init();    
    // x wins horizontal in first line
    gameBoard.makeMove(0);
    gameBoard.makeMove(3);
    gameBoard.makeMove(1);
    gameBoard.makeMove(4);
    gameBoard.makeMove(2);
    LOG.info(gameBoard.toString());

    
    gameBoard.init();
    // x wins vertical in first column
    gameBoard.makeMove(0);
    gameBoard.makeMove(4);
    gameBoard.makeMove(3);
    gameBoard.makeMove(5);
    gameBoard.makeMove(6);
    gameBoard.checkThreeInARow();
 
    // look at result board
    LOG.info(gameBoard.toString());
  } // end public static void main() 
  */

} // end class TicTacToeBoard
