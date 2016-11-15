package tictactoe;

/**
 * Class Board
 * 
 * <P>Interface for a game board behavior.</P>
 * 
 * @author <A HREF="mailto:[marek.koch@stud.fh-luebeck.de]">[Marek Koch]</A>
 * @version $Revision: 1.2 $ $Date: 2016/11/15 21:55 $
 */
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
   * @return True if one player has won.
   */
  boolean checkThreeInARow();
}