package org.meri.antlr_step_by_step.parsers;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;
import org.meri.antlr_step_by_step.parsers.S005SimpleBooleanCompiler.S005Error;

public class S005SimpleBooleanTest {

	@Test
	public void testAnd() {
		//compile the expression
		S005SimpleBooleanCompiler compiler = new S005SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("aaa && bbb");
		
		//check AST structure
		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(0).getType());
		assertEquals(S005SimpleBooleanParser.AND, ast.getChild(1).getType());
		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(2).getType());
	}

	@Test
	public void testOr() {
		//compile the expression
		S005SimpleBooleanCompiler compiler = new S005SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("aaa || bbb");
		
		//check AST structure
		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(0).getType());
		assertEquals(S005SimpleBooleanParser.OR, ast.getChild(1).getType());
		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(2).getType());
	}

	@Test
	public void testNot() {
		//compile the expression
		S005SimpleBooleanCompiler compiler = new S005SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("!aaa");
		
		//check AST structure
		assertEquals(S005SimpleBooleanParser.NOT, ast.getChild(0).getType());
		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(1).getType());
	}

	@Test
	public void testComposedExpression() {
		//compile the expression
		S005SimpleBooleanCompiler compiler = new S005SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("aaa && bbb || !(aaa || ccc)");
		
		//check AST structure
		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(0).getType());
		assertEquals(S005SimpleBooleanParser.AND, ast.getChild(1).getType());
		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(2).getType());
		assertEquals(S005SimpleBooleanParser.OR, ast.getChild(3).getType());
		assertEquals(S005SimpleBooleanParser.NOT, ast.getChild(4).getType());

		assertEquals(S005SimpleBooleanParser.LPAREN, ast.getChild(5).getType());

		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(6).getType());
		assertEquals(S005SimpleBooleanParser.OR, ast.getChild(7).getType());
		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(8).getType());

		assertEquals(S005SimpleBooleanParser.RPAREN, ast.getChild(9).getType());
	}

	@Test
	public void testAnotherCorrectExpression() {
		//compile the expression
		S005SimpleBooleanCompiler compiler = new S005SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("!(bwahaha)");
		
		//check AST structure
		assertEquals(S005SimpleBooleanParser.NOT, ast.getChild(0).getType());
		assertEquals(S005SimpleBooleanParser.LPAREN, ast.getChild(1).getType());
		assertEquals(S005SimpleBooleanParser.NAME, ast.getChild(2).getType());
		assertEquals(S005SimpleBooleanParser.RPAREN, ast.getChild(3).getType());
	}
	
	@Test(expected=S005Error.class)
	public void testCompletelyWrong() {
		//compile the expression
		S005SimpleBooleanCompiler compiler = new S005SimpleBooleanCompiler();
		compiler.compile("Incorrect Expression");
	}

}
