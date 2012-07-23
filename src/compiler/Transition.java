package compiler;

import java.util.LinkedList;

public class Transition {

	private Symbole o;
	private LinkedList<State> left;
	private State right;
	
	public Transition(Symbole o, LinkedList<State> left, State right){
		this.o=o;
		this.left=left;
		this.right=right;
	}
	
	public Symbole getO(){return o;}
	public LinkedList<State> getLeft(){return left;}
	public State getRight(){return right;}

	public String print() {
		String trans = "";
		for(State s:left)
			trans = trans+","+s.toString();
		if(trans.length()>0)
			trans = trans.substring(1);
		trans = o.print(trans);
		trans = trans+" -> "+right.toString();
		return trans;
	}
	public boolean equals(Transition obj) {
		if(o.equals(obj.getO())&&right.equals(obj.getRight())){
			LinkedList<State> leftObj = obj.getLeft();
			for(int i = 0; i<left.size(); i++){
				if(!left.get(i).equals(leftObj.get(i)))
					return false;
			}
			return true;
		}
		else
			return false;
	}
	
}
