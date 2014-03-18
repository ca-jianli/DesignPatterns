package ca.jianli.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.CompositePattern.Employee;
import ca.jianli.designpatterns.CompositePattern.IndividualContributor;
import ca.jianli.designpatterns.CompositePattern.Manager;

public class CompositePatternTest {

	@Test
	public void test1() {
		Employee m1 = new Manager("Tom");
		Employee i1 = new IndividualContributor("Dick");
		Employee m2 = new Manager("Harry");
		Employee i2 = new IndividualContributor("Joe");
		((Manager) m1).add(i1);
		((Manager) m1).add(m2);
		((Manager) m2).add(i2);
		// m1.list();
		assertEquals(4, m1.count());
	}
}
