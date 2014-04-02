package ca.jianli.designpatterns.behavioral;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.behavioral.ObserverPattern.ObserverA;
import ca.jianli.designpatterns.behavioral.ObserverPattern.ObserverB;
import ca.jianli.designpatterns.behavioral.ObserverPattern.ObserverC;
import ca.jianli.designpatterns.behavioral.ObserverPattern.Subject;

public class ObserverPatternTest {

	@Test
	public void test1() {
		Subject model = new Subject();
		ObserverA A1 = new ObserverA();
		ObserverA A2 = new ObserverA();
		ObserverB B1 = new ObserverB();
		ObserverC C1 = new ObserverC();

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
