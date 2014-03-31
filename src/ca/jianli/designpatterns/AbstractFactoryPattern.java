package ca.jianli.designpatterns;

/**
 * Provides an interface for creating families of related objects without
 * specifying their concrete classes.
 * 
 * Client would create a platform-specific, conconcrete factory that implements
 * abstract factory methods for creating various products. Client uses the
 * factory's abstract method to create platform objects, never create them
 * directly; that is not using new.
 * 
 * This pattern makes exchanging product families easy because the specfic class
 * of the factory object appears only once in the client application, where it
 * is instantiated.
 * 
 * @author Jian Li
 * 
 */
public class AbstractFactoryPattern {

	// product hierachy: abstract product Button and concrete class
	// WindowsButton and MacButton, etc

	public interface Button {
		public String draw();
	}

	public static class WindowsButton implements Button {
		public String draw() {
			return "Draw Windows Button";
		}
	}

	public static class MacButton implements Button {
		public String draw() {
			return "Draw Mac Button";
		}
	}

	public interface Slider {
		public String draw();
	}

	public static class WindowsSlider implements Slider {
		public String draw() {
			return "Draw Windows Slider";
		}
	}

	public static class MacSlider implements Slider {
		public String draw() {
			return "Draw Mac Slider";
		}
	}

	// abstract factory

	public interface AbstractFactory {
		public Button createButton();

		public Slider createSlider();
	}

	// concrete factories implementing product creation for different platforms.

	public static class WindowsFactory implements AbstractFactory {
		public Button createButton() {
			return new WindowsButton();
		}

		public Slider createSlider() {
			return new WindowsSlider();
		}
	}

	public static class MacFactory implements AbstractFactory {
		public Button createButton() {
			return new MacButton();
		}

		public Slider createSlider() {
			return new MacSlider();
		}
	}
}
