package compiler;
/**
 * Décrit un identifiant déclaré variable.
 * Chaque type possède une valeur par défaut.
 */
public class IdVar extends Ident {
	
	static int activeOffset = 2; //offset du dernier élément de la pile
	
	int offset;
	
	/* Constructeurs */
	private IdVar(Type t, int o){
		super(t);
		offset = o;
	}
	
	public IdVar(Type t){
		this(t, activeOffset += 2);
	}
	
	public IdVar IdParameter(Type t){
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
		activeOffset = 2;
	}
	
	/**
	 * Sortie en string pour débug.
	 */
	public String toString(){
		return "VARIABLE : OFFSET: "+offset;
	}
}
