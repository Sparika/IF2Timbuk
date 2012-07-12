// $ANTLR 3.4 /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g 2012-07-05 11:27:59

	package antlr.output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ifgrammarLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int Auth=4;
    public static final int Comment=5;
    public static final int Const_ident=6;
    public static final int Nat_ident=7;
    public static final int Secret=8;
    public static final int Var_ident=9;
    public static final int WS=10;
    public static final int WeakAuth=11;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public ifgrammarLexer() {} 
    public ifgrammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ifgrammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:6:7: ( '&' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:6:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:7:7: ( '(' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:7:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:8:7: ( '(-)' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:8:9: '(-)'
            {
            match("(-)"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:9:7: ( ')' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:9:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:10:7: ( '*' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:10:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:11:7: ( ',' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:11:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:12:7: ( '->' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:12:9: '->'
            {
            match("->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:13:7: ( '.' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:13:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:14:7: ( '/\\\\' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:14:9: '/\\\\'
            {
            match("/\\"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:15:7: ( ':' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:15:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:16:7: ( ':=' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:16:9: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:17:7: ( '<->' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:17:9: '<->'
            {
            match("<->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:18:7: ( '=' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:18:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:19:7: ( '=>' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:19:9: '=>'
            {
            match("=>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:20:7: ( '=[exists' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:20:9: '=[exists'
            {
            match("=[exists"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:21:7: ( '>' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:21:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:22:7: ( '[-]' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:22:9: '[-]'
            {
            match("[-]"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:23:7: ( '[]' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:23:9: '[]'
            {
            match("[]"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:24:7: ( '\\\\/' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:24:9: '\\\\/'
            {
            match("\\/"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:25:7: ( ']' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:25:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:26:7: ( 'attack_state' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:26:9: 'attack_state'
            {
            match("attack_state"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:27:7: ( 'equal' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:27:9: 'equal'
            {
            match("equal"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:28:7: ( 'fact' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:28:9: 'fact'
            {
            match("fact"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:29:7: ( 'initial_state' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:29:9: 'initial_state'
            {
            match("initial_state"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:30:7: ( 'leq' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:30:9: 'leq'
            {
            match("leq"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:31:7: ( 'ltl_' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:31:9: 'ltl_'
            {
            match("ltl_"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:32:7: ( 'not' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:32:9: 'not'
            {
            match("not"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:33:7: ( 'property' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:33:9: 'property'
            {
            match("property"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:34:7: ( 'section approximations:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:34:9: 'section approximations:'
            {
            match("section approximations:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:35:7: ( 'section attack_states:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:35:9: 'section attack_states:'
            {
            match("section attack_states:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:36:7: ( 'section check:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:36:9: 'section check:'
            {
            match("section check:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:37:7: ( 'section equations:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:37:9: 'section equations:'
            {
            match("section equations:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:38:7: ( 'section fail_states:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:38:9: 'section fail_states:'
            {
            match("section fail_states:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:39:7: ( 'section inits:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:39:9: 'section inits:'
            {
            match("section inits:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:40:7: ( 'section intruder:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:40:9: 'section intruder:'
            {
            match("section intruder:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:41:7: ( 'section primitiveTypes:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:41:9: 'section primitiveTypes:'
            {
            match("section primitiveTypes:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:42:7: ( 'section properties:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:42:9: 'section properties:'
            {
            match("section properties:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:43:7: ( 'section rules:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:43:9: 'section rules:'
            {
            match("section rules:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:44:7: ( 'section signature:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:44:9: 'section signature:'
            {
            match("section signature:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:45:7: ( 'section typeSymbols:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:45:9: 'section typeSymbols:'
            {
            match("section typeSymbols:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:46:7: ( 'section types:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:46:9: 'section types:'
            {
            match("section types:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:47:7: ( 'section verification:' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:47:9: 'section verification:'
            {
            match("section verification:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:48:7: ( 'state_' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:48:9: 'state_'
            {
            match("state_"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:49:7: ( 'step' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:49:9: 'step'
            {
            match("step"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:50:7: ( '{' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:50:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:51:7: ( '}' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:51:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:52:7: ( '~' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:52:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "Secret"
    public final void mSecret() throws RecognitionException {
        try {
            int _type = Secret;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:117:8: ( 'secrecy_of_' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:117:10: 'secrecy_of_' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            match("secrecy_of_"); 



            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:117:23: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Secret"

    // $ANTLR start "Auth"
    public final void mAuth() throws RecognitionException {
        try {
            int _type = Auth;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:118:6: ( 'authentication_on_' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:118:8: 'authentication_on_' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            match("authentication_on_"); 



            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:118:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Auth"

    // $ANTLR start "WeakAuth"
    public final void mWeakAuth() throws RecognitionException {
        try {
            int _type = WeakAuth;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:119:10: ( 'weak_authentication_on_' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:119:12: 'weak_authentication_on_' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            match("weak_authentication_on_"); 



            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:119:37: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WeakAuth"

    // $ANTLR start "Var_ident"
    public final void mVar_ident() throws RecognitionException {
        try {
            int _type = Var_ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:122:2: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:122:4: ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:122:14: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Var_ident"

    // $ANTLR start "Const_ident"
    public final void mConst_ident() throws RecognitionException {
        try {
            int _type = Const_ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:125:2: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:125:4: ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:125:14: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Const_ident"

    // $ANTLR start "Nat_ident"
    public final void mNat_ident() throws RecognitionException {
        try {
            int _type = Nat_ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:128:2: ( ( '0' .. '9' )+ )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:128:4: ( '0' .. '9' )+
            {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:128:4: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Nat_ident"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:782:4: ( ( ' ' | '\\t' | '\\n' )+ )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:782:6: ( ' ' | '\\t' | '\\n' )+
            {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:782:6: ( ' ' | '\\t' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:785:9: ( '%' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '(' | ')' | ' ' | ',' | ':' | '\\t' | '-' | '=' | '%' | '/' | '\\\\' | '.' | '[' | ']' | '>' )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:785:11: '%' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '(' | ')' | ' ' | ',' | ':' | '\\t' | '-' | '=' | '%' | '/' | '\\\\' | '.' | '[' | ']' | '>' )*
            {
            match('%'); 

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:785:14: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '(' | ')' | ' ' | ',' | ':' | '\\t' | '-' | '=' | '%' | '/' | '\\\\' | '.' | '[' | ']' | '>' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' '||LA8_0=='%'||(LA8_0 >= '(' && LA8_0 <= ')')||(LA8_0 >= ',' && LA8_0 <= ':')||(LA8_0 >= '=' && LA8_0 <= '>')||(LA8_0 >= 'A' && LA8_0 <= ']')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' '||input.LA(1)=='%'||(input.LA(1) >= '(' && input.LA(1) <= ')')||(input.LA(1) >= ',' && input.LA(1) <= ':')||(input.LA(1) >= '=' && input.LA(1) <= '>')||(input.LA(1) >= 'A' && input.LA(1) <= ']')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Comment"

    public void mTokens() throws RecognitionException {
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | Secret | Auth | WeakAuth | Var_ident | Const_ident | Nat_ident | WS | Comment )
        int alt9=55;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:10: T__12
                {
                mT__12(); 


                }
                break;
            case 2 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:16: T__13
                {
                mT__13(); 


                }
                break;
            case 3 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:22: T__14
                {
                mT__14(); 


                }
                break;
            case 4 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:28: T__15
                {
                mT__15(); 


                }
                break;
            case 5 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:34: T__16
                {
                mT__16(); 


                }
                break;
            case 6 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:40: T__17
                {
                mT__17(); 


                }
                break;
            case 7 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:46: T__18
                {
                mT__18(); 


                }
                break;
            case 8 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:52: T__19
                {
                mT__19(); 


                }
                break;
            case 9 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:58: T__20
                {
                mT__20(); 


                }
                break;
            case 10 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:64: T__21
                {
                mT__21(); 


                }
                break;
            case 11 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:70: T__22
                {
                mT__22(); 


                }
                break;
            case 12 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:76: T__23
                {
                mT__23(); 


                }
                break;
            case 13 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:82: T__24
                {
                mT__24(); 


                }
                break;
            case 14 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:88: T__25
                {
                mT__25(); 


                }
                break;
            case 15 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:94: T__26
                {
                mT__26(); 


                }
                break;
            case 16 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:100: T__27
                {
                mT__27(); 


                }
                break;
            case 17 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:106: T__28
                {
                mT__28(); 


                }
                break;
            case 18 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:112: T__29
                {
                mT__29(); 


                }
                break;
            case 19 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:118: T__30
                {
                mT__30(); 


                }
                break;
            case 20 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:124: T__31
                {
                mT__31(); 


                }
                break;
            case 21 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:130: T__32
                {
                mT__32(); 


                }
                break;
            case 22 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:136: T__33
                {
                mT__33(); 


                }
                break;
            case 23 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:142: T__34
                {
                mT__34(); 


                }
                break;
            case 24 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:148: T__35
                {
                mT__35(); 


                }
                break;
            case 25 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:154: T__36
                {
                mT__36(); 


                }
                break;
            case 26 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:160: T__37
                {
                mT__37(); 


                }
                break;
            case 27 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:166: T__38
                {
                mT__38(); 


                }
                break;
            case 28 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:172: T__39
                {
                mT__39(); 


                }
                break;
            case 29 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:178: T__40
                {
                mT__40(); 


                }
                break;
            case 30 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:184: T__41
                {
                mT__41(); 


                }
                break;
            case 31 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:190: T__42
                {
                mT__42(); 


                }
                break;
            case 32 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:196: T__43
                {
                mT__43(); 


                }
                break;
            case 33 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:202: T__44
                {
                mT__44(); 


                }
                break;
            case 34 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:208: T__45
                {
                mT__45(); 


                }
                break;
            case 35 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:214: T__46
                {
                mT__46(); 


                }
                break;
            case 36 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:220: T__47
                {
                mT__47(); 


                }
                break;
            case 37 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:226: T__48
                {
                mT__48(); 


                }
                break;
            case 38 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:232: T__49
                {
                mT__49(); 


                }
                break;
            case 39 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:238: T__50
                {
                mT__50(); 


                }
                break;
            case 40 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:244: T__51
                {
                mT__51(); 


                }
                break;
            case 41 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:250: T__52
                {
                mT__52(); 


                }
                break;
            case 42 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:256: T__53
                {
                mT__53(); 


                }
                break;
            case 43 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:262: T__54
                {
                mT__54(); 


                }
                break;
            case 44 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:268: T__55
                {
                mT__55(); 


                }
                break;
            case 45 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:274: T__56
                {
                mT__56(); 


                }
                break;
            case 46 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:280: T__57
                {
                mT__57(); 


                }
                break;
            case 47 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:286: T__58
                {
                mT__58(); 


                }
                break;
            case 48 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:292: Secret
                {
                mSecret(); 


                }
                break;
            case 49 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:299: Auth
                {
                mAuth(); 


                }
                break;
            case 50 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:304: WeakAuth
                {
                mWeakAuth(); 


                }
                break;
            case 51 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:313: Var_ident
                {
                mVar_ident(); 


                }
                break;
            case 52 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:323: Const_ident
                {
                mConst_ident(); 


                }
                break;
            case 53 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:335: Nat_ident
                {
                mNat_ident(); 


                }
                break;
            case 54 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:345: WS
                {
                mWS(); 


                }
                break;
            case 55 :
                // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:1:348: Comment
                {
                mComment(); 


                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\2\uffff\1\42\6\uffff\1\44\1\uffff\1\47\4\uffff\10\35\3\uffff\1"+
        "\35\16\uffff\21\35\1\110\1\35\1\112\10\35\1\124\1\35\1\uffff\1\126"+
        "\1\uffff\4\35\1\133\3\35\1\137\1\uffff\1\35\1\uffff\4\35\1\uffff"+
        "\3\35\1\uffff\4\35\1\154\7\35\1\uffff\4\35\1\170\1\uffff\5\35\13"+
        "\uffff\5\35\5\uffff\5\35\5\uffff\1\u009e\1\35\1\u00a0\2\35\1\uffff"+
        "\1\u009e\1\uffff\1\35\1\uffff\1\35\1\u00a7\2\uffff\2\35\1\uffff"+
        "\7\35\1\u00b2\1\35\1\u00b2\1\uffff\4\35\2\u00b9\1\uffff";
    static final String DFA9_eofS =
        "\u00ba\uffff";
    static final String DFA9_minS =
        "\1\11\1\uffff\1\55\6\uffff\1\75\1\uffff\1\76\1\uffff\1\55\2\uffff"+
        "\1\164\1\161\1\141\1\156\1\145\1\157\1\162\1\145\3\uffff\1\145\16"+
        "\uffff\2\164\1\165\1\143\1\151\1\161\1\154\1\164\1\157\1\143\3\141"+
        "\1\150\1\141\2\164\1\60\1\137\1\60\1\160\1\162\1\164\1\160\1\153"+
        "\1\143\1\145\1\154\1\60\1\151\1\uffff\1\60\1\uffff\1\145\1\151\2"+
        "\145\1\60\1\137\1\153\1\156\1\60\1\uffff\1\141\1\uffff\1\162\1\157"+
        "\1\143\1\137\1\uffff\1\141\1\137\1\164\1\uffff\1\154\1\164\1\156"+
        "\1\171\1\60\1\165\1\163\1\151\1\137\1\171\1\40\1\137\1\uffff\2\164"+
        "\1\143\1\163\1\60\1\141\1\157\1\150\2\141\1\164\1\uffff\1\160\3"+
        "\uffff\1\156\1\162\2\uffff\1\171\1\uffff\1\146\1\145\2\164\1\141"+
        "\2\uffff\2\151\1\160\1\137\1\156\1\145\1\151\1\164\4\uffff\1\145"+
        "\1\60\1\164\1\60\1\157\1\145\1\123\1\60\1\uffff\1\151\1\uffff\1"+
        "\156\1\60\2\uffff\1\143\1\137\1\uffff\1\141\1\157\1\164\1\156\1"+
        "\151\1\137\1\157\1\60\1\156\1\60\1\uffff\1\137\1\157\1\156\1\137"+
        "\2\60\1\uffff";
    static final String DFA9_maxS =
        "\1\176\1\uffff\1\55\6\uffff\1\75\1\uffff\1\133\1\uffff\1\135\2\uffff"+
        "\1\165\1\161\1\141\1\156\1\164\1\157\1\162\1\164\3\uffff\1\145\16"+
        "\uffff\2\164\1\165\1\143\1\151\1\161\1\154\1\164\1\157\1\143\1\145"+
        "\2\141\1\150\1\141\2\164\1\172\1\137\1\172\1\160\2\164\1\160\1\153"+
        "\1\143\1\145\1\154\1\172\1\151\1\uffff\1\172\1\uffff\1\145\1\151"+
        "\2\145\1\172\1\137\1\153\1\156\1\172\1\uffff\1\141\1\uffff\1\162"+
        "\1\157\1\143\1\137\1\uffff\1\141\1\137\1\164\1\uffff\1\154\1\164"+
        "\1\156\1\171\1\172\1\165\1\163\1\151\1\137\1\171\1\40\1\137\1\uffff"+
        "\2\164\1\143\1\163\1\172\1\166\1\157\1\150\2\141\1\164\1\uffff\1"+
        "\164\3\uffff\1\156\1\162\2\uffff\1\171\1\uffff\1\146\1\145\2\164"+
        "\1\141\2\uffff\1\164\1\157\1\160\1\137\1\156\1\145\1\151\1\164\4"+
        "\uffff\1\145\1\172\1\164\1\172\1\157\1\145\1\163\1\172\1\uffff\1"+
        "\151\1\uffff\1\156\1\172\2\uffff\1\143\1\137\1\uffff\1\141\1\157"+
        "\1\164\1\156\1\151\1\137\1\157\1\172\1\156\1\172\1\uffff\1\137\1"+
        "\157\1\156\1\137\2\172\1\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\14\1\uffff"+
        "\1\20\1\uffff\1\23\1\24\10\uffff\1\55\1\56\1\57\1\uffff\1\63\1\64"+
        "\1\65\1\66\1\67\1\3\1\2\1\13\1\12\1\16\1\17\1\15\1\21\1\22\36\uffff"+
        "\1\31\1\uffff\1\33\11\uffff\1\27\1\uffff\1\32\4\uffff\1\54\3\uffff"+
        "\1\26\14\uffff\1\53\13\uffff\1\34\1\uffff\1\37\1\40\1\41\2\uffff"+
        "\1\46\1\47\1\uffff\1\52\5\uffff\1\35\1\36\10\uffff\1\42\1\43\1\44"+
        "\1\45\10\uffff\1\60\1\uffff\1\25\2\uffff\1\50\1\51\2\uffff\1\30"+
        "\12\uffff\1\61\6\uffff\1\62";
    static final String DFA9_specialS =
        "\u00ba\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\37\25\uffff\1\37\4\uffff\1\40\1\1\1\uffff\1\2\1\3\1\4\1\uffff"+
            "\1\5\1\6\1\7\1\10\12\36\1\11\1\uffff\1\12\1\13\1\14\2\uffff"+
            "\32\34\1\15\1\16\1\17\3\uffff\1\20\3\35\1\21\1\22\2\35\1\23"+
            "\2\35\1\24\1\35\1\25\1\35\1\26\2\35\1\27\3\35\1\33\3\35\1\30"+
            "\1\uffff\1\31\1\32",
            "",
            "\1\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\43",
            "",
            "\1\45\34\uffff\1\46",
            "",
            "\1\50\57\uffff\1\51",
            "",
            "",
            "\1\52\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57\16\uffff\1\60",
            "\1\61",
            "\1\62",
            "\1\63\16\uffff\1\64",
            "",
            "",
            "",
            "\1\65",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100\3\uffff\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\111",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\113",
            "\1\115\1\uffff\1\114",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\125",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\134",
            "\1\135",
            "\1\136",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\140",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "",
            "\1\145",
            "\1\146",
            "\1\147",
            "",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\171\1\uffff\1\172\1\uffff\1\173\1\174\2\uffff\1\175\6\uffff"+
            "\1\176\1\uffff\1\177\1\u0080\1\u0081\1\uffff\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "\1\u0088\3\uffff\1\u0089",
            "",
            "",
            "",
            "\1\u008a",
            "\1\u008b",
            "",
            "",
            "\1\u008c",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "",
            "",
            "\1\u0092\12\uffff\1\u0093",
            "\1\u0094\5\uffff\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "",
            "",
            "",
            "",
            "\1\u009c",
            "\12\u009d\7\uffff\32\u009d\4\uffff\1\u009d\1\uffff\32\u009d",
            "\1\u009f",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a4",
            "\12\u009d\7\uffff\32\u009d\4\uffff\1\u009d\1\uffff\32\u009d",
            "",
            "\1\u00a5",
            "",
            "\1\u00a6",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "",
            "\1\u00a8",
            "\1\u00a9",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\12\u00b1\7\uffff\32\u00b1\4\uffff\1\u00b1\1\uffff\32\u00b1",
            "\1\u00b3",
            "\12\u00b1\7\uffff\32\u00b1\4\uffff\1\u00b1\1\uffff\32\u00b1",
            "",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | Secret | Auth | WeakAuth | Var_ident | Const_ident | Nat_ident | WS | Comment );";
        }
    }
 

}