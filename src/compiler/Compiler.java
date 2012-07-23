package compiler;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

public class Compiler {
	private static int linearTRS;
	private Hashtable<String,Var> varsTable;
	private Hashtable<String,Symbole> symbolesTable;
	private Hashtable<String,Type> typesTable;
	private LinkedList<Rule> rulesTable;
	private Automata automata;
	private Hashtable<String,Pattern> patternsTable;
	
	private String superType;
	private String superTypeEq;
	
	private LinkedList<Term> init;
	private int flag=0;
	
	private Hashtable<String,Equation> equTable;
	private Boolean checkFalse;
	
	public Compiler(){
		checkFalse = false;
		varsTable = new Hashtable<String, Var>();
		symbolesTable = new Hashtable<String, Symbole>();
		typesTable = new Hashtable<String, Type>();
		rulesTable = new LinkedList<Rule>();
		patternsTable = new Hashtable<String, Pattern>();
		equTable = new Hashtable<String, Equation>();
		
		linearTRS = 0;
		
		automata = new Automata();
		
		superType = "%super type declaration\n";
		superTypeEq = "%super type equation\n";
	}
	
	public void addSymbole(Symbole sym) throws Exception{
		if (symbolesTable.containsKey(sym.getId())){
			if(flag>0)
				throw new Exception("symbole already declared: "+sym.getId());
		}
		else
			symbolesTable.put(sym.getId(), sym);
	}
	
	public void addVar(Var var) throws Exception{
		if (varsTable.containsKey(var.getId())){
			if(flag>0)
			throw new Exception("var already declared: "+var.getId());
		}
		else
			varsTable.put(var.getId(), var);
	}
	
	public void addType(Type type) throws Exception{
		if (typesTable.containsKey(type.getId())){
			if(flag>0)
			throw new Exception("type already declared: "+type.getId());
		}
		else
			typesTable.put(type.getId(), type);
	}
	
	public void addRule(Rule rule) throws Exception{
		rulesTable.add(rule);
	}
	
	public void addPattern(Pattern pattern) throws Exception{
		if (patternsTable.containsKey(pattern.getId())){
			if(flag>0)
			throw new Exception("pattern already declared: "+pattern.getId());
		}
		else
			patternsTable.put(pattern.getId(), pattern);
	}
	
	public void addEquation(Equation equation) throws Exception {
		if (equTable.containsKey(equation.getId())){
			if(flag>0)
			throw new Exception("equation already declared: "+equation.getId());
		}
		else
			equTable.put(equation.getId(), equation);
	}
	
	public void addTransition(Term t){
		automata.addTerm(t);
	}

	/**********************************************************
	 * 					GETTERS AND SETTERS
	 **********************************************************/

	public Hashtable<String, Var> getVarsTable() {
		return varsTable;
	}

	public void setVarsTable(Hashtable<String, Var> varsTable) {
		this.varsTable = varsTable;
	}

	public Hashtable<String, Symbole> getSymbolesTable() {
		return symbolesTable;
	}

	public void setSymbolesTable(Hashtable<String, Symbole> symbolesTable) {
		this.symbolesTable = symbolesTable;
	}

	public Hashtable<String, Type> getTypesTable() {
		return typesTable;
	}

	public void setTypesTable(Hashtable<String, Type> typesTable) {
		this.typesTable = typesTable;
	}

	public LinkedList<Rule> getRulesTable() {
		return rulesTable;
	}

	public void setRulesTable(LinkedList<Rule> rulesTable) {
		this.rulesTable = rulesTable;
	}

	public Hashtable<String, Pattern> getPatternsTable() {
		return patternsTable;
	}

	public void setPatternsTable(Hashtable<String, Pattern> patternsTable) {
		this.patternsTable = patternsTable;
	}
	
	public void setInit(LinkedList<Term> list){
		//init=list;
		for(Term t:list){
			t.correctPair();
			t.tagPair("nulli", "", "",this);
			t.tagCrypt("nulli", "", "",this);
			addTransition(t);
		}
	}
	
	public LinkedList<Term> getInit(){
		return init;
	}
	public void setSuperType(String superType) {
		this.superType = superType;
	}

	public String getSuperType() {
		return superType;
	}
	
	public void addSuperType(String superType) {
		this.superType = this.superType+superType;
	}
	
	public void setSuperTypeEq(String superTypeEq) {
		this.superTypeEq = superTypeEq;
	}

	public String getSuperTypeEq() {
		return superTypeEq;
	}
	
	public void addSuperTypeEq(String superTypeEq) {
		this.superTypeEq = this.superTypeEq+superTypeEq;
	}

