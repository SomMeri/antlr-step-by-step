// $ANTLR 3.3 Nov 30, 2010 12:46:29 org\\meri\\antlr_step_by_step\\parsers\\S003HelloWordWithErrorHandling.g 2011-09-29 09:52:03

package org.meri.antlr_step_by_step.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class S003HelloWordWithErrorHandlingLexer extends Lexer {
    public static final int EOF=-1;
    public static final int SALUTATION=4;
    public static final int ENDSYMBOL=5;

    // delegates
    // delegators

    public S003HelloWordWithErrorHandlingLexer() {;} 
    public S003HelloWordWithErrorHandlingLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public S003HelloWordWithErrorHandlingLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "org\\meri\\antlr_step_by_step\\parsers\\S003HelloWordWithErrorHandling.g"; }

    // $ANTLR start "SALUTATION"
    public final void mSALUTATION() throws RecognitionException {
        try {
            int _type = SALUTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S003HelloWordWithErrorHandling.g:36:11: ( 'Hello word' )
            // org\\meri\\antlr_step_by_step\\parsers\\S003HelloWordWithErrorHandling.g:36:12: 'Hello word'
            {
            match("Hello word"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SALUTATION"

    // $ANTLR start "ENDSYMBOL"
    public final void mENDSYMBOL() throws RecognitionException {
        try {
            int _type = ENDSYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S003HelloWordWithErrorHandling.g:37:10: ( '!' )
            // org\\meri\\antlr_step_by_step\\parsers\\S003HelloWordWithErrorHandling.g:37:11: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDSYMBOL"

    public void mTokens() throws RecognitionException {
        // org\\meri\\antlr_step_by_step\\parsers\\S003HelloWordWithErrorHandling.g:1:8: ( SALUTATION | ENDSYMBOL )
        int alt1=2;
        switch ( input.LA(1) ) {
        case 'H':
            {
            alt1=1;
            }
            break;
        case '!':
            {
            alt1=2;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 1, 0, input);

            throw nvae;
        }

        switch (alt1) {
            case 1 :
                // org\\meri\\antlr_step_by_step\\parsers\\S003HelloWordWithErrorHandling.g:1:10: SALUTATION
                {
                mSALUTATION(); 

                }
                break;
            case 2 :
                // org\\meri\\antlr_step_by_step\\parsers\\S003HelloWordWithErrorHandling.g:1:21: ENDSYMBOL
                {
                mENDSYMBOL(); 

                }
                break;

        }

    }


 

}