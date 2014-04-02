package ca.jianli.designpatterns;

/**
 * Structural Pattern
 * 
 * Facade (185) Provide a unified interface to a set of interfaces in a
 * subsystem. Facade defines a higher-level interface that makes the subsystem
 * easier to use.
 * 
 * Provide a unified interface to a set of interfaces. Facde defines a
 * higher-level interface that makes the subsystem easier to use. Wrap a
 * complicated subsystem with a simpler interface.
 * 
 * Difference between facade pattern and adapter pattern is the intent, not the
 * number of wrappees.
 * 
 * @author Jian Li
 * 
 */
public class FacadePattern {

	public static class CPU {
		public void boot() {
			// does work
		}
	}

	public static class Ram {
		public void reset() {
			// does work
		}
	}

	public static class HardDrive {
		public void spin() {
			// does work
		}
	}

	// Computer is a facade for the underlying subsystems.
	public static class Computer {
		private CPU cpu = new CPU();
		private Ram ram = new Ram();
		private HardDrive harddrive = new HardDrive();

		public String start() {
			cpu.boot();
			ram.reset();
			harddrive.spin();
			return "Success.";
		}
	}
}
