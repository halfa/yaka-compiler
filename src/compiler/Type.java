package compiler;
public enum Type {
	BOOLEAN ("boolean"), 
	INTEGER ("integer"), 
	ERROR ("error"),
	SUCCESS ("succes");
	
	private final String label;
	
	Type (String label) {
		this.label = label;
	}
	
	public String toString(){
		return label;
	}
}
