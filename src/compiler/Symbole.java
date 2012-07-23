package compiler;
/**
 * 
 * @author Kevin CORRE
 *
 * Class Symbol
 * This abstract class represent a symbol (function, constant or variable) of rewriting language
 */
public abstract class Symbole {
	protected String id;
	public final static String PAIR="pair", CRYPT = "crypt", SCRYPT ="scrypt";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Returns symbol's arity
	 *
	 * @return      the arity of the symbol
	 */
	public abstract int getSize();
	/**
	 * Returns a String showing the symbol applied to its parameters "s" and 
	 * protected by a type symbol<p>
	 * 
	 *  i.e.  "f".toString("a,b") will return "t(f(a,b))" 
	 *
	 * @param  s	the parameters of the function
	 * @return      a String representing the symbol applied to its parameters
	 */
	public abstract String printType(String s);
	/**
	 * Returns a String showing the symbol applied to its parameters "s" <p>
	 * 
	 *  i.e.  "f".toString("a,b") will return "f(a,b)" 
	 *
	 * @param  s	the parameters of the function
	 * @return      a String representing the symbol applied to its parameters
	 */
	public String print(String s) {
		return id.replaceAll("_", "")+"("+s+")";
	}
	/**
	 * Returns a String showing the symbol 
	 *
	 * @return      a String representing the symbol applied to its parameters
	 */
	public String toString() {
		return id.replaceAll("_", "");
	}
	/**
	 * Returns true is the Symbole is of a primitive type else false.
	 *
	 * @return      true if the symbol is of a primitive type.
	 */
	public abstract Boolean isPrimitive();
	
	/**
	 * Returns the Type of the symbol.
	 *
	 * @return      the type of the symbol.
	 */
	public abstract Type getType();
	
	/**
	 * Returns true if the symbol is "pair".
	 * 
	 * @return 		true if the symbol is "pair" else false.
	 */
	public Boolean isPair(){
		return id.equals(PAIR);
	}
	public Boolean isCrypt(){
		return id.equals(CRYPT);
	}
	public Boolean isScrypt(){
		return id.equals(SCRYPT);
	}
	
	public void check(Compiler compiler){
		//null
	}
	public void checkFalse(Compiler compiler){
		//null
	}
	@Override
	public boolean equals(Object obj) {
		return ((Symbole) obj).getId().equals(getId());
	}
	public String printVariable(Compiler compiler) {
		// TODO Auto-generated method stub
		return null;
	}
}
