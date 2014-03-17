package ca.jianli.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.AbstractFactoryPattern.AbstractFactory;
import ca.jianli.designpatterns.AbstractFactoryPattern.Button;
import ca.jianli.designpatterns.AbstractFactoryPattern.MacFactory;
import ca.jianli.designpatterns.AbstractFactoryPattern.WindowsFactory;

public class AbstractFactoryPatternTest {

	@Test
	public void test1() {

		// client is isolated from platform specific implementation and creation
		// of button. client is only aware of the Button interface.

		AbstractFactory factory = new WindowsFactory();
		Button button = factory.createButton();
		assertEquals("Draw Windows Button", button.draw());

		// Simply change the concrete factory to switch to another platform

		factory = new MacFactory();
		button = factory.createButton();
		assertEquals("Draw Mac Button", button.draw());
	}
}
