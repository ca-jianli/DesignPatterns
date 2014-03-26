package ca.jianli.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.StrategyPattern.Comparator1;
import ca.jianli.designpatterns.StrategyPattern.Comparator2;
import ca.jianli.designpatterns.StrategyPattern.Comparator3;
import ca.jianli.designpatterns.StrategyPattern.Point3D;
import ca.jianli.designpatterns.StrategyPattern.Sort3DPoints;

public class StrategyPatternTest {

	@Test
	public void test() {
		Point3D[] points = new Point3D[3];
		points[0] = new Point3D(1, 2, 3);
		points[1] = new Point3D(3, 1, 2);
		points[2] = new Point3D(2, 3, 1);
		Sort3DPoints sorted;
		sorted = new Sort3DPoints(points, new Comparator1());
		assertEquals("(1, 2, 3) (2, 3, 1) (3, 1, 2) ", sorted.toString());
		sorted = new Sort3DPoints(points, new Comparator2());
		assertEquals("(3, 1, 2) (1, 2, 3) (2, 3, 1) ", sorted.toString());
		sorted = new Sort3DPoints(points, new Comparator3());
		assertEquals("(2, 3, 1) (3, 1, 2) (1, 2, 3) ", sorted.toString());
	}
}