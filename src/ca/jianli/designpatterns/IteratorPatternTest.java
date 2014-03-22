package ca.jianli.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.IteratorPattern.LinkedList;

public class IteratorPatternTest {

	@Test
	public void test() {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		LinkedList.Iterator iterator = list.getIterator();
		int sum = 0;
		while (iterator.hasNext()) {
			sum += iterator.next();
		}
		assertEquals(8, sum);
	}

}
