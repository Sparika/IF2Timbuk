package compiler;

public class Untyped extends Type {
	public Untyped(String id) {
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
