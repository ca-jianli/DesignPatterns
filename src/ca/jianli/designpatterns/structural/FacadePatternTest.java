package ca.jianli.designpatterns.structural;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.structural.FacadePattern.Computer;

public class FacadePatternTest {

	@Test
	public void test1() {
		Computer computer = new Computer();
		assertEquals("Success.", computer.start());
	}
}
