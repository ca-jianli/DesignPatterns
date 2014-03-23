package ca.jianli.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Mediator elevates the communications between many-to-many objects into an OOD
 * class. It decouples the sources and destinations. Each object communicate
 * with the mediator class.
 * 
 * Need to balance the principle of decoupling with that of even distribution of
 * responsibility. Be careful not to create a controller or a "God" object.
 * 
 * @author Jian Li
 * 
 */
public class MediatorPattern {
	public static class Mediator {
		List<Colleague> colleagues = new ArrayList<Colleague>();

		void sendMessage(String msg, Colleague col) {
			for (Colleague other : colleagues) {
				if (other != col) {
					other.receive(msg);
				}
			}
		}

		void register(Colleague col) {
			colleagues.add(col);
		}
	}

	public static class Colleague {
		Mediator med;
		String name;

		public Colleague(Mediator med, String name) {
			this.med = med;
			this.name = name;
		}

		public void send(String msg) {
			System.out.format("%s is sending message: %s\n", name, msg);
			med.sendMessage(msg, this);
		}

		public void receive(String msg) {
			System.out.format("%s received message: %s\n", name, msg);
		}
	}
}
