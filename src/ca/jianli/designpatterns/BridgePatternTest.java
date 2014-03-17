package ca.jianli.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.BridgePattern.CircleShape;
import ca.jianli.designpatterns.BridgePattern.DrawingAPI1;
import ca.jianli.designpatterns.BridgePattern.DrawingAPI2;
import ca.jianli.designpatterns.BridgePattern.SquareShape;

public class BridgePatternTest {

	@Test
	public void test1() {
		SquareShape square1 = new SquareShape(1, 1, 2, new DrawingAPI1());
		SquareShape square2 = new SquareShape(2, 2, 1, new DrawingAPI2());
		assertEquals("API1 square at 1.000000, 1.000000 with length 2.000000",
				square1.draw());

		assertEquals("API2 square at 2.000000, 2.000000 with length 1.000000",
				square2.draw());
		square2.resizeByPercentage(0.9);
		square2.draw();
		CircleShape circle1 = new CircleShape(0, 0, 1, new DrawingAPI1());
		assertEquals("API1 circle at 0.000000, 0.000000 with radius 1.000000",
				circle1.draw());
	}
}
