// $ANTLR 3.3 Nov 30, 2010 12:46:29 org\\meri\\antlr_step_by_step\\parsers\\S004HelloWordWithErrorHandling.g 2011-09-29 09:52:04

package org.meri.antlr_step_by_step.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class S004HelloWordWithErrorHandlingParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SALUTATION", "ENDSYMBOL"
    };
    public static final int EOF=-1;
    public static final int SALUTATION=4;
    public static final int ENDSYMBOL=5;

    // delegates
    // delegators


        public S004HelloWordWithErrorHandlingParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public S004HelloWordWithErrorHandlingParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return S004HelloWordWithErrorHandlingParser.tokenNames; }
    public String getGrammarFileName() { return "org\\meri\\antlr_step_by_step\\parsers\\S004HelloWordWithErrorHandling.g"; }


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
      


    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // org\\meri\\antlr_step_by_step\\parsers\\S004HelloWordWithErrorHandling.g:76:1: expression : SALUTATION ENDSYMBOL ;
    public final S004HelloWordWithErrorHandlingParser.expression_return expression() throws RecognitionException {
        S004HelloWordWithErrorHandlingParser.expression_return retval = new S004HelloWordWithErrorHandlingParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SALUTATION1=null;
        Token ENDSYMBOL2=null;

        Object SALUTATION1_tree=null;
        Object ENDSYMBOL2_tree=null;

        try {
            // org\\meri\\antlr_step_by_step\\parsers\\S004HelloWordWithErrorHandling.g:76:12: ( SALUTATION ENDSYMBOL )
            // org\\meri\\antlr_step_by_step\\parsers\\S004HelloWordWithErrorHandling.g:76:14: SALUTATION ENDSYMBOL
            {
            root_0 = (Object)adaptor.nil();

            SALUTATION1=(Token)match(input,SALUTATION,FOLLOW_SALUTATION_in_expression99); 
            SALUTATION1_tree = (Object)adaptor.create(SALUTATION1);
            adaptor.addChild(root_0, SALUTATION1_tree);

            ENDSYMBOL2=(Token)match(input,ENDSYMBOL,FOLLOW_ENDSYMBOL_in_expression101); 
            ENDSYMBOL2_tree = (Object)adaptor.create(ENDSYMBOL2);
            adaptor.addChild(root_0, ENDSYMBOL2_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    // Delegated rules


 

    public static final BitSet FOLLOW_SALUTATION_in_expression99 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ENDSYMBOL_in_expression101 = new BitSet(new long[]{0x0000000000000002L});

}