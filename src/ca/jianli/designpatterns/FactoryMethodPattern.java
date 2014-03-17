package ca.jianli.designpatterns;

/**
 * Factory method defines an interface or high-level logic for constructing an
 * object, and defers the actual implementation details to subclasses.
 * 
 * There two common implementation of factory method.
 * 
 * 1) a superclass specifies all standard and generic behavior using virtual
 * placeholders for creation steps, and then delegate the creation details to
 * subclasses. This is similar to abstract factory method without the emphasis
 * on families. This is the original implementation discussed in the Gang of
 * Four.
 * 
 * 2) static method of a class is used to return an object of a type; this
 * object may be of a sub-class, may be of an existing instance reused, and may
 * have a more descriptive name.
 * 
 * Method 2 is becoming more popular. One reason being that it completely
 * decouples the client from the implementation details of derived classes.
 * 
 * Method 2 is implemented here.  
 * 
 * Method 2 is called Simple Factory Method.
 * 
 * @author Jian Li
 * 
 */
public class FactoryMethodPattern {

	// Factory class with static factory method create();
	public static class FruitFactory {
		public static Fruit create(int arg) {
			switch (arg) {
			case 0:
				return new Apple();
			case 1:
				return new Banana();
			case 2:
				return new Strawberry();
			}
			return null;
		}
	}

	// Fruit interface and concrete fruit classes with private constructor

	public interface Fruit {
		public String getColor();

		public String getName();
	}

	public static class Apple implements Fruit {
		private Apple() {
		}

		public String getColor() {
			return "red";
		}

		public String getName() {
			return "apple";
		}
	}

	public static class Strawberry implements Fruit {
		private Strawberry() {
		}

		public String getColor() {
			return "red";
		}

		public String getName() {
			return "strawberry";
		}
	}

	public static class Banana implements Fruit {
		private Banana() {
		}

		public String getColor() {
			return "yellow";
		}

		public String getName() {
			return "banana";
		}
	}
}
