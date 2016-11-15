/**
 * Class Board
 * 
 * <P>Interface for a game board behavior.</P>
 * 
 * @author <A HREF="mailto:[koch@physik.uni-kiel.de]">[Marek Koch]</A>
 * @version $Revision: 1.1 $ $Date: 2016/11/13 13:29 $
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
  boolean checkThreeInARow();
}