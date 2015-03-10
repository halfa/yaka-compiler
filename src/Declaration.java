/**
 * Gère les déclarations des variables et constantes.
 * 
 */
public class Declaration {

	static private String currentIdent;
	static private int nbVariables;
	
	// Définition pour le type booléen
	static public int FAUX = 0;
	static public int VRAI = -1;
	
	
	public static int getNbVariables() {return nbVariables;}
	public static void setNbVariables(int nbVariables) {Declaration.nbVariables = nbVariables;}
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
	 * @param t type de la valeur
	 */
	public static void createVar(String name, Type t){
		// Initialisation par défaut à 0/false
		TabIdent.addIdent(name, new IdVar(0, t));
		nbVariables++;
	}
}
