package ca.jianli;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ObserverPatternTest {

	@Test
	public void test1() {
		ObserverPattern.Subject model = new ObserverPattern.Subject();
		ObserverPattern.ObserverA A1 = new ObserverPattern.ObserverA();
		ObserverPattern.ObserverA A2 = new ObserverPattern.ObserverA();
		ObserverPattern.ObserverB B1 = new ObserverPattern.ObserverB();
		ObserverPattern.ObserverC C1 = new ObserverPattern.ObserverC();

		model.register(A1);
		model.register(A2);
		model.register(B1);
		model.register(C1);

		String msg = "good news!";
		model.updateObservers(msg);
		assertEquals("ObserverA " + A1 + " gets " + msg, A1.get());
		assertEquals("ObserverA " + A2 + " gets " + msg, A2.get());
		assertEquals("ObserverB " + B1 + " gets " + msg, B1.get());
		assertEquals("ObserverC " + C1 + " gets " + msg, C1.get());
	}
}
