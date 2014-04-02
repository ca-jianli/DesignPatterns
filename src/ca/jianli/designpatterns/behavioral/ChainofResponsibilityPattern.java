package ca.jianli.designpatterns.behavioral;

/**
 * Behavioral Pattern
 * 
 * Chain of Responsibility (223) Avoid coupling the sender of a request to its
 * receiver by giving more than one object a chance to handle the request. Chain
 * the receiving objects and pass the request along the chain until an object
 * handles it.
 * 
 * Chain of responsibility avoid coupling the sender of a request to its
 * receiver by giving more than one object a chance to handle the request. Chain
 * the receiving objects, and pass the request along the chain until an object
 * handles it.
 * 
 * It's like an object-oriented linked list with recursive traversal. Each chain
 * object is a wrapper for the chain object it precedes. When called, it tries
 * to handle the request; if it cannot, it calls the next handler in the chain.
 * 
 * @author Jian Li
 * 
 */
import java.util.Random;

public class ChainofResponsibilityPattern {
	public static class Handler {
		private static int numHandlers = 0;
		private int mId = numHandlers++;
		private Handler mNext;

		public void add(Handler next) {
			if (mNext == null) {
				mNext = next;
			} else {
				mNext.add(next);
			}
		}

		public void wrapAround(Handler start) {
			add(start);
		}

		public String doIt(int task) {
			Random r = new Random();
			if (r.nextInt(3) == 0) {
				return String.format("%d did %d", mId, task);
			} else {
				return String.format("%d is busy... ", mId) + mNext.doIt(task);
			}
		}
	}
}
