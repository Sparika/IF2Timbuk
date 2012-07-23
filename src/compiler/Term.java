package compiler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/**
 * 
 * @author Kevin CORRE
 *
 * Class Term
 * This class represent a term. A term is made of a symbol o at position 0 and n sons of type Term where n=arity(o).
 */
public class Term {
	protected Symbole o;
	protected LinkedList<Term> sons;
	protected String cond="";
	/**
	 * Constructor
	 * @param o the Symbole a position 0
	 * @param sons a list of Term for position 1, 2, 3, ...
	 */
	public Term(Symbole o, LinkedList<Term> sons){
		this.o = o;
		this.sons = sons;
	}
	
	/**************************************
	 * 			GETTERS & SETTERS
	 **************************************/
	public Symbole getO() {
		return o;
	}
	public void setO(Symbole o) {
		this.o = o;
	}
	public LinkedList<Term> getSons() {
		return sons;
	}
	public void setSons(LinkedList<Term> sons) {
		this.sons = sons;
	}
	
	/***************************************
	 * 				PRINT
	 ***************************************/
	/**
	 * @return a String representation of a Term
	 */
	public String print(){
		String s ="";
		if(sons != null){
			try{
				for(Term t:sons){
					s=s+t.print()+",";
				}
			}catch(NullPointerException e){
				s=s+"union(null),";
				//e.printStackTrace();
			}
			try{
			s=s.substring(0, s.length()-1);
			}catch(Exception e){}
		}
		s = o.printType(s);
		return s;
	}
	/**
	 * Call print()
	 */
	public String toString(){return print();}
	
	/**************************************
	 * 				NONCE
	 **************************************/
	
	/**
	 * Returns a Nonce. A Nonce is a Term made of all primitive variable or constant present 
	 * in the "state" sub-term of this term.
	 * This function is triggered by a rule of the form "L =[exists N]=> R" where L and R are
	 *  terms and N is a fresh variable. A fresh variable is present in the right-hand side 
	 *  of the rewriting rule but not in the left.
	 *  
	 *  TODO This function can't handle several Nonce generated at once
	 * 
	 * @param nonFreshVar a list of non fresh variable
	 * @param u the union symbol used for a nonce construction
	 * @param n the Term used to close the union
	 * @return		a Term containing a concatenation of several primitive symbol.
	 */
	public static Term generateNonce(LinkedList<Var> nonFreshVar, Symbole u, Term n){
		LinkedList<Term> unionTerm = new LinkedList<Term>();
		for(Var v:nonFreshVar){
			if(v.isPrimitive())
				unionTerm.add(new Nonce(v));
		}
		Term t = Term.union(unionTerm,u,n);
		return t;
	}
	/**
	 * For each Term of state call replaceNonce(freshNonce, freshVar)
	 * @param state
	 * @param freshNonce a freshNonce
	 * @param freshVar a List of Var to be replaced by a nonce
	 * @return
	 */
	public static LinkedList<Term> replaceNonce(LinkedList<Term> state, Term freshNonce, LinkedList<Var> freshVar){
		for(Term t:state){
			t.replaceNonce(freshNonce, freshVar);
		}
		return state;
	}
	/**
	 * Replace each freshVar in a Term by freshNonce
	 * @param freshNonce a freshNonce
	 * @param freshVar a List of Var to be replaced by a nonce
	 */
	private void replaceNonce(Term freshNonce, LinkedList<Var> freshVar) {
		if(freshVar.contains(o)){
			try{
				o = o.getType();
				sons = new LinkedList<Term>();
				sons.add(freshNonce);
			}catch(NullPointerException e){
				System.out.println("nonce : "+freshNonce);
				e.printStackTrace();
			}
		}
		else if(sons != null){
			if(sons.size()>0){
				for(Term t:sons){
					t.replaceNonce(freshNonce, freshVar);
				}
			}
		}
	}
	
	
	
