/**
 * Décrit un identifiant typé générique.
 * Les identifiants font tous 2 octets en mémoire
 */
public abstract class Ident {
	
	Type type;
	
	public Ident(Type t){
		type = t;
	}
	
	public Type getType(){
		return type;
	}

}
