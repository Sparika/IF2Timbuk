// $ANTLR 3.4 /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g 2012-07-05 11:27:59
	
	package antlr.output;

	import compiler.Compiler;
	import compiler.Cons;
	import compiler.Ops;
	import compiler.Pattern;
	import compiler.Rule;
	import compiler.Equation;
	import compiler.Symbole;
	import compiler.Term;
	import compiler.Type;
	import compiler.Union;
	import compiler.Fact;
	import compiler.TypeCompound;
	import compiler.Var;
	
	import java.util.LinkedList;
	import java.util.ListIterator;
	import java.util.Vector;
	import java.util.Iterator;
	
	import java.util.Hashtable;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ifgrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Auth", "Comment", "Const_ident", "Nat_ident", "Secret", "Var_ident", "WS", "WeakAuth", "'&'", "'('", "'(-)'", "')'", "'*'", "','", "'->'", "'.'", "'/\\\\'", "':'", "':='", "'<->'", "'='", "'=>'", "'=[exists'", "'>'", "'[-]'", "'[]'", "'\\\\/'", "']'", "'attack_state'", "'equal'", "'fact'", "'initial_state'", "'leq'", "'ltl_'", "'not'", "'property'", "'section approximations:'", "'section attack_states:'", "'section check:'", "'section equations:'", "'section fail_states:'", "'section inits:'", "'section intruder:'", "'section primitiveTypes:'", "'section properties:'", "'section rules:'", "'section signature:'", "'section typeSymbols:'", "'section types:'", "'section verification:'", "'state_'", "'step'", "'{'", "'}'", "'~'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public ifgrammarParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ifgrammarParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return ifgrammarParser.tokenNames; }
    public String getGrammarFileName() { return "/home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g"; }


    	private Boolean ok = true;
    	private Compiler compiler = new Compiler();
    	
    	private int nbRule = 0, nbEq=0;
    	
    	public void reportError(Exception e) { 
    		ok = false;
    		//System.err.println("ligne "+e.line+":"+e.charPositionInLine + " (a preciser !!)");
    	}
    	
    	//Classe représentant un set extraits des contains/secret des règles
    	private class Cont{
    		private Term id, var;
    		
    		public Cont(Term t){
    			LinkedList<Term> lst = t.getSons();
    			
    			this.id=lst.getLast();
    			this.var=lst.getFirst();
    		}
    		
    		public Term getId(){return id;}
    		public Term getVar(){return var;}
    	}
    	private class Secr{
    		private Term a,b,c;
    		
    		public Secr(Term t){
    			LinkedList<Term> lst = t.getSons();
    			
    			this.a = lst.get(0);
    			this.b = lst.get(1);
    			this.c = lst.get(2);
    		}
    		
    		public Term toTerm(Vector<Cont> vecC){
    			LinkedList<Term> lst;
    			if(vecC.size()==0){
    				lst = new LinkedList<Term>();
    				lst.add(a);
    				lst.add(b);
    				lst.add(c);
    			}
    			else{
    				Hashtable<String,Symbole> hashS = compiler.getSymbolesTable();
    				Term t = new Term(hashS.get("end"),null);
    				Symbole l = hashS.get("l");
    				for(int i =0; i < vecC.size(); i++){
    					// If we have contains(A,c) we add A to Term list t
    					//System.out.println(vecC.get(i).getId().toString()+"?="+c.toString());
    					if(vecC.get(i).getId().toString().equals(c.toString())){
    						lst = new LinkedList<Term>();
    						lst.add(vecC.get(i).getVar());
    						lst.add(t);
    						t = new Term(l,lst);
    					}
    				
    				}
    				lst = new LinkedList<Term>();
    				lst.add(a);
    				lst.add(b);
    				lst.add(t);
    			}
    			return new Term(compiler.getSymbolesTable().get("secret"),lst);
    		}
    		
    		public Term toTerm(){
    			LinkedList<Term> lst = new LinkedList<Term>();
    			lst.add(a);
    			lst.add(b);
    			lst.add(c);
    			return new Term(compiler.getSymbolesTable().get("secret"),lst);
    		}
    		
    	}
    	
    	public Compiler getCompiler(){return(compiler);}



    // $ANTLR start "prelude"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:131:1: prelude : typeSymbolsSection signatureSection typesSection equationSection intruderSection EOF ;
    public final void prelude() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:132:2: ( typeSymbolsSection signatureSection typesSection equationSection intruderSection EOF )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:132:5: typeSymbolsSection signatureSection typesSection equationSection intruderSection EOF
            {
            if ( state.backtracking==0 ) {System.out.print("prelude if");}

            pushFollow(FOLLOW_typeSymbolsSection_in_prelude202);
            typeSymbolsSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_signatureSection_in_prelude207);
            signatureSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_typesSection_in_prelude212);
            typesSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_equationSection_in_prelude217);
            equationSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_intruderSection_in_prelude222);
            intruderSection();

            state._fsp--;
            if (state.failed) return ;

            match(input,EOF,FOLLOW_EOF_in_prelude232); if (state.failed) return ;

            if ( state.backtracking==0 ) {System.out.println(" : done");}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prelude"



    // $ANTLR start "if_File"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:143:1: if_File : signatureSection typesSection initsSection rulesSection propertiesSection attackStatesSection EOF ;
    public final void if_File() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:144:2: ( signatureSection typesSection initsSection rulesSection propertiesSection attackStatesSection EOF )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:144:5: signatureSection typesSection initsSection rulesSection propertiesSection attackStatesSection EOF
            {
            if ( state.backtracking==0 ) {System.out.print("if file");}

            pushFollow(FOLLOW_signatureSection_in_if_File259);
            signatureSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_typesSection_in_if_File264);
            typesSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_initsSection_in_if_File269);
            initsSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_rulesSection_in_if_File274);
            rulesSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_propertiesSection_in_if_File279);
            propertiesSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_attackStatesSection_in_if_File284);
            attackStatesSection();

            state._fsp--;
            if (state.failed) return ;

            match(input,EOF,FOLLOW_EOF_in_if_File294); if (state.failed) return ;

            if ( state.backtracking==0 ) {System.out.println(" : done");}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "if_File"



    // $ANTLR start "tim_prelude"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:155:1: tim_prelude : typeSymbolsSection primitiveTypesSection signatureSection typesSection equationSection intruderSection checkSection verifSection failSection approxSection EOF ;
    public final void tim_prelude() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:156:2: ( typeSymbolsSection primitiveTypesSection signatureSection typesSection equationSection intruderSection checkSection verifSection failSection approxSection EOF )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:156:4: typeSymbolsSection primitiveTypesSection signatureSection typesSection equationSection intruderSection checkSection verifSection failSection approxSection EOF
            {
            if ( state.backtracking==0 ) {System.out.print("prelude timbuk");}

            pushFollow(FOLLOW_typeSymbolsSection_in_tim_prelude319);
            typeSymbolsSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_primitiveTypesSection_in_tim_prelude323);
            primitiveTypesSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_signatureSection_in_tim_prelude327);
            signatureSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_typesSection_in_tim_prelude331);
            typesSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_equationSection_in_tim_prelude336);
            equationSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_intruderSection_in_tim_prelude341);
            intruderSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_checkSection_in_tim_prelude346);
            checkSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_verifSection_in_tim_prelude350);
            verifSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_failSection_in_tim_prelude354);
            failSection();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_approxSection_in_tim_prelude358);
            approxSection();

            state._fsp--;
            if (state.failed) return ;

            match(input,EOF,FOLLOW_EOF_in_tim_prelude362); if (state.failed) return ;

            if ( state.backtracking==0 ) {System.out.println(" : done");}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tim_prelude"



    // $ANTLR start "typeSymbolsSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:172:1: typeSymbolsSection : 'section typeSymbols:' constantList ;
    public final void typeSymbolsSection() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:173:2: ( 'section typeSymbols:' constantList )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:173:5: 'section typeSymbols:' constantList
            {
            match(input,51,FOLLOW_51_in_typeSymbolsSection380); if (state.failed) return ;

            pushFollow(FOLLOW_constantList_in_typeSymbolsSection382);
            constantList();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "typeSymbolsSection"



    // $ANTLR start "primitiveTypesSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:176:1: primitiveTypesSection : 'section primitiveTypes:' primitiveList ;
    public final void primitiveTypesSection() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:177:2: ( 'section primitiveTypes:' primitiveList )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:177:5: 'section primitiveTypes:' primitiveList
            {
            match(input,47,FOLLOW_47_in_primitiveTypesSection396); if (state.failed) return ;

            pushFollow(FOLLOW_primitiveList_in_primitiveTypesSection398);
            primitiveList();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "primitiveTypesSection"



    // $ANTLR start "primitiveList"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:180:1: primitiveList : ( Const_ident ( ',' )? )* ;
    public final void primitiveList() throws RecognitionException {
        Token Const_ident1=null;

        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:181:2: ( ( Const_ident ( ',' )? )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:181:4: ( Const_ident ( ',' )? )*
            {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:181:4: ( Const_ident ( ',' )? )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Const_ident) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:181:5: Const_ident ( ',' )?
            	    {
            	    Const_ident1=(Token)match(input,Const_ident,FOLLOW_Const_ident_in_primitiveList412); if (state.failed) return ;

            	    if ( state.backtracking==0 ) {
            	    		compiler.getTypesTable().get((Const_ident1!=null?Const_ident1.getText():null)).setPrimitive(true);
            	    	}

            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:184:3: ( ',' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==17) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:184:4: ','
            	            {
            	            match(input,17,FOLLOW_17_in_primitiveList417); if (state.failed) return ;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "primitiveList"



    // $ANTLR start "constantList"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:187:1: constantList : (ci= Const_ident ( ',' )? | 'fact' ( ',' )? )* ;
    public final void constantList() throws RecognitionException {
        Token ci=null;

        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:188:2: ( (ci= Const_ident ( ',' )? | 'fact' ( ',' )? )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:188:4: (ci= Const_ident ( ',' )? | 'fact' ( ',' )? )*
            {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:188:4: (ci= Const_ident ( ',' )? | 'fact' ( ',' )? )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Const_ident) ) {
                    alt5=1;
                }
                else if ( (LA5_0==34) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:188:5: ci= Const_ident ( ',' )?
            	    {
            	    ci=(Token)match(input,Const_ident,FOLLOW_Const_ident_in_constantList436); if (state.failed) return ;

            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:188:20: ( ',' )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==17) ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:188:21: ','
            	            {
            	            match(input,17,FOLLOW_17_in_constantList439); if (state.failed) return ;

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    	try{
            	    		Type t;
            	    		if((ci!=null?ci.getText():null).equals("union"))
            	    			t = new Union("union");	
            	    		else
            	    			t = new Type((ci!=null?ci.getText():null));
            	    		compiler.addType(t);
            	    		compiler.addSymbole(t);
            	    	} catch (Exception e) {
            	    		e.printStackTrace();
            	    	}
            	    	}

            	    }
            	    break;
            	case 2 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:202:3: 'fact' ( ',' )?
            	    {
            	    match(input,34,FOLLOW_34_in_constantList448); if (state.failed) return ;

            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:202:10: ( ',' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==17) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:202:11: ','
            	            {
            	            match(input,17,FOLLOW_17_in_constantList451); if (state.failed) return ;

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    	try{
            	    		Type t = new Fact("fact");	
            	    		compiler.addType(t);
            	    		compiler.addSymbole(t);
            	    	} catch (Exception e) {
            	    		e.printStackTrace();
            	    	}
            	    	}

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "constantList"



    // $ANTLR start "signatureSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:214:1: signatureSection : 'section signature:' signatureSection0 ;
    public final void signatureSection() throws RecognitionException {
        ifgrammarParser.signatureSection0_return signatureSection02 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:215:2: ( 'section signature:' signatureSection0 )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:215:5: 'section signature:' signatureSection0
            {
            match(input,50,FOLLOW_50_in_signatureSection471); if (state.failed) return ;

            pushFollow(FOLLOW_signatureSection0_in_signatureSection473);
            signatureSection02=signatureSection0();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {
            		compiler.addSuperType((signatureSection02!=null?signatureSection02.superType:null));
            		compiler.addSuperTypeEq((signatureSection02!=null?signatureSection02.superTypeEq:null));
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "signatureSection"


    public static class signatureSection0_return extends ParserRuleReturnScope {
        public String superType="";
        public String superTypeEq="";
    };


    // $ANTLR start "signatureSection0"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:222:1: signatureSection0 returns [String superType=\"\", String superTypeEq=\"\"] : (st= superTypeDeclaration )* ( functionDeclaration )* ( predicateDeclaration )* ;
    public final ifgrammarParser.signatureSection0_return signatureSection0() throws RecognitionException {
        ifgrammarParser.signatureSection0_return retval = new ifgrammarParser.signatureSection0_return();
        retval.start = input.LT(1);


        ifgrammarParser.superTypeDeclaration_return st =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:223:2: ( (st= superTypeDeclaration )* ( functionDeclaration )* ( predicateDeclaration )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:223:5: (st= superTypeDeclaration )* ( functionDeclaration )* ( predicateDeclaration )*
            {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:223:5: (st= superTypeDeclaration )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Const_ident) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==27) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:223:6: st= superTypeDeclaration
            	    {
            	    pushFollow(FOLLOW_superTypeDeclaration_in_signatureSection0496);
            	    st=superTypeDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {
            	    	 		retval.superType+=(st!=null?st.text:null);
            	    	 		retval.superTypeEq+=(st!=null?st.eq:null);
            	    	 }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:229:4: ( functionDeclaration )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Const_ident) ) {
                    int LA7_1 = input.LA(2);

                    if ( (synpred8_ifgrammar()) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:229:4: functionDeclaration
            	    {
            	    pushFollow(FOLLOW_functionDeclaration_in_signatureSection0509);
            	    functionDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:231:4: ( predicateDeclaration )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Const_ident) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:231:4: predicateDeclaration
            	    {
            	    pushFollow(FOLLOW_predicateDeclaration_in_signatureSection0519);
            	    predicateDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "signatureSection0"


    public static class superTypeDeclaration_return extends ParserRuleReturnScope {
        public String text;
        public String eq;
    };


    // $ANTLR start "superTypeDeclaration"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:234:1: superTypeDeclaration returns [String text, String eq] : l= if_Type '>' r= if_Type ;
    public final ifgrammarParser.superTypeDeclaration_return superTypeDeclaration() throws RecognitionException {
        ifgrammarParser.superTypeDeclaration_return retval = new ifgrammarParser.superTypeDeclaration_return();
        retval.start = input.LT(1);


        String l =null;

        String r =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:235:2: (l= if_Type '>' r= if_Type )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:235:5: l= if_Type '>' r= if_Type
            {
            pushFollow(FOLLOW_if_Type_in_superTypeDeclaration539);
            l=if_Type();

            state._fsp--;
            if (state.failed) return retval;

            match(input,27,FOLLOW_27_in_superTypeDeclaration541); if (state.failed) return retval;

            pushFollow(FOLLOW_if_Type_in_superTypeDeclaration545);
            r=if_Type();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {
            		retval.text =r+"(X) -> "+l+"(X)\n\n";
            		retval.eq =r+"(X) = "+l+"(X)\n\n";
            	}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "superTypeDeclaration"



    // $ANTLR start "functionDeclaration"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:241:1: functionDeclaration : op= if_Operator ':' sig= typeStar '->' t= type ;
    public final void functionDeclaration() throws RecognitionException {
        String op =null;

        LinkedList<Type> sig =null;

        ifgrammarParser.type_return t =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:242:2: (op= if_Operator ':' sig= typeStar '->' t= type )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:242:5: op= if_Operator ':' sig= typeStar '->' t= type
            {
            pushFollow(FOLLOW_if_Operator_in_functionDeclaration561);
            op=if_Operator();

            state._fsp--;
            if (state.failed) return ;

            match(input,21,FOLLOW_21_in_functionDeclaration563); if (state.failed) return ;

            pushFollow(FOLLOW_typeStar_in_functionDeclaration567);
            sig=typeStar();

            state._fsp--;
            if (state.failed) return ;

            match(input,18,FOLLOW_18_in_functionDeclaration569); if (state.failed) return ;

            pushFollow(FOLLOW_type_in_functionDeclaration573);
            t=type();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {
            		Ops ops = new Ops(op,(t!=null?t.t:null),sig);
            		try{
            			compiler.addSymbole(ops);
            		}catch(Exception e){
            			e.printStackTrace();
            		}
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "functionDeclaration"



    // $ANTLR start "predicateDeclaration"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:252:1: predicateDeclaration : op= if_Operator ':' sig= typeStar '->' 'fact' ;
    public final void predicateDeclaration() throws RecognitionException {
        String op =null;

        LinkedList<Type> sig =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:253:2: (op= if_Operator ':' sig= typeStar '->' 'fact' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:253:5: op= if_Operator ':' sig= typeStar '->' 'fact'
            {
            pushFollow(FOLLOW_if_Operator_in_predicateDeclaration589);
            op=if_Operator();

            state._fsp--;
            if (state.failed) return ;

            match(input,21,FOLLOW_21_in_predicateDeclaration591); if (state.failed) return ;

            pushFollow(FOLLOW_typeStar_in_predicateDeclaration595);
            sig=typeStar();

            state._fsp--;
            if (state.failed) return ;

            match(input,18,FOLLOW_18_in_predicateDeclaration597); if (state.failed) return ;

            match(input,34,FOLLOW_34_in_predicateDeclaration599); if (state.failed) return ;

            if ( state.backtracking==0 ) {
            		Type fact = compiler.getTypesTable().get("fact");
            		Ops ops = new Ops(op,fact,sig);
            		try{
            			compiler.addSymbole(ops);
            		}catch(Exception e){
            			e.printStackTrace();
            		}
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "predicateDeclaration"



    // $ANTLR start "if_Operator"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:265:1: if_Operator returns [String text] : Const_ident ;
    public final String if_Operator() throws RecognitionException {
        String text = null;


        Token Const_ident3=null;

        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:266:2: ( Const_ident )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:266:5: Const_ident
            {
            Const_ident3=(Token)match(input,Const_ident,FOLLOW_Const_ident_in_if_Operator618); if (state.failed) return text;

            if ( state.backtracking==0 ) {
            		text = (Const_ident3!=null?Const_ident3.getText():null);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return text;
    }
    // $ANTLR end "if_Operator"



    // $ANTLR start "if_Type"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:271:1: if_Type returns [String text] : Const_ident ;
    public final String if_Type() throws RecognitionException {
        String text = null;


        Token Const_ident4=null;

        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:272:2: ( Const_ident )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:272:5: Const_ident
            {
            Const_ident4=(Token)match(input,Const_ident,FOLLOW_Const_ident_in_if_Type636); if (state.failed) return text;

            if ( state.backtracking==0 ) {
            		text = (Const_ident4!=null?Const_ident4.getText():null);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return text;
    }
    // $ANTLR end "if_Type"


    public static class type_return extends ParserRuleReturnScope {
        public Type t;
    };


    // $ANTLR start "type"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:279:1: type returns [Type t] : (ift= if_Type |op= if_Operator '(' tL= typeList ')' | '{' constantNatList '}' | 'fact' );
    public final ifgrammarParser.type_return type() throws RecognitionException {
        ifgrammarParser.type_return retval = new ifgrammarParser.type_return();
        retval.start = input.LT(1);


        String ift =null;

        String op =null;

        LinkedList<Type> tL =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:280:2: (ift= if_Type |op= if_Operator '(' tL= typeList ')' | '{' constantNatList '}' | 'fact' )
            int alt9=4;
            switch ( input.LA(1) ) {
            case Const_ident:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==EOF||(LA9_1 >= Const_ident && LA9_1 <= Nat_ident)||LA9_1==Var_ident||(LA9_1 >= 15 && LA9_1 <= 18)||LA9_1==43||LA9_1==45||LA9_1==52) ) {
                    alt9=1;
                }
                else if ( (LA9_1==13) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
                }
                break;
            case 56:
                {
                alt9=3;
                }
                break;
            case 34:
                {
                alt9=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:280:5: ift= if_Type
                    {
                    pushFollow(FOLLOW_if_Type_in_type659);
                    ift=if_Type();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    		retval.t = compiler.getTypesTable().get(ift);
                    	}

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:284:5: op= if_Operator '(' tL= typeList ')'
                    {
                    pushFollow(FOLLOW_if_Operator_in_type670);
                    op=if_Operator();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,13,FOLLOW_13_in_type672); if (state.failed) return retval;

                    pushFollow(FOLLOW_typeList_in_type676);
                    tL=typeList();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,15,FOLLOW_15_in_type678); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    		//A ameliorer
                    		retval.t = new TypeCompound(op,tL);
                    		//retval.t = tC;
                    	}

                    }
                    break;
                case 3 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:290:5: '{' constantNatList '}'
                    {
                    match(input,56,FOLLOW_56_in_type687); if (state.failed) return retval;

                    pushFollow(FOLLOW_constantNatList_in_type688);
                    constantNatList();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,57,FOLLOW_57_in_type689); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:291:4: 'fact'
                    {
                    match(input,34,FOLLOW_34_in_type694); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    		retval.t = compiler.getTypesTable().get("fact");
                    	}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"



    // $ANTLR start "typeStar"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:296:1: typeStar returns [LinkedList<Type> list] : ( type '*' tS= typeStar | type );
    public final LinkedList<Type> typeStar() throws RecognitionException {
        LinkedList<Type> list = null;


        LinkedList<Type> tS =null;

        ifgrammarParser.type_return type5 =null;

        ifgrammarParser.type_return type6 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:297:2: ( type '*' tS= typeStar | type )
            int alt10=2;
            switch ( input.LA(1) ) {
            case Const_ident:
                {
                int LA10_1 = input.LA(2);

                if ( (synpred13_ifgrammar()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;

                }
                }
                break;
            case 56:
                {
                int LA10_2 = input.LA(2);

                if ( (synpred13_ifgrammar()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;

                }
                }
                break;
            case 34:
                {
                int LA10_3 = input.LA(2);

                if ( (synpred13_ifgrammar()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return list;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:297:5: type '*' tS= typeStar
                    {
                    pushFollow(FOLLOW_type_in_typeStar712);
                    type5=type();

                    state._fsp--;
                    if (state.failed) return list;

                    match(input,16,FOLLOW_16_in_typeStar714); if (state.failed) return list;

                    pushFollow(FOLLOW_typeStar_in_typeStar718);
                    tS=typeStar();

                    state._fsp--;
                    if (state.failed) return list;

                    if ( state.backtracking==0 ) {
                    		list = tS;
                    		list.addFirst((type5!=null?type5.t:null));
                    	}

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:302:4: type
                    {
                    pushFollow(FOLLOW_type_in_typeStar726);
                    type6=type();

                    state._fsp--;
                    if (state.failed) return list;

                    if ( state.backtracking==0 ) {
                    		list = new LinkedList<Type>();
                    		list.add((type6!=null?type6.t:null));
                    	}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "typeStar"



    // $ANTLR start "typeList"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:310:1: typeList returns [LinkedList<Type> list] : ( type ',' tL= typeList | type );
    public final LinkedList<Type> typeList() throws RecognitionException {
        LinkedList<Type> list = null;


        LinkedList<Type> tL =null;

        ifgrammarParser.type_return type7 =null;

        ifgrammarParser.type_return type8 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:311:2: ( type ',' tL= typeList | type )
            int alt11=2;
            switch ( input.LA(1) ) {
            case Const_ident:
                {
                int LA11_1 = input.LA(2);

                if ( (synpred14_ifgrammar()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
                }
                break;
            case 56:
                {
                int LA11_2 = input.LA(2);

                if ( (synpred14_ifgrammar()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;

                }
                }
                break;
            case 34:
                {
                int LA11_3 = input.LA(2);

                if ( (synpred14_ifgrammar()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return list;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:311:5: type ',' tL= typeList
                    {
                    pushFollow(FOLLOW_type_in_typeList748);
                    type7=type();

                    state._fsp--;
                    if (state.failed) return list;

                    match(input,17,FOLLOW_17_in_typeList750); if (state.failed) return list;

                    pushFollow(FOLLOW_typeList_in_typeList754);
                    tL=typeList();

                    state._fsp--;
                    if (state.failed) return list;

                    if ( state.backtracking==0 ) {
                    		Type t = compiler.getTypesTable().get((type7!=null?input.toString(type7.start,type7.stop):null));
                    		list = tL;
                    		list.addFirst(t);
                    	}

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:317:4: type
                    {
                    pushFollow(FOLLOW_type_in_typeList762);
                    type8=type();

                    state._fsp--;
                    if (state.failed) return list;

                    if ( state.backtracking==0 ) {
                    		Type t = compiler.getTypesTable().get((type8!=null?input.toString(type8.start,type8.stop):null));
                    		list = new LinkedList<Type>();
                    		list.add(t);
                    	}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "typeList"



    // $ANTLR start "constantNatList"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:325:1: constantNatList : ( Const_ident | Nat_ident ) ( ',' ( Const_ident | Nat_ident ) )* ;
    public final void constantNatList() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:326:2: ( ( Const_ident | Nat_ident ) ( ',' ( Const_ident | Nat_ident ) )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:326:4: ( Const_ident | Nat_ident ) ( ',' ( Const_ident | Nat_ident ) )*
            {
            if ( (input.LA(1) >= Const_ident && input.LA(1) <= Nat_ident) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:326:30: ( ',' ( Const_ident | Nat_ident ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==17) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:326:31: ',' ( Const_ident | Nat_ident )
            	    {
            	    match(input,17,FOLLOW_17_in_constantNatList786); if (state.failed) return ;

            	    if ( (input.LA(1) >= Const_ident && input.LA(1) <= Nat_ident) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "constantNatList"



    // $ANTLR start "typesSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:329:1: typesSection : 'section types:' ( typeDeclaration )* ;
    public final void typesSection() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:330:2: ( 'section types:' ( typeDeclaration )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:330:5: 'section types:' ( typeDeclaration )*
            {
            match(input,52,FOLLOW_52_in_typesSection809); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:330:22: ( typeDeclaration )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= Const_ident && LA13_0 <= Nat_ident)||LA13_0==Var_ident) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:330:22: typeDeclaration
            	    {
            	    pushFollow(FOLLOW_typeDeclaration_in_typesSection811);
            	    typeDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "typesSection"



    // $ANTLR start "typeDeclaration"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:333:1: typeDeclaration : atL= atomicTermList ':' t= type ;
    public final void typeDeclaration() throws RecognitionException {
        LinkedList<String> atL =null;

        ifgrammarParser.type_return t =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:334:2: (atL= atomicTermList ':' t= type )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:334:4: atL= atomicTermList ':' t= type
            {
            pushFollow(FOLLOW_atomicTermList_in_typeDeclaration826);
            atL=atomicTermList();

            state._fsp--;
            if (state.failed) return ;

            match(input,21,FOLLOW_21_in_typeDeclaration828); if (state.failed) return ;

            pushFollow(FOLLOW_type_in_typeDeclaration832);
            t=type();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {
            		LinkedList<String> lst =atL;
            		ListIterator<String> it = lst.listIterator();
            		while(it.hasNext()){
            			String s = it.next();
            	       			try {
            	       				if (Character.isUpperCase(s.charAt(0))) { //Var
            	       					Var v = new Var(s,(t!=null?t.t:null));
            	       					compiler.addSymbole(v);
            	       				}
            	       				else{
            					compiler.addSymbole(new Cons(s,(t!=null?t.t:null)));
            					}
            				} catch (Exception e) {
            					// TODO Auto-generated catch block
            					e.printStackTrace();
            				}
            		}
            		
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "typeDeclaration"



    // $ANTLR start "atomicTermList"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:356:1: atomicTermList returns [LinkedList<String> list] : ( atomicTerm ',' atL= atomicTermList | atomicTerm );
    public final LinkedList<String> atomicTermList() throws RecognitionException {
        LinkedList<String> list = null;


        LinkedList<String> atL =null;

        String atomicTerm9 =null;

        String atomicTerm10 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:357:2: ( atomicTerm ',' atL= atomicTermList | atomicTerm )
            int alt14=2;
            switch ( input.LA(1) ) {
            case Const_ident:
                {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==17) ) {
                    alt14=1;
                }
                else if ( (LA14_1==EOF||LA14_1==21) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;

                }
                }
                break;
            case Nat_ident:
                {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==17) ) {
                    alt14=1;
                }
                else if ( (LA14_2==EOF||LA14_2==21) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;

                }
                }
                break;
            case Var_ident:
                {
                int LA14_3 = input.LA(2);

                if ( (LA14_3==17) ) {
                    alt14=1;
                }
                else if ( (LA14_3==EOF||LA14_3==21) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return list;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:357:4: atomicTerm ',' atL= atomicTermList
                    {
                    pushFollow(FOLLOW_atomicTerm_in_atomicTermList849);
                    atomicTerm9=atomicTerm();

                    state._fsp--;
                    if (state.failed) return list;

                    match(input,17,FOLLOW_17_in_atomicTermList851); if (state.failed) return list;

                    pushFollow(FOLLOW_atomicTermList_in_atomicTermList855);
                    atL=atomicTermList();

                    state._fsp--;
                    if (state.failed) return list;

                    if ( state.backtracking==0 ) {
                    		list = atL;
                    		list.addFirst(atomicTerm9);	
                    	}

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:362:4: atomicTerm
                    {
                    pushFollow(FOLLOW_atomicTerm_in_atomicTermList863);
                    atomicTerm10=atomicTerm();

                    state._fsp--;
                    if (state.failed) return list;

                    if ( state.backtracking==0 ) {
                    		list = new LinkedList<String>();
                    		list.add(atomicTerm10);	
                    	}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "atomicTermList"



    // $ANTLR start "atomicTerm"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:368:1: atomicTerm returns [String s] : ( Const_ident | Nat_ident | Var_ident );
    public final String atomicTerm() throws RecognitionException {
        String s = null;


        Token Const_ident11=null;
        Token Nat_ident12=null;
        Token Var_ident13=null;

        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:369:2: ( Const_ident | Nat_ident | Var_ident )
            int alt15=3;
            switch ( input.LA(1) ) {
            case Const_ident:
                {
                alt15=1;
                }
                break;
            case Nat_ident:
                {
                alt15=2;
                }
                break;
            case Var_ident:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return s;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:369:4: Const_ident
                    {
                    Const_ident11=(Token)match(input,Const_ident,FOLLOW_Const_ident_in_atomicTerm880); if (state.failed) return s;

                    if ( state.backtracking==0 ) {
                    		s =(Const_ident11!=null?Const_ident11.getText():null);
                    	}

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:373:4: Nat_ident
                    {
                    Nat_ident12=(Token)match(input,Nat_ident,FOLLOW_Nat_ident_in_atomicTerm888); if (state.failed) return s;

                    if ( state.backtracking==0 ) {
                    		s ="nat"+(Nat_ident12!=null?Nat_ident12.getText():null);
                    	}

                    }
                    break;
                case 3 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:377:4: Var_ident
                    {
                    Var_ident13=(Token)match(input,Var_ident,FOLLOW_Var_ident_in_atomicTerm896); if (state.failed) return s;

                    if ( state.backtracking==0 ) {
                    		s =(Var_ident13!=null?Var_ident13.getText():null);
                    	}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return s;
    }
    // $ANTLR end "atomicTerm"



    // $ANTLR start "equationSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:383:1: equationSection : 'section equations:' ( equation )* ;
    public final void equationSection() throws RecognitionException {
        ifgrammarParser.equation_return equation14 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:384:2: ( 'section equations:' ( equation )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:384:5: 'section equations:' ( equation )*
            {
            match(input,43,FOLLOW_43_in_equationSection912); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:384:26: ( equation )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= Const_ident && LA16_0 <= Nat_ident)||LA16_0==Var_ident) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:384:27: equation
            	    {
            	    pushFollow(FOLLOW_equation_in_equationSection915);
            	    equation14=equation();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    if ( state.backtracking==0 ) {
            	    		String id = String.valueOf(nbRule);
            	    		try {
            	    			compiler.addRule(new Rule(id+"lr", (equation14!=null?equation14.left:null), (equation14!=null?equation14.right:null)));
            	    		} catch (Exception e) {
            	    			// TODO Auto-generated catch block
            	    			e.printStackTrace();
            	    		}
            	    		try {
            	    			compiler.addRule(new Rule(id+"rl", (equation14!=null?equation14.right:null), (equation14!=null?equation14.left:null)));
            	    		} catch (Exception e) {
            	    			// TODO Auto-generated catch block
            	    			e.printStackTrace();
            	    		}
            	    		nbRule++;
            	    	}

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "equationSection"


    public static class equation_return extends ParserRuleReturnScope {
        public Term left;
        public Term right;
    };


    // $ANTLR start "equation"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:403:1: equation returns [Term left, Term right] : l= term '=' r= term ;
    public final ifgrammarParser.equation_return equation() throws RecognitionException {
        ifgrammarParser.equation_return retval = new ifgrammarParser.equation_return();
        retval.start = input.LT(1);


        Term l =null;

        Term r =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:404:2: (l= term '=' r= term )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:404:4: l= term '=' r= term
            {
            pushFollow(FOLLOW_term_in_equation938);
            l=term();

            state._fsp--;
            if (state.failed) return retval;

            match(input,24,FOLLOW_24_in_equation940); if (state.failed) return retval;

            pushFollow(FOLLOW_term_in_equation944);
            r=term();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {
            		retval.left = l;
            		retval.right = r;
            	}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "equation"



    // $ANTLR start "term"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:410:1: term returns [Term t] : ( atomicTerm | composedTerm );
    public final Term term() throws RecognitionException {
        Term t = null;


        String atomicTerm15 =null;

        Term composedTerm16 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:411:2: ( atomicTerm | composedTerm )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Const_ident) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==EOF||(LA17_1 >= Const_ident && LA17_1 <= Nat_ident)||LA17_1==Var_ident||LA17_1==15||LA17_1==17||LA17_1==24||LA17_1==46) ) {
                    alt17=1;
                }
                else if ( (LA17_1==13) ) {
                    alt17=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return t;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA17_0==Nat_ident||LA17_0==Var_ident) ) {
                alt17=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return t;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:411:4: atomicTerm
                    {
                    pushFollow(FOLLOW_atomicTerm_in_term961);
                    atomicTerm15=atomicTerm();

                    state._fsp--;
                    if (state.failed) return t;

                    if ( state.backtracking==0 ) {
                    		Symbole sym = compiler.getSymbolesTable().get(atomicTerm15);
                    		t = new Term(sym, null);
                    	}

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:416:4: composedTerm
                    {
                    pushFollow(FOLLOW_composedTerm_in_term969);
                    composedTerm16=composedTerm();

                    state._fsp--;
                    if (state.failed) return t;

                    if ( state.backtracking==0 ) {
                    		t =composedTerm16;
                    	}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return t;
    }
    // $ANTLR end "term"



    // $ANTLR start "composedTerm"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:422:1: composedTerm returns [Term t] : op= if_Operator '(' tL= termList ')' ;
    public final Term composedTerm() throws RecognitionException {
        Term t = null;


        String op =null;

        LinkedList<Term> tL =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:423:2: (op= if_Operator '(' tL= termList ')' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:423:4: op= if_Operator '(' tL= termList ')'
            {
            pushFollow(FOLLOW_if_Operator_in_composedTerm989);
            op=if_Operator();

            state._fsp--;
            if (state.failed) return t;

            match(input,13,FOLLOW_13_in_composedTerm991); if (state.failed) return t;

            pushFollow(FOLLOW_termList_in_composedTerm994);
            tL=termList();

            state._fsp--;
            if (state.failed) return t;

            match(input,15,FOLLOW_15_in_composedTerm995); if (state.failed) return t;

            if ( state.backtracking==0 ) {
            		Symbole sym = compiler.getSymbolesTable().get(op);
            		t = new Term(sym, tL);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return t;
    }
    // $ANTLR end "composedTerm"



    // $ANTLR start "termList"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:429:1: termList returns [LinkedList<Term> list] : (t= term ',' tL= termList |t= term );
    public final LinkedList<Term> termList() throws RecognitionException {
        LinkedList<Term> list = null;


        Term t =null;

        LinkedList<Term> tL =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:430:2: (t= term ',' tL= termList |t= term )
            int alt18=2;
            switch ( input.LA(1) ) {
            case Const_ident:
                {
                int LA18_1 = input.LA(2);

                if ( (synpred24_ifgrammar()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;

                }
                }
                break;
            case Nat_ident:
                {
                int LA18_2 = input.LA(2);

                if ( (synpred24_ifgrammar()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;

                }
                }
                break;
            case Var_ident:
                {
                int LA18_3 = input.LA(2);

                if ( (synpred24_ifgrammar()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return list;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return list;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }

            switch (alt18) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:430:4: t= term ',' tL= termList
                    {
                    pushFollow(FOLLOW_term_in_termList1014);
                    t=term();

                    state._fsp--;
                    if (state.failed) return list;

                    match(input,17,FOLLOW_17_in_termList1016); if (state.failed) return list;

                    pushFollow(FOLLOW_termList_in_termList1020);
                    tL=termList();

                    state._fsp--;
                    if (state.failed) return list;

                    if ( state.backtracking==0 ) {
                    		tL.addFirst(t);
                    		list = tL;
                    	}

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:435:4: t= term
                    {
                    pushFollow(FOLLOW_term_in_termList1030);
                    t=term();

                    state._fsp--;
                    if (state.failed) return list;

                    if ( state.backtracking==0 ) {
                    		list = new LinkedList<Term>();
                    		list.add(t); 
                    	}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "termList"



    // $ANTLR start "initsSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:442:1: initsSection : 'section inits:' ( 'initial_state' Const_ident ':=' state )+ ;
    public final void initsSection() throws RecognitionException {
        ifgrammarParser.state_return state17 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:443:2: ( 'section inits:' ( 'initial_state' Const_ident ':=' state )+ )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:443:4: 'section inits:' ( 'initial_state' Const_ident ':=' state )+
            {
            match(input,45,FOLLOW_45_in_initsSection1046); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:443:21: ( 'initial_state' Const_ident ':=' state )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==35) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:443:22: 'initial_state' Const_ident ':=' state
            	    {
            	    match(input,35,FOLLOW_35_in_initsSection1049); if (state.failed) return ;

            	    match(input,Const_ident,FOLLOW_Const_ident_in_initsSection1051); if (state.failed) return ;

            	    match(input,22,FOLLOW_22_in_initsSection1053); if (state.failed) return ;

            	    pushFollow(FOLLOW_state_in_initsSection1055);
            	    state17=state();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    if ( state.backtracking==0 ) {
            	    		compiler.setInit((state17!=null?state17.list:null));
            	    	}

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "initsSection"


    public static class state_return extends ParserRuleReturnScope {
        public LinkedList<Term> list;
        public Vector<Cont> vecC;
        public Vector<Secr> vecS;
        public Term sid;
    };


    // $ANTLR start "state"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:449:1: state returns [LinkedList<Term> list, Vector<Cont> vecC, Vector<Secr> vecS, Term sid] : ( ( '.' )? f1= fact )+ ;
    public final ifgrammarParser.state_return state() throws RecognitionException {
        ifgrammarParser.state_return retval = new ifgrammarParser.state_return();
        retval.start = input.LT(1);


        ifgrammarParser.fact_return f1 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:450:2: ( ( ( '.' )? f1= fact )+ )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:451:2: ( ( '.' )? f1= fact )+
            {
            if ( state.backtracking==0 ) {
            		retval.list = new LinkedList<Term>();
            		retval.vecC = new Vector<Cont>();
            		retval.vecS = new Vector<Secr>();
            		retval.sid = new Term(compiler.getSymbolesTable().get("nulli"),null);
            	}

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:457:2: ( ( '.' )? f1= fact )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Const_ident||LA21_0==Var_ident||LA21_0==19||LA21_0==54) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:457:4: ( '.' )? f1= fact
            	    {
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:457:4: ( '.' )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==19) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:457:5: '.'
            	            {
            	            match(input,19,FOLLOW_19_in_state1085); if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_fact_in_state1090);
            	    f1=fact();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {
            	    		if((f1!=null?f1.f:null).getO().equals(compiler.getSymbolesTable().get("contains"))){
            	    			retval.vecC.add(new Cont((f1!=null?f1.f:null)));
            	    			retval.list.add((f1!=null?f1.f:null));
            	    		} else if ((f1!=null?f1.f:null).getO().equals(compiler.getSymbolesTable().get("secret"))){
            	    			retval.vecS.add(new Secr((f1!=null?f1.f:null)));
            	    		} else {
            	    			retval.list.add((f1!=null?f1.f:null));
            	    		}
            	    		
            	    		if((f1!=null?f1.isState:null)){
            	    			retval.sid = (f1!=null?f1.sid:null);
            	    		}
            	    	}

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "state"


    public static class fact_return extends ParserRuleReturnScope {
        public Term f;
        public Term sid;
        public Boolean isState;
    };


    // $ANTLR start "fact"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:474:1: fact returns [Term f, Term sid, Boolean isState] : if_Fact ( '(' termList ')' )? ;
    public final ifgrammarParser.fact_return fact() throws RecognitionException {
        ifgrammarParser.fact_return retval = new ifgrammarParser.fact_return();
        retval.start = input.LT(1);


        ifgrammarParser.if_Fact_return if_Fact18 =null;

        LinkedList<Term> termList19 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:475:2: ( if_Fact ( '(' termList ')' )? )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:475:4: if_Fact ( '(' termList ')' )?
            {
            pushFollow(FOLLOW_if_Fact_in_fact1111);
            if_Fact18=if_Fact();

            state._fsp--;
            if (state.failed) return retval;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:475:11: ( '(' termList ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==13) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:475:12: '(' termList ')'
                    {
                    match(input,13,FOLLOW_13_in_fact1113); if (state.failed) return retval;

                    pushFollow(FOLLOW_termList_in_fact1115);
                    termList19=termList();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,15,FOLLOW_15_in_fact1117); if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		Symbole o = compiler.getSymbolesTable().get((if_Fact18!=null?input.toString(if_Fact18.start,if_Fact18.stop):null));
            		retval.f = new Term(o,termList19);
            		retval.isState = (if_Fact18!=null?if_Fact18.isState:null);
            		if(retval.isState){
            			retval.sid = retval.f.getSons().getLast();
            		}
            	}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fact"


    public static class if_Fact_return extends ParserRuleReturnScope {
        public Boolean isState=false;
    };


    // $ANTLR start "if_Fact"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:485:1: if_Fact returns [Boolean isState=false] : ( 'state_' Const_ident | Const_ident | Var_ident );
    public final ifgrammarParser.if_Fact_return if_Fact() throws RecognitionException {
        ifgrammarParser.if_Fact_return retval = new ifgrammarParser.if_Fact_return();
        retval.start = input.LT(1);


        Token Const_ident20=null;

        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:486:2: ( 'state_' Const_ident | Const_ident | Var_ident )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt23=1;
                }
                break;
            case Const_ident:
                {
                alt23=2;
                }
                break;
            case Var_ident:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:486:4: 'state_' Const_ident
                    {
                    match(input,54,FOLLOW_54_in_if_Fact1136); if (state.failed) return retval;

                    match(input,Const_ident,FOLLOW_Const_ident_in_if_Fact1137); if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.isState =true;
                    	System.out.println("top");}

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:489:4: Const_ident
                    {
                    Const_ident20=(Token)match(input,Const_ident,FOLLOW_Const_ident_in_if_Fact1145); if (state.failed) return retval;

                    if ( state.backtracking==0 ) { 
                    		if((Const_ident20!=null?Const_ident20.getText():null).startsWith("state_"))
                    			retval.isState =true;
                    	}

                    }
                    break;
                case 3 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:494:4: Var_ident
                    {
                    match(input,Var_ident,FOLLOW_Var_ident_in_if_Fact1153); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "if_Fact"



    // $ANTLR start "rulesSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:497:1: rulesSection : 'section rules:' ( ruleDeclarationULHS )* ;
    public final void rulesSection() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:498:2: ( 'section rules:' ( ruleDeclarationULHS )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:498:4: 'section rules:' ( ruleDeclarationULHS )*
            {
            match(input,49,FOLLOW_49_in_rulesSection1165); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:498:21: ( ruleDeclarationULHS )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==55) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:498:21: ruleDeclarationULHS
            	    {
            	    pushFollow(FOLLOW_ruleDeclarationULHS_in_rulesSection1167);
            	    ruleDeclarationULHS();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "rulesSection"



    // $ANTLR start "ruleDeclarationU"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:501:1: ruleDeclarationU : 'step' Const_ident '(' ( variableList )? ')' ':=' ( cState )? ( existsVar )? '=>' state ;
    public final void ruleDeclarationU() throws RecognitionException {
        Token Const_ident25=null;
        ifgrammarParser.state_return state21 =null;

        LinkedList<Var> existsVar22 =null;

        LinkedList<Var> variableList23 =null;

        ifgrammarParser.cState_return cState24 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:502:2: ( 'step' Const_ident '(' ( variableList )? ')' ':=' ( cState )? ( existsVar )? '=>' state )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:502:4: 'step' Const_ident '(' ( variableList )? ')' ':=' ( cState )? ( existsVar )? '=>' state
            {
            match(input,55,FOLLOW_55_in_ruleDeclarationU1180); if (state.failed) return ;

            Const_ident25=(Token)match(input,Const_ident,FOLLOW_Const_ident_in_ruleDeclarationU1182); if (state.failed) return ;

            match(input,13,FOLLOW_13_in_ruleDeclarationU1184); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:502:27: ( variableList )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Var_ident) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:502:27: variableList
                    {
                    pushFollow(FOLLOW_variableList_in_ruleDeclarationU1186);
                    variableList23=variableList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,15,FOLLOW_15_in_ruleDeclarationU1189); if (state.failed) return ;

            match(input,22,FOLLOW_22_in_ruleDeclarationU1191); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:503:3: ( cState )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Const_ident||LA26_0==Var_ident||LA26_0==19||LA26_0==54) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:503:3: cState
                    {
                    pushFollow(FOLLOW_cState_in_ruleDeclarationU1195);
                    cState24=cState();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:503:11: ( existsVar )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==26) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:503:11: existsVar
                    {
                    pushFollow(FOLLOW_existsVar_in_ruleDeclarationU1198);
                    existsVar22=existsVar();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,25,FOLLOW_25_in_ruleDeclarationU1201); if (state.failed) return ;

            pushFollow(FOLLOW_state_in_ruleDeclarationU1203);
            state21=state();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {
            		LinkedList<Term> list = (state21!=null?state21.list:null);
            		Vector<Secr> vecS = (state21!=null?state21.vecS:null);
            		Term freshNonce;
            		for(int i = 0; i < vecS.size(); i++){
            			list.add(vecS.get(i).toTerm((state21!=null?state21.vecC:null)));
            		}
            		if(existsVar22 != null){
            			LinkedList<Var> nonFreshVar = variableList23;
            			nonFreshVar.removeAll(existsVar22);
            			
            			freshNonce = Term.generateNonce(nonFreshVar, compiler.getSymbolesTable().get("n"), new Term(compiler.getSymbolesTable().get("nulli"),null));
            			list = Term.replaceNonce(list,freshNonce,existsVar22);
            		}

            		Term l;
            		try{
            			if((cState24!=null?cState24.list:null).size()==1)
            				l = (cState24!=null?cState24.list:null).getFirst();
            			else
            				l = Term.union((cState24!=null?cState24.list:null),compiler.getSymbolesTable().get("u"), compiler.getSymbolesTable().get("null"));
            		}catch(Exception e){
            			l=null;
            		}
            		Term r;
            			if(list.size() == 1)
            				r = list.getFirst();
            			else
            				r = Term.union(list,compiler.getSymbolesTable().get("u"), compiler.getSymbolesTable().get("null"));
            		//Rule rule = new Rule((Const_ident25!=null?Const_ident25.getText():null), l, r, existsVar22, nonFreshVar, compiler.getSymbolesTable().get("u"));
            		l.correctPair();
            		r.correctPair();
            		Rule rule = new Rule((Const_ident25!=null?Const_ident25.getText():null), l, r);
            		//rule.toLinear(compiler);
            		try{
            			compiler.addRule(rule);
            		}catch(Exception e){
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ruleDeclarationU"



    // $ANTLR start "ruleDeclarationULHS"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:547:1: ruleDeclarationULHS : 'step' Const_ident '(' ( variableList )? ')' ':=' ( cState )? ( existsVar )? '=>' state ;
    public final void ruleDeclarationULHS() throws RecognitionException {
        Token Const_ident30=null;
        ifgrammarParser.state_return state26 =null;

        ifgrammarParser.cState_return cState27 =null;

        LinkedList<Var> existsVar28 =null;

        LinkedList<Var> variableList29 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:548:2: ( 'step' Const_ident '(' ( variableList )? ')' ':=' ( cState )? ( existsVar )? '=>' state )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:548:4: 'step' Const_ident '(' ( variableList )? ')' ':=' ( cState )? ( existsVar )? '=>' state
            {
            match(input,55,FOLLOW_55_in_ruleDeclarationULHS1218); if (state.failed) return ;

            Const_ident30=(Token)match(input,Const_ident,FOLLOW_Const_ident_in_ruleDeclarationULHS1220); if (state.failed) return ;

            match(input,13,FOLLOW_13_in_ruleDeclarationULHS1222); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:548:27: ( variableList )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Var_ident) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:548:27: variableList
                    {
                    pushFollow(FOLLOW_variableList_in_ruleDeclarationULHS1224);
                    variableList29=variableList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,15,FOLLOW_15_in_ruleDeclarationULHS1227); if (state.failed) return ;

            match(input,22,FOLLOW_22_in_ruleDeclarationULHS1229); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:549:3: ( cState )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==Const_ident||LA29_0==Var_ident||LA29_0==19||LA29_0==54) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:549:3: cState
                    {
                    pushFollow(FOLLOW_cState_in_ruleDeclarationULHS1233);
                    cState27=cState();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:549:11: ( existsVar )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==26) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:549:11: existsVar
                    {
                    pushFollow(FOLLOW_existsVar_in_ruleDeclarationULHS1236);
                    existsVar28=existsVar();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,25,FOLLOW_25_in_ruleDeclarationULHS1239); if (state.failed) return ;

            pushFollow(FOLLOW_state_in_ruleDeclarationULHS1241);
            state26=state();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {
            		LinkedList<Term> listR = (state26!=null?state26.list:null);
            		LinkedList<Term> listL = (LinkedList<Term>)(cState27!=null?cState27.list:null).clone();
            		Vector<Secr> vecS = (state26!=null?state26.vecS:null);
            		Term freshNonce;
            		Term sid;
            		if((cState27!=null?cState27.sid:null)==null)
            			sid = new Term(compiler.getSymbolesTable().get("nulli"),null);
            		else
            			sid = (cState27!=null?cState27.sid:null);
            		for(int i = 0; i < vecS.size(); i++){
            			listR.add(vecS.get(i).toTerm((state26!=null?state26.vecC:null)));
            		}
            		if(existsVar28 != null){
            			LinkedList<Var> nonFreshVar = variableList29;
            			nonFreshVar.removeAll(existsVar28);
            			
            			freshNonce = Term.generateNonce(nonFreshVar, compiler.getSymbolesTable().get("n"), sid);
            			listR = Term.replaceNonce(listR,freshNonce,existsVar28);
            		}
            		
            		Term l;
            		try{
            				l = Term.union((cState27!=null?cState27.list:null),compiler.getSymbolesTable().get("u"),(Var)compiler.getSymbolesTable().get("U"));
            		}catch(Exception e){
            			l=null;
            		}
            		l.correctPair();
            		l.tagPair("PID", (Const_ident30!=null?Const_ident30.getText():null), "",compiler);
            		l.tagCrypt("CID", (Const_ident30!=null?Const_ident30.getText():null), "",compiler);
            		 
            		
            		
            		Iterator<Term> it = listR.iterator();
            		while(it.hasNext()){
            			Term t = it.next();
            			t.correctPair();
            			t.tagPair(sid.getO().toString(),(Const_ident30!=null?Const_ident30.getText():null),"",compiler);
            		}
            		for(Term t:listR){
            			t.tagCrypt(sid.getO().toString(), (Const_ident30!=null?Const_ident30.getText():null), "",compiler);
            		}
            		/*try{
            			listR.addAll(listL);
            		}catch(NullPointerException e){}	*/
            		
            		l = l.toLinear(compiler,(Const_ident30!=null?Const_ident30.getText():null));
            		//l = Term.union(l,compiler.getSymbolesTable().get("u"),(Var)compiler.getSymbolesTable().get("U"));
            		
            		Term r = new Term(compiler.getSymbolesTable().get("u"), new LinkedList<Term>());
            		Term r2 = r;
            		Term r3 = r;
            		for(Term t:listR){
            			r2 = r3;
            			r2.getSons().add(t);
            			r3 = new Term(compiler.getSymbolesTable().get("u"), new LinkedList<Term>());
            			r2.getSons().add(r3);
            		}
            		// remove union(u())
            		r2.getSons().removeLast();
            		// add union(u(l,U))
            		r2.getSons().add(l);
            		Rule rule = new Rule((Const_ident30!=null?Const_ident30.getText():null)+"_2", l, r);
            		try{
            			compiler.addRule(rule);
            		}catch(Exception e){
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ruleDeclarationULHS"



    // $ANTLR start "ruleDeclarationR"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:622:1: ruleDeclarationR : 'step' Const_ident '(' ( variableList )? ')' ':=' ( cState )? ( existsVar )? '=>' state ;
    public final void ruleDeclarationR() throws RecognitionException {
        Token Const_ident35=null;
        ifgrammarParser.state_return state31 =null;

        ifgrammarParser.cState_return cState32 =null;

        LinkedList<Var> existsVar33 =null;

        LinkedList<Var> variableList34 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:623:2: ( 'step' Const_ident '(' ( variableList )? ')' ':=' ( cState )? ( existsVar )? '=>' state )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:623:4: 'step' Const_ident '(' ( variableList )? ')' ':=' ( cState )? ( existsVar )? '=>' state
            {
            match(input,55,FOLLOW_55_in_ruleDeclarationR1255); if (state.failed) return ;

            Const_ident35=(Token)match(input,Const_ident,FOLLOW_Const_ident_in_ruleDeclarationR1257); if (state.failed) return ;

            match(input,13,FOLLOW_13_in_ruleDeclarationR1259); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:623:27: ( variableList )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==Var_ident) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:623:27: variableList
                    {
                    pushFollow(FOLLOW_variableList_in_ruleDeclarationR1261);
                    variableList34=variableList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,15,FOLLOW_15_in_ruleDeclarationR1264); if (state.failed) return ;

            match(input,22,FOLLOW_22_in_ruleDeclarationR1266); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:624:3: ( cState )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==Const_ident||LA32_0==Var_ident||LA32_0==19||LA32_0==54) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:624:3: cState
                    {
                    pushFollow(FOLLOW_cState_in_ruleDeclarationR1270);
                    cState32=cState();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:624:11: ( existsVar )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==26) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:624:11: existsVar
                    {
                    pushFollow(FOLLOW_existsVar_in_ruleDeclarationR1273);
                    existsVar33=existsVar();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,25,FOLLOW_25_in_ruleDeclarationR1276); if (state.failed) return ;

            pushFollow(FOLLOW_state_in_ruleDeclarationR1278);
            state31=state();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {
            		LinkedList<Term> listR = (state31!=null?state31.list:null);
            		LinkedList<Term> listL = (LinkedList<Term>)(cState32!=null?cState32.list:null).clone();
            		Vector<Secr> vecS = (state31!=null?state31.vecS:null);
            		Term freshNonce;
            		Term sid;
            		if((cState32!=null?cState32.sid:null)==null)
            			sid = new Term(compiler.getSymbolesTable().get("nulli"),null);
            		else
            			sid = (cState32!=null?cState32.sid:null);
            		for(int i = 0; i < vecS.size(); i++){
            			listR.add(vecS.get(i).toTerm((state31!=null?state31.vecC:null)));
            		}
            		if(existsVar33 != null){
            			LinkedList<Var> nonFreshVar = variableList34;
            			nonFreshVar.removeAll(existsVar33);
            			
            			freshNonce = Term.generateNonce(nonFreshVar, compiler.getSymbolesTable().get("n"), sid);
            			listR = Term.replaceNonce(listR,freshNonce,existsVar33);
            		}
            		
            		Term l = listL.get(0);
            		l.correctPair();
            		l.tagPair(compiler.getSymbolesTable().get("PID").toString(), (Const_ident35!=null?Const_ident35.getText():null), "",compiler);
            		l.tagCrypt(compiler.getSymbolesTable().get("CID").toString(), (Const_ident35!=null?Const_ident35.getText():null), "",compiler);

            		Term r = listR.get(0);
            		r.correctPair();
            		r.tagPair(sid.getO().toString(),(Const_ident35!=null?Const_ident35.getText():null),"",compiler);
            		r.tagCrypt(sid.getO().toString(), (Const_ident35!=null?Const_ident35.getText():null), "",compiler);

            		Rule rule = new Rule((Const_ident35!=null?Const_ident35.getText():null), l, r);
            		//rule.toLinear(compiler);
            		try{
            			compiler.addRule(rule);
            		}catch(Exception e){
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ruleDeclarationR"


    public static class cState_return extends ParserRuleReturnScope {
        public LinkedList<Term> list;
        public Vector<Secr> vecS;
        public Term sid;
    };


    // $ANTLR start "cState"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:667:1: cState returns [LinkedList<Term> list, Vector<Secr> vecS, Term sid] : state conditionList ;
    public final ifgrammarParser.cState_return cState() throws RecognitionException {
        ifgrammarParser.cState_return retval = new ifgrammarParser.cState_return();
        retval.start = input.LT(1);


        ifgrammarParser.state_return state36 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:668:2: ( state conditionList )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:668:4: state conditionList
            {
            pushFollow(FOLLOW_state_in_cState1297);
            state36=state();

            state._fsp--;
            if (state.failed) return retval;

            pushFollow(FOLLOW_conditionList_in_cState1299);
            conditionList();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {
            		retval.list = (state36!=null?state36.list:null);
            		retval.vecS = (state36!=null?state36.vecS:null);
            		for(int i=0; i < retval.vecS.size(); i++){
            			retval.list.add(retval.vecS.get(i).toTerm());
            		}
            		retval.sid = (state36!=null?state36.sid:null);
            	}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cState"



    // $ANTLR start "conditionList"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:678:1: conditionList : ( '&' condition )* ;
    public final void conditionList() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:679:2: ( ( '&' condition )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:679:4: ( '&' condition )*
            {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:679:4: ( '&' condition )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==12) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:679:5: '&' condition
            	    {
            	    match(input,12,FOLLOW_12_in_conditionList1313); if (state.failed) return ;

            	    pushFollow(FOLLOW_condition_in_conditionList1315);
            	    condition();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "conditionList"



    // $ANTLR start "condition"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:681:1: condition : ( positiveCondition | negativeCondition );
    public final void condition() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:682:2: ( positiveCondition | negativeCondition )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==33||LA35_0==36) ) {
                alt35=1;
            }
            else if ( (LA35_0==38) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:682:4: positiveCondition
                    {
                    pushFollow(FOLLOW_positiveCondition_in_condition1327);
                    positiveCondition();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:683:4: negativeCondition
                    {
                    pushFollow(FOLLOW_negativeCondition_in_condition1332);
                    negativeCondition();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "condition"



    // $ANTLR start "positiveCondition"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:685:1: positiveCondition : ( 'equal' '(' term ',' term ')' | 'leq' '(' term ',' term ')' );
    public final void positiveCondition() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:686:2: ( 'equal' '(' term ',' term ')' | 'leq' '(' term ',' term ')' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==33) ) {
                alt36=1;
            }
            else if ( (LA36_0==36) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:686:4: 'equal' '(' term ',' term ')'
                    {
                    match(input,33,FOLLOW_33_in_positiveCondition1342); if (state.failed) return ;

                    match(input,13,FOLLOW_13_in_positiveCondition1344); if (state.failed) return ;

                    pushFollow(FOLLOW_term_in_positiveCondition1346);
                    term();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,17,FOLLOW_17_in_positiveCondition1348); if (state.failed) return ;

                    pushFollow(FOLLOW_term_in_positiveCondition1350);
                    term();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,15,FOLLOW_15_in_positiveCondition1352); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:687:4: 'leq' '(' term ',' term ')'
                    {
                    match(input,36,FOLLOW_36_in_positiveCondition1357); if (state.failed) return ;

                    match(input,13,FOLLOW_13_in_positiveCondition1359); if (state.failed) return ;

                    pushFollow(FOLLOW_term_in_positiveCondition1361);
                    term();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,17,FOLLOW_17_in_positiveCondition1363); if (state.failed) return ;

                    pushFollow(FOLLOW_term_in_positiveCondition1365);
                    term();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,15,FOLLOW_15_in_positiveCondition1367); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "positiveCondition"



    // $ANTLR start "negativeCondition"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:689:1: negativeCondition : ( 'not' '(' condition ')' | 'not' '(' fact ')' );
    public final void negativeCondition() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:690:2: ( 'not' '(' condition ')' | 'not' '(' fact ')' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==38) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==13) ) {
                    int LA37_2 = input.LA(3);

                    if ( (LA37_2==33||LA37_2==36||LA37_2==38) ) {
                        alt37=1;
                    }
                    else if ( (LA37_2==Const_ident||LA37_2==Var_ident||LA37_2==54) ) {
                        alt37=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:690:4: 'not' '(' condition ')'
                    {
                    match(input,38,FOLLOW_38_in_negativeCondition1377); if (state.failed) return ;

                    match(input,13,FOLLOW_13_in_negativeCondition1379); if (state.failed) return ;

                    pushFollow(FOLLOW_condition_in_negativeCondition1381);
                    condition();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,15,FOLLOW_15_in_negativeCondition1383); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:691:4: 'not' '(' fact ')'
                    {
                    match(input,38,FOLLOW_38_in_negativeCondition1388); if (state.failed) return ;

                    match(input,13,FOLLOW_13_in_negativeCondition1390); if (state.failed) return ;

                    pushFollow(FOLLOW_fact_in_negativeCondition1392);
                    fact();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,15,FOLLOW_15_in_negativeCondition1394); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "negativeCondition"



    // $ANTLR start "existsVar"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:693:1: existsVar returns [LinkedList<Var> list] : '=[exists' variableList ']' ;
    public final LinkedList<Var> existsVar() throws RecognitionException {
        LinkedList<Var> list = null;


        LinkedList<Var> variableList37 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:694:2: ( '=[exists' variableList ']' )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:694:4: '=[exists' variableList ']'
            {
            match(input,26,FOLLOW_26_in_existsVar1408); if (state.failed) return list;

            pushFollow(FOLLOW_variableList_in_existsVar1410);
            variableList37=variableList();

            state._fsp--;
            if (state.failed) return list;

            match(input,31,FOLLOW_31_in_existsVar1412); if (state.failed) return list;

            if ( state.backtracking==0 ) {
            		list = variableList37;
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "existsVar"



    // $ANTLR start "variableList"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:699:1: variableList returns [LinkedList<Var> list] : vi1= Var_ident ( ',' vi2= Var_ident )* ;
    public final LinkedList<Var> variableList() throws RecognitionException {
        LinkedList<Var> list = null;


        Token vi1=null;
        Token vi2=null;

        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:700:2: (vi1= Var_ident ( ',' vi2= Var_ident )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:700:4: vi1= Var_ident ( ',' vi2= Var_ident )*
            {
            vi1=(Token)match(input,Var_ident,FOLLOW_Var_ident_in_variableList1431); if (state.failed) return list;

            if ( state.backtracking==0 ) {
            		list = new LinkedList<Var>();
            		Var v = (Var)compiler.getSymbolesTable().get((vi1!=null?vi1.getText():null));
            		list.add(v);
            	}

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:706:3: ( ',' vi2= Var_ident )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==17) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:706:4: ',' vi2= Var_ident
            	    {
            	    match(input,17,FOLLOW_17_in_variableList1440); if (state.failed) return list;

            	    vi2=(Token)match(input,Var_ident,FOLLOW_Var_ident_in_variableList1444); if (state.failed) return list;

            	    if ( state.backtracking==0 ) {
            	    		Var v = (Var)compiler.getSymbolesTable().get((vi2!=null?vi2.getText():null));
            	    		list.add(v);	
            	    	}

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "variableList"



    // $ANTLR start "propertiesSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:713:1: propertiesSection : 'section properties:' ( propertyDeclaration )* ;
    public final void propertiesSection() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:714:2: ( 'section properties:' ( propertyDeclaration )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:714:4: 'section properties:' ( propertyDeclaration )*
            {
            match(input,48,FOLLOW_48_in_propertiesSection1461); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:714:26: ( propertyDeclaration )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==39) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:714:26: propertyDeclaration
            	    {
            	    pushFollow(FOLLOW_propertyDeclaration_in_propertiesSection1463);
            	    propertyDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "propertiesSection"



    // $ANTLR start "propertyDeclaration"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:717:1: propertyDeclaration : 'property' propertyID '(' variableList ')' ':=' '[]' ltl_Formula ;
    public final void propertyDeclaration() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:718:2: ( 'property' propertyID '(' variableList ')' ':=' '[]' ltl_Formula )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:718:4: 'property' propertyID '(' variableList ')' ':=' '[]' ltl_Formula
            {
            match(input,39,FOLLOW_39_in_propertyDeclaration1475); if (state.failed) return ;

            pushFollow(FOLLOW_propertyID_in_propertyDeclaration1477);
            propertyID();

            state._fsp--;
            if (state.failed) return ;

            match(input,13,FOLLOW_13_in_propertyDeclaration1479); if (state.failed) return ;

            pushFollow(FOLLOW_variableList_in_propertyDeclaration1481);
            variableList();

            state._fsp--;
            if (state.failed) return ;

            match(input,15,FOLLOW_15_in_propertyDeclaration1483); if (state.failed) return ;

            match(input,22,FOLLOW_22_in_propertyDeclaration1485); if (state.failed) return ;

            match(input,29,FOLLOW_29_in_propertyDeclaration1489); if (state.failed) return ;

            pushFollow(FOLLOW_ltl_Formula_in_propertyDeclaration1491);
            ltl_Formula();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "propertyDeclaration"



    // $ANTLR start "propertyID"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:721:1: propertyID : ( attackStateID | 'ltl_' Nat_ident );
    public final void propertyID() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:722:2: ( attackStateID | 'ltl_' Nat_ident )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==Auth||LA40_0==Const_ident||LA40_0==Secret||LA40_0==WeakAuth) ) {
                alt40=1;
            }
            else if ( (LA40_0==37) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }
            switch (alt40) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:722:4: attackStateID
                    {
                    pushFollow(FOLLOW_attackStateID_in_propertyID1501);
                    attackStateID();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:723:5: 'ltl_' Nat_ident
                    {
                    match(input,37,FOLLOW_37_in_propertyID1507); if (state.failed) return ;

                    match(input,Nat_ident,FOLLOW_Nat_ident_in_propertyID1509); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "propertyID"



    // $ANTLR start "ltl_Formula"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:726:1: ltl_Formula : ( ltl_Predicate | '<->' ltl_Formula | '(-)' ltl_Formula | '[-]' ltl_Formula | '~' ltl_Formula | '(' ltl_Formula ')' ) ( '/\\\\' ltl_Formula | '\\\\/' ltl_Formula | '=>' ltl_Formula )* ;
    public final void ltl_Formula() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:727:2: ( ( ltl_Predicate | '<->' ltl_Formula | '(-)' ltl_Formula | '[-]' ltl_Formula | '~' ltl_Formula | '(' ltl_Formula ')' ) ( '/\\\\' ltl_Formula | '\\\\/' ltl_Formula | '=>' ltl_Formula )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:727:4: ( ltl_Predicate | '<->' ltl_Formula | '(-)' ltl_Formula | '[-]' ltl_Formula | '~' ltl_Formula | '(' ltl_Formula ')' ) ( '/\\\\' ltl_Formula | '\\\\/' ltl_Formula | '=>' ltl_Formula )*
            {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:727:4: ( ltl_Predicate | '<->' ltl_Formula | '(-)' ltl_Formula | '[-]' ltl_Formula | '~' ltl_Formula | '(' ltl_Formula ')' )
            int alt41=6;
            switch ( input.LA(1) ) {
            case Const_ident:
            case Var_ident:
            case 33:
            case 36:
            case 54:
                {
                alt41=1;
                }
                break;
            case 23:
                {
                alt41=2;
                }
                break;
            case 14:
                {
                alt41=3;
                }
                break;
            case 28:
                {
                alt41=4;
                }
                break;
            case 58:
                {
                alt41=5;
                }
                break;
            case 13:
                {
                alt41=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }

            switch (alt41) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:727:5: ltl_Predicate
                    {
                    pushFollow(FOLLOW_ltl_Predicate_in_ltl_Formula1522);
                    ltl_Predicate();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:728:5: '<->' ltl_Formula
                    {
                    match(input,23,FOLLOW_23_in_ltl_Formula1529); if (state.failed) return ;

                    pushFollow(FOLLOW_ltl_Formula_in_ltl_Formula1531);
                    ltl_Formula();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:729:5: '(-)' ltl_Formula
                    {
                    match(input,14,FOLLOW_14_in_ltl_Formula1538); if (state.failed) return ;

                    pushFollow(FOLLOW_ltl_Formula_in_ltl_Formula1540);
                    ltl_Formula();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:730:5: '[-]' ltl_Formula
                    {
                    match(input,28,FOLLOW_28_in_ltl_Formula1547); if (state.failed) return ;

                    pushFollow(FOLLOW_ltl_Formula_in_ltl_Formula1549);
                    ltl_Formula();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:731:5: '~' ltl_Formula
                    {
                    match(input,58,FOLLOW_58_in_ltl_Formula1556); if (state.failed) return ;

                    pushFollow(FOLLOW_ltl_Formula_in_ltl_Formula1558);
                    ltl_Formula();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:732:5: '(' ltl_Formula ')'
                    {
                    match(input,13,FOLLOW_13_in_ltl_Formula1565); if (state.failed) return ;

                    pushFollow(FOLLOW_ltl_Formula_in_ltl_Formula1567);
                    ltl_Formula();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,15,FOLLOW_15_in_ltl_Formula1569); if (state.failed) return ;

                    }
                    break;

            }


            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:733:3: ( '/\\\\' ltl_Formula | '\\\\/' ltl_Formula | '=>' ltl_Formula )*
            loop42:
            do {
                int alt42=4;
                switch ( input.LA(1) ) {
                case 20:
                    {
                    int LA42_2 = input.LA(2);

                    if ( (synpred53_ifgrammar()) ) {
                        alt42=1;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA42_3 = input.LA(2);

                    if ( (synpred54_ifgrammar()) ) {
                        alt42=2;
                    }


                    }
                    break;
                case 25:
                    {
                    int LA42_4 = input.LA(2);

                    if ( (synpred55_ifgrammar()) ) {
                        alt42=3;
                    }


                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:733:4: '/\\\\' ltl_Formula
            	    {
            	    match(input,20,FOLLOW_20_in_ltl_Formula1575); if (state.failed) return ;

            	    pushFollow(FOLLOW_ltl_Formula_in_ltl_Formula1577);
            	    ltl_Formula();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:734:5: '\\\\/' ltl_Formula
            	    {
            	    match(input,30,FOLLOW_30_in_ltl_Formula1584); if (state.failed) return ;

            	    pushFollow(FOLLOW_ltl_Formula_in_ltl_Formula1586);
            	    ltl_Formula();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:735:5: '=>' ltl_Formula
            	    {
            	    match(input,25,FOLLOW_25_in_ltl_Formula1593); if (state.failed) return ;

            	    pushFollow(FOLLOW_ltl_Formula_in_ltl_Formula1595);
            	    ltl_Formula();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ltl_Formula"



    // $ANTLR start "ltl_Predicate"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:737:1: ltl_Predicate : ( fact | positiveCondition );
    public final void ltl_Predicate() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:738:2: ( fact | positiveCondition )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==Const_ident||LA43_0==Var_ident||LA43_0==54) ) {
                alt43=1;
            }
            else if ( (LA43_0==33||LA43_0==36) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:738:4: fact
                    {
                    pushFollow(FOLLOW_fact_in_ltl_Predicate1607);
                    fact();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:739:5: positiveCondition
                    {
                    pushFollow(FOLLOW_positiveCondition_in_ltl_Predicate1613);
                    positiveCondition();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ltl_Predicate"



    // $ANTLR start "attackStatesSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:742:1: attackStatesSection : 'section attack_states:' ( attackStateDeclaration )* ;
    public final void attackStatesSection() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:743:2: ( 'section attack_states:' ( attackStateDeclaration )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:743:4: 'section attack_states:' ( attackStateDeclaration )*
            {
            match(input,41,FOLLOW_41_in_attackStatesSection1624); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:743:29: ( attackStateDeclaration )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==32) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:743:29: attackStateDeclaration
            	    {
            	    pushFollow(FOLLOW_attackStateDeclaration_in_attackStatesSection1626);
            	    attackStateDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "attackStatesSection"



    // $ANTLR start "attackStateDeclaration"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:746:1: attackStateDeclaration returns [Vector<Pattern> lstPat] : 'attack_state' attackStateID '(' variableList ')' ':=' cState ;
    public final Vector<Pattern> attackStateDeclaration() throws RecognitionException {
        Vector<Pattern> lstPat = null;


        String attackStateID38 =null;

        ifgrammarParser.cState_return cState39 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:747:2: ( 'attack_state' attackStateID '(' variableList ')' ':=' cState )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:747:4: 'attack_state' attackStateID '(' variableList ')' ':=' cState
            {
            match(input,32,FOLLOW_32_in_attackStateDeclaration1643); if (state.failed) return lstPat;

            pushFollow(FOLLOW_attackStateID_in_attackStateDeclaration1645);
            attackStateID38=attackStateID();

            state._fsp--;
            if (state.failed) return lstPat;

            match(input,13,FOLLOW_13_in_attackStateDeclaration1647); if (state.failed) return lstPat;

            pushFollow(FOLLOW_variableList_in_attackStateDeclaration1649);
            variableList();

            state._fsp--;
            if (state.failed) return lstPat;

            match(input,15,FOLLOW_15_in_attackStateDeclaration1651); if (state.failed) return lstPat;

            match(input,22,FOLLOW_22_in_attackStateDeclaration1653); if (state.failed) return lstPat;

            pushFollow(FOLLOW_cState_in_attackStateDeclaration1655);
            cState39=cState();

            state._fsp--;
            if (state.failed) return lstPat;

            if ( state.backtracking==0 ) {
            		lstPat = new Vector<Pattern>();
            		if(!(attackStateID38 == null)){
            			LinkedList<Term> list = (cState39!=null?cState39.list:null);	
            			//for(int i=0; i < (cState39!=null?cState39.vecS:null).size(); i++){
            			//	list.add(vecS.get(i).toPattern());
            			//}
            			Term l;
            			if(list.size()==1)
            				l = list.getFirst();
            			else
            				l = Term.union(list,compiler.getSymbolesTable().get("u"));
            			try{
            				lstPat.add(new Pattern(attackStateID38, l));
            			} catch (Exception e) {
            				// TODO Auto-generated catch block
            				e.printStackTrace();
            			}
            		}
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return lstPat;
    }
    // $ANTLR end "attackStateDeclaration"



    // $ANTLR start "attackStateID"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:769:1: attackStateID returns [String s] : (s2= Secret | Auth | WeakAuth | Const_ident );
    public final String attackStateID() throws RecognitionException {
        String s = null;


        Token s2=null;

        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:770:2: (s2= Secret | Auth | WeakAuth | Const_ident )
            int alt45=4;
            switch ( input.LA(1) ) {
            case Secret:
                {
                alt45=1;
                }
                break;
            case Auth:
                {
                alt45=2;
                }
                break;
            case WeakAuth:
                {
                alt45=3;
                }
                break;
            case Const_ident:
                {
                alt45=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return s;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:770:4: s2= Secret
                    {
                    s2=(Token)match(input,Secret,FOLLOW_Secret_in_attackStateID1674); if (state.failed) return s;

                    if ( state.backtracking==0 ) {
                    		s =(s2!=null?s2.getText():null);
                    	}

                    }
                    break;
                case 2 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:774:4: Auth
                    {
                    match(input,Auth,FOLLOW_Auth_in_attackStateID1682); if (state.failed) return s;

                    }
                    break;
                case 3 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:775:4: WeakAuth
                    {
                    match(input,WeakAuth,FOLLOW_WeakAuth_in_attackStateID1687); if (state.failed) return s;

                    }
                    break;
                case 4 :
                    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:776:4: Const_ident
                    {
                    match(input,Const_ident,FOLLOW_Const_ident_in_attackStateID1692); if (state.failed) return s;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return s;
    }
    // $ANTLR end "attackStateID"



    // $ANTLR start "intruderSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:779:1: intruderSection : 'section intruder:' ( ruleDeclarationULHS )* ;
    public final void intruderSection() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:780:2: ( 'section intruder:' ( ruleDeclarationULHS )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:780:4: 'section intruder:' ( ruleDeclarationULHS )*
            {
            match(input,46,FOLLOW_46_in_intruderSection1704); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:780:24: ( ruleDeclarationULHS )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==55) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:780:24: ruleDeclarationULHS
            	    {
            	    pushFollow(FOLLOW_ruleDeclarationULHS_in_intruderSection1706);
            	    ruleDeclarationULHS();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "intruderSection"



    // $ANTLR start "verifSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:790:1: verifSection : 'section verification:' ( ruleDeclarationULHS )* ;
    public final void verifSection() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:791:2: ( 'section verification:' ( ruleDeclarationULHS )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:791:4: 'section verification:' ( ruleDeclarationULHS )*
            {
            match(input,53,FOLLOW_53_in_verifSection1797); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:791:28: ( ruleDeclarationULHS )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==55) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:791:28: ruleDeclarationULHS
            	    {
            	    pushFollow(FOLLOW_ruleDeclarationULHS_in_verifSection1799);
            	    ruleDeclarationULHS();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "verifSection"



    // $ANTLR start "checkSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:793:1: checkSection : 'section check:' ( ruleDeclarationR )* ;
    public final void checkSection() throws RecognitionException {
        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:794:2: ( 'section check:' ( ruleDeclarationR )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:794:4: 'section check:' ( ruleDeclarationR )*
            {
            match(input,42,FOLLOW_42_in_checkSection1810); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:794:21: ( ruleDeclarationR )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==55) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:794:21: ruleDeclarationR
            	    {
            	    pushFollow(FOLLOW_ruleDeclarationR_in_checkSection1812);
            	    ruleDeclarationR();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "checkSection"



    // $ANTLR start "failSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:796:1: failSection : 'section fail_states:' ( attackStateDeclaration )* ;
    public final void failSection() throws RecognitionException {
        Vector<Pattern> attackStateDeclaration40 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:797:2: ( 'section fail_states:' ( attackStateDeclaration )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:797:4: 'section fail_states:' ( attackStateDeclaration )*
            {
            match(input,44,FOLLOW_44_in_failSection1823); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:797:27: ( attackStateDeclaration )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==32) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:797:27: attackStateDeclaration
            	    {
            	    pushFollow(FOLLOW_attackStateDeclaration_in_failSection1825);
            	    attackStateDeclaration40=attackStateDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		Vector<Pattern> vecP = attackStateDeclaration40;
            		for(int i=0; i<vecP.size(); i++){
            			try{
            				compiler.addPattern(vecP.get(i));
            			}catch(Exception e){}
            		}
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "failSection"



    // $ANTLR start "approxSection"
    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:808:1: approxSection : 'section approximations:' ( equation )* ;
    public final void approxSection() throws RecognitionException {
        ifgrammarParser.equation_return equation41 =null;


        try {
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:809:2: ( 'section approximations:' ( equation )* )
            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:809:5: 'section approximations:' ( equation )*
            {
            match(input,40,FOLLOW_40_in_approxSection1842); if (state.failed) return ;

            // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:809:31: ( equation )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0 >= Const_ident && LA50_0 <= Nat_ident)||LA50_0==Var_ident) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:809:32: equation
            	    {
            	    pushFollow(FOLLOW_equation_in_approxSection1845);
            	    equation41=equation();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    if ( state.backtracking==0 ) {
            	    		String id = String.valueOf(nbEq);
            	    		try {
            	    			compiler.addEquation(new Equation(id, (equation41!=null?equation41.left:null), (equation41!=null?equation41.right:null)));
            	    		} catch (Exception e) {
            	    			// TODO Auto-generated catch block
            	    			e.printStackTrace();
            	    		}
            	    		nbEq++;
            	    	}

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "approxSection"

    // $ANTLR start synpred8_ifgrammar
    public final void synpred8_ifgrammar_fragment() throws RecognitionException {
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:229:4: ( functionDeclaration )
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:229:4: functionDeclaration
        {
        pushFollow(FOLLOW_functionDeclaration_in_synpred8_ifgrammar509);
        functionDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred8_ifgrammar

    // $ANTLR start synpred13_ifgrammar
    public final void synpred13_ifgrammar_fragment() throws RecognitionException {
        LinkedList<Type> tS =null;


        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:297:5: ( type '*' tS= typeStar )
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:297:5: type '*' tS= typeStar
        {
        pushFollow(FOLLOW_type_in_synpred13_ifgrammar712);
        type();

        state._fsp--;
        if (state.failed) return ;

        match(input,16,FOLLOW_16_in_synpred13_ifgrammar714); if (state.failed) return ;

        pushFollow(FOLLOW_typeStar_in_synpred13_ifgrammar718);
        tS=typeStar();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred13_ifgrammar

    // $ANTLR start synpred14_ifgrammar
    public final void synpred14_ifgrammar_fragment() throws RecognitionException {
        LinkedList<Type> tL =null;


        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:311:5: ( type ',' tL= typeList )
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:311:5: type ',' tL= typeList
        {
        pushFollow(FOLLOW_type_in_synpred14_ifgrammar748);
        type();

        state._fsp--;
        if (state.failed) return ;

        match(input,17,FOLLOW_17_in_synpred14_ifgrammar750); if (state.failed) return ;

        pushFollow(FOLLOW_typeList_in_synpred14_ifgrammar754);
        tL=typeList();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred14_ifgrammar

    // $ANTLR start synpred24_ifgrammar
    public final void synpred24_ifgrammar_fragment() throws RecognitionException {
        Term t =null;

        LinkedList<Term> tL =null;


        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:430:4: (t= term ',' tL= termList )
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:430:4: t= term ',' tL= termList
        {
        pushFollow(FOLLOW_term_in_synpred24_ifgrammar1014);
        t=term();

        state._fsp--;
        if (state.failed) return ;

        match(input,17,FOLLOW_17_in_synpred24_ifgrammar1016); if (state.failed) return ;

        pushFollow(FOLLOW_termList_in_synpred24_ifgrammar1020);
        tL=termList();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred24_ifgrammar

    // $ANTLR start synpred53_ifgrammar
    public final void synpred53_ifgrammar_fragment() throws RecognitionException {
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:733:4: ( '/\\\\' ltl_Formula )
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:733:4: '/\\\\' ltl_Formula
        {
        match(input,20,FOLLOW_20_in_synpred53_ifgrammar1575); if (state.failed) return ;

        pushFollow(FOLLOW_ltl_Formula_in_synpred53_ifgrammar1577);
        ltl_Formula();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred53_ifgrammar

    // $ANTLR start synpred54_ifgrammar
    public final void synpred54_ifgrammar_fragment() throws RecognitionException {
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:734:5: ( '\\\\/' ltl_Formula )
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:734:5: '\\\\/' ltl_Formula
        {
        match(input,30,FOLLOW_30_in_synpred54_ifgrammar1584); if (state.failed) return ;

        pushFollow(FOLLOW_ltl_Formula_in_synpred54_ifgrammar1586);
        ltl_Formula();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred54_ifgrammar

    // $ANTLR start synpred55_ifgrammar
    public final void synpred55_ifgrammar_fragment() throws RecognitionException {
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:735:5: ( '=>' ltl_Formula )
        // /home/sparika/workspace/Timbuk 3/IF2Timbuk/src/antlr/ifgrammar.g:735:5: '=>' ltl_Formula
        {
        match(input,25,FOLLOW_25_in_synpred55_ifgrammar1593); if (state.failed) return ;

        pushFollow(FOLLOW_ltl_Formula_in_synpred55_ifgrammar1595);
        ltl_Formula();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred55_ifgrammar

    // Delegated rules

    public final boolean synpred53_ifgrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_ifgrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_ifgrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_ifgrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_ifgrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_ifgrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_ifgrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_ifgrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_ifgrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_ifgrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_ifgrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_ifgrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_ifgrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_ifgrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_typeSymbolsSection_in_prelude202 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_signatureSection_in_prelude207 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_typesSection_in_prelude212 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_equationSection_in_prelude217 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_intruderSection_in_prelude222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_prelude232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signatureSection_in_if_File259 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_typesSection_in_if_File264 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_initsSection_in_if_File269 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rulesSection_in_if_File274 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_propertiesSection_in_if_File279 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_attackStatesSection_in_if_File284 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_if_File294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeSymbolsSection_in_tim_prelude319 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_primitiveTypesSection_in_tim_prelude323 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_signatureSection_in_tim_prelude327 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_typesSection_in_tim_prelude331 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_equationSection_in_tim_prelude336 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_intruderSection_in_tim_prelude341 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_checkSection_in_tim_prelude346 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_verifSection_in_tim_prelude350 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_failSection_in_tim_prelude354 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_approxSection_in_tim_prelude358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_tim_prelude362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_typeSymbolsSection380 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_constantList_in_typeSymbolsSection382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_primitiveTypesSection396 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_primitiveList_in_primitiveTypesSection398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Const_ident_in_primitiveList412 = new BitSet(new long[]{0x0000000000020042L});
    public static final BitSet FOLLOW_17_in_primitiveList417 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_Const_ident_in_constantList436 = new BitSet(new long[]{0x0000000400020042L});
    public static final BitSet FOLLOW_17_in_constantList439 = new BitSet(new long[]{0x0000000400000042L});
    public static final BitSet FOLLOW_34_in_constantList448 = new BitSet(new long[]{0x0000000400020042L});
    public static final BitSet FOLLOW_17_in_constantList451 = new BitSet(new long[]{0x0000000400000042L});
    public static final BitSet FOLLOW_50_in_signatureSection471 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_signatureSection0_in_signatureSection473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_superTypeDeclaration_in_signatureSection0496 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_functionDeclaration_in_signatureSection0509 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_predicateDeclaration_in_signatureSection0519 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_if_Type_in_superTypeDeclaration539 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_superTypeDeclaration541 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_if_Type_in_superTypeDeclaration545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_Operator_in_functionDeclaration561 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionDeclaration563 = new BitSet(new long[]{0x0100000400000040L});
    public static final BitSet FOLLOW_typeStar_in_functionDeclaration567 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_functionDeclaration569 = new BitSet(new long[]{0x0100000400000040L});
    public static final BitSet FOLLOW_type_in_functionDeclaration573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_Operator_in_predicateDeclaration589 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_predicateDeclaration591 = new BitSet(new long[]{0x0100000400000040L});
    public static final BitSet FOLLOW_typeStar_in_predicateDeclaration595 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_predicateDeclaration597 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicateDeclaration599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Const_ident_in_if_Operator618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Const_ident_in_if_Type636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_Type_in_type659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_Operator_in_type670 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_type672 = new BitSet(new long[]{0x0100000400000040L});
    public static final BitSet FOLLOW_typeList_in_type676 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_type678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_type687 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_constantNatList_in_type688 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_type689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_type694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeStar712 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_typeStar714 = new BitSet(new long[]{0x0100000400000040L});
    public static final BitSet FOLLOW_typeStar_in_typeStar718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeStar726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeList748 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_typeList750 = new BitSet(new long[]{0x0100000400000040L});
    public static final BitSet FOLLOW_typeList_in_typeList754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeList762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constantNatList777 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_constantNatList786 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_constantNatList788 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_52_in_typesSection809 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_typeDeclaration_in_typesSection811 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_atomicTermList_in_typeDeclaration826 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_typeDeclaration828 = new BitSet(new long[]{0x0100000400000040L});
    public static final BitSet FOLLOW_type_in_typeDeclaration832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicTerm_in_atomicTermList849 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_atomicTermList851 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_atomicTermList_in_atomicTermList855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicTerm_in_atomicTermList863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Const_ident_in_atomicTerm880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Nat_ident_in_atomicTerm888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Var_ident_in_atomicTerm896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_equationSection912 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_equation_in_equationSection915 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_term_in_equation938 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_equation940 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_term_in_equation944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicTerm_in_term961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_composedTerm_in_term969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_Operator_in_composedTerm989 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_composedTerm991 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_termList_in_composedTerm994 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_composedTerm995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_termList1014 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_termList1016 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_termList_in_termList1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_termList1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_initsSection1046 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_initsSection1049 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Const_ident_in_initsSection1051 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_initsSection1053 = new BitSet(new long[]{0x0040000000080240L});
    public static final BitSet FOLLOW_state_in_initsSection1055 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_19_in_state1085 = new BitSet(new long[]{0x0040000000000240L});
    public static final BitSet FOLLOW_fact_in_state1090 = new BitSet(new long[]{0x0040000000080242L});
    public static final BitSet FOLLOW_if_Fact_in_fact1111 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_fact1113 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_termList_in_fact1115 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_fact1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_if_Fact1136 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Const_ident_in_if_Fact1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Const_ident_in_if_Fact1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Var_ident_in_if_Fact1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rulesSection1165 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleDeclarationULHS_in_rulesSection1167 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleDeclarationU1180 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Const_ident_in_ruleDeclarationU1182 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDeclarationU1184 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_variableList_in_ruleDeclarationU1186 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDeclarationU1189 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleDeclarationU1191 = new BitSet(new long[]{0x0040000006080240L});
    public static final BitSet FOLLOW_cState_in_ruleDeclarationU1195 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_existsVar_in_ruleDeclarationU1198 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleDeclarationU1201 = new BitSet(new long[]{0x0040000000080240L});
    public static final BitSet FOLLOW_state_in_ruleDeclarationU1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleDeclarationULHS1218 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Const_ident_in_ruleDeclarationULHS1220 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDeclarationULHS1222 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_variableList_in_ruleDeclarationULHS1224 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDeclarationULHS1227 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleDeclarationULHS1229 = new BitSet(new long[]{0x0040000006080240L});
    public static final BitSet FOLLOW_cState_in_ruleDeclarationULHS1233 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_existsVar_in_ruleDeclarationULHS1236 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleDeclarationULHS1239 = new BitSet(new long[]{0x0040000000080240L});
    public static final BitSet FOLLOW_state_in_ruleDeclarationULHS1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleDeclarationR1255 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Const_ident_in_ruleDeclarationR1257 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDeclarationR1259 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_variableList_in_ruleDeclarationR1261 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDeclarationR1264 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleDeclarationR1266 = new BitSet(new long[]{0x0040000006080240L});
    public static final BitSet FOLLOW_cState_in_ruleDeclarationR1270 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_existsVar_in_ruleDeclarationR1273 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleDeclarationR1276 = new BitSet(new long[]{0x0040000000080240L});
    public static final BitSet FOLLOW_state_in_ruleDeclarationR1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_state_in_cState1297 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_conditionList_in_cState1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_conditionList1313 = new BitSet(new long[]{0x0000005200000000L});
    public static final BitSet FOLLOW_condition_in_conditionList1315 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_positiveCondition_in_condition1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negativeCondition_in_condition1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_positiveCondition1342 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_positiveCondition1344 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_term_in_positiveCondition1346 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_positiveCondition1348 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_term_in_positiveCondition1350 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_positiveCondition1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_positiveCondition1357 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_positiveCondition1359 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_term_in_positiveCondition1361 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_positiveCondition1363 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_term_in_positiveCondition1365 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_positiveCondition1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_negativeCondition1377 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_negativeCondition1379 = new BitSet(new long[]{0x0000005200000000L});
    public static final BitSet FOLLOW_condition_in_negativeCondition1381 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_negativeCondition1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_negativeCondition1388 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_negativeCondition1390 = new BitSet(new long[]{0x0040000000000240L});
    public static final BitSet FOLLOW_fact_in_negativeCondition1392 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_negativeCondition1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_existsVar1408 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_variableList_in_existsVar1410 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_existsVar1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Var_ident_in_variableList1431 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_variableList1440 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Var_ident_in_variableList1444 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_48_in_propertiesSection1461 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_propertiesSection1463 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_propertyDeclaration1475 = new BitSet(new long[]{0x0000002000000950L});
    public static final BitSet FOLLOW_propertyID_in_propertyDeclaration1477 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_propertyDeclaration1479 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_variableList_in_propertyDeclaration1481 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_propertyDeclaration1483 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_propertyDeclaration1485 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_propertyDeclaration1489 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_propertyDeclaration1491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attackStateID_in_propertyID1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_propertyID1507 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Nat_ident_in_propertyID1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ltl_Predicate_in_ltl_Formula1522 = new BitSet(new long[]{0x0000000042100002L});
    public static final BitSet FOLLOW_23_in_ltl_Formula1529 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_ltl_Formula1531 = new BitSet(new long[]{0x0000000042100002L});
    public static final BitSet FOLLOW_14_in_ltl_Formula1538 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_ltl_Formula1540 = new BitSet(new long[]{0x0000000042100002L});
    public static final BitSet FOLLOW_28_in_ltl_Formula1547 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_ltl_Formula1549 = new BitSet(new long[]{0x0000000042100002L});
    public static final BitSet FOLLOW_58_in_ltl_Formula1556 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_ltl_Formula1558 = new BitSet(new long[]{0x0000000042100002L});
    public static final BitSet FOLLOW_13_in_ltl_Formula1565 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_ltl_Formula1567 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ltl_Formula1569 = new BitSet(new long[]{0x0000000042100002L});
    public static final BitSet FOLLOW_20_in_ltl_Formula1575 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_ltl_Formula1577 = new BitSet(new long[]{0x0000000042100002L});
    public static final BitSet FOLLOW_30_in_ltl_Formula1584 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_ltl_Formula1586 = new BitSet(new long[]{0x0000000042100002L});
    public static final BitSet FOLLOW_25_in_ltl_Formula1593 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_ltl_Formula1595 = new BitSet(new long[]{0x0000000042100002L});
    public static final BitSet FOLLOW_fact_in_ltl_Predicate1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positiveCondition_in_ltl_Predicate1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_attackStatesSection1624 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_attackStateDeclaration_in_attackStatesSection1626 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_attackStateDeclaration1643 = new BitSet(new long[]{0x0000000000000950L});
    public static final BitSet FOLLOW_attackStateID_in_attackStateDeclaration1645 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_attackStateDeclaration1647 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_variableList_in_attackStateDeclaration1649 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_attackStateDeclaration1651 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_attackStateDeclaration1653 = new BitSet(new long[]{0x0040000000080240L});
    public static final BitSet FOLLOW_cState_in_attackStateDeclaration1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Secret_in_attackStateID1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Auth_in_attackStateID1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WeakAuth_in_attackStateID1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Const_ident_in_attackStateID1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_intruderSection1704 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleDeclarationULHS_in_intruderSection1706 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_53_in_verifSection1797 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleDeclarationULHS_in_verifSection1799 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_42_in_checkSection1810 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleDeclarationR_in_checkSection1812 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_44_in_failSection1823 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_attackStateDeclaration_in_failSection1825 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_40_in_approxSection1842 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_equation_in_approxSection1845 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred8_ifgrammar509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_synpred13_ifgrammar712 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_synpred13_ifgrammar714 = new BitSet(new long[]{0x0100000400000040L});
    public static final BitSet FOLLOW_typeStar_in_synpred13_ifgrammar718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_synpred14_ifgrammar748 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_synpred14_ifgrammar750 = new BitSet(new long[]{0x0100000400000040L});
    public static final BitSet FOLLOW_typeList_in_synpred14_ifgrammar754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_synpred24_ifgrammar1014 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_synpred24_ifgrammar1016 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_termList_in_synpred24_ifgrammar1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred53_ifgrammar1575 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_synpred53_ifgrammar1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred54_ifgrammar1584 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_synpred54_ifgrammar1586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred55_ifgrammar1593 = new BitSet(new long[]{0x0440001210806240L});
    public static final BitSet FOLLOW_ltl_Formula_in_synpred55_ifgrammar1595 = new BitSet(new long[]{0x0000000000000002L});

}