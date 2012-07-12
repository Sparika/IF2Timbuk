package compiler;

import java.util.Collection;
import java.util.LinkedList;


public class IntermediateTerm {
	Compiler compiler;
	LinkedList<VarEnum> varL;
	Term it, it2;
	
	public IntermediateTerm(String ident, Type type, Compiler compiler){
		//new symbol
		this.compiler = compiler;
		Ops o = new Ops(ident+"lin", type, new LinkedList<Type>());
		try {
			compiler.addSymbole(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		it = new Term(o, new LinkedList<Term>());
		it2 = new Term(o, new LinkedList<Term>());
		varL = new LinkedList<IntermediateTerm.VarEnum>();
	}
	/**
	 * AddV create a Var vDup# where # is the number of times v has been added
	 * @param v the Var to add
	 * @return a new variable
	 */
	public Var addV(Var v){
		if(!v.getType().equals(compiler.getTypesTable().get("union"))){
			for(VarEnum ve:varL){
				if (ve.isV(v)){
					ve.add();
					Var var = new Var(v.getId()+"Dup"+ve.getN(), v.getType());
					try{
						compiler.addVar(var);
						compiler.addSymbole(var);
					}catch(Exception e){e.printStackTrace();}
					Term v1 = new Term(v, new LinkedList<Term>());
					Term v2 = new Term(var, new LinkedList<Term>());
					LinkedList<Term> lst = new LinkedList<Term>();
					lst.add(v1);
					lst.add(v2);
					Term check = new Term(compiler.getSymbolesTable().get("check_eq"),lst);
					// l -> it
					it.getSons().add(check);
					// it2 -> r
					it2.getSons().add(new Term(compiler.getSymbolesTable().get("true"),new LinkedList<Term>()));
					((Ops) it.getO()).getSignature().add(compiler.getTypesTable().get("bool"));
					return var;
				}
			}
			VarEnum ve = new VarEnum(v);
			varL.add(ve);
			return v;
		}
		else
			return v;
	}

	protected class VarEnum{
		Var v;
		int n;
		public VarEnum(Var v){
			this.v = v;
			n = 0;
		}
		
		public int getN(){return n;}
		public Var getV(){return v;}
		
		public Boolean isV(Var v){return this.v.equals(v);}
		public void add(){n++;}
	}

	public Boolean close() {
		//If there were no linearisation added
		if(it.getSons().size()==0){
			compiler.getSymbolesTable().remove(it.getO().getId());
			return false;
		}
		//Else complete construction of the new term
		else{
			for(VarEnum ve:varL){
				Term t = new Term(ve.getV(), new LinkedList<Term>());
				it.getSons().add(t);
				it2.getSons().add(t);
				((Ops) it.getO()).getSignature().add(ve.getV().getType());
			}
			//Add equation o(_,...,_) = lin
			Term leftEq = new Term(it.getO(),new LinkedList<Term>());
			Term leftRu = new Term(it.getO(),new LinkedList<Term>());
			Term underscore = new Term(new Underscore(),new LinkedList<Term>());
			for(int i=0; i<it.getO().getSize(); i++){
				Var v = new Var("X"+i,new Untyped(""));
				try {
					compiler.addVar(v);
					compiler.addSymbole(v);
				} catch (Exception e) {
					e.printStackTrace();
				}
				leftRu.getSons().add(new Term(v,new LinkedList<Term>()));
				leftEq.getSons().add(underscore);
			}
			Term right = new Term(compiler.getSymbolesTable().get("lin"),new LinkedList<Term>());
			try {
				compiler.addRule(new Rule(it.getO().toString()+"toLin",leftRu,right));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				compiler.addEquation(new Equation(it.getO().toString()+"toLin",leftEq,right));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
	}
		
	public Boolean close2() {
		//If there were no linearisation added
		if(it.getSons().size()==0){
			compiler.getSymbolesTable().remove(it.getO().getId());
			return false;
		}
		//Else complete construction of the new term
		else{
			//Extract ducplicated Vars from checkeq of it1
			LinkedList<Term> varDupList = new LinkedList<Term>();
			for(Term tV:it.getSons()){
				varDupList.add(tV.getY());
			}
			//Add original Vars
			for(VarEnum ve:varL){
				Term t = new Term(ve.getV(), new LinkedList<Term>());
				varDupList.add(t);
			}
			//Extract checkeq Terms from sons
			LinkedList<Term> checkList = it.getSons();
			
			//lin0
			Term tLin1, tLin2;
			Term tS1, tS2;
			Ops o = new Ops(it.getO().getId()+"_"+0, it.getO().getType(), new LinkedList<Type>());
			try {
				compiler.addSymbole(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tLin2 = new Term(o, new LinkedList<Term>()); 
			// add clone varDupList
			tLin2.getSons().addAll((Collection<? extends Term>) varDupList.clone());
			tS1=tLin2;
			
			for(Term t:tLin2.getSons()){
				o.getSignature().add(t.getO().getType());
			}
			
			//Pour chaque élément, on cré deux nouveaux symboles intermédiaire
			//Et deux nouveaux termes
			//t1(true, vars) -> t2 (check, vars-1)
			int i = 1;
			for(Term tCheck:checkList){
				//new symbol
				o = new Ops(it.getO().getId()+"_"+i, it.getO().getType(), new LinkedList<Type>());
				try {
					compiler.addSymbole(o);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// remove varDup
				varDupList.remove(0);
				// new Term
				tLin1 = new Term(o, new LinkedList<Term>());
				// add checkeq
				tLin1.getSons().add(tCheck);
				// add clone varDupList
				tLin1.getSons().addAll((Collection<? extends Term>) varDupList.clone());
				
				Rule rule = new Rule(o.getId(),tLin2,tLin1);
				try {
					compiler.addRule(rule);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				tLin2 = new Term(o, new LinkedList<Term>());
				tLin2.getSons().add(new Term(compiler.getSymbolesTable().get("true"),new LinkedList<Term>()));
				tLin2.getSons().addAll((Collection<? extends Term>) varDupList.clone());
				
				for(Term t:tLin2.getSons()){
					o.getSignature().add(t.getO().getType());
				}
				
				i++;
			}
			tS2=tLin2;
			
			it = tS1;
			it2 = tS2;		
			
			return true;
		}
	}

	public Term getIt1() {return it;}
	public Term getIt2() {return it2;}
	
}
