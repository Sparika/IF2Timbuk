package compiler;
/**
 * 
 * @author Kevin CORRE
 *
 * Class Var
 * This class represent a variable.
 */
public class Var extends Symbole {
	private Type type;
	public Var(String id, Type type){
		this.id = id;
		this.type = type;
	}
	@Override
	public int getSize() {
		return 0;
	}
	@Override
	public String print(String s) {
		return type.print(id.replaceAll("_", ""));
	}
	@Override
	public String printType(String s) {
		return type.print(id.replaceAll("_", ""));
	}
	@Override
	public Boolean isPrimitive() {
		return type.isPrimitive();
	}
	@Override
	public Type getType() {
		return type;
	}
}
