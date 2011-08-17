grammar S005SimpleBoolean;

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

// ***************** lexer rules:
//the grammar must contain at least one lexer rule
LPAREN : '(' ;
RPAREN : ')' ;
AND : '&&';
OR : '||';
NOT : '!';
NAME : ('a'..'z' | '0'..'9')+; 

// ***************** parser rules:
//This looks useless, but ANTLR would complain about "no start rule (...)"
//without it. As this rule is not referenced by any other rule, ANTLR will 
//start rule and the warning disappears. 
//
//You may try to remove the rule to see what happens.
expression : andexpression;
//first, we try to match all first level && (e.g. && not included in some 
//sub-expression) 
andexpression : orexpression (AND orexpression)*;
//second, we try to match all first level || (e.g. || not included in some 
//sub-expression) 
orexpression : notexpression (OR notexpression)*;
//third, there may or may not be first level ! in front of an expression
notexpression : NOT atom | atom;
//finally, we found either name, or a sub-expression
atom : NAME | LPAREN andexpression RPAREN;

