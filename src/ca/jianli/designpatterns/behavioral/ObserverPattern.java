package ca.jianli.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer pattern defines a very decoupled interface that allows for multiple
 * observers to be defined at runtime. It defines a one-to-many relationship, in
 * which the subject updates all its registered observers.
 * 
 * The communication can be a mixture of push (passing an object to observer)
 * and pull (passing a pointer to subject to observer, which then can be used to
 * query subject).
 * 
 * @author Jian Li
 * 
 */

public class ObserverPattern {
	public static abstract class Observer {
		private String view;

		public abstract void update(Subject sub, Object arg);

		protected void set(String s) {
			view = s;
		}

		protected String get() {
			return view;
		}
	}

	public static class ObserverA extends Observer {
		public void update(Subject sub, Object arg) {
			set(new String("ObserverA " + this + " gets " + (String) arg));
		}
	}

	public static class ObserverB extends Observer {
		public void update(Subject sub, Object arg) {
			set(new String("ObserverB " + this + " gets " + (String) arg));
		}
	}

	public static class ObserverC extends Observer {
		public void update(Subject sub, Object arg) {
			set(new String("ObserverC " + this + " gets " + (String) arg));
		}
	}

	public static class Subject {
		private List<Observer> observers;

		public Subject() {
			observers = new ArrayList<Observer>();
		}

		public void register(Observer op) {
			observers.add(op);
		}

		public void updateObservers(Object arg) {
			for (Observer op : observers) {
				op.update(this, arg);
			}
		}
	}

}
