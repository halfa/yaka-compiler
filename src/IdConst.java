
public class IdConst extends Ident{

	final char val;
	
	public IdConst(char v, Type t){
		super(t);
		val=v;
	}

	public char getVal(){
		return val;
	}
}