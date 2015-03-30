package compiler;

/**
 * Gestion de la fonction principale et de la déclaration des variables locales.
 * 
 */
public class IdFPrinc extends Ident {
	// Nombres de variables locales pour la fonction
	int numberOfLocalVariables;
	
	public IdFPrinc(Type t) {
		super(t);
		numberOfLocalVariables = 0;
	}
	
	/**
	 * TODO retourne le nombre de variables locales de la fonction
	 */
	public int getNumberOfLocalVariable(){
		return numberOfLocalVariables;
	}
}
