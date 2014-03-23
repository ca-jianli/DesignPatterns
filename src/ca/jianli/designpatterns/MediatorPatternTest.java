package ca.jianli.designpatterns;

import org.junit.Test;

import ca.jianli.designpatterns.MediatorPattern.Colleague;
import ca.jianli.designpatterns.MediatorPattern.Mediator;

public class MediatorPatternTest {

	@Test
	public void test() {
		Mediator med = new Mediator();
		Colleague c1 = new Colleague(med, "Bob");
		Colleague c2 = new Colleague(med, "Jane");
		Colleague c3 = new Colleague(med, "Adam");
		med.register(c1);
		med.register(c2);
		med.register(c3);
		c1.send("hello");
	}

}
