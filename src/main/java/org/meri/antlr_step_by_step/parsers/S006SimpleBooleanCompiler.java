package org.meri.antlr_step_by_step.parsers;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class S006SimpleBooleanCompiler extends AbstractCompiler {

	public CommonTree compile(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new S006SimpleBooleanLexer(input));
			
			//parser generates abstract syntax tree
			S006SimpleBooleanParser parser = new S006SimpleBooleanParser(tokens);
			S006SimpleBooleanParser.expression_return ret = parser.expression();
			
			//acquire parse result
			CommonTree ast = (CommonTree) ret.tree;
			printTree(ast);
			return ast;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	@SuppressWarnings("serial")
	public static class S006Error extends RuntimeException {

		public S006Error(String arg0, Throwable arg1) {
			super(arg0, arg1);
		}
		
	}
}
