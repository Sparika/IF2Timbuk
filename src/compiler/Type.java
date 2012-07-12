package compiler;

import java.util.Enumeration;
import java.util.LinkedList;

/**
 * 
 * @author Kevin CORRE
 *
 * Class Type
 * This class represent a functional symbol. Type symbol encapsulate and protect terms.
 */
public class Type extends Symbole implements VoidType{
	/**
	 * primitive define if the type is a primitive type (ie: nat, agent)
	 */
	private Boolean primitive;
	/**
	 * Constructor. Primitive is set to false
	 * @param id the String id of the type
	 */
	public Type(String id){
		this.id = id;
		this.primitive = false;
	}
	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public String printType(String s) {
		return id.replaceAll("_", "")+"("+s+")";
	}
	public String print(String s) {
		return id.replaceAll("_", "")+"("+s+")";
	}

	@Override
	public Boolean isPrimitive() {
		return primitive;
	}

	public void setPrimitive(Boolean primitive) {
		this.primitive = primitive;
	}
	
	@Override
	/**
	 * Herited from Symbole, return null because Type are untyped.
	 */
	public Type getType() {
		return null;
	}
	
	/*@Override
	public void checkFalse(Compiler compiler){
		if(!getId().equals("message")){
			Term falseTerm = new Term(compiler.getSymbolesTable().get("false"),new LinkedList<Term>());
			Enumeration<Type> e = compiler.getTypesTable().elements();
			Term x = new Term(new Var("X",this),new LinkedList<Term>());
			Term left = new Term(this,new LinkedList<Term>());
			left.getSons().add(x);
			while(e.hasMoreElements()){
				Type t = e.nextElement();
				if(!t.isVoidType()&&!t.equals(this)&&!t.getId().equals("message")){
					Term y = new Term(new Var("Y",t),new LinkedList<Term>());
					Term right = new Term(t,new LinkedList<Term>());
					right.getSons().add(y);
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
	}*/
	@Override
	public Boolean isVoidType() {
		return false;
	}
}
