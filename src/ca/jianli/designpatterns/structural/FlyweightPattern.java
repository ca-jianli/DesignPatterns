package ca.jianli.designpatterns.structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Structural Pattern
 * 
 * Flyweight (195) Use sharing to support large numbers of fine-grained objects
 * efficiently.
 * 
 * When we need to create many (small) objects that share certain intrinsic
 * properties, we can improve memory usage effciency by separating out the
 * shared intrinsic property and wrap it inside a flyweight class. The client
 * would call one or a few instances of the flyweight objects using factory
 * method, and provide the extrinsic properties that differentiate the
 * components.
 * 
 * Example from Wikipeida entry. Instead of creating a Flavor object for each
 * Order, the same instance is reused.
 * 
 */
public class FlyweightPattern {
	// Instances of CoffeeFlavour will be the Flyweights
	public static class CoffeeFlavour {
		private final String name;

		CoffeeFlavour(String newFlavor) {
			this.name = newFlavor;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	// Menu acts as a factory and cache for CoffeeFlavour flyweight objects
	public static class Menu {
		private Map<String, CoffeeFlavour> flavours = new HashMap<String, CoffeeFlavour>();

		CoffeeFlavour lookup(String flavorName) {
			if (!flavours.containsKey(flavorName))
				flavours.put(flavorName, new CoffeeFlavour(flavorName));
			return flavours.get(flavorName);
		}

		int totalCoffeeFlavoursMade() {
			return flavours.size();
		}
	}

	public static class Order {
		private final int tableNumber;
		private final CoffeeFlavour flavour;

		Order(int tableNumber, CoffeeFlavour flavor) {
			this.tableNumber = tableNumber;
			this.flavour = flavor;
		}

		void serve() {
			System.out.println("Serving " + flavour + " to table "
					+ tableNumber);
		}
	}

	public static class CoffeeShop {
		private final List<Order> orders = new ArrayList<Order>();
		private final Menu menu = new Menu();

		void takeOrder(String flavourName, int table) {
			CoffeeFlavour flavour = menu.lookup(flavourName);
			Order order = new Order(table, flavour);
			orders.add(order);
		}

		void service() {
			for (Order order : orders)
				order.serve();
		}

		String report() {
			return "total CoffeeFlavour objects made: "
					+ menu.totalCoffeeFlavoursMade();
		}

	}
}