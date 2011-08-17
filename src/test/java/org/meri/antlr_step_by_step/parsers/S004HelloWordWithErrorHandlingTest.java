package org.meri.antlr_step_by_step.parsers;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

public class S004HelloWordWithErrorHandlingTest {

	/**
	 * Abstract syntax tree generated from "Hello word!" should have an unnamed 
	 * root node with two children. First child corresponds to salutation token 
	 * and second child corresponds to end symbol token.
	 * 
	 * Token type constants are defined in generated S004HelloWordWithErrorHandlingParser class.
	 */
	@Test
	public void testCorrectExpression() {
		//compile the expression
		S004HelloWordWithErrorHandlingCompiler compiler = new S004HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Hello word!");

		//check number of reported errors
		assertEquals(0, compiler.getAllErrors().size());

		//check AST structure
		assertEquals(S004HelloWordWithErrorHandlingParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S004HelloWordWithErrorHandlingParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test
	public void testSmallError() {
		//compile the expression
		S004HelloWordWithErrorHandlingCompiler compiler = new S004HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Hello word?");

		//check number of reported errors
		assertEquals(2, compiler.getAllErrors().size());

		//check AST structure
		assertEquals(S004HelloWordWithErrorHandlingParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S004HelloWordWithErrorHandlingParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test
	public void testBiggerError() {
		//compile the expression
		S004HelloWordWithErrorHandlingCompiler compiler = new S004HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Bye!");

		//check number of reported errors
		assertEquals(4, compiler.getAllErrors().size());

		//check AST structure
		assertEquals(S004HelloWordWithErrorHandlingParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S004HelloWordWithErrorHandlingParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test
	public void testCompletelyWrong() {
		//compile the expression
		S004HelloWordWithErrorHandlingCompiler compiler = new S004HelloWordWithErrorHandlingCompiler();
		CommonTree ast = compiler.compile("Incorrect Expression");

		//check number of reported errors
		assertEquals(21, compiler.getAllErrors().size());

		//check AST structure
		assertEquals(0, ast.getChildCount());
	}

}
