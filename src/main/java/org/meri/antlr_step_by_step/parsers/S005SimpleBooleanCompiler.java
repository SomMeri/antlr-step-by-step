package org.meri.antlr_step_by_step.parsers;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class S005SimpleBooleanCompiler extends AbstractCompiler {

	public CommonTree compile(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new S005SimpleBooleanLexer(input));
			
			//parser generates abstract syntax tree
			S005SimpleBooleanParser parser = new S005SimpleBooleanParser(tokens);
			S005SimpleBooleanParser.expression_return ret = parser.expression();
			
			//acquire parse result
			CommonTree ast = (CommonTree) ret.tree;
			printTree(ast);
			return ast;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	@SuppressWarnings("serial")
	public static class S005Error extends RuntimeException {

		public S005Error(String arg0, Throwable arg1) {
			super(arg0, arg1);
		}
		
	}
}
