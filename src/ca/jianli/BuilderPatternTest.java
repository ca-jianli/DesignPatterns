package ca.jianli;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.BuilderPattern.Director;
import ca.jianli.BuilderPattern.KFCBuilder;
import ca.jianli.BuilderPattern.WendyBuilder;

public class BuilderPatternTest {

	@Test
	public void test1() {
		KFCBuilder kfcMeal = new KFCBuilder();
		WendyBuilder wendyMeal = new WendyBuilder();
		Director chef;

		chef = new Director(kfcMeal);
		chef.makeOrder(new boolean[] { true, true, true });
		assertEquals("Coke, French Fries, KFC Chicken", kfcMeal.getMeal()
				.toString());

		chef = new Director(wendyMeal);
		chef.makeOrder(new boolean[] { true, true, true });
		assertEquals("Pepsi, Onion Rings, Square Burger", wendyMeal.getMeal()
				.toString());

		chef = new Director(kfcMeal);
		chef.makeOrder(new boolean[] { true, false, true });
		assertEquals("Coke, null, KFC Chicken", kfcMeal.getMeal().toString());

		chef = new Director(wendyMeal);
		chef.makeOrder(new boolean[] { false, true, true });
		assertEquals("null, Onion Rings, Square Burger", wendyMeal.getMeal()
				.toString());
	}

}
