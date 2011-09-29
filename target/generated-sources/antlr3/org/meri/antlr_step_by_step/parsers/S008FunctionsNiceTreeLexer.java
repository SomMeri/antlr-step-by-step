// $ANTLR 3.3 Nov 30, 2010 12:46:29 org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g 2011-09-29 12:39:20

package org.meri.antlr_step_by_step.parsers;
import org.meri.antlr_step_by_step.parsers.S008FunctionsNiceTreeCompiler.S008Error;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class S008FunctionsNiceTreeLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__15=15;
    public static final int LPAREN=4;
    public static final int RPAREN=5;
    public static final int AND=6;
    public static final int OR=7;
    public static final int NOT=8;
    public static final int ALL=9;
    public static final int ATLEASTONE=10;
    public static final int NEITHER=11;
    public static final int NOTALL=12;
    public static final int NAME=13;
    public static final int WS=14;

      //override method
      public void reportError(RecognitionException e) {
        displayRecognitionError(this.getTokenNames(), e);
        throw new S008Error(":(", e); 
      }
      


    // delegates
    // delegators

    public S008FunctionsNiceTreeLexer() {;} 
    public S008FunctionsNiceTreeLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public S008FunctionsNiceTreeLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:20:7: ( ',' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:20:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:47:8: ( '(' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:47:10: '('
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
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:48:8: ( ')' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:48:10: ')'
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
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:49:5: ( '&&' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:49:7: '&&'
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
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:50:4: ( '||' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:50:6: '||'
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
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:51:5: ( '!' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:51:7: '!'
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

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:53:5: ( 'all' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:53:7: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "ATLEASTONE"
    public final void mATLEASTONE() throws RecognitionException {
        try {
            int _type = ATLEASTONE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:54:12: ( 'atleastone' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:54:14: 'atleastone'
            {
            match("atleastone"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ATLEASTONE"

    // $ANTLR start "NEITHER"
    public final void mNEITHER() throws RecognitionException {
        try {
            int _type = NEITHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:55:9: ( 'neither' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:55:11: 'neither'
            {
            match("neither"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEITHER"

    // $ANTLR start "NOTALL"
    public final void mNOTALL() throws RecognitionException {
        try {
            int _type = NOTALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:56:8: ( 'notall' )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:56:10: 'notall'
            {
            match("notall"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOTALL"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:58:6: ( ( 'a' .. 'z' | '0' .. '9' )+ )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:58:8: ( 'a' .. 'z' | '0' .. '9' )+
            {
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:58:8: ( 'a' .. 'z' | '0' .. '9' )+
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
            	    // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:59:4: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:59:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:59:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:8: ( T__15 | LPAREN | RPAREN | AND | OR | NOT | ALL | ATLEASTONE | NEITHER | NOTALL | NAME | WS )
        int alt3=12;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:16: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 3 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:23: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 4 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:30: AND
                {
                mAND(); 

                }
                break;
            case 5 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:34: OR
                {
                mOR(); 

                }
                break;
            case 6 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:37: NOT
                {
                mNOT(); 

                }
                break;
            case 7 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:41: ALL
                {
                mALL(); 

                }
                break;
            case 8 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:45: ATLEASTONE
                {
                mATLEASTONE(); 

                }
                break;
            case 9 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:56: NEITHER
                {
                mNEITHER(); 

                }
                break;
            case 10 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:64: NOTALL
                {
                mNOTALL(); 

                }
                break;
            case 11 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:71: NAME
                {
                mNAME(); 

                }
                break;
            case 12 :
                // org\\meri\\antlr_step_by_step\\parsers\\S008FunctionsNiceTree.g:1:76: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\7\uffff\2\11\2\uffff\4\11\1\23\3\11\1\uffff\10\11\1\37\1\11\1"+
        "\41\1\uffff\1\11\1\uffff\1\11\1\44\1\uffff";
    static final String DFA3_eofS =
        "\45\uffff";
    static final String DFA3_minS =
        "\1\11\6\uffff\1\154\1\145\2\uffff\2\154\1\151\1\164\1\60\1\145"+
        "\1\164\1\141\1\uffff\1\141\1\150\1\154\1\163\1\145\1\154\1\164\1"+
        "\162\1\60\1\157\1\60\1\uffff\1\156\1\uffff\1\145\1\60\1\uffff";
    static final String DFA3_maxS =
        "\1\174\6\uffff\1\164\1\157\2\uffff\2\154\1\151\1\164\1\172\1\145"+
        "\1\164\1\141\1\uffff\1\141\1\150\1\154\1\163\1\145\1\154\1\164\1"+
        "\162\1\172\1\157\1\172\1\uffff\1\156\1\uffff\1\145\1\172\1\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\1\13\1\14\10\uffff\1\7"+
        "\13\uffff\1\12\1\uffff\1\11\2\uffff\1\10";
    static final String DFA3_specialS =
        "\45\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\12\2\uffff\1\12\22\uffff\1\12\1\6\4\uffff\1\4\1\uffff\1"+
            "\2\1\3\2\uffff\1\1\3\uffff\12\11\47\uffff\1\7\14\11\1\10\14"+
            "\11\1\uffff\1\5",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13\7\uffff\1\14",
            "\1\15\11\uffff\1\16",
            "",
            "",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\22",
            "\12\11\47\uffff\32\11",
            "\1\24",
            "\1\25",
            "\1\26",
            "",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\12\11\47\uffff\32\11",
            "\1\40",
            "\12\11\47\uffff\32\11",
            "",
            "\1\42",
            "",
            "\1\43",
            "\12\11\47\uffff\32\11",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | LPAREN | RPAREN | AND | OR | NOT | ALL | ATLEASTONE | NEITHER | NOTALL | NAME | WS );";
        }
    }
 

}