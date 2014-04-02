package ca.jianli.designpatterns.behavioral;

/**
 * Iterator pattern elevate the traversal of elements in a collection into an
 * object. It allows separation between algorithm and data structure. It allows
 * polymorphic traversal, and different ways of traversal.
 * 
 * @author Jian Li
 * 
 */

public class IteratorPattern {
	public static class LinkedList {
		Node head;
		Node tail;

		protected class Node {
			Node next;
			int val;

			protected Node(int val) {
				this.val = val;
			}
		}

		public void add(int val) {
			if (head == null) {
				head = tail = new Node(val);
			} else {
				tail.next = new Node(val);
				tail = tail.next;
			}
		}

		public Iterator getIterator() {
			return new Iterator(this);
		}

		public class Iterator {
			LinkedList list;
			Node current;

			private Iterator(LinkedList list) {
				this.list = list;
				current = this.list.head;
			}

			public boolean hasNext() {
				return current != null;
			}

			public int next() {
				int ret = current.val;
				current = current.next;
				return ret;
			}
		}
	}
}
