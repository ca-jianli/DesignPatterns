package ca.jianli.designpatterns;

/**
 * A proxy is a wrapper to the real object. It shares the same interface as the
 * underlying object. It can provides additional leverage such as, not limited
 * to:
 * 
 * 1. lazy construction for expensive to create object
 * 
 * 2. access control to sensitive object, check permission
 * 
 * 3. local representitive for an object that resides in a different space
 * 
 * @author Jian Li
 * 
 */
public class ProxyPattern {
	public interface Payment {
		public int amount();
	}

	public static class FundsFromBankAccount implements Payment {
		int value;

		public FundsFromBankAccount(int x) {
			value = x;
		}

		public int amount() {
			return value;
		}
	}

	public static class Cheque implements Payment {
		int value;
		private FundsFromBankAccount realFund;

		public Cheque(int x) {
			value = x;
		}

		public int amount() {
			if (realFund == null) {
				realFund = new FundsFromBankAccount(value);
			}
			return realFund.amount();
		}
	}
}
