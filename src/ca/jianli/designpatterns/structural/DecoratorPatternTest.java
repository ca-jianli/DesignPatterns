package ca.jianli.designpatterns.structural;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.structural.DecoratorPattern.ChocolateChipDecorator;
import ca.jianli.designpatterns.structural.DecoratorPattern.Icecream;
import ca.jianli.designpatterns.structural.DecoratorPattern.SimpleIcecream;
import ca.jianli.designpatterns.structural.DecoratorPattern.WhipCreamDecorator;

public class DecoratorPatternTest {

	@Test
	public void test1() {
		Icecream icecream = new SimpleIcecream();

		assertEquals("A simple icecream", icecream.makeIcecream());

		icecream = new ChocolateChipDecorator(new WhipCreamDecorator(icecream));

		assertEquals(
				"A simple icecream with whipped cream with chocolate chips",
				icecream.makeIcecream());
	}

}
