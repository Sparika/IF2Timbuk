package compiler;

public class Union extends Type{

	public Union(String id) {
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
