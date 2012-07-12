package compiler;

import java.util.LinkedList;

public class TypeCompound extends Type {

	private LinkedList<Type> compound;
	
	public TypeCompound(String id, LinkedList<Type> compound) {
		super(id);

		this.compound = compound;
	}

	public LinkedList<Type> getCompound() {
		return compound;
	}

	public void setCompound(LinkedList<Type> compound) {
		this.compound = compound;
	}
	
	public String toString(){
		/*String s = id+"(";
		Iterator<Type> it = compound.iterator();
		if(it.hasNext()){
			s = s+it.next().toString();
		}
		while(it.hasNext()){
			s = s+","+it.next().toString();
		}
		s=s+")";
		return s;*/
		return super.toString();
	}

}
