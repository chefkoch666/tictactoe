/**
 * 
 * Board.java
 * Interface for a game board.
 * 
 * @author <A HREF="mailto:[koch@physik.uni-kiel.de]">[Marek Koch]</A>
 * @version $Revision: 1.0 $ $Date: 2016/11/02 09:36:00 $
 */

package tictactoe;

public interface Board {
  /**
   * List all moves of the Board made so far.
   * @return String that lists all the moves of the Board made so far. 
   */
  String listMoves();
  
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