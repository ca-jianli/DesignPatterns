package ca.jianli.designpatterns.structural;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jianli.designpatterns.structural.ProxyPattern.Cheque;
import ca.jianli.designpatterns.structural.ProxyPattern.FundsFromBankAccount;
import ca.jianli.designpatterns.structural.ProxyPattern.Payment;

public class ProxyPatternTest {

	@Test
	public void test() {
		Payment p1 = new Cheque(100);
		Payment p2 = new FundsFromBankAccount(100);
		assertEquals(p1.amount(), p2.amount());
	}

}
