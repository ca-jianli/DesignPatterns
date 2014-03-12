package ca.jianli;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.SingletonPattern.Singleton;

public class SingletonPatternTest {

	@Test
	public void test1() {
		Singleton one = Singleton.getInstance();
		assertEquals(0, one.get());
		one.set(100);
		assertEquals(100, one.get());

		// two is assigned the same Singleton instance as one

		Singleton two = Singleton.getInstance();
		assertEquals(100, two.get());

		// Below code gives compile error
		// Singleton three = new Singleton();
	}

}
