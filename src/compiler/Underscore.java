package compiler;

public class Underscore extends Var {

	public Underscore() {
		super("Underscore", null);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String print(String s) {
		return "_";
	}
	@Override
	public String printType(String s) {
		return "_";
	}

}
