package compiler;

public class FinalState extends State {
	public FinalState(String s) {
		super(s);
	}

	@Override
	public Boolean isFinal(){
		return true;
	}
}
