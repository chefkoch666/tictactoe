/**
 * Class TicTacToeBoard
 * 
 * <P>[Class description.  The first sentence should be a meaningful summary of the class since it
 *  will be displayed as the class summary on the Javadoc package page.]</P>
 *  
 * <P>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 *  about desired improvements, etc.]</P>
 *  
 *  @author <A HREF="mailto:[koch@physik.uni-kiel.de]">[Marek Koch]</A>
 *  @version $Revision: 1.1 $ $Date: 2016/11/13 13:29 $
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
   * Outputs board in a human readable way.
   * @return String Converted StringBuffer as board output.
   */
  @Override
  public String toString() {
    final StringBuffer outputBoard = new StringBuffer("\n");
    for (int i = 0; i <= 6; i += 3) {
      outputBoard.append("[" + this.getRepresentation(this.board[i]) + " "
          + this.getRepresentation(this.board[i + 1]) + " "
          + this.getRepresentation(this.board[i + 2]) + "]\n");
    }
    return outputBoard.toString();
  }

  /**
   * Returns a list of all made moves.
   * @return String contains all the moves.
   */
  public String listMoves() {
    return moves.toString();
  }

  /**
   * Player makes a move at desired position.
   * @param atPosition The position on the one board.
   */
  public void makeMove(final int atPosition) {
    moves.add(atPosition);
    this.board[atPosition] = turn;
    turn = -turn;
  }

  /**
   * Undo the last move.
   */
  public void undoMove() {
    LOG.info("undoMove: Value moves.get(moves.size()-1) is : " + moves.get(moves.size() - 1));
    this.board[moves.get(moves.size() - 1)] = 0;
    moves.remove(moves.size() - 1);
    turn = -turn;
  }

  /**
   * Outputs the winner's symbol (x or o).
   * @param theWinner output the winner's symbol x or o.
   */
  public void checkForWinner(final char theWinner) {
    if (Character.isLetter(theWinner)) {
      LOG.info("Game over. The winner is : " + theWinner);
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
   * Checks for a Winner horizontally.
   * @return playerWon contains the symbol of the player who has won.
   */
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

  /**
   * Checks for a Winner vertically.
   * @return playerWon contains the symbol of the player who has won.
   */
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

  /**
   * Checks for a Winner diagonally.
   * @return playerWon contains the symbol of the player who has won.
   */
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

  /**
   * Main Method to start the game.
   * @param args if invoked from command line
   */
  public static void main(final String[] args) {
    final TicTacToeBoard gameBoard = new TicTacToeBoard();
    LOG.info("x beginnt das Spiel.");
    // x wins horizontal in first line
    gameBoard.makeMove(0);
    gameBoard.makeMove(3);
    gameBoard.makeMove(1);
    gameBoard.makeMove(4);
    gameBoard.makeMove(2);
    gameBoard.checkThreeInARow();
    
    // look at result board
    LOG.info(gameBoard.toString());
  } // end public static void main() 

} // end class TicTacToeBoard
