package ca.jianli.designpatterns;

import org.junit.Test;

import ca.jianli.designpatterns.CommandPattern.Light;
import ca.jianli.designpatterns.CommandPattern.LightOffCommand;
import ca.jianli.designpatterns.CommandPattern.LightOnCommand;
import ca.jianli.designpatterns.CommandPattern.Switch;

public class CommandPatternTest {

	@Test
	public void test() {

		// client creates a series of commands and pass on to the invoker to
		// execute

		Switch switch0 = new Switch(); // invoker class
		Light light = new Light(); // service class

		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0) {
				switch0.add(new LightOnCommand(light));
			} else {
				switch0.add(new LightOffCommand(light));
			}
		}

		switch0.service();
	}
}
