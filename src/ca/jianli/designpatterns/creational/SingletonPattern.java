package ca.jianli.designpatterns.creational;

/**
 * Creational Pattern
 * 
 * Singleton (127) Ensure a class only has one instance, and provide a global
 * point of access to it.
 * 
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

		// private constructor

		private Singleton() {
			// do initialization;
		}

		// public accessor method with lazy construction using nested static
		// class; thread safe and lazy loading without need for synchronization
		// or locks; SingletonHolder class doesn't get loaded until
		// Singleton.getInstance() is called for the first time

		private static class SingletonHolder {
			public static final Singleton instance = new Singleton();
		}

		public static Singleton getInstance() {
			return SingletonHolder.instance;
		}

	}
}
