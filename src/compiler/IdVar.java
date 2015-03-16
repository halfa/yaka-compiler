package compiler;
/**
 * Décrit un identifiant déclaré variable.
 * Chaque type possède une valeur par défaut.
 */
public class IdVar extends Ident {
	
	static int activeOffset = 0; //offset du dernier élément de la pile
	
	int offset;
	
	/* Constructeurs */
	private IdVar(Type t, int o){
		super(t);
		offset = o;
	}
	
	public IdVar(Type t){
		this(t, activeOffset -= 2);
	}
	
	/**
	 * Retourne la position de la variable dans la pile
	 * @return offset
	 */
	public int getOffset(){
		return offset;
	}
}
