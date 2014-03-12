package ca.jianli;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingletonPatternTest {

	@Test
	public void test1() {
		SingletonPattern.Singleton one = SingletonPattern.Singleton
				.getInstance();
		assertEquals(0, one.get());
		one.set(100);
		assertEquals(100, one.get());

		// two is assigned the same Singleton instance as one

		SingletonPattern.Singleton two = SingletonPattern.Singleton
				.getInstance();
		assertEquals(100, two.get());

		// Below code gives compile error
		// SingletonPattern.Singleton three = new SingletonPattern.Singleton();
	}

}
