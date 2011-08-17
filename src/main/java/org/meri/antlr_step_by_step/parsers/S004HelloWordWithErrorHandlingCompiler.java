package org.meri.antlr_step_by_step.parsers;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class S004HelloWordWithErrorHandlingCompiler extends AbstractCompiler {

    private List<RecognitionException> errors = new ArrayList<RecognitionException>();
	
	public CommonTree compile(String expression) {
		try {
			System.out.println(expression);
			
			//clean errors log
			errors = new ArrayList<RecognitionException>();
			
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			S004HelloWordWithErrorHandlingLexer lexer = new S004HelloWordWithErrorHandlingLexer(input);
			TokenStream tokens = new CommonTokenStream(lexer);

			//Note: above is initialization only. There are no errors in lexer yet.
			if (lexer.hasErrors())
				throw new IllegalStateException("Nothing should happen yet.");

			//parser generates abstract syntax tree
			S004HelloWordWithErrorHandlingParser parser = new S004HelloWordWithErrorHandlingParser(tokens);
			S004HelloWordWithErrorHandlingParser.expression_return ret = parser.expression();

			//collect all errors  
			if (lexer.hasErrors())
				errors.addAll(lexer.getAllErrors());
			
			if (parser.hasErrors())
				errors.addAll(parser.getAllErrors());
			
			//acquire parse result
			CommonTree ast = (CommonTree) ret.tree;
			printTree(ast);
			return ast;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	/**
	 * @return all errors found during last run
	 */
    public List<RecognitionException> getAllErrors() {
      return errors;
    }

}
