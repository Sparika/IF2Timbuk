package compiler;

public class CheckRule extends Rule {

	public CheckRule(String id, Term l, Term r) {
		super(id, l, r);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Returns a String showing the rule in Timbuk format <p>
	 *
	 * @return a String representation of the rule
	 */
	@Override
	public String print(){
		String s = "%"+id+"\n";
		try{
			s+=l.print()+" -> \n";
			s+=r.print()+"\n";
			
			/**
			 * Commented code for the equation version
			 */
			//if(!cond.equals(""))
			//	s+="if "+cond+"\n";
			
			
		//return "%"+id+"\n"+l.toString()+" -> "+r.toString()+"\n";
		}catch(NullPointerException e){
			s+=" -> "+r.print()+"\n";
			e.printStackTrace();
		}
		return s;
	}
}
