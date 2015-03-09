
public class IdVar extends Ident{

	int val;
	
	public IdVar(int v,Type t){
		super(t);
		val=v;
	}
	
	public int getVal(){
		return val;
	}

	public void setVal(int v){
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
