package org.meri.antlr_step_by_step.parsers;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class S008FunctionsNiceTreeCompiler extends AbstractCompiler {

	public CommonTree compile(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new S008FunctionsNiceTreeLexer(input));
			
			//parser generates abstract syntax tree
			S008FunctionsNiceTreeParser parser = new S008FunctionsNiceTreeParser(tokens);
			S008FunctionsNiceTreeParser.expression_return ret = parser.expression();
			
			//acquire parse result
			CommonTree ast = (CommonTree) ret.tree;
			printTree(ast);
			return ast;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	@SuppressWarnings("serial")
	public static class S008Error extends RuntimeException {

		public S008Error(String arg0, Throwable arg1) {
			super(arg0, arg1);
		}
		
	}
}
