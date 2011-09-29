package org.meri.antlr_step_by_step.parsers;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;
import org.meri.antlr_step_by_step.parsers.S007BooleanWithFunctionsCompiler.S007Error;

public class S007BooleanWithFunctionsTest {

	@Test
	public void testSimpleFunction() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("all(bwahaha)");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.ALL, ast.getType());
		assertNameToken(ast.getChild(0), "bwahaha");
	}
	
	@Test
	public void testMultipleArgsFunctionNeither() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("neither(bwahaha, hello, argument, last)");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.NEITHER, ast.getType());
		assertNameToken(ast.getChild(0), "bwahaha");
		assertNameToken(ast.getChild(1), "hello");
		assertNameToken(ast.getChild(2), "argument");
		assertNameToken(ast.getChild(3), "last");
	}

	@Test
	public void testFunctionInExpression() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("atleastone(bwahaha) && (winner || !notall(looser))");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.AND, ast.getType());
		assertEquals(S007BooleanWithFunctionsParser.ATLEASTONE, ast.getChild(0).getType());
		assertNameToken(ast.getChild(0).getChild(0), "bwahaha");
		
		Tree orSubTree = ast.getChild(1);
		assertEquals(S007BooleanWithFunctionsParser.OR, orSubTree.getType());
		assertNameToken(orSubTree.getChild(0), "winner");

		Tree notSubTree = orSubTree.getChild(1);
		assertEquals(S007BooleanWithFunctionsParser.NOT, notSubTree.getType());
		assertEquals(S007BooleanWithFunctionsParser.NOTALL, notSubTree.getChild(0).getType());
		assertNameToken(notSubTree.getChild(0).getChild(0), "looser");
	}
	
	@Test
	public void testExampleNestedTree() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("all(notall(p1, p2 && p3), neither(p2,p3, atleastone(p2,p4)))");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.ALL, ast.getType());
		Tree notAll = ast.getChild(0);
		assertEquals(S007BooleanWithFunctionsParser.NOTALL, notAll.getType());
		assertNameToken(notAll.getChild(0), "p1");
		assertEquals(S007BooleanWithFunctionsParser.AND, notAll.getChild(1).getType());
		assertNameToken(notAll.getChild(1).getChild(0), "p2");
		assertNameToken(notAll.getChild(1).getChild(1), "p3");
		
		Tree neither = ast.getChild(1);
		assertNameToken(neither.getChild(0), "p2");
		assertNameToken(neither.getChild(1), "p3");

		Tree atleast = neither.getChild(2);
		assertNameToken(atleast.getChild(0), "p2");
		assertNameToken(atleast.getChild(1), "p4");
	}

	@Test
	public void testExampleTree() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("bwahaha && (winner || !looser)");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.AND, ast.getType());
		assertNameToken(ast.getChild(0), "bwahaha");
		
		Tree orSubTree = ast.getChild(1);
		assertEquals(S007BooleanWithFunctionsParser.OR, orSubTree.getType());
		assertNameToken(orSubTree.getChild(0), "winner");

		Tree notSubTree = orSubTree.getChild(1);
		assertEquals(S007BooleanWithFunctionsParser.NOT, notSubTree.getType());
		assertNameToken(notSubTree.getChild(0), "looser");
	}
	
	@Test
	public void testAnd() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("aaa && bbb");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.AND, ast.getType());
		assertNameToken(ast.getChild(0), "aaa");
		assertNameToken(ast.getChild(1), "bbb");
	}

	@Test
	public void testOr() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("aaa || bbb");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.OR, ast.getType());
		assertNameToken(ast.getChild(0), "aaa");
		assertNameToken(ast.getChild(1), "bbb");
	}

	@Test
	public void testNot() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("!aaa");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.NOT, ast.getType());
		assertNameToken(ast.getChild(0), "aaa");
	}

	@Test
	public void testComposedExpression() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("aaa && bbb || !(aaa || ccc)");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.AND, ast.getType());
		assertNameToken(ast.getChild(0), "aaa");
		
		Tree rigthSubTree = ast.getChild(1);
		assertEquals(S007BooleanWithFunctionsParser.OR, rigthSubTree.getType());
		assertNameToken(rigthSubTree.getChild(0), "bbb");
		
		Tree rigthSubSubTree = rigthSubTree.getChild(1);
		assertEquals(S007BooleanWithFunctionsParser.NOT, rigthSubSubTree.getType());
		
		Tree rigthSubSubSubTree = rigthSubSubTree.getChild(0);
		assertEquals(S007BooleanWithFunctionsParser.OR, rigthSubSubSubTree.getType());
		assertNameToken(rigthSubSubSubTree.getChild(0), "aaa");
		assertNameToken(rigthSubSubSubTree.getChild(1), "ccc");
	}

	@Test
	public void testAnotherCorrectExpression() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		CommonTree ast = compiler.compile("!(bwahaha)");
		
		//check AST structure
		assertEquals(S007BooleanWithFunctionsParser.NOT, ast.getType());
		assertNameToken(ast.getChild(0), "bwahaha");
	}
	
	@Test(expected=S007Error.class)
	public void testCompletelyWrong() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		compiler.compile("Incorrect Expression");
	}

	@Test(expected=S007Error.class)
	public void testKeywordMisuse() {
		//compile the expression
		S007BooleanWithFunctionsCompiler compiler = new S007BooleanWithFunctionsCompiler();
		compiler.compile("all");
	}

	private void assertNameToken(Tree token, String name) {
		assertEquals(S007BooleanWithFunctionsParser.NAME, token.getType());
		assertEquals(name, token.getText());
	}
	
}
