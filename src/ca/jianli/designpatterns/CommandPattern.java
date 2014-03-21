package ca.jianli.designpatterns;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Command pattern separates the component providing the service from that
 * invoking the service by adding a layer of indirection. By materializing the
 * method call or service as an Command object, the invoker can queue, undo, and
 * log the service requests.
 * 
 * Invoker can issue the request without knowing anything about the operation or
 * the receiver of the requsest.
 * 
 * Formmally, the command base class matches a receiver (object) with an action
 * (a pointer to a member function), and maintains an execute() method that
 * simply calls the action on the receiver.
 * 
 * @author Jian Li
 * 
 */

public class CommandPattern {

	// class that provides the service
	public static class Light {

		void turnOff() {
			System.out.println("Light is off");
		}

		void turnOn() {
			System.out.println("Light is on");
		}
	}

	public interface Command {
		void execute();
	}

	public static class LightOnCommand implements Command {
		Light light;

		public LightOnCommand(Light light) {
			this.light = light;
		}

		@Override
		public void execute() {
			light.turnOn();
		}
	}

	public static class LightOffCommand implements Command {
		Light light;

		public LightOffCommand(Light light) {
			this.light = light;
		}

		@Override
		public void execute() {
			light.turnOff();
		}
	}

	// Invoker class
	public static class Switch {
		Queue<Command> actions = new ArrayDeque<Command>();

		void add(Command c) {
			actions.add(c);
		}

		void service() {
			for (Command c : actions)
				c.execute();
		}
	}
}
