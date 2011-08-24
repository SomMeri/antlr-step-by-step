grammar S004HelloWordWithErrorHandling;

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
}

//override some methods and add new members to generated lexer
@lexer::members {
  //add new field
  private List<RecognitionException> errors = new ArrayList<RecognitionException>();
  
  //add new method
  public List<RecognitionException> getAllErrors() {
    return new ArrayList<RecognitionException>(errors);
  }

  //add new method
  public boolean hasErrors() {
    return !errors.isEmpty();
  }
  
  //override method
  public void reportError(RecognitionException e) {
    errors.add(e);
	displayRecognitionError(this.getTokenNames(), e);
  }
  
}

//override some methods and add new members to generated parser
@parser::members {
  //add new field
  private List<RecognitionException> errors = new ArrayList<RecognitionException>();
  
  //add new method
  public List<RecognitionException> getAllErrors() {
    return new ArrayList<RecognitionException>(errors);
  }

  //add new method
  public boolean hasErrors() {
    return !errors.isEmpty();
  }

  //override method
  public void reportError(RecognitionException e) {
    errors.add(e);
	  displayRecognitionError(this.getTokenNames(), e);
  }
  
}

// ***************** lexer rules:
//the grammar must contain at least one lexer rule
SALUTATION:'Hello word';   
ENDSYMBOL:'!';

// ***************** parser rules:
//our grammar accepts only salutation followed by an end symbol
expression : SALUTATION ENDSYMBOL;
