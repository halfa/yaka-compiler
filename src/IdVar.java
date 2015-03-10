/**
 * Décrit un identifiant déclaré variable.
 * Chaque type possède une valeur par défaut.
 */
public class IdVar extends Ident {
	
	static int activeOffset = 0; //offset du dernier élément de la pile
	
	int val;
	int offset;
	
	public IdVar(int v,Type t){
		super(t);
		val=v;
		offset = (activeOffset -= 2);
	}
	
	public int getVal(){ return val; }
	public void setVal(int v){ val=v; }
	
	/**
	 * Retourne la position de la variable dans la pile
	 * @return offset of the ident
	 */
	public int getOffset(){
		return offset;
	}
}
