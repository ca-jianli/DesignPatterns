package ca.jianli;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbstractFactoryPatternTest {

	@Test
	public void test1() {

		// client is isolated from platform specific implementation and creation
		// of button. client is only aware of the Button interface.

		AbstractFactoryPattern.AbstractFactory factory = new AbstractFactoryPattern.WindowsFactory();
		AbstractFactoryPattern.Button button = factory.createButton();
		assertEquals("Draw Windows Button", button.draw());

		// Simply change the concrete factory to switch to another platform

		factory = new AbstractFactoryPattern.MacFactory();
		button = factory.createButton();
		assertEquals("Draw Mac Button", button.draw());
	}
}
