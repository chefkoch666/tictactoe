/*
 * Heavily based on http://www.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe.html#zz-2.
 * URL last accessed 11.11.2016 13:18
 */

package tictactoe;

import java.util.Scanner;

/**
 * The main class for the Tic-Tac-Toe (Console-OO, non-graphics version)
 * It acts as the overall controller of the game.
 */
public class GameController {
  /**
   * TicTacToeBoard to play with.
   */
  private final TicTacToeBoard board;
  
  /**
   * The current state of the game (of enum GameState).
   */
  private GameState currentState;
  
  /**
   * The current player (of enum Seed).
   */
  private Seed currentPlayer;
 
  /**
   * Player input which move she wants to make.
   */
  private static Scanner inputMove = new Scanner(System.in);
 
  /** Constructor to setup the game. */
  public GameController() {
    board = new TicTacToeBoard();
 
    // Initialize the game-board and current status
    initGame();
    // Play the game once. Players CROSS and CIRCLE move alternately.
    do {
      playerMove(currentPlayer); // update the content, currentRow and currentCol
      board.toString();             // ask the board to paint itself
      updateGame(currentPlayer); // update currentState
      // Print message if game-over
      if (currentState == GameState.CROSS_WON) {
        System.out.println("'X' hat gewonnen!");
      } else if (currentState == GameState.CIRCLE_WON) {
        System.out.println("'O' hat gewonnen!");
      } else if (currentState == GameState.DRAW) {
        System.out.println("Es ist ein Unentschieden!");
      } // end if else
      // Switch player
      currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.CIRCLE : Seed.CROSS;
    } while (currentState == GameState.PLAYING);  // repeat until game-over
  } // end public GameController()
 
  /** Initialize the game-board contents and the current states. */
  public void initGame() {
    board.init();  // clear the board contents
    currentPlayer = Seed.CROSS;       // CROSS plays first
    currentState = GameState.PLAYING; // ready to play
  }
 
  /** The player with "theSeed" makes one move, with input validation.
       Update Cell's content, Board's currentRow and currentCol. */
  public void playerMove(Seed theSeed) {
    boolean validInput = false;  // for validating input
    do {
      if (theSeed == Seed.CROSS) {
        System.out.print("Spieler 'X', gib deinen Zug ein 0-8: ");
      } else {
        System.out.print("Spieler 'O', gib deinen Zug ein 0-8: ");
      }
      final int playersMove = inputMove.nextInt() - 1;
      //int row = in.nextInt() - 1;
      //int col = in.nextInt() - 1;
      //if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
      //      && board.cells[row][col].content == Seed.EMPTY) {
      if (playersMove <= 8 && board.board[playersMove] == Seed.EMPTY) {
        board.cells[row][col].content = theSeed;
        board.currentRow = row;
        board.currentCol = col;
        validInput = true; // input okay, exit loop
      } else {
        System.out.println("This move at (" + (row + 1) + "," + (col + 1)
               + ") is not valid. Try again...");
      }
    } while (!validInput);   // repeat until input is valid
  } // end public void playerMove(Seed theSeed)
 
  /** Update the currentState after the player with "theSeed" has moved. */
  public void updateGame(Seed theSeed) {
    if (board.hasWon(theSeed)) {  // check for win
      currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.CIRCLE_WON;
    } else if (board.isDraw()) {  // check for draw
      currentState = GameState.DRAW;
    } // end if (board.hasWon(theSeed))
    // Otherwise, no change to current state (still GameState.PLAYING).
  } // end public void updateGame(Seed theSeed)
 
  /** The entry main() method. */
  public static void main(final String[] args) {
    new GameController();  // Let the constructor do the job
  } // end public static void main(final String[] args)
} // end class