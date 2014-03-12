package ca.jianli;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuilderPatternTest {

	@Test
	public void test1() {
		BuilderPattern.KFCBuilder kfcMeal = new BuilderPattern.KFCBuilder();
		BuilderPattern.WendyBuilder wendyMeal = new BuilderPattern.WendyBuilder();
		BuilderPattern.Director chef;

		chef = new BuilderPattern.Director(kfcMeal);
		chef.makeOrder(new boolean[] { true, true, true });
		assertEquals("Coke, French Fries, KFC Chicken", kfcMeal.getMeal()
				.toString());

		chef = new BuilderPattern.Director(wendyMeal);
		chef.makeOrder(new boolean[] { true, true, true });
		assertEquals("Pepsi, Onion Rings, Square Burger", wendyMeal.getMeal()
				.toString());

		chef = new BuilderPattern.Director(kfcMeal);
		chef.makeOrder(new boolean[] { true, false, true });
		assertEquals("Coke, null, KFC Chicken", kfcMeal.getMeal().toString());

		chef = new BuilderPattern.Director(wendyMeal);
		chef.makeOrder(new boolean[] { false, true, true });
		assertEquals("null, Onion Rings, Square Burger", wendyMeal.getMeal()
				.toString());
	}

}
