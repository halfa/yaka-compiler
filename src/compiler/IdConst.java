package compiler;
/**
 * Décrit un identifiant déclaré comme constant.
 */
public class IdConst extends Ident{
	
	final int value;

	public IdConst(int v, Type t){
		super(t);
		value = v;
	}

	/* Get & Set */
	public int getVal(){ return value; }
	
	/**
	 * Sortie en string pour débug.
	 */
	public String toString(){
		return "CONSTANTE : VALEUR : "+value;
	}
}