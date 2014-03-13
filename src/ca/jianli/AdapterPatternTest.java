package ca.jianli;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.AdapterPattern.QueueWrapper;

public class AdapterPatternTest {

	@Test
	public void test1() {
		QueueWrapper<String> q = new QueueWrapper<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		assertEquals("A", q.deqeue());
		assertEquals("B", q.deqeue());
		assertEquals("C", q.deqeue());
		assertEquals("D", q.deqeue());
	}
}
