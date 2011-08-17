package org.meri.antlr_step_by_step.parsers;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;
import org.meri.antlr_step_by_step.parsers.S002HelloWordWithErrorHandlingCompiler.S002HelloWordError;

public class S002HelloWordWithErrorHandlingTest {

	/**
	 * Abstract syntax tree generated from "Hello word!" should have an unnamed 
	 * root node with two children. First child corresponds to salutation token 
	 * and second child corresponds to end symbol token.
	 * 
	 * Token type constants are defined in generated S002HelloWordWithErrorHandlingParser class.
	 */
	@Test
	public void testCorrectExpression() {
		//compile the expression
		S002HelloWordWithErrorHandlingCompiler compiler = new S002HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Hello word!");
		
		//check AST structure
		assertEquals(S002HelloWordWithErrorHandlingParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S002HelloWordWithErrorHandlingParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test
	public void testSmallError() {
		//compile the expression
		S002HelloWordWithErrorHandlingCompiler compiler = new S002HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Hello word?");

		//check AST structure
		assertEquals(S002HelloWordWithErrorHandlingParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S002HelloWordWithErrorHandlingParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test
	public void testBiggerError() {
		//compile the expression
		S002HelloWordWithErrorHandlingCompiler compiler = new S002HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Bye!");

		//check AST structure
		assertEquals(S002HelloWordWithErrorHandlingParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S002HelloWordWithErrorHandlingParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test(expected=S002HelloWordError.class)
	public void testCompletelyWrong() {
		//compile the expression
		S002HelloWordWithErrorHandlingCompiler compiler = new S002HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Incorrect Expression");

		//check AST structure
		assertEquals(0, ast.getChildCount());
	}

}
