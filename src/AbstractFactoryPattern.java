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
	public interface Button {
		public void draw();
	}

	public static class WindowsButton implements Button {
		public void draw() {
			System.out.println("Draw Windows Button");
		}
	}

	public static class MacButton implements Button {
		public void draw() {
			System.out.println("Draw mac Button");
		}
	}

	// abstract factory

	public interface AbstractFactory {
		public Button createButton();
	}

	// concrete factories implementing product creation for different platforms.

	public static class WindowsFactory implements AbstractFactory {
		public Button createButton() {
			return new WindowsButton();
		}
	}

	public static class MacFactory implements AbstractFactory {
		public Button createButton() {
			return new MacButton();
		}
	}

	public static void main(String[] args) {

		// client is isolated from platform specific implementation and creation
		// of button. client is only aware of the Button interface.

		AbstractFactory factory = new WindowsFactory();
		Button button = factory.createButton();
		button.draw();

		// Simply change the concrete factory to switch to another platform

		factory = new MacFactory();
		button = factory.createButton();
		button.draw();
	}
}
