package compiler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/**
 * 
 * @author Kevin CORRE
 *
 * Class Rule
 * This class represent a rewriting rule of the rewriting system
 */
public class Rule {
	/**
	 * String id of the rule
	 */
	protected String id;
	/**
	 * Left hand side of the rule
	 */
	protected Term l;
	/**
	 * Right hand side of the rule
	 */
	protected Term r;
	/**
	 * Deprecated ?
	 * TODO
	 */
	protected LinkedList<Var> linear;
	/**
	 * Deprecated ?
	 * TODO
	 */
	private String cond;
	/**
	 * Constructor
	 * @param id if the rule
	 * @param l a Term
	 * @param r a Term
	 */
	public Rule(String id, Term l, Term r){
		this.id = id;
		this.l = l;
		this.r = r;
		linear = null;
		cond = l.getCond();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public LinkedList<Var> getLinear() {
		return linear;
	}

	public void setLinear(LinkedList<Var> linear) {
		this.linear = linear;
	}
	/**
	 * Returns a String showing the rule in Timbuk format <p>
	 *
	 * @return a String representation of the rule
	 */
	public String print(){
		String s = "%"+id+"\n";
		try{
			s+=l.print()+" -> \n";
			s+=r.print()+"\n";
			
			/**
			 * Code for the equation version
			 */
			if(cond.length()>0)
				s+="if "+cond+"\n";
			
			
		//return "%"+id+"\n"+l.toString()+" -> "+r.toString()+"\n";
		}catch(NullPointerException e){
			s+=" -> "+r.print()+"\n";
			e.printStackTrace();
		}
		return s;
	}
}