	public void setEquTable(Hashtable<String,Equation> equTable) {
		this.equTable = equTable;
	}

	public Hashtable<String,Equation> getEquTable() {
		return equTable;
	}
	
	
	public void doOutput(PrintWriter out){
		typesTable.get("message").setVoidType(true);
		typesTable.get("pairT").setVoidType(true);
	//	((Type)symbolesTable.get("message")).setVoidType(b)
		automata.init(this);
		/*Enumeration<Rule> re = rulesTable.element();
		Rule r;
		while(re.hasMoreElements()){
			r = re.nextElement();
			r.toLinear(this);
		}*/
		/* OPS */
		out.println("Ops");
		Hashtable<String, Symbole> hashS = new Hashtable<String, Symbole>();
		hashS.putAll(symbolesTable);
		
		Enumeration<Symbole> e = hashS.elements();
		if(linearTRS==0||linearTRS==2)
			while(e.hasMoreElements()){
				Symbole sym = e.nextElement();
				sym.check(this);
				if(checkFalse)
					sym.checkFalse(this);
			}
		
		e = symbolesTable.elements();
		Symbole s;
		while(e.hasMoreElements()){
			s = e.nextElement();
			if(s.getClass().equals(Cons.class))
				out.print(s.toString()+":"+s.getSize()+" ");
			else if(s.getClass().equals(Ops.class))
				out.print(s.toString()+":"+s.getSize()+" ");
			//else
				//System.out.println(s);
		}
		/* Types */
		Enumeration<Type> te = typesTable.elements();
		Type t;
		while(te.hasMoreElements()){
			t = te.nextElement();
			out.print(t.toString()+":1 ");
		}
		/* VAR */
		out.println("\n\nVars");
		e = symbolesTable.elements();
		while(e.hasMoreElements()){
			s = e.nextElement();
			if(s.getClass()==Var.class)
				out.print(s.toString()+" ");
		}
		/* TRS */
		out.println("\n\nTRS R");
		for(Rule r:rulesTable)
			out.println(r.print());
		out.println(superType.replaceAll("_", ""));
		
		out.println("%check_text\n"+
				"bool(checkeq(text(X),text(Y))) ->\n"+
				"bool(checkeq(X,Y))");
		/* INIT *//*
		System.out.println(init);
		out.println("Set Initial");

		for(Term initA:init){
			initA.correctPair();
			initA.tagPair("nulli", "", "",this);
			initA.tagCrypt("nulli", "", "",this);
		}	
		out.println(Term.union(init, symbolesTable.get("u")).print());*/
		out.println("\n"+automata.print());
		
		/* Patterns */
		out.println("\n\nPatterns");
		Enumeration<Pattern> pe = patternsTable.elements();
		Pattern p;
		while(pe.hasMoreElements()){
			p = pe.nextElement();
			out.println(p.print());
		}

		/* Equations */
		out.println("Equations E\nRules\n");
		Enumeration<Equation> peq = equTable.elements();
		Equation eq;
		while(peq.hasMoreElements()){
			eq = peq.nextElement();
			out.println(eq.toString());
		}
		out.println(superTypeEq.replaceAll("_", ""));
		
		out.println(/*"message(crypt(X,Y,CID)) = crypt(X,Y,CID) \n"+
		"message(scrypt(X,Y,CID)) = scrypt(X,Y,CID) \n"+
		//"fact(iknows(X)) = iknows(X) \n"+
		//"fact(X) = fact(Y) \n"+
		"message(u(X,Y)) = u(X,Y) \n"+
		"nat(pid(X,Y,Z)) = pid(X,Y,Z) \n"+
		"pairT(pair(X,Y)) = pair(X,Y) \n"+
		"union(u(X,Y)) = u(X,Y) \n"+
		"u(X,Y) = Y \n"+*/
		"state(checki(Z)) = Z\n"+
		"checkeq(X,Y) = checkeq(Y,X)\n"+
		"[u(X,Y)] => [X=timNetwork Y=timNetwork]\n"
		);/*
		e = hashS.elements();
		while(e.hasMoreElements()){
			Symbole sym = e.nextElement();
			if(sym.getType().getClass().equals(Fact.class)&&sym.getClass().equals(Ops.class)){
				out.println(sym.printVariable(this)+" = timNetwork");
			}
		}*/
		out.close();
	}

	public void setLinearTRS(int i) {
		linearTRS = i;
	}
	public int getLinearTRS(){
		return linearTRS;
	}

	public void setCheckFalse(boolean b) {
		checkFalse = b;
		
	}
}
