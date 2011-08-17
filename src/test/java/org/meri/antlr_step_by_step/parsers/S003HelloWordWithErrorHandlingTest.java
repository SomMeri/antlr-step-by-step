package org.meri.antlr_step_by_step.parsers;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;
import org.meri.antlr_step_by_step.parsers.S003HelloWordWithErrorHandlingCompiler.S003HelloWordError;

public class S003HelloWordWithErrorHandlingTest {

	/**
	 * Abstract syntax tree generated from "Hello word!" should have an unnamed 
	 * root node with two children. First child corresponds to salutation token 
	 * and second child corresponds to end symbol token.
	 * 
	 * Token type constants are defined in generated S003HelloWordWithErrorHandlingParser class.
	 */
	@Test
	public void testCorrectExpression() {
		//compile the expression
		S003HelloWordWithErrorHandlingCompiler compiler = new S003HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Hello word!");
		
		//check AST structure
		assertEquals(S003HelloWordWithErrorHandlingParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S003HelloWordWithErrorHandlingParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test
	public void testSmallError() {
		//compile the expression
		S003HelloWordWithErrorHandlingCompiler compiler = new S003HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Hello word?");

		//check AST structure
		assertEquals(S003HelloWordWithErrorHandlingParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S003HelloWordWithErrorHandlingParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test
	public void testBiggerError() {
		//compile the expression
		S003HelloWordWithErrorHandlingCompiler compiler = new S003HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Bye!");

		//check AST structure
		assertEquals(S003HelloWordWithErrorHandlingParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S003HelloWordWithErrorHandlingParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test(expected=S003HelloWordError.class)
	public void testCompletelyWrong() {
		//compile the expression
		S003HelloWordWithErrorHandlingCompiler compiler = new S003HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Incorrect Expression");

		//check AST structure
		assertEquals(0, ast.getChildCount());
	}

}
