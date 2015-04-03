package compiler;
/**
 * Décrit un identifiant déclaré variable.
 * Chaque type possède une valeur par défaut.
 */
public class IdVar extends Ident {
	
	static int activeOffset = 0; //offset du dernier élément de la pile
	
	/**
	 * Position de la variable dans la pile
	 */
	int offset;
	
	/* Constructeurs */
	private IdVar(Type t, int o){
		super(t);
		offset = o;
	}
	
	public IdVar(Type t){
		this(t, activeOffset -= 2);
	}
	
	static public IdVar IdParameter(Type t){
		return new IdVar(t, 0);
	}
	
	
	/**
	 * Retourne la position de la variable dans la pile
	 * @return offset
	 */
	public int getOffset(){
		return offset;
	}
	
	public void setOffset(int o){
		offset = o;
	}
	
	public static void resetOffset(){
		activeOffset = 0;
	}
	
	/**
	 * Sortie en string pour débug.
	 */
	public String toString(){
		return "VARIABLE : OFFSET: "+offset;
	}
}
