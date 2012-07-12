package compiler;

public class Fact extends Type {

	public Fact(String id) {
		super(id);
	}

	@Override
	public String print(String s) {
		return s;
	}
	
	@Override
	public Boolean isVoidType() {
		return true;
	}
}
