package org.meri.antlr_step_by_step.parsers;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.meri.antlr_step_by_step.parsers.S001HelloWordLexer;
import org.meri.antlr_step_by_step.parsers.S001HelloWordParser;
import org.meri.antlr_step_by_step.parsers.S001HelloWordParser.expression_return;

public class S001HelloWordCompiler {

	public CommonTree compile(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new S001HelloWordLexer(input));
			
			//parser generates abstract syntax tree
			S001HelloWordParser parser = new S001HelloWordParser(tokens);
			S001HelloWordParser.expression_return ret = parser.expression();
			
			//acquire parse result
			CommonTree ast = (CommonTree) ret.tree;
			printTree(ast);
			return ast;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	private void printTree(CommonTree ast) {
		print(ast, 0);
	}

	private void print(CommonTree tree, int level) {
		//indent level
		for (int i = 0; i < level; i++)
			System.out.print("--");

		//print node description: type code followed by token text
		System.out.println(" " + tree.getType() + " " + tree.getText());
		
		//print all children
		if (tree.getChildren() != null)
			for (Object ie : tree.getChildren()) {
				print((CommonTree) ie, level + 1);
			}
	}

}
