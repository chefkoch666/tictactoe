/**
 * 
 * Board.java
 * Interface for a game board.
 * 
 * @author <A HREF="mailto:[marek.koch@stud.fh-luebeck.de]">[Marek Koch]</A>
 * @version $Revision: 1.1 $ $Date: 2016/11/11 10:04 $
 */

package tictactoe;

public interface Board {
  /**
   * List all moves of the Board made so far.
   * @return String that lists all the moves of the Board made so far. 
   */
  String listMoves();
  
  /**
   * Initialize board to start a new game.
   */
  void init();
  
  /**
   * Make a move on the Board at position.
   * @param atPosition the position to change on the Board.
   */
  void makeMove(final int atPosition);
  
  /**
   * Undo last move on the Board.
   */
  void undoMove();

  /**
   * Check for winning/draw situation after a move.
   */
  void checkThreeInARow();
}