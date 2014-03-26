package ca.jianli.designpatterns;

/**
 * The Strategy design pattern is about making alternate implementations of an
 * algorithm interchangeable, and coupling the client of that algorithm to an
 * interface only.
 * 
 * @author Jian Li
 * 
 */
public class StrategyPattern {
	public static class Point3D {
		final int x, y, z;

		public Point3D(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public String toString() {
			return "(" + x + ", " + y + ", " + z + ")";
		}
	}

	public interface Comparator {
		public int compare(Point3D p1, Point3D p2);
	}

	public static class Comparator1 implements Comparator {
		public int compare(Point3D p1, Point3D p2) {
			if (p1.x < p2.x)
				return -1;
			if (p1.x > p2.x)
				return 1;
			return 0;
		}
	}

	public static class Comparator2 implements Comparator {
		public int compare(Point3D p1, Point3D p2) {
			if (p1.y < p2.y)
				return -1;
			if (p1.y > p2.y)
				return 1;
			return 0;
		}
	}

	public static class Comparator3 implements Comparator {
		public int compare(Point3D p1, Point3D p2) {
			if (p1.z < p2.z)
				return -1;
			if (p1.z > p2.z)
				return 1;
			return 0;
		}
	}

	public static class Sort3DPoints {
		private Comparator comparator;
		private Point3D[] points;

		public Sort3DPoints(Point3D[] points, Comparator comparator) {
			this.points = new Point3D[points.length];
			for (int i = 0; i < points.length; i++) {
				this.points[i] = points[i];
			}
			this.comparator = comparator;
			sort();
		}

		private void sort() {
			for (int i = 1; i < points.length; i++) {
				for (int j = i; j > 0; j--) {
					if (comparator.compare(points[j], points[j - 1]) < 0) {
						Point3D tmp = points[j];
						points[j] = points[j - 1];
						points[j - 1] = tmp;
					}
				}
			}
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (Point3D p : points) {
				sb.append(p.toString() + " ");
			}
			return sb.toString();
		}
	}
}
