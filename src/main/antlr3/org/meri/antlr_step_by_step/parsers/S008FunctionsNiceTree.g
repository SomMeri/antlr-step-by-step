grammar S008FunctionsNiceTree;

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
import org.meri.antlr_step_by_step.parsers.S008FunctionsNiceTreeCompiler.S008Error;
}

//as the generated parser will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@parser::header {
package org.meri.antlr_step_by_step.parsers;
import org.meri.antlr_step_by_step.parsers.S008FunctionsNiceTreeCompiler.S008Error;
}

//override some methods and add new members to generated lexer
@lexer::members {
  //override method
  public void reportError(RecognitionException e) {
    displayRecognitionError(this.getTokenNames(), e);
    throw new S008Error(":(", e); 
  }
  
}

//override some methods and add new members to generated parser
@parser::members {
  //override method
  public void reportError(RecognitionException e) {
    displayRecognitionError(this.getTokenNames(), e);
    throw new S008Error(":(", e); 
  }
  
}

// ***************** lexer rules:
//the grammar must contain at least one lexer rule
LPAREN : '(' ;
RPAREN : ')' ;
AND : '&&';
OR : '||';
NOT : '!';

ALL : 'all';
ATLEASTONE : 'atleastone';
NEITHER : 'neither';
NOTALL : 'notall';

NAME : ('a'..'z' | '0'..'9')+; 
WS : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; };

// ***************** parser rules:
//This looks useless, but ANTLR would complain about "no start rule (...)"
//without it. As this rule is not referenced by any other rule, ANTLR will 
//start rule and the warning disappears. 
//
//start rule
expression : andexpression;
//first, we try to match all first level && (e.g. && not included in some sub-expression)
andexpression : orexpression (AND^ orexpression)*;
//second, we try to match all first level || (e.g. || not included in some sub-expression)
orexpression : notexpression (OR^ notexpression)*;
//third, there may or may not be first level ! in front of an expression
notexpression : NOT^ atom | atom;
//finally, we found either name, functions, or a sub-expression
atom : function | NAME | LPAREN! andexpression RPAREN!;
//functions definition
function : allFunction | atleastoneFunction | neitherFunction | notallFunction;

//the function all(p1, p2, ..., pn) is equivalent to p1 && p2 && ... && pn
allFunction : ALL LPAREN b=andexpression (',' a+=andexpression)* RPAREN 
  //if the list $a is empty, use only first argument 
  -> {$a==null || $a.isEmpty()}? $b
  //otherwise create a flat tree 
  -> ^(AND $b $a*);

//the function ateastone(p1, p2, ..., pn) is equivalent to p1 || p2 || ... || pn
atleastoneFunction : ATLEASTONE LPAREN b=andexpression (',' a+=andexpression)* RPAREN 
  //if the list $a is empty, use only first argument 
  -> {$a==null || $a.isEmpty()}? $b
  //otherwise create a flat tree 
  -> ^(OR $b $a*);

//the function neither(p1, p2, ..., pn) is equivalent to !p1 && !p2 && ... && !pn
neitherFunction : NEITHER LPAREN b=andexpression (',' a+=andexpression)* RPAREN 
  //if the list $a is empty, use only first argument 
  -> {$a==null || $a.isEmpty()}? ^(NOT $b)
  //otherwise create a flat tree 
  -> ^(AND ^(NOT $b) ^(NOT $a)*);

//the function notall(p1, p2, ..., pn) is equivalent to !p1 || !p2 || ... || !pn
notallFunction : NOTALL LPAREN b=andexpression (',' a+=andexpression)* RPAREN 
  //if the list $a is empty, use only first argument 
  -> {$a==null || $a.isEmpty()}? ^(NOT $b)
  //otherwise create a flat tree 
  -> ^(OR ^(NOT $b) ^(NOT $a)*);

  