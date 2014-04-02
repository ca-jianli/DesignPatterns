package ca.jianli.designpatterns;

/**
 * Structural Pattern
 * 
 * Bridge (151) Decouple an abstraction from its implementation so that the two
 * can vary independently.
 * 
 * Bridge pattern separates the implementation from the abstraction so the two
 * can vary independently. Insulation. Expose an interface to implementation in
 * the class abstraction, but buries concrete implementation in its own
 * hierarchy.
 * 
 * Separate the component into abstraction and implemention. Implementations
 * become interchangeable at time of component instantiation.
 * 
 * Abstraction hiearchy of the component defined as a wrapper to the
 * implementation hierarchy.
 * 
 * Client chooses the wrapper object, and may substitute the wrappee object.
 * 
 * As the client makes request, the abstraction objects simply delegates to the
 * implementation object.
 * 
 * @author Jian Li
 * 
 */

public class BridgePattern {

	public interface DrawingAPI {
		public String drawCircle(double x, double y, double radius);

		public String drawSquare(double x, double y, double length);
	}

	public static class DrawingAPI1 implements DrawingAPI {
		public String drawCircle(double x, double y, double radius) {
			return String.format("API1 circle at %f, %f with radius %f", x, y,
					radius);
		}

		@Override
		public String drawSquare(double x, double y, double length) {
			return String.format("API1 square at %f, %f with length %f", x, y,
					length);
		}
	}

	public static class DrawingAPI2 implements DrawingAPI {
		public String drawCircle(double x, double y, double radius) {
			return String.format("API2 circle at %f, %f with radius %f", x, y,
					radius);
		}

		@Override
		public String drawSquare(double x, double y, double length) {
			return String.format("API2 square at %f, %f with length %f", x, y,
					length);
		}
	}

	public static abstract class Shape {
		protected DrawingAPI drawingAPI;

		protected Shape(DrawingAPI drawingAPI) {
			this.drawingAPI = drawingAPI;
		}

		public abstract String draw();

		public abstract void resizeByPercentage(double pct);

	}

	public static class CircleShape extends Shape {
		public double x, y, radius;

		protected CircleShape(double x, double y, double radius,
				DrawingAPI drawingAPI) {
			super(drawingAPI);
			this.x = x;
			this.y = y;
			this.radius = radius;
		}

		@Override
		public String draw() {
			return drawingAPI.drawCircle(x, y, radius);
		}

		@Override
		public void resizeByPercentage(double pct) {
			radius *= pct;
		}
	}

	public static class SquareShape extends Shape {
		private double x, y, length;

		protected SquareShape(double x, double y, double length,
				DrawingAPI drawingAPI) {
			super(drawingAPI);
			this.x = x;
			this.y = y;
			this.length = length;
		}

		@Override
		public String draw() {
			return drawingAPI.drawSquare(x, y, length);
		}

		@Override
		public void resizeByPercentage(double pct) {
			length *= pct;
		}
	}
}
