package org.meri.antlr_step_by_step.parsers;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;
import org.meri.antlr_step_by_step.parsers.S008FunctionsNiceTreeCompiler.S008Error;

public class S008FunctionsNiceTreeTest {

	@Test
	public void testOneArgAll() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("all(bwahaha)");
		
		//check AST structure
		assertNameToken(ast, "bwahaha");
	}
	
	@Test
	public void testMultiArgAll() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("all(bwahaha, winner, looser)");
		
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.AND, ast.getType());
		assertNameToken(ast.getChild(0), "bwahaha");
		assertNameToken(ast.getChild(1), "winner");
		assertNameToken(ast.getChild(2), "looser");
	}
	
	@Test
	public void testOneArgAtleastone() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("atleastone(bwahaha)");
		
		//check AST structure
		assertNameToken(ast, "bwahaha");
	}
	
	@Test
	public void testMultiArgAtleastone() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("atleastone(bwahaha, winner, looser)");
		
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.OR, ast.getType());
		assertNameToken(ast.getChild(0), "bwahaha");
		assertNameToken(ast.getChild(1), "winner");
		assertNameToken(ast.getChild(2), "looser");
	}
	
	@Test
	public void testOneArgNeither() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("neither(bwahaha)");
		
		//check AST structure
		assertNegatedNameToken(ast, "bwahaha");
	}
	
	@Test
	public void testMultiArgNeither() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("neither(bwahaha, winner, looser)");
		
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.AND, ast.getType());
		assertNegatedNameToken(ast.getChild(0), "bwahaha");
		assertNegatedNameToken(ast.getChild(1), "winner");
		assertNegatedNameToken(ast.getChild(2), "looser");
	}
	
	@Test
	public void testOneArgNotall() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("notall(bwahaha)");
		
		//check AST structure
		//check AST structure
		assertNegatedNameToken(ast, "bwahaha");
	}
	
	@Test
	public void testMultiArgNotall() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("notall(bwahaha, winner, looser)");
		
		//check AST structure
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.OR, ast.getType());
		assertNegatedNameToken(ast.getChild(0), "bwahaha");
		assertNegatedNameToken(ast.getChild(1), "winner");
		assertNegatedNameToken(ast.getChild(2), "looser");
	}
	
	@Test
	public void testFunctionInExpression() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("atleastone(bwahaha) && (winner || !notall(looser))");
		
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.AND, ast.getType());
		assertNameToken(ast.getChild(0), "bwahaha");
		
		Tree orSubTree = ast.getChild(1);
		assertEquals(S008FunctionsNiceTreeParser.OR, orSubTree.getType());
		assertNameToken(orSubTree.getChild(0), "winner");

		Tree notSubTree = orSubTree.getChild(1);
		assertEquals(S008FunctionsNiceTreeParser.NOT, notSubTree.getType());
		assertNegatedNameToken(notSubTree.getChild(0), "looser");
	}
	
	@Test
	public void testExampleNestedTree() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("all(notall(p1, p2 && p3), neither(p2,p3, atleastone(p2,p4)))");
		
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.AND, ast.getType());
		Tree notAll = ast.getChild(0);
		assertEquals(S008FunctionsNiceTreeParser.OR, notAll.getType());
		assertNegatedNameToken(notAll.getChild(0), "p1");

		Tree notP1AndP2 = notAll.getChild(1);
		assertEquals(S008FunctionsNiceTreeParser.NOT, notP1AndP2.getType());
		assertEquals(S008FunctionsNiceTreeParser.AND, notP1AndP2.getChild(0).getType());
		assertNameToken(notP1AndP2.getChild(0).getChild(0), "p2");
		assertNameToken(notP1AndP2.getChild(0).getChild(1), "p3");
		
		Tree neither = ast.getChild(1);
		assertEquals(S008FunctionsNiceTreeParser.AND, neither.getType());
		assertNegatedNameToken(neither.getChild(0), "p2");
		assertNegatedNameToken(neither.getChild(1), "p3");

		Tree notAtleast = neither.getChild(2);
		assertEquals(S008FunctionsNiceTreeParser.NOT, notAtleast.getType());
		Tree atleast = notAtleast.getChild(0);
		assertEquals(S008FunctionsNiceTreeParser.OR, atleast.getType());
		assertNameToken(atleast.getChild(0), "p2");
		assertNameToken(atleast.getChild(1), "p4");
	}

	@Test
	public void testExampleTree() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("bwahaha && (winner || !looser)");
		
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.AND, ast.getType());
		assertNameToken(ast.getChild(0), "bwahaha");
		
		Tree orSubTree = ast.getChild(1);
		assertEquals(S008FunctionsNiceTreeParser.OR, orSubTree.getType());
		assertNameToken(orSubTree.getChild(0), "winner");

		Tree notSubTree = orSubTree.getChild(1);
		assertNegatedNameToken(notSubTree, "looser");
	}
	
	@Test
	public void testAnd() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("aaa && bbb");
		
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.AND, ast.getType());
		assertNameToken(ast.getChild(0), "aaa");
		assertNameToken(ast.getChild(1), "bbb");
	}

	@Test
	public void testOr() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("aaa || bbb");
		
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.OR, ast.getType());
		assertNameToken(ast.getChild(0), "aaa");
		assertNameToken(ast.getChild(1), "bbb");
	}

	@Test
	public void testNot() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("!aaa");
		
		//check AST structure
		assertNegatedNameToken(ast, "aaa");
	}

	@Test
	public void testComposedExpression() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("aaa && bbb || !(aaa || ccc)");
		
		//check AST structure
		assertEquals(S008FunctionsNiceTreeParser.AND, ast.getType());
		assertNameToken(ast.getChild(0), "aaa");
		
		Tree rigthSubTree = ast.getChild(1);
		assertEquals(S008FunctionsNiceTreeParser.OR, rigthSubTree.getType());
		assertNameToken(rigthSubTree.getChild(0), "bbb");
		
		Tree rigthSubSubTree = rigthSubTree.getChild(1);
		assertEquals(S008FunctionsNiceTreeParser.NOT, rigthSubSubTree.getType());
		
		Tree rigthSubSubSubTree = rigthSubSubTree.getChild(0);
		assertEquals(S008FunctionsNiceTreeParser.OR, rigthSubSubSubTree.getType());
		assertNameToken(rigthSubSubSubTree.getChild(0), "aaa");
		assertNameToken(rigthSubSubSubTree.getChild(1), "ccc");
	}

	@Test
	public void testAnotherCorrectExpression() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		CommonTree ast = compiler.compile("!(bwahaha)");
		
		//check AST structure
		assertNegatedNameToken(ast, "bwahaha");
	}
	
	@Test(expected=S008Error.class)
	public void testCompletelyWrong() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		compiler.compile("Incorrect Expression");
	}

	@Test(expected=S008Error.class)
	public void testKeywordMisuse() {
		//compile the expression
		S008FunctionsNiceTreeCompiler compiler = new S008FunctionsNiceTreeCompiler();
		compiler.compile("all");
	}

	private void assertNameToken(Tree token, String name) {
		assertEquals(S008FunctionsNiceTreeParser.NAME, token.getType());
		assertEquals(name, token.getText());
	}
	
	private void assertNegatedNameToken(Tree token, String name) {
		assertEquals(S008FunctionsNiceTreeParser.NOT, token.getType());
		assertEquals(S008FunctionsNiceTreeParser.NAME, token.getChild(0).getType());
		assertEquals(name, token.getChild(0).getText());
	}
	
}
