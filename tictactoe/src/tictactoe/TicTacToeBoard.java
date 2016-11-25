package tictactoe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class TicTacToeBoard
 * 
 * <P>[Class description.  The first sentence should be a meaningful summary of the class since it
 *  will be displayed as the class summary on the Javadoc package page.]</P>
 *  
 * <P>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 *  about desired improvements, etc.]</P>
 *  
 *  @author <A HREF="mailto:[marek.koch@stud.fh-luebeck.de]">[Marek Koch]</A>
 *  @version $Revision: 1.2 $ $Date: 2016/11/15 21:55 $
 */
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
   * Toggles whose turn it is. Value of +1 represents player x and -1 player o.
   */
  private static int turn = +1;
  
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
    LOG.debug("undoMove: Value moves.get(moves.size()-1) is : " + moves.get(moves.size() - 1));
    this.board[moves.get(moves.size() - 1)] = 0;
    moves.remove(moves.size() - 1);
    turn = -turn;
  }

  /**
   * Checks for three in a row.
   * @return True if one player has won.
   */
  public boolean checkThreeInARow() {
    return checkHorizontally() || checkVertically() || checkDiagonally();
  }
  
  /**
   * Checks for a Winner horizontally.
   * @return True if a player has won horizontally.
   */
  public boolean checkHorizontally() {
    for (int i = 0; i < board.length; i += 3) {
      if (this.board[i] != 0 && this.board[i] == this.board[i + 1]
          && this.board[i] == this.board[i + 2]) {
        return true;
      } // end if
    } // end for
    
    return false;
  }

  /**
   * Checks for a Winner vertically.
   * 
   * @return True if a player has won vertically.
   */
  public boolean checkVertically() {
    for (int i = 0; i < board.length - 6; i++) {
      if (this.board[i] != 0 && this.board[i] == this.board[i + 3]
          && this.board[i] == this.board[i + 6]) {
        return true;
      } // end if
    } // end for

    return false;
  }

  /**
   * Checks for a Winner diagonally.
   * @return True if a player has won diagonally.
   */
  public boolean checkDiagonally() {
    if (this.board[0] != 0 && this.board[0] == this.board[4] && this.board[0] == this.board[8]
        || this.board[2] != 0 && this.board[2] == this.board[4] && this.board[2] == this.board[6]) {
      return true;
    }

    return false;
  }

  /**
   * Main Method to start the game.
   * @param args if invoked from command line
   */
  public static void main(final String[] args) {
    final TicTacToeBoard gameBoard = new TicTacToeBoard();
    final Scanner inputPlayerMove = new Scanner(System.in);
    
    do {
      LOG.info("Player "
                           + gameBoard.getRepresentation(turn)
                           + ", enter your move [0-8]: ");
      final int playerMove = inputPlayerMove.nextInt(); // could throw out of bounds exception
      gameBoard.makeMove(playerMove);
    } while (!gameBoard.checkThreeInARow());
    
    inputPlayerMove.close();
    LOG.info(gameBoard.toString());
    LOG.info(gameBoard.getRepresentation(-turn) + " hat das Spiel gewonnen.");
  } // end public static void main() 

} // end class TicTacToeBoard
