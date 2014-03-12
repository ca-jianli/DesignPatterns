package ca.jianli;

/**
 * Singleton design pattern makes the class of the single instance object
 * responsible for creation and management of the instance. The constructor is
 * made private, and a public method encapsulates the initialization code for
 * the instance, which has a static pointer in the class, and provide access for
 * it.
 * 
 * Singleton should be considered only if the following three criteria are
 * satisfied: 1. ownership of the single instance cannot be easily assigned 2.
 * lazy initialization is desirable 3. global access is not otherwise provided
 * for.
 * 
 * @author Jian Li
 * 
 */
public class SingletonPattern {
	public static class Singleton {

		private int value;

		// single instance of class

		private static Singleton singleton = null;

		// private constructor

		private Singleton() {
			// do something;
		}

		// public accessor method with lazy construction

		public static Singleton getInstance() {
			if (singleton == null) {
				singleton = new Singleton();
			}
			return singleton;
		}

		public int get() {
			return value;
		}

		public void set(int x) {
			value = x;
		}

	}

	public static void main(String[] args) {
		// do nothing
	}
}
