/**
 * Décrit un identifiant déclaré variable.
 * Chaque type possède une valeur par défaut.
 */
public class IdVar extends Ident {
	
	static int activeOffset = 0; //offset du dernier élément de la pile
	
	int val;
	int offset;
	
	/* Constructeurs */
	private IdVar(int v, Type t, int o){
		super(t);
		val = v;
		offset = o;
	}
	
	public IdVar(int v, Type t){
		this(v, t, activeOffset -= 2);
	}

	/* Get & Set */
	public int getVal(){ return val; }
	public void setVal(int v){ val=v; }
	
	/**
	 * @see Ident#copy()
	 */
	public IdVar copy(){
		return new IdVar(val, super.type);
	}
	
	/**
	 * Retourne la position de la variable dans la pile
	 * @return offset
	 */
	public int getOffset(){
		return offset;
	}
	
}
