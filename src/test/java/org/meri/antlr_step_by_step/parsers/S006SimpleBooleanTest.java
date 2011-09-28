package org.meri.antlr_step_by_step.parsers;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;
import org.meri.antlr_step_by_step.parsers.S006SimpleBooleanCompiler.S006Error;

public class S006SimpleBooleanTest {

	@Test
	public void testExampleTree() {
		//compile the expression
		S006SimpleBooleanCompiler compiler = new S006SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("bwahaha && (winner || !looser)");
		
		//check AST structure
		assertEquals(S006SimpleBooleanParser.AND, ast.getType());
		assertEquals(S006SimpleBooleanParser.NAME, ast.getChild(0).getType());
		assertEquals("bwahaha", ast.getChild(0).getText());
		
		Tree orSubTree = ast.getChild(1);
		assertEquals(S006SimpleBooleanParser.OR, orSubTree.getType());
		assertEquals(S006SimpleBooleanParser.NAME, orSubTree.getChild(0).getType());
		assertEquals("winner", orSubTree.getChild(0).getText());

		Tree notSubTree = orSubTree.getChild(1);
		assertEquals(S006SimpleBooleanParser.NOT, notSubTree.getType());
		assertEquals(S006SimpleBooleanParser.NAME, notSubTree.getChild(0).getType());
		assertEquals("looser", notSubTree.getChild(0).getText());
	}
	
	@Test
	public void testAnd() {
		//compile the expression
		S006SimpleBooleanCompiler compiler = new S006SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("aaa && bbb");
		
		//check AST structure
		assertEquals(S006SimpleBooleanParser.AND, ast.getType());
		assertEquals(S006SimpleBooleanParser.NAME, ast.getChild(0).getType());
		assertEquals(S006SimpleBooleanParser.NAME, ast.getChild(1).getType());
	}

	@Test
	public void testOr() {
		//compile the expression
		S006SimpleBooleanCompiler compiler = new S006SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("aaa || bbb");
		
		//check AST structure
		assertEquals(S006SimpleBooleanParser.OR, ast.getType());
		assertEquals(S006SimpleBooleanParser.NAME, ast.getChild(0).getType());
		assertEquals(S006SimpleBooleanParser.NAME, ast.getChild(1).getType());
	}

	@Test
	public void testNot() {
		//compile the expression
		S006SimpleBooleanCompiler compiler = new S006SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("!aaa");
		
		//check AST structure
		assertEquals(S006SimpleBooleanParser.NOT, ast.getType());
		assertEquals(S006SimpleBooleanParser.NAME, ast.getChild(0).getType());
	}

	@Test
	public void testComposedExpression() {
		//compile the expression
		S006SimpleBooleanCompiler compiler = new S006SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("aaa && bbb || !(aaa || ccc)");
		
		//check AST structure
		assertEquals(S006SimpleBooleanParser.AND, ast.getType());
		assertEquals(S006SimpleBooleanParser.NAME, ast.getChild(0).getType());
		
		Tree rigthSubTree = ast.getChild(1);
		assertEquals(S006SimpleBooleanParser.OR, rigthSubTree.getType());
		assertEquals(S006SimpleBooleanParser.NAME, rigthSubTree.getChild(0).getType());
		
		Tree rigthSubSubTree = rigthSubTree.getChild(1);
		assertEquals(S006SimpleBooleanParser.NOT, rigthSubSubTree.getType());
		
		Tree rigthSubSubSubTree = rigthSubSubTree.getChild(0);
		assertEquals(S006SimpleBooleanParser.OR, rigthSubSubSubTree.getType());
		assertEquals(S006SimpleBooleanParser.NAME, rigthSubSubSubTree.getChild(0).getType());
		assertEquals(S006SimpleBooleanParser.NAME, rigthSubSubSubTree.getChild(1).getType());
	}

	@Test
	public void testAnotherCorrectExpression() {
		//compile the expression
		S006SimpleBooleanCompiler compiler = new S006SimpleBooleanCompiler();
		CommonTree ast = compiler.compile("!(bwahaha)");
		
		//check AST structure
		assertEquals(S006SimpleBooleanParser.NOT, ast.getType());
		assertEquals(S006SimpleBooleanParser.NAME, ast.getChild(0).getType());
	}
	
	@Test(expected=S006Error.class)
	public void testCompletelyWrong() {
		//compile the expression
		S006SimpleBooleanCompiler compiler = new S006SimpleBooleanCompiler();
		compiler.compile("Incorrect Expression");
	}

}
