package ca.jianli.designpatterns;

import org.junit.Test;

import ca.jianli.designpatterns.StatePattern.CeilingFanPullChain;

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
