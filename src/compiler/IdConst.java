package compiler;
/**
 * Décrit un identifiant déclaré comme constant.
 */
public class IdConst extends Ident{
	
	final int val;

	public IdConst(int v, Type t){
		super(t);
		val = v;
	}

	/* Get & Set */
	public int getVal(){ return val; }
	
	/**
	 * @see Ident#copy()
	 */
	public IdConst copy(){
		return new IdConst(val, super.type);
	}
}