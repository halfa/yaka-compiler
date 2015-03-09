
public class IdVar extends Ident{

	char val;
	
	public IdVar(char v,Type t){
		super(t);
		val=v;
	}
	
	public char getVal(){
		return val;
	}

	public void setVal(char v){
		val=v;
	}
	
	
	/**
	 * TODO
	 * @return offset of the ident
	 */
	public int getOffset(){
		return 0;
	}
}
