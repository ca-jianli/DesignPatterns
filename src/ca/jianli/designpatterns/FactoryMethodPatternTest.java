package ca.jianli.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.creational.FactoryMethodPattern.Fruit;
import ca.jianli.designpatterns.creational.FactoryMethodPattern.FruitFactory;

public class FactoryMethodPatternTest {

	@Test
	public void test1() {
		for (int i = 0; i < 3; i++) {
			Fruit f = FruitFactory.create(i);
			String name = f.getName();
			switch (name) {
			case "apple":
				assertEquals("red", f.getColor());
				break;
			case "banana":
				assertEquals("yellow", f.getColor());
				break;
			case "strawberry":
				assertEquals("red", f.getColor());
				break;
			default:
			}

			// Error below because constructor for Apple is private
			// Fruit f = new FactoryMethodPattern.Apple();
		}
	}
}
