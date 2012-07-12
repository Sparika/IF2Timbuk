package compiler;

import java.util.LinkedList;

public class Nonce extends Term {

	public Nonce(Var v) {
		super(v,null);
	}
	
	/***************************************
	 * 				PRINT
	 ***************************************/
	@Override
	public String print(){
		String s ="";
		if(sons != null){
			try{
				for(Term t:sons){
					s=s+t.print()+",";
				}
			}catch(NullPointerException e){
				//s=s+"union(null),";
				//System.out.println("err\n"+s+"nonce");
			}
			if(s.length()>0)
				s=s.substring(0, s.length()-1);
		}
		s = o.print(s);
		return s;
	}

}
