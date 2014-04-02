package ca.jianli.designpatterns.creational;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrototypePatternTest {

	@Test
	public void test1() {
		Person a = Factory.getPerson("Tom");
		Person b = Factory.getPerson("Dick");
		Person c = Factory.getPerson("Harry");
		assertEquals("I'm Tom", a.getName());
		assertEquals("I'm Dick", b.getName());
		assertEquals("I'm Harry", c.getName());
	}

}
