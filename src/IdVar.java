
public class IdVar extends Ident{

	static int activeOffset =-2;
	int val;
	int offset;
	
	public IdVar(int v,Type t){
		super(t);
		val=v;
		offset = activeOffset ;
		activeOffset-=2;
	}
	
	public int getVal(){
		return val;
	}

	public void setVal(int v){
		val=v;
	}
	
	
	/**
	 * 
	 * @return offset of the ident
	 */
	public int getOffset(){
		return offset;
	}
}
