/**
 * Décrit un identifiant déclaré comme constant.
 */
public class IdConst extends Ident{
	
	final int val;
	
	public IdConst(int v, Type t){
		super(t);
		val = v;
	}

	public int getVal(){
		return val;
	}
}