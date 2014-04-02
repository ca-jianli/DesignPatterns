package ca.jianli.designpatterns.creational;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingletonPatternTest {

	@Test
	public void test1() {
		Singleton one = Singleton.getInstance();
		Singleton two = Singleton.getInstance();

		assertEquals(one, two);

		// Below code gives compile error
		// Singleton three = new Singleton();
	}

}
