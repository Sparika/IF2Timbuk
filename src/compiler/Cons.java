package compiler;

import java.util.Enumeration;
import java.util.LinkedList;

/**
 * 
 * @author Kevin CORRE
 *
 * Class Cons
 * This class represent a constant symbol.
 */
public class Cons extends Symbole {
	private Type type;
	
	public Cons(String id, Type type){
		this.id = id;
		this.type = type;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public String print(String s) {
		return id.replaceAll("_", "");
	}
	@Override
	public String printType(String s) {
		return type.print(id.replaceAll("_", ""));
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
	public void check(Compiler compiler) {
		Term l, r;
		Symbole check = compiler.getSymbolesTable().get("check_eq");
		LinkedList<Term> lst = new LinkedList<Term>();
		LinkedList<Term> lst2 = new LinkedList<Term>();
		lst.add(new Term(this,lst2));
		lst.add(new Term(this,lst2));
		l = new Term(check,lst);
		r = new Term(compiler.getSymbolesTable().get("true"),null);
		try {
			compiler.addRule(new Rule("check_"+id, l, r));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void checkFalse(Compiler compiler){
		Term falseTerm = new Term(compiler.getSymbolesTable().get("false"),new LinkedList<Term>());
		Enumeration<Symbole> e = compiler.getSymbolesTable().elements();
		Term x = new Term(this,new LinkedList<Term>());
		while(e.hasMoreElements()){
			Symbole t = e.nextElement();
			if(t.getClass().equals(this.getClass())&&!t.equals(this)&&this.getType().equals(t.getType())){
				Term y = new Term(t,new LinkedList<Term>());
				Term check = new Term(compiler.getSymbolesTable().get("check_eq"),new LinkedList<Term>());
				check.getSons().add(x);
				check.getSons().add(y);
				
				try {
					compiler.addRule(new Rule("checkFalse"+getId()+t.getId() ,check,falseTerm));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
