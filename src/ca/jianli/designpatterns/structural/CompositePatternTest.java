package ca.jianli.designpatterns.structural;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.structural.CompositePattern.IndividualContributor;
import ca.jianli.designpatterns.structural.CompositePattern.Manager;

public class CompositePatternTest {

	@Test
	public void test1() {
		Manager m1 = new Manager("Tom");
		IndividualContributor i1 = new IndividualContributor("Dick");
		Manager m2 = new Manager("Harry");
		IndividualContributor i2 = new IndividualContributor("Joe");
		m1.add(i1);
		m1.add(m2);
		m2.add(i2);
		m1.list();
		assertEquals(4, m1.count());
		assertEquals(2, m2.count());
	}
}
