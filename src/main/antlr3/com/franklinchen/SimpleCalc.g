grammar SimpleCalc;
 
options {
    output = AST;
    ASTLabelType = CommonTree;
}

tokens {
    PLUS    = '+' ;
    MINUS   = '-' ;
    MULT    = '*' ;
    DIV = '/' ;
}

@header {
package com.franklinchen;
}

@lexer::header {
package com.franklinchen;
}

@members {
    private List<RecognitionException> exceptions =
        new ArrayList<RecognitionException>();
    
    public List<RecognitionException> getExceptions() {
        return this.exceptions;
    }

    @Override
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        this.exceptions.add(e);
    }
}

@lexer::members {
    // TODO Bad duplication, should refactor.
    private List<RecognitionException> exceptions =
        new ArrayList<RecognitionException>();
    
    public List<RecognitionException> getExceptions() {
        return this.exceptions;
    }

    @Override
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        this.exceptions.add(e);
    }
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
 
expr    : term ( ( PLUS | MINUS )  term )* ;
 
term    : factor ( ( MULT | DIV ) factor )* ;
 
factor  : NUMBER ;
 
 
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
 
NUMBER  : (DIGIT)+ ;
 
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;
 
fragment DIGIT  : '0'..'9' ;
