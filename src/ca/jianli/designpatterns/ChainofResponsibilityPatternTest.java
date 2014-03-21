package ca.jianli.designpatterns;

import org.junit.Test;

import ca.jianli.designpatterns.ChainofResponsibilityPattern.Handler;

public class ChainofResponsibilityPatternTest {

	@Test
	public void test() {
		Handler handlers = new Handler();
		handlers.add(new Handler());
		handlers.add(new Handler());
		handlers.add(new Handler());
		handlers.wrapAround(handlers);

		for (int i = 0; i < 10; i++) {
			// System.out.println(handlers.doIt(i));
		}
	}

}
