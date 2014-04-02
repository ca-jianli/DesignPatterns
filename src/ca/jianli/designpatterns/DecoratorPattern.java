package ca.jianli.designpatterns;

/**
 * Structural Pattern
 * 
 * Decorator (175) Attach additional responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to subclassing for extending
 * functionality.
 * 
 * Attach additional responsibilities to an object dynamically. Client can
 * specify embellishment of a core object by recursively wrapping it.
 * 
 * Solve the problem of adding additional behavior to individual object at
 * run-time. Inheritance is not desired because it is static and applies to an
 * entire class.
 * 
 * A single core (or non-optional) component, several optional embellishments or
 * wrappers, and an interface common to all. A second level base class to
 * support wrapper functionality; all decorators (optional) components extend
 * from this class. This class contains a pointer to the interface; hence
 * allowing recursive composition.
 * 
 * @author Jian Li
 * 
 */
public class DecoratorPattern {

	// a common interface to core component and decorator components

	public interface Icecream {
		public String makeIcecream();
	}

	// abstract decorator containing a pointer to the core component

	public static abstract class IcecreamDecorator implements Icecream {
		protected Icecream specialIcecream; // wrappee

		public IcecreamDecorator(Icecream specialIcecream) {
			this.specialIcecream = specialIcecream;
		}

		@Override
		public String makeIcecream() {
			return specialIcecream.makeIcecream();
		}
	}

	// concrete decorators that embelishes the core component

	public static class ChocolateChipDecorator extends IcecreamDecorator {

		public ChocolateChipDecorator(Icecream specialIcecream) {
			super(specialIcecream);
		}

		@Override
		public String makeIcecream() {
			StringBuilder sb = new StringBuilder(super.makeIcecream());
			sb.append(" with chocolate chips");
			return sb.toString();
		}
	}

	public static class WhipCreamDecorator extends IcecreamDecorator {

		public WhipCreamDecorator(Icecream specialIcecream) {
			super(specialIcecream);
		}

		@Override
		public String makeIcecream() {
			StringBuilder sb = new StringBuilder(super.makeIcecream());
			sb.append(" with whipped cream");
			return sb.toString();
		}
	}

	// core component

	public static class SimpleIcecream implements Icecream {

		public String makeIcecream() {
			return "A simple icecream";
		}
	}
}
