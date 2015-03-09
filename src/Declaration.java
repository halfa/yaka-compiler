/**
 * Gère les déclarations des variables et constantes.
 * 
 */
public class Declaration {

	static private String currentIdent;
	
	/* GetSet */
	public static void setCurrentIdent(String s) { currentIdent = s; }
	public static String getCurrentIdent(){ return currentIdent; }
	
	/**
	 * Initialise le couple constant (déclaration, valeur) dans la table interne.
	 * @param name identifiant de la déclaration
	 * @param value valeur associé
	 * @param t type de la valeur
	 */
	public static void createConst(String name, int value, Type t){
		TabIdent.addIdent(name, new IdConst(value, t));
	}
	
	/**
	 * Initialise la variable dans la table interne et réserve l'espace mémoire associée.
	 * La variable est initialisé à 0
	 * TODO gérer la mémoire (compteur ?)
	 * @param name identifiant de la déclaration
	 */
	public static void createVar(){ createVar(currentIdent); }
	public static void createVar(String name){ /* TODO */ }
}