	/***************************************	
	 * 				PAIR 					
	 * *************************************/
	/**
	 * Reorganize each pair in a Term as if:
	 * pair(pair(X,Y),Z) => pair(X,pair(Y,Z))
	 */
	public void correctPair(){
		if(sons != null){
			for(Term t:sons){
				t.correctPair();
			}
			if(isPair()){
				if(getX().isPair()){
					Term x = getX().getX();
					Term y = getX().getY();
					Term z = getY();
					
					LinkedList<Term> lst = new LinkedList<Term>();
					lst.add(y);
					lst.add(z);
					y = new Term(o,lst);
					
					lst = new LinkedList<Term>();
					lst.add(x);
					lst.add(y);
					this.sons = lst;
				}
			}
		}
	}
	public Boolean isPair(){
		return o.isPair();
	}
	public Term getX(){
		return sons.get(0);
	}
	public Term getY(){
		return sons.get(1);
	}
	/**
	 * Modify all pair in a Term to end with a Pair identifier (PID) constructed as "pid(sid,ident,pos)"
	 * @param sid
	 * @param ident 
	 * @param pos
	 * @param compiler
	 */
	public void tagPair(String sid, String ident, String pos, Compiler compiler){
		int s = 0;
		if(sons != null){
			for(Term t:sons){
				t.tagPair(sid, ident, pos+s, compiler);
				s++;
			}
			if(isPair()){
				if(!getY().isPair()){
					LinkedList<Term> lst = new LinkedList<Term>();
					lst.add(getY());
					lst.add(generatePid(sid, ident, pos, compiler));
					Term tag = new Term(o,lst);
					sons.removeLast();
					sons.add(tag);
				}
			}
		}
	}
	/**
	 * Generate a PID of the form pid(sid,ident,pos) or pnulli
	 * @param sid
	 * @param ident
	 * @param pos
	 * @param compiler
	 * @return
	 */
	public Term generatePid(String sid, String ident, String pos, Compiler compiler){
		if(sid.equals("PID")){
			Symbole sym = new Var(sid+pos,compiler.getTypesTable().get("nat"));
			try {
				compiler.addVar((Var)sym);
				compiler.addSymbole((Var)sym);
			} catch (Exception e) {
					//variable already declared
			}
			return new Term(sym,null);
		}else if(sid.equals("nulli")){
			return new Term(compiler.getSymbolesTable().get("pnulli"),null);
		}else{
			Symbole identS = new Cons(ident, compiler.getTypesTable().get("nat"));
			try {
				compiler.addSymbole(identS);
			} catch (Exception e) {
				//variable already declared
			}
			Symbole posS = new Cons("pos"+pos, compiler.getTypesTable().get("nat"));
			try {
				compiler.addSymbole(posS);
			} catch (Exception e) {
				//variable already declared
			}
			LinkedList<Term> lst = new LinkedList<Term>();
			Symbole sidS = compiler.getSymbolesTable().get(sid);
			lst.add(new Term(sidS, null));
			lst.add(new Term(identS, null));
			lst.add(new Term(posS, null));
			Symbole pidS = compiler.getSymbolesTable().get("pid");
			return new Term(pidS,lst);
		}
	}
	
	/************************************
	 * 			CRYPT SCRYPT
	 ************************************/
	/**
	 * Modify all crypt in a Term to end with a crypt identifier (CID) constructed as "cid(sid,ident,pos)"
	 * @param sid
	 * @param ident 
	 * @param pos
	 * @param compiler
	 */
	public void tagCrypt(String sid, String ident, String pos, Compiler compiler){
		int s = 0;
		if(sons != null){
			for(Term t:sons){
				t.tagCrypt(sid, ident, pos+s, compiler);
				s++;
			}
			if(isCrypt()||isScrypt()){
				sons.add(generateCid(sid, ident, pos, compiler));
			}
		}
	}
	/**
	 * 
	 * @return true if symbol at position 0 is a crypt
	 */
	public Boolean isCrypt(){
		return o.isCrypt();
	}
	/**
	 * 
	 * @return true if symbol at position 0 is a scrypt
	 */
	public Boolean isScrypt(){
		return o.isScrypt();
	}
	/**
	 * Generate a PID of the form pid(sid,ident,pos) or cnulli
	 * @param sid
	 * @param ident
	 * @param pos
	 * @param compiler
	 * @return
	 */
	public Term generateCid(String sid, String ident, String pos, Compiler compiler){
		if(sid.equals("CID")){
			Symbole sym = new Var("CID"+pos,compiler.getTypesTable().get("nat"));
			try {
				compiler.addVar((Var)sym);
				compiler.addSymbole((Var)sym);
			} catch (Exception e) {
					//variable already declared
			}
			return new Term(sym,null);
		}else if(sid.equals("nulli")){
			if(isCrypt()){
				return new Term(compiler.getSymbolesTable().get("cnulli"),null);
			}
			else if(isScrypt()){
				return new Term(compiler.getSymbolesTable().get("scnulli"),null);
			}
			else{
				System.err.println("sid.equals(nulli) but is not crypt nor scrypt");
				return new Term(compiler.getSymbolesTable().get("nulli"),null);
			}
			
		}else{
			Symbole identS = new Cons(ident, compiler.getTypesTable().get("nat"));
			try {
				compiler.addSymbole(identS);
			} catch (Exception e) {
				//variable already declared
			}
			Symbole posS = new Cons("pos"+pos, compiler.getTypesTable().get("nat"));
			try {
				compiler.addSymbole(posS);
			} catch (Exception e) {
				//variable already declared
			}
			LinkedList<Term> lst = new LinkedList<Term>();
			Symbole sidS = compiler.getSymbolesTable().get(sid);
			lst.add(new Term(sidS, null));
			lst.add(new Term(identS, null));
			lst.add(new Term(posS, null));
			Symbole pidS = compiler.getSymbolesTable().get("cid");
			return new Term(pidS,lst);
		}
	}
	
	
	/************************************
	 * 				UNION
	 *************************************/
	

