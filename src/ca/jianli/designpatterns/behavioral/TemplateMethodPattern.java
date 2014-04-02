package ca.jianli.designpatterns.behavioral;

/**
 * Define the skeleton of an algorithm in an operation. Separate the standard
 * (invariant) steps from the peculiar (variable) steps. Implement the standard
 * step in abstract class, and create placeholder classes for the variable steps
 * which get implemented by the client.
 * 
 * Code from wikipedia
 * 
 */
public class TemplateMethodPattern {
	/**
	 * An abstract class that is common to several games in which players play
	 * against the others, but only one is playing at a given time.
	 */

	static abstract class Game {

		protected int playersCount;

		abstract void initializeGame();

		abstract void makePlay(int player);

		abstract boolean endOfGame();

		abstract void printWinner();

		/* A template method : */
		public final void playOneGame(int playersCount) {
			this.playersCount = playersCount;
			initializeGame();
			int j = 0;
			while (!endOfGame()) {
				makePlay(j);
				j = (j + 1) % playersCount;
			}
			printWinner();
		}
	}

	// Now we can extend this class in order
	// to implement actual games:

	static class Monopoly extends Game {

		/* Implementation of necessary concrete methods */
		void initializeGame() {
			// Initialize players
			// Initialize money
		}

		void makePlay(int player) {
			// Process one turn of player
		}

		boolean endOfGame() {
			// Return true if game is over
			// according to Monopoly rules
			return true;
		}

		void printWinner() {
			// Display who won
		}
		/* Specific declarations for the Monopoly game. */

		// ...
	}

	static class Chess extends Game {

		/* Implementation of necessary concrete methods */
		void initializeGame() {
			// Initialize players
			// Put the pieces on the board
		}

		void makePlay(int player) {
			// Process a turn for the player
		}

		boolean endOfGame() {
			// Return true if in Checkmate or
			// Stalemate has been reached
			return true;
		}

		void printWinner() {
			// Display the winning player
		}
		/* Specific declarations for the chess game. */

		// ...
	}

}
