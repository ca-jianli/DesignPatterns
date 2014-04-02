package ca.jianli.designpatterns.creational;

/**
 * Creational Pattern
 * 
 * Builder (97) Separate the construction of a complex object from its
 * representation so that the same construction process can create different
 * representations.
 * 
 * The builder pattern separate the construction process of a complex component
 * from the representation. Often a common input format is stored/represented on
 * secondary storage. The builder interface encapsulates the high-level steps
 * required to construct a complex object, which may have a variety
 * implementations. The director/reader parse the common input file, and
 * delegate the construction to the builder.
 * 
 * Client creates a builder and a director, passes the builder to the director.
 * The director invoke the builder service while it interprets the external
 * format. Builder constructs part of the complext component each time its
 * called while maintaining the intermediate state. When product is finished,
 * client retrieves the result from the builder.
 * 
 * @author Jian Li
 * 
 */

public class BuilderPattern {

	// the product of builder

	public static class Meal {
		String drink;
		String fries;
		String burger;

		@Override
		public String toString() {
			return drink + ", " + fries + ", " + burger;
		}
	}

	// builder interface and concrete builders

	public interface Builder {
		public void initializeOrder();

		public void makeDrink();

		public void makeFries();

		public void makeBurger();

		public Meal getMeal();
	}

	public static class WendyBuilder implements Builder {
		Meal meal;

		@Override
		public void initializeOrder() {
			meal = new Meal();
		}

		@Override
		public void makeDrink() {
			meal.drink = "Pepsi";
		}

		@Override
		public void makeFries() {
			meal.fries = "Onion Rings";
		}

		@Override
		public void makeBurger() {
			meal.burger = "Square Burger";
		}

		@Override
		public Meal getMeal() {
			return meal;
		}
	}

	public static class KFCBuilder implements Builder {
		Meal meal;

		@Override
		public void initializeOrder() {
			meal = new Meal();
		}

		@Override
		public void makeDrink() {
			meal.drink = "Coke";
		}

		@Override
		public void makeFries() {
			meal.fries = "French Fries";
		}

		@Override
		public void makeBurger() {
			meal.burger = "KFC Chicken";
		}

		@Override
		public Meal getMeal() {
			return meal;
		}
	}

	// Director takes a concrete implementation of builder and create the
	// product based on a common specification following a series of standard
	// steps.

	public static class Director {
		Builder builder;

		public Director(Builder b) {
			builder = b;
		}

		public void makeOrder(boolean[] order) {
			builder.initializeOrder();

			if (order[0]) {
				builder.makeDrink();
			}
			if (order[1]) {
				builder.makeFries();
			}
			if (order[2]) {
				builder.makeBurger();
			}
		}
	}

}