	public static Term union(LinkedList<Term> list, Symbole u){
		LinkedList<Term> l2;
		if(list == null){
			return (null);
		}
		Iterator<Term> it = list.iterator();
		if(it.hasNext()){
			l2 = new LinkedList<Term>();
			l2.add(it.next());
			list.remove();
			l2.add(union(list,u));
		}
		else{
			//TODO return terme de marquage de fin de liste
			return(null);
		}
		Term t = new Term(u,l2);
		return(t);
	}

	public static Term union(LinkedList<Term> list, Symbole u, Symbole x){
		LinkedList<Term> l2;
		if(list == null){
			return new Term(x, null);
		}
		Iterator<Term> it = list.iterator();
		if(it.hasNext()){
			l2 = new LinkedList<Term>();
			l2.add(it.next());
			list.remove();
			l2.add(union(list,u,x));
		}
		else{
			//TODO return terme de marquage de fin de liste
			return new Term(x, null);
		}
		Term t = new Term(u,l2);
		return(t);
	}

	public static Term union(LinkedList<Term> list, Symbole u, Term tend){
		LinkedList<Term> l2;
		if(list == null){
			return tend;
		}
		Iterator<Term> it = list.iterator();
		if(it.hasNext()){
			l2 = new LinkedList<Term>();
			l2.add(it.next());
			list.remove();
			l2.add(union(list,u,tend));
		}
		else{
			//TODO return terme de marquage de fin de liste
			return tend;
		}
		Term t = new Term(u,l2);
		return(t);
	}

	public static Term union(Term t, Symbole u, Symbole x){
		LinkedList<Term> lst = new LinkedList<Term>();
		lst.add(t);
		lst.add(new Term(x, new LinkedList<Term>()));
		return new Term(u,lst);
	}
	
	public static LinkedList<Term> extractVarAgent(LinkedList<Term> list){
		LinkedList<Term> endList = new LinkedList<Term>();
		Iterator<Term> it = list.iterator();
		while(it.hasNext()){
			Term next = it.next();
			if(next.getO().getType().getId().equals("agent")&&next.getO().getClass().equals(Var.class))
				endList.add(next);
		}
		return endList;
	}

	/******************************************
	 * 				LINEAR
	 ******************************************/
	public Term toLinear(Compiler compiler, String ident){
		IntermediateTerm it = new IntermediateTerm(ident, compiler.getTypesTable().get("fact"), compiler);
		this.toLinear(it);
		Boolean closeResult;
		switch(compiler.getLinearTRS()){
		case 1: cond = it.close1();
			closeResult = false;
			break;
		case 2: closeResult = it.close2();
			break;
		default: closeResult = it.close();
		}
		if(closeResult){
			//new Rule l -> it1
			Term it1 = it.getIt1();
			LinkedList<Term> lst = new LinkedList<Term>();
			lst.add(it1);
			lst.add(this);
			it1 = new Term(compiler.getSymbolesTable().get("u"),lst);
			Rule r = new Rule(ident+"_1",this,it1);
			try {
				compiler.addRule(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Term it2 = union(it.getIt2(), compiler.getSymbolesTable().get("u"), compiler.getSymbolesTable().get("U"));
			return it2;
		}
		else{
			//rule is only l -> r thus return l=this
			return this;
		}
	}

	public void toLinear(IntermediateTerm it){
		if(o.getClass().equals(Var.class))
			o = it.addV((Var)o);
		if(sons!=null)
			for(Term t:sons)
				t.toLinear(it);
	}

	public void setCond(String cond){
		this.cond = cond;
	}
	public String getCond() {
		return cond;
	}
}