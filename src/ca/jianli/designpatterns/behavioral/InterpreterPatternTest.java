package ca.jianli.designpatterns.behavioral;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ca.jianli.designpatterns.behavioral.InterpreterPattern.Expression;
import ca.jianli.designpatterns.behavioral.InterpreterPattern.Number;
import ca.jianli.designpatterns.behavioral.InterpreterPattern.Parser;
import ca.jianli.designpatterns.behavioral.InterpreterPattern.Variable;

public class InterpreterPatternTest {

	@Test
	public void test1() {
		Expression e = new Parser("5 6 +");
		assertEquals(11, e.interpret(null));
	}

	@Test
	public void test2() {
		Map<String, Expression> variables = new HashMap<String, Expression>();
		variables.put("aa", new Number(5));
		variables.put("bb", new Variable("aa"));
		Expression e = new Parser("aa bb + cc -");
		assertEquals(10, e.interpret(variables));
	}
}
