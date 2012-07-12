package compiler;

public class Pattern {
	private String id;
	private Term l;
	
	public Pattern(String id, Term l){
		this.id = id;
		this.l=l;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Term getL() {
		return l;
	}
	public void setL(Term l) {
		this.l = l;
	}
	
	public String toString(){
		return "%"+id+"\n"+l.toString()+"\n";
	}


	public String print() {
		return "%"+id+"\n"+l.print()+"\n";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((l == null) ? 0 : l.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pattern other = (Pattern) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (l == null) {
			if (other.l != null)
				return false;
		} else if (!l.equals(other.l))
			return false;
		return true;
	}
}
