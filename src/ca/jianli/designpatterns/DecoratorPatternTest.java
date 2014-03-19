package ca.jianli.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.DecoratorPattern.ChocolateChipDecorator;
import ca.jianli.designpatterns.DecoratorPattern.Icecream;
import ca.jianli.designpatterns.DecoratorPattern.SimpleIcecream;
import ca.jianli.designpatterns.DecoratorPattern.WhipCreamDecorator;

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
