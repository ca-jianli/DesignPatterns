package ca.jianli.designpatterns.behavioral;

/**
 * Memento pattern elevates the rollback and undo of the state ("memento") of an
 * object ("originator") to full object status. The client ("caretaken") knows
 * when and why to backup the state of the "originator". The "originator" knows
 * how to take a snapshot of its internal state to create a "memento", and later
 * use it to restore itself to this state.
 * 
 * Example from Wikipedia
 * 
 * @author Jian Li
 * 
 */

public class MementoPattern {

	static class Originator {
		private String state;

		// The class could also contain additional data that is not part of the
		// state saved in the memento..

		public void set(String state) {
			System.out.println("Originator: Setting state to " + state);
			this.state = state;
		}

		public Memento saveToMemento() {
			System.out.println("Originator: Saving to Memento.");
			return new Memento(state);
		}

		public void restoreFromMemento(Memento memento) {
			state = memento.getSavedState();
			System.out
					.println("Originator: State after restoring from Memento: "
							+ state);
		}

		public static class Memento {
			private final String state;

			public Memento(String stateToSave) {
				state = stateToSave;
			}

			public String getSavedState() {
				return state;
			}
		}
	}
}
