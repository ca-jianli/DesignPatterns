package ca.jianli.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Structural Pattern
 * 
 * Composite (163) Compose objects into tree structures to represent part-whole
 * hierarchies. Composite lets clients treat individual objects and compositions
 * of objects uniformly.
 * 
 * Allow client to treat component and composite uniformly by creating an
 * abstraction over the component and composite, which contains shared
 * attributes and operations. The base class makes composites and components
 * interchangeable.
 * 
 * Recursive composition is allowed. Composite may contain components and as
 * well as other composites. For example, directory may contain files and other
 * directores.
 * 
 * @author Jian Li
 * 
 */
public class CompositePattern {
	static StringBuilder indent = new StringBuilder();

	public static abstract class Employee {
		public Employee(String n) {
			name = n;
		}

		public void list() {
			System.out.println(indent.toString() + name);
		}

		public abstract int count();

		String name;
	}

	public static class Manager extends Employee {
		public Manager(String n) {
			super(n);
			reports = new ArrayList<Employee>();
		}

		public void list() {
			super.list();
			indent.append("   ");
			for (Employee e : reports) {
				e.list();
			}
			indent.setLength(indent.length() - 3);
		}

		public void add(Employee e) {
			if (!reports.contains(e)) {
				reports.add(e);
			}
		}

		public void remove(Employee e) {
			if (reports.contains(e)) {
				reports.remove(e);
			}
		}

		List<Employee> reports;

		@Override
		public int count() {
			int res = 1;
			for (Employee e : reports) {
				res += e.count();
			}
			return res;
		}
	}

	public static class IndividualContributor extends Employee {

		public IndividualContributor(String n) {
			super(n);
		}

		@Override
		public int count() {
			return 1;
		}
	}
}
