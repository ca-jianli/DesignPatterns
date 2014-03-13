package ca.jianli;

import java.util.Stack;

/**
 * Adapter is a wrapper that wraps an existing class ("adaptee") with a new
 * interface, that the client want to use. The adapter "has" an instance of the
 * old class, and maps the client interface to the adaptee interface.
 * 
 * @author Jian Li
 * 
 */
public class AdapterPattern {
	public interface Queue<T> {
		public void enqueue(T t);

		public T deqeue();

		public boolean isEmpty();

		public int size();
	}

	public static class QueueWrapper<T> implements Queue<T> {
		private Stack<T> stack;

		public QueueWrapper() {
			stack = new Stack<T>();
		}

		@Override
		public void enqueue(T t) {
			stack.push(t);
		}

		@Override
		public T deqeue() {
			if (stack.isEmpty())
				return null;
			Stack<T> temp = new Stack<T>();
			while (!stack.isEmpty())
				temp.push(stack.pop());
			T ret = temp.pop();
			while (!temp.isEmpty())
				stack.push(temp.pop());
			return ret;
		}

		@Override
		public boolean isEmpty() {
			return stack.isEmpty();
		}

		@Override
		public int size() {
			return stack.size();
		}
	}
}
