package ca.jianli.designpatterns.structural;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.structural.FlyweightPattern.CoffeeShop;

public class FlyweightPatternTest {

	@Test
	public void test() {

		CoffeeShop shop = new CoffeeShop();

		shop.takeOrder("Cappuccino", 2);
		shop.takeOrder("Frappe", 1);
		shop.takeOrder("Espresso", 1);
		shop.takeOrder("Frappe", 897);
		shop.takeOrder("Cappuccino", 97);
		shop.takeOrder("Frappe", 3);
		shop.takeOrder("Espresso", 3);
		shop.takeOrder("Cappuccino", 3);
		shop.takeOrder("Espresso", 96);
		shop.takeOrder("Frappe", 552);
		shop.takeOrder("Cappuccino", 121);
		shop.takeOrder("Espresso", 121);

		shop.service();
		assertEquals("total CoffeeFlavour objects made: 3", shop.report());
	}

}
