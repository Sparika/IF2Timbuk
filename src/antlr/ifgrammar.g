grammar ifgrammar;


options {
	backtrack=true;
	}

@parser::header {	
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
}

@lexer::header {
	package antlr.output;
}

@members {
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
}

Secret	:	'secrecy_of_'('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Auth	:	'authentication_on_'('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
WeakAuth	:	'weak_authentication_on_'('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Var_ident 
	:	('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;
Const_ident 
	:	('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;
Nat_ident 
	:	('0'..'9')+
	;

prelude
	: 	{System.out.print("prelude if");}
		typeSymbolsSection
	 	signatureSection
	 	typesSection
	 	equationSection
	 	intruderSection 
     		EOF
     		{System.out.println(" : done");}
	;
	

if_File
	: 	{System.out.print("if file");}
		signatureSection
	 	typesSection
	 	initsSection
	 	rulesSection
	 	propertiesSection
	 	attackStatesSection 
     		EOF
     		{System.out.println(" : done");}
	;
	
tim_prelude
	:	{System.out.print("prelude timbuk");}
		typeSymbolsSection
		primitiveTypesSection
		signatureSection
		typesSection
	 	equationSection
	 	intruderSection 
		checkSection
		verifSection
		failSection
		approxSection
		EOF
		{System.out.println(" : done");}
	;

	
typeSymbolsSection
	: 	'section typeSymbols:' constantList
	; 
	
primitiveTypesSection
	: 	'section primitiveTypes:' primitiveList
	; 
	
primitiveList
	: (Const_ident
	{
		compiler.getTypesTable().get($Const_ident.text).setPrimitive(true);
	}(',')?)*
	;
	
constantList
	: (ci=Const_ident (',')?
	{
	try{
		Type t;
		if($ci.text.equals("union"))
			t = new Union("union");	
		else
			t = new Type($ci.text);
		compiler.addType(t);
		compiler.addSymbole(t);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	|'fact' (',')?
	{
	try{
		Type t = new Fact("fact");	
		compiler.addType(t);
		compiler.addSymbole(t);
	} catch (Exception e) {
		e.printStackTrace();
	}
	})*
	;
	
signatureSection
	: 	'section signature:' signatureSection0
	{
		compiler.addSuperType($signatureSection0.superType);
		compiler.addSuperTypeEq($signatureSection0.superTypeEq);
	}
	;
	
signatureSection0 returns [String superType="", String superTypeEq=""]
	: 	(st=superTypeDeclaration
	{
	 		$superType+=$st.text;
	 		$superTypeEq+=$st.eq;
	 }
	 )*
	 	functionDeclaration*
	 	
	 	predicateDeclaration*
	;
	
superTypeDeclaration returns [String text, String eq]
	:	 l=if_Type '>' r=if_Type
	{
		$text=$r.text+"(X) -> "+$l.text+"(X)\n\n";
		$eq=$r.text+"(X) = "+$l.text+"(X)\n\n";
	}
	;
functionDeclaration
	: 	op=if_Operator ':' sig=typeStar '->' t=type
	{
		Ops ops = new Ops($op.text,$t.t,$sig.list);
		try{
			compiler.addSymbole(ops);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	;
predicateDeclaration
	: 	op=if_Operator ':' sig=typeStar '->' 'fact'
	{
		Type fact = compiler.getTypesTable().get("fact");
		Ops ops = new Ops(op,fact,sig);
		try{
			compiler.addSymbole(ops);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	;
	
if_Operator returns[String text]
	: 	Const_ident//Identifier
	{
		$text = $Const_ident.text;
	}
	;
if_Type  returns[String text]
	: 	Const_ident//Identifier
	{
		$text = $Const_ident.text;
	}
	;
	
	
type returns[Type t]
	: 	ift=if_Type
	{
		$t = compiler.getTypesTable().get($ift.text);
	}
	| 	op=if_Operator '(' tL=typeList ')'
	{
		//A ameliorer
		$t = new TypeCompound(op,tL);
		//$t = tC;
	}
	| 	'{'constantNatList'}'
	|	'fact'
	{
		$t = compiler.getTypesTable().get("fact");
	}
	;
typeStar returns [LinkedList<Type> list]
	: 	type '*' tS=typeStar
	{
		$list = $tS.list;
		$list.addFirst($type.t);
	}
	|	type
	{
		$list = new LinkedList<Type>();
		$list.add($type.t);
	}
	;
	
	
typeList returns [LinkedList<Type> list]
	: 	type ',' tL=typeList
	{
		Type t = compiler.getTypesTable().get($type.text);
		$list = $tL.list;
		$list.addFirst(t);
	}
	|	type
	{
		Type t = compiler.getTypesTable().get($type.text);
		$list = new LinkedList<Type>();
		$list.add(t);
	}
	;
	
constantNatList
	:	(Const_ident | Nat_ident) (',' (Const_ident | Nat_ident))*
	;
	
typesSection
	: 	'section types:' typeDeclaration*
	;
	
typeDeclaration
	: atL=atomicTermList ':' t=type
	{
		LinkedList<String> lst =$atL.list;
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
	;
atomicTermList returns [LinkedList<String> list]
	: atomicTerm ',' atL=atomicTermList
	{
		$list = $atL.list;
		$list.addFirst($atomicTerm.s);	
	}
	| atomicTerm
	{
		$list = new LinkedList<String>();
		$list.add($atomicTerm.s);	
	}
	;
atomicTerm returns [String s]
	: Const_ident
	{
		$s=$Const_ident.text;
	}
	| Nat_ident
	{
		$s="nat"+$Nat_ident.text;
	}
	| Var_ident
	{
		$s=$Var_ident.text;
	}
	;
	
equationSection
	: 	'section equations:' (equation
	{
		String id = String.valueOf(nbRule);
		try {
			compiler.addRule(new Rule(id+"lr", $equation.left, $equation.right));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compiler.addRule(new Rule(id+"rl", $equation.right, $equation.left));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nbRule++;
	})*
	;
	
equation returns [Term left, Term right]
	: l=term '=' r=term
	{
		$left = l;
		$right = r;
	}
	;
term returns [Term t]
	: atomicTerm
	{
		Symbole sym = compiler.getSymbolesTable().get($atomicTerm.s);
		$t = new Term(sym, null);
	}
	| composedTerm
	{
		$t=$composedTerm.t;
	}
	;

composedTerm returns [Term t]
	: op=if_Operator '('tL=termList')'
	{
		Symbole sym = compiler.getSymbolesTable().get(op);
		$t = new Term(sym, $tL.list);
	}
	;
termList returns [LinkedList<Term> list]
	: t=term ',' tL=termList
	{
		$tL.list.addFirst($t.t);
		$list = $tL.list;
	}
	| t=term
	{
		$list = new LinkedList<Term>();
		$list.add($t.t); 
	}
	;
	
initsSection 
	:	'section inits:' ('initial_state' Const_ident ':=' state
	{
		compiler.setInit($state.list);
	})+
	;
	
state returns[LinkedList<Term> list, Vector<Cont> vecC, Vector<Secr> vecS, Term sid]	
	: 	
	{
		$list = new LinkedList<Term>();
		$vecC= new Vector<Cont>();
		$vecS = new Vector<Secr>();
		$sid = new Term(compiler.getSymbolesTable().get("nulli"),null);
	}
	(	('.')?f1=fact
	{
		if($f1.f.getO().equals(compiler.getSymbolesTable().get("contains"))){
			$vecC.add(new Cont($f1.f));
			$list.add($f1.f);
		} else if ($f1.f.getO().equals(compiler.getSymbolesTable().get("secret"))){
			$vecS.add(new Secr($f1.f));
		} else {
			$list.add($f1.f);
		}
		
		if($f1.isState){
			$sid = $f1.sid;
		}
	}
	)+
	;
fact returns [Term f, Term sid, Boolean isState]
	:	if_Fact('(' termList ')')?
	{
		Symbole o = compiler.getSymbolesTable().get($if_Fact.text);
		$f = new Term(o,$termList.list);
		$isState = $if_Fact.isState;
		if($isState){
			$sid = $f.getSons().getLast();
		}
	}
	;
if_Fact returns [Boolean isState=false]
	: 'state_'Const_ident
	{ $isState=true;
	System.out.println("top");}
	| Const_ident
	{ 
		if($Const_ident.text.startsWith("state_"))
			$isState=true;
	}
	| Var_ident
	;
	
rulesSection
	:	'section rules:' ruleDeclarationULHS*
	;
	
ruleDeclarationU
	:	'step' Const_ident '(' variableList? ')' ':='
		cState? existsVar? '=>' state
	{
		LinkedList<Term> list = $state.list;
		Vector<Secr> vecS = $state.vecS;
		Term freshNonce;
		for(int i = 0; i < vecS.size(); i++){
			list.add(vecS.get(i).toTerm($state.vecC));
		}
		if($existsVar.list != null){
			LinkedList<Var> nonFreshVar = $variableList.list;
			nonFreshVar.removeAll($existsVar.list);
			
			freshNonce = Term.generateNonce(nonFreshVar, compiler.getSymbolesTable().get("n"), new Term(compiler.getSymbolesTable().get("nulli"),null));
			list = Term.replaceNonce(list,freshNonce,$existsVar.list);
		}

		Term l;
		try{
			if($cState.list.size()==1)
				l = $cState.list.getFirst();
			else
				l = Term.union($cState.list,compiler.getSymbolesTable().get("u"), compiler.getSymbolesTable().get("null"));
		}catch(Exception e){
			l=null;
		}
		Term r;
			if(list.size() == 1)
				r = list.getFirst();
			else
				r = Term.union(list,compiler.getSymbolesTable().get("u"), compiler.getSymbolesTable().get("null"));
		//Rule rule = new Rule($Const_ident.text, l, r, $existsVar.list, nonFreshVar, compiler.getSymbolesTable().get("u"));
		l.correctPair();
		r.correctPair();
		Rule rule = new Rule($Const_ident.text, l, r);
		//rule.toLinear(compiler);
		try{
			compiler.addRule(rule);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	;
	
ruleDeclarationULHS
	:	'step' Const_ident '(' variableList? ')' ':='
		cState? existsVar? '=>' state
	{
		LinkedList<Term> listR = $state.list;
		LinkedList<Term> listL = (LinkedList<Term>)$cState.list.clone();
		Vector<Secr> vecS = $state.vecS;
		Term freshNonce;
		Term sid;
		if($cState.sid==null)
			sid = new Term(compiler.getSymbolesTable().get("nulli"),null);
		else
			sid = $cState.sid;
		for(int i = 0; i < vecS.size(); i++){
			listR.add(vecS.get(i).toTerm($state.vecC));
		}
		if($existsVar.list != null){
			LinkedList<Var> nonFreshVar = $variableList.list;
			nonFreshVar.removeAll($existsVar.list);
			
			freshNonce = Term.generateNonce(nonFreshVar, compiler.getSymbolesTable().get("n"), sid);
			listR = Term.replaceNonce(listR,freshNonce,$existsVar.list);
		}
		
		Term l;
		try{
				l = Term.union($cState.list,compiler.getSymbolesTable().get("u"),(Var)compiler.getSymbolesTable().get("U"));
		}catch(Exception e){
			l=null;
		}
		l.correctPair();
		l.tagPair("PID", $Const_ident.text, "",compiler);
		l.tagCrypt("CID", $Const_ident.text, "",compiler);
		 
		
		
		Iterator<Term> it = listR.iterator();
		while(it.hasNext()){
			Term t = it.next();
			t.correctPair();
			t.tagPair(sid.getO().toString(),$Const_ident.text,"",compiler);
		}
		for(Term t:listR){
			t.tagCrypt(sid.getO().toString(), $Const_ident.text, "",compiler);
		}
		/*try{
			listR.addAll(listL);
		}catch(NullPointerException e){}	*/
		
		l = l.toLinear(compiler,$Const_ident.text);
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
		Rule rule = new Rule($Const_ident.text+"_2", l, r);
		try{
			compiler.addRule(rule);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	;

ruleDeclarationR
	:	'step' Const_ident '(' variableList? ')' ':='
		cState? existsVar? '=>' state
	{
		LinkedList<Term> listR = $state.list;
		LinkedList<Term> listL = (LinkedList<Term>)$cState.list.clone();
		Vector<Secr> vecS = $state.vecS;
		Term freshNonce;
		Term sid;
		if($cState.sid==null)
			sid = new Term(compiler.getSymbolesTable().get("nulli"),null);
		else
			sid = $cState.sid;
		for(int i = 0; i < vecS.size(); i++){
			listR.add(vecS.get(i).toTerm($state.vecC));
		}
		if($existsVar.list != null){
			LinkedList<Var> nonFreshVar = $variableList.list;
			nonFreshVar.removeAll($existsVar.list);
			
			freshNonce = Term.generateNonce(nonFreshVar, compiler.getSymbolesTable().get("n"), sid);
			listR = Term.replaceNonce(listR,freshNonce,$existsVar.list);
		}
		
		Term l = listL.get(0);
		l.correctPair();
		l.tagPair(compiler.getSymbolesTable().get("PID").toString(), $Const_ident.text, "",compiler);
		l.tagCrypt(compiler.getSymbolesTable().get("CID").toString(), $Const_ident.text, "",compiler);

		Term r = listR.get(0);
		r.correctPair();
		r.tagPair(sid.getO().toString(),$Const_ident.text,"",compiler);
		r.tagCrypt(sid.getO().toString(), $Const_ident.text, "",compiler);

		Rule rule = new Rule($Const_ident.text, l, r);
		//rule.toLinear(compiler);
		try{
			compiler.addRule(rule);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	;

cState returns [LinkedList<Term> list, Vector<Secr> vecS, Term sid]	
	:	state conditionList
	{
		$list = $state.list;
		$vecS = $state.vecS;
		for(int i=0; i < $vecS.size(); i++){
			$list.add($vecS.get(i).toTerm());
		}
		$sid = $state.sid;
	}
	;
conditionList
	:	('&' condition)*
	;
condition
	:	positiveCondition
	|	negativeCondition
	;
positiveCondition
	:	'equal' '(' term ',' term ')'
	|	'leq' '(' term ',' term ')'
	;
negativeCondition
	:	'not' '(' condition ')'
	|	'not' '(' fact ')'
	;
existsVar returns [LinkedList<Var> list]
	:	'=[exists' variableList ']'
	{
		$list = $variableList.list;
	}
	;
variableList returns [LinkedList<Var> list]
	:	vi1=Var_ident 
	{
		$list = new LinkedList<Var>();
		Var v = (Var)compiler.getSymbolesTable().get($vi1.text);
		$list.add(v);
	}
		(',' vi2=Var_ident
	{
		Var v = (Var)compiler.getSymbolesTable().get($vi2.text);
		$list.add(v);	
	})*
	;
	
propertiesSection
	:	'section properties:' propertyDeclaration*
	;

propertyDeclaration
	:	'property' propertyID '(' variableList ')' ':='
		'[]' ltl_Formula
	;
propertyID
	:	attackStateID
	| 	'ltl_' Nat_ident
	;
	
ltl_Formula
	:	(ltl_Predicate 
	| 	'<->' ltl_Formula 
	| 	'(-)' ltl_Formula 
	| 	'[-]' ltl_Formula 
	| 	'~' ltl_Formula 
	| 	'(' ltl_Formula ')')
		('/\\' ltl_Formula 
	|	 '\\/' ltl_Formula 
	| 	'=>' ltl_Formula)*
	;
ltl_Predicate
	:	fact
	| 	positiveCondition
	;

attackStatesSection
	:	'section attack_states:' attackStateDeclaration*
	;
	
attackStateDeclaration returns [Vector<Pattern> lstPat]
	:	'attack_state' attackStateID '(' variableList ')' ':=' cState
	{
		$lstPat = new Vector<Pattern>();
		if(!($attackStateID.s == null)){
			LinkedList<Term> list = $cState.list;	
			//for(int i=0; i < $cState.vecS.size(); i++){
			//	list.add(vecS.get(i).toPattern());
			//}
			Term l;
			if(list.size()==1)
				l = list.getFirst();
			else
				l = Term.union(list,compiler.getSymbolesTable().get("u"));
			try{
				$lstPat.add(new Pattern($attackStateID.s, l));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	;
attackStateID returns [String s]
	:	s2=Secret
	{
		$s=$s2.text;
	}
	|	Auth
	|	WeakAuth
	|	Const_ident
	;
	
intruderSection
	: 'section intruder:' ruleDeclarationULHS*
	;
WS	: (' '|'\t'|'\n')+  {$channel=HIDDEN;}
	;
	
Comment	: '%'('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|' '|','|':'|'\t'|'-'|'='|'%'|'/'|'\\'|'.'|'['|']'|'>')*{$channel=HIDDEN;}
	;



verifSection
	:	'section verification:' ruleDeclarationULHS*
	;
checkSection
	:	'section check:' ruleDeclarationR*
	;
failSection
	:	'section fail_states:' attackStateDeclaration*
	{
		Vector<Pattern> vecP = $attackStateDeclaration.lstPat;
		for(int i=0; i<vecP.size(); i++){
			try{
				compiler.addPattern(vecP.get(i));
			}catch(Exception e){}
		}
	}
	;
	
approxSection
	: 	'section approximations:' (equation
	{
		String id = String.valueOf(nbEq);
		try {
			compiler.addEquation(new Equation(id, $equation.left, $equation.right));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nbEq++;
	})*
	;