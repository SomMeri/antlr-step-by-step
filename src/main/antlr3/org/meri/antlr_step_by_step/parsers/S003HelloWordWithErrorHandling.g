grammar S003HelloWordWithErrorHandling;

//NOT COPIED YET
options
{
  // antlr will generate java lexer and parser
  language = Java;
  // generated parser should create abstract syntax tree
  output = AST;
}

//as the generated lexer will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@lexer::header {
package org.meri.antlr_step_by_step.parsers;
}

//as the generated parser will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@parser::header {
package org.meri.antlr_step_by_step.parsers;

//add imports 
import org.meri.antlr_step_by_step.parsers.S003HelloWordWithErrorHandlingCompiler.S003HelloWordError;
}

//change error handling in all parser rules
@rulecatch {
  catch (RecognitionException e) {
	//Custom handling of an exception. Any java code is allowed.
	throw new S003HelloWordError(":(", e); 
  }
}

// ***************** lexer rules:
//the grammar must contain at least one lexer rule
SALUTATION:'Hello word';   
ENDSYMBOL:'!';

// ***************** parser rules:
//our grammar accepts only salutation followed by an end symbol
expression : SALUTATION ENDSYMBOL;
