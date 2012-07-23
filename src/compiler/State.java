package compiler;

public class State extends Symbole{

	public State(String s) {
		this.id=s;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String printType(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isPrimitive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Boolean isFinal(){
		return false;
	}

}
