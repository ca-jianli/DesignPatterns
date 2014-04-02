package ca.jianli.designpatterns.behavioral;

/**
 * Behavioral Pattern
 * 
 * State (305) Allow an object to alter its behavior when its internal state
 * changes. The object will appear to change its class.
 * 
 * Allow an object ("context", the wrapper) to change it's internal state (the
 * wrappee). The object will appear to have changed its class. The context
 * contains a pointer to an abstract state class. The concrete state class
 * implementation defines different behaviors for the same method. The wrapper
 * delegates to the wrappee.
 * 
 * The State pattern does not specify where the state transitions will be
 * defined. The choices are two: the "context" object, or each individual State
 * derived class. The advantage of the latter option is ease of adding new State
 * derived classes. The disadvantage is each State derived class has knowledge
 * of (coupling to) its siblings, which introduces dependencies between
 * subclasses. [GoF, p308]
 * 
 * A table-driven approach to designing finite state machines does a good job of
 * specifying state transitions, but it is difficult to add actions to accompany
 * the state transitions. The pattern-based approach uses code (instead of data
 * structures) to specify state transitions, but it does a good job of
 * accomodating state transition actions. [GoF, p308]
 * 
 * @author Jian Li
 * 
 */
public class StatePattern {
	public static class CeilingFanPullChain {
		private State m_state = new stopState();

		public void pull() {
			m_state.pull(this);
		}

		public void setState(State state) {
			m_state = state;
		}
	}

	public interface State {
		public void pull(CeilingFanPullChain context);
	}

	public static class stopState implements State {
		public void pull(CeilingFanPullChain context) {
			System.out.println("Pulling");
			System.out.println("Current state is low-speed");
			context.m_state = new lowSpeedState();

		}
	}

	public static class lowSpeedState implements State {
		public void pull(CeilingFanPullChain context) {
			System.out.println("Pulling");
			System.out.println("Current state is high-speed");
			context.m_state = new highSpeedState();
		}
	}

	public static class highSpeedState implements State {
		public void pull(CeilingFanPullChain context) {
			System.out.println("Pulling");
			System.out.println("Current state is stop");
			context.m_state = new stopState();
		}
	}
}
