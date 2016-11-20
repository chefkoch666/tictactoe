package tictactoe;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeBoardTest {

  private TicTacToeBoard tester;
  
  @Before
  public void setUp() {
    tester = new TicTacToeBoard();
    tester.makeMove(0);
  }
  
  @Test
  public void testgetRepresentation() {
    assertThat(tester.getRepresentation(0),isA(Character.class));
  }
  
  @Test
  public void testtoString() {
    assertThat(tester.toString(),isA(String.class));
  }
  
  @Test
  public void testlistMoves() {
    assertThat(tester.listMoves(),isA(String.class));
  }
  
  @Test
  public void testmakeMove() {
    assertEquals(3, tester.listMoves().length());
    tester.makeMove(0);
    assertEquals(6, tester.listMoves().length());
  }
  
  @Test
  public void testundoMove() { // ArrayIndexOutOfBoundsException can happen
    int lengthBefore = tester.listMoves().length();
    tester.undoMove();
    int lengthAfter = tester.listMoves().length();
    assertTrue(lengthBefore > lengthAfter);
  }
  
  @Test
  public void testcheckThreeInARow() {
    assertFalse(tester.checkThreeInARow());
  }
  
  @Test
  public void testcheckVertically() { 
    assertFalse(tester.checkVertically());
  }

  @Test
  public void testcheckHorizontally() {
    assertFalse(tester.checkHorizontally());
  }
  
  @Test
  public void testcheckDiagonally() {
    assertFalse(tester.checkDiagonally());
  }
}
