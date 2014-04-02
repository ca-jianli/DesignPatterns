package ca.jianli.designpatterns.behavioral;

/**
 * Uses double dispatching. Represent an operation to be performed on the
 * elements of an object hierarchy. Visitor let you define a new operation
 * without changing the classes of elements it operates on. It requires the
 * element hierarchy and interface to be stable.
 * 
 * The two hierarchies are intertwined. Element hierarchy is coupled to the
 * visitor base class. Visitor hierarchy is coupled to each element derived
 * class. Create a concrete visitor class for each operation on the element
 * hierarchy, that does different work on different elements.
 * 
 * @author Jian Li
 * 
 */
public class VisitorPattern {
	public interface Color {
		public void accept(Visitor visitor);
	}

	public static class Red implements Color {
		public void accept(Visitor visitor) {
			visitor.visit(this);
		}

		public String eye() {
			return "Red Eye";
		}
	}

	public static class Blue implements Color {
		public void accept(Visitor visitor) {
			visitor.visit(this);
		}

		public String sky() {
			return "Blue Sky";
		}
	}

	public static abstract class Visitor {
		public abstract void visit(Red red);

		public abstract void visit(Blue blue);
	}

	public static class Counter extends Visitor {
		private int redCount;
		private int blueCount;

		@Override
		public void visit(Red red) {
			++redCount;
		}

		@Override
		public void visit(Blue blue) {
			++blueCount;
		}

		public int getRedCount() {
			return redCount;
		}

		public int getBlueCount() {
			return blueCount;
		}
	}

	public static class Printer extends Visitor {

		@Override
		public void visit(Red red) {
			System.out.println(red.eye());
		}

		@Override
		public void visit(Blue blue) {
			System.out.println(blue.sky());
		}

	}
}
