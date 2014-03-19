package ca.jianli.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.FacadePattern.Computer;

public class FacadePatternTest {

	@Test
	public void test1() {
		Computer computer = new Computer();
		assertEquals("Success.", computer.start());
	}
}
