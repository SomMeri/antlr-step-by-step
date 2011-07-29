package org.meri.antlr_step_by_step.parsers;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

public class S001HelloWordExperimentsTest {
	//
	
	@Test
	public void testSmallError() {
		//compile the expression
		S001HelloWordCompiler compiler = new S001HelloWordCompiler();
		CommonTree ast = compiler.compile("Hello word?");

		//check AST structure
		assertEquals(S001HelloWordParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S001HelloWordParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test
	public void testBiggerError() {
		//compile the expression
		S001HelloWordCompiler compiler = new S001HelloWordCompiler();
		CommonTree ast = compiler.compile("Bye!");

		//check AST structure
		assertEquals(S001HelloWordParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S001HelloWordParser.ENDSYMBOL, ast.getChild(1).getType());
	}

	@Test
	public void testCompletelyWrong() {
		//compile the expression
		S001HelloWordCompiler compiler = new S001HelloWordCompiler();
		CommonTree ast = compiler.compile("Incorrect Expression");

		//check AST structure
		assertEquals(0, ast.getChildCount());
	}


}
