package compiler;
/**
 * Décrit un identifiant typé générique.
 * Les identifiants font tous 2 octets en mémoire.
 */
public abstract class Ident {
	
	Type type;
	
	public Ident(Type t){
		type = t;
	}
	
	public Type getType(){ return type; }
	
	/**
	 * Duplique un identifiant.
	 * TODO implémenter <clonable> ?
	 * @return une copie de l'identifiant
	 */
	public Ident copy() {
		return null; 
	}

}
