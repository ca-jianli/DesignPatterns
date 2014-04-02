package ca.jianli.designpatterns.behavioral;

import java.util.Map;
import java.util.Stack;

/**
 * Map a domain to a language, a language to a grammar, and the grammar to a
 * hierarchy of object-oriented design.
 * 
 * This is a design pattern that specifies how to evaluate sentences in a
 * language. The basic idea is to have a class for each symbol (terminal or
 * nonterminal) in a specialized computer language. The syntax tree of a
 * sentence in the language is an instance of the composite pattern and is used
 * to evaluate (interpret) the sentence.
 * 
 * For example, define a language which contains Reverse Polish expression like
 * 
 * a b +
 * 
 * Wikipedia
 * 
 */
public class InterpreterPattern {
	interface Expression {
		public int interpret(Map<String, Expression> variables);
	}

	static class Number implements Expression {
		private int number;

		public Number(int number) {
			this.number = number;
		}

		@Override
		public int interpret(Map<String, Expression> variables) {
			return number;
		}
	}

	static class Plus implements Expression {
		Expression leftOperand;
		Expression rightOperand;

		public Plus(Expression left, Expression right) {
			leftOperand = left;
			rightOperand = right;
		}

		public int interpret(Map<String, Expression> variables) {
			return leftOperand.interpret(variables)
					+ rightOperand.interpret(variables);
		}
	}

	static class Minus implements Expression {
		Expression leftOperand;
		Expression rightOperand;

		public Minus(Expression left, Expression right) {
			leftOperand = left;
			rightOperand = right;
		}

		public int interpret(Map<String, Expression> variables) {
			return leftOperand.interpret(variables)
					- rightOperand.interpret(variables);
		}
	}

	static class Variable implements Expression {
		private String name;

		public Variable(String name) {
			this.name = name;
		}

		public int interpret(Map<String, Expression> variables) {
			if (variables.containsKey(name)) {
				return variables.get(name).interpret(variables);
			} else {
				return (new Number(0)).interpret(variables);
			}
		}
	}

	static class Parser implements Expression {
		Stack<Expression> syntaxTree = new Stack<Expression>();

		public Parser(String sentence) {
			String[] tokens = sentence.split(" ");
			for (String token : tokens) {
				if (token.equals("+") || token.equals("-")) {
					Expression op2 = syntaxTree.pop();
					Expression op1 = syntaxTree.pop();
					switch (token) {
					case "+":
						syntaxTree.push(new Plus(op1, op2));
						break;
					case "-":
						syntaxTree.push(new Minus(op1, op2));
						break;
					}
				} else if (isNumeric(token)) {
					syntaxTree.push(new Number(Integer.parseInt(token)));
				} else {
					syntaxTree.push(new Variable(token));
				}
			}
		}

		@Override
		public int interpret(Map<String, Expression> variables) {
			return syntaxTree.pop().interpret(variables);
		}
	}

	@SuppressWarnings("unused")
	static boolean isNumeric(String str) {
		try {
			int d = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
