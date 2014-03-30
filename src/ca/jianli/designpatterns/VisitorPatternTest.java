package ca.jianli.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.VisitorPattern.Blue;
import ca.jianli.designpatterns.VisitorPattern.Color;
import ca.jianli.designpatterns.VisitorPattern.Counter;
import ca.jianli.designpatterns.VisitorPattern.Printer;
import ca.jianli.designpatterns.VisitorPattern.Red;

public class VisitorPatternTest {

	@Test
	public void test() {
		Color[] colors = new Color[] { new Red(), new Blue(), new Red(),
				new Blue(), new Red() };

		Counter counter = new Counter();
		Printer printer = new Printer();
		for (Color color : colors) {
			color.accept(counter);
			color.accept(printer);
		}
		assertEquals(3, counter.getRedCount());
		assertEquals(2, counter.getBlueCount());
	}

}
