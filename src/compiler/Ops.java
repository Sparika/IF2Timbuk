package compiler;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * 
 * @author Kevin CORRE
 *
 * Class Ops
 * This class represent a functional symbol.
 */
public class Ops extends Symbole {
	private LinkedList<Type> signature;
	private Type type;
	
	public Ops(String id, Type type, LinkedList<Type> sig){
		this.id=id;
		this.type=type;
		this.signature=sig;
	}

	@Override
	public int getSize() {
		return signature.size();
	}

	@Override
	public Boolean isPrimitive() {
		return type.isPrimitive();
	}
	@Override
	public Type getType() {
		return type;
	}
	@Override
	public String printType(String s) {
		return type.print(id.replaceAll("_", "")+"("+s+")");
	}
	
	public LinkedList<Type> getSignature(){
		return signature;
	}

	@Override
	public void check(Compiler compiler) {
		Term l, r;
		int i = 0;
		Symbole check = compiler.getSymbolesTable().get("check_eq");
		LinkedList<Term> lst1= new LinkedList<Term>(), lst2 = new LinkedList<Term>();
		LinkedList<Term> conj = new LinkedList<Term>();
		for(Type t:signature){
			LinkedList<Term> lstR = new LinkedList<Term>();
			Term tTemp;
			Var v1 = new Var("V"+t.getId()+"c1"+i, t);
			try {
				compiler.addVar(v1);
				compiler.addSymbole(v1);
			} catch (Exception e) {
				v1 = compiler.getVarsTable().get(v1.getId());
			}
			tTemp = new Term(v1,new LinkedList<Term>());
			lst1.add(tTemp);
			lstR.add(tTemp);
			Var v2 = new Var("V"+t.getId()+"c2"+i, t);
			try {
				compiler.addVar(v2);
				compiler.addSymbole(v2);
			} catch (Exception e) {
				v2 = compiler.getVarsTable().get(v2.getId());
			}
			tTemp = new Term(v2,new LinkedList<Term>());
			lst2.add(tTemp);
			lstR.add(tTemp);
			
			conj.add(new Term(check,lstR));
			i++;
		}
		
		LinkedList<Term> lstT = new LinkedList();
		lstT.add(new Term(this,lst1));
		lstT.add(new Term(this,lst2));
		l = new Term(check,lstT);
		
		Symbole and = compiler.getSymbolesTable().get("and");
		LinkedList<Term> lstR = new LinkedList<Term>();
		r = new Term(and, lstR);
		lstR.add(new Term(compiler.getSymbolesTable().get("true"),new LinkedList<Term>()));
		for(Term t:conj){
			LinkedList<Term> lstR2 = new LinkedList<Term>();
			lstR2.add(t);
			Term tand = new Term(and, lstR2);
			lstR.add(tand);
			lstR = lstR2;
		}
		lstR.add(new Term(compiler.getSymbolesTable().get("true"),new LinkedList<Term>()));
		try {
			compiler.addRule(new Rule("check_"+id, l, r));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
