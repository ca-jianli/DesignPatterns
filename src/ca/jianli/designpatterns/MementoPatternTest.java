package ca.jianli.designpatterns;

import org.junit.Test;

import ca.jianli.designpatterns.MementoPattern.Originator;
import ca.jianli.designpatterns.MementoPattern.Originator.Memento;

public class MementoPatternTest {

	@Test
	public void test() {
		Originator originator = new Originator();
		originator.set("state1");
		Memento memento = originator.saveToMemento();
		originator.set("state2");
		originator.restoreFromMemento(memento);
	}

}
