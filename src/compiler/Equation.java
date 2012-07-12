package compiler;

public class Equation extends Rule{

	public Equation(String id, Term l, Term r) {
		super(id, l, r);
	}
	
	public String toString(){
		String s = "%"+id+"\n";
		try{
			s+=l.print()+" = \n";
			s+=r.print()+"\n";
			
			
		//return "%"+id+"\n"+l.toString()+" -> "+r.toString()+"\n";
		}catch(NullPointerException e){
			s+="%error\n";
		}
		return s;
	}
	
}
