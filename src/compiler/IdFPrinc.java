package compiler;

/**
 * Gestion de la fonction principale et de la déclaration des variables locales.
 * 
 */
public class IdFPrinc extends IdFun {
	// Nombres de variables locales pour la fonction
	int numberOfLocalVariables;
	
	public IdFPrinc(Type t) {
		super(t);
		numberOfLocalVariables = 0;
	}
	
	public IdFPrinc() {
		super(Type.SUCCESS);
		// TODO tout doux FIXME type
	}

	/**
	 * TODO retourne le nombre de variables locales de la fonction
	 */
	public int getNumberOfLocalVariable(){
		return numberOfLocalVariables;
	}
}
