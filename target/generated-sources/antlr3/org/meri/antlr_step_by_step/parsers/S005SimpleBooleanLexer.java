// $ANTLR 3.3 Nov 30, 2010 12:46:29 org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g 2011-08-17 23:09:26

package org.meri.antlr_step_by_step.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class S005SimpleBooleanLexer extends Lexer {
    public static final int EOF=-1;
    public static final int LPAREN=4;
    public static final int RPAREN=5;
    public static final int AND=6;
    public static final int OR=7;
    public static final int NOT=8;
    public static final int NAME=9;

    // delegates
    // delegators

    public S005SimpleBooleanLexer() {;} 
    public S005SimpleBooleanLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public S005SimpleBooleanLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g"; }

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:25:8: ( '(' )
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:25:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:26:8: ( ')' )
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:26:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:27:5: ( '&&' )
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:27:7: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:28:4: ( '||' )
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:28:6: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:29:5: ( '!' )
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:29:7: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:30:6: ( ( 'a' .. 'z' | '0' .. '9' )+ )
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:30:8: ( 'a' .. 'z' | '0' .. '9' )+
            {
            // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:30:8: ( 'a' .. 'z' | '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    public void mTokens() throws RecognitionException {
        // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:1:8: ( LPAREN | RPAREN | AND | OR | NOT | NAME )
        int alt2=6;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt2=1;
            }
            break;
        case ')':
            {
            alt2=2;
            }
            break;
        case '&':
            {
            alt2=3;
            }
            break;
        case '|':
            {
            alt2=4;
            }
            break;
        case '!':
            {
            alt2=5;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt2=6;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 2, 0, input);

            throw nvae;
        }

        switch (alt2) {
            case 1 :
                // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:1:10: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 2 :
                // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:1:17: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 3 :
                // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:1:24: AND
                {
                mAND(); 

                }
                break;
            case 4 :
                // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:1:28: OR
                {
                mOR(); 

                }
                break;
            case 5 :
                // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:1:31: NOT
                {
                mNOT(); 

                }
                break;
            case 6 :
                // org\\meri\\antlr_step_by_step\\parsers\\S005SimpleBoolean.g:1:35: NAME
                {
                mNAME(); 

                }
                break;

        }

    }


 

}