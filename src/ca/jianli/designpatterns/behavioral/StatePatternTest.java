package ca.jianli.designpatterns.behavioral;

import org.junit.Test;

import ca.jianli.designpatterns.behavioral.StatePattern.CeilingFanPullChain;

public class StatePatternTest {

	@Test
	public void test() {
		CeilingFanPullChain context = new CeilingFanPullChain();
		context.pull();
		context.pull();
		context.pull();
		context.pull();
	}

}
