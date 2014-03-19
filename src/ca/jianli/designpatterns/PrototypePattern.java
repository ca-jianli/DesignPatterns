package ca.jianli.designpatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype pattern co-opts one instance ("prototype") of a class for use as a
 * breeder of all future instances
 * 
 * Each concrete class implements a method called clone() which returns a new
 * instance of the class. The base class contains the interface or abstract
 * method clone().
 * 
 * The base class, or a Factory class, contains a dictionary of all "cloneable"
 * concrete derived classes, and a method to return a instance of the desired
 * class by calling the clone() method of the contained instance. The client
 * calls a method in the base class or factory class with a argument to select
 * which product to create.
 * 
 * @author Jian Li
 * 
 */

public class PrototypePattern {
	interface Person {
		Person clone();

		String getName();
	}

	static class Tom implements Person {
		public Person clone() {
			return new Tom();
		}

		public String getName() {
			return "I'm Tom";
		}
	}

	static class Dick implements Person {
		public Person clone() {
			return new Dick();
		}

		public String getName() {
			return "I'm Dick";
		}
	}

	static class Harry implements Person {
		public Person clone() {
			return new Harry();
		}

		public String getName() {
			return "I'm Harry";
		}
	}

	static class Factory {
		private static Map<String, Person> prototypes = new HashMap<String, Person>();
		static {
			prototypes.put("Tom", new Tom());
			prototypes.put("Dick", new Dick());
			prototypes.put("Harry", new Harry());
		}

		public static Person getPerson(String s) {
			return ((Person) prototypes.get(s)).clone();
		}
	}
}
