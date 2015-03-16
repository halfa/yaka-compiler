package compiler;

import exception.*;

/**
 * Gère les déclarations des variables et constantes.
 * 
 */
public class Declaration {

	// Utilisé pour le stockage des identifiants par les constantes
	static private String currentIdent;
	// Utilisé pour le stockage des types par les variables
	static private Type currentType;
	static private int nbVariables;
	// Utilisé pour le stockage de la fonction courante
	static private IdFun currentFunction;

	// Définition pour le type booléen
	static public int FAUX = 0;
	static public int VRAI = -1;

	/* GetSet */
	public static int getNbVariables() { return nbVariables; }
	public static void setNbVariables(int n){ nbVariables = n; }
	public static void setCurrentIdent(String s) { currentIdent = s; }
	public static String getCurrentIdent() { return currentIdent; }
	public static void setCurrentType(Type t) { currentType = t; }
	public static IdFun getCurrentFunction() { return currentFunction; }
	public static void setCurrentFunction(IdFun id) { currentFunction = id; }

	/**
	 * Initialise le couple constant (déclaration, valeur) dans la table interne.
	 * @param value valeur associé
	 * @param t type de la valeur
	 */
	public static void createConst(int value, Type t) {
		TabIdent.addIdent(currentIdent, new IdConst(value, t));
	}

	// Créer une constante à partir d'un autre identifiant
	public static void createConst(String ident) throws DeclarationException {
		Ident i = TabIdent.getIdent(ident);
		if (i == null)
			throw new UnknownIdentException("Ident not found : "+ident);
		TabIdent.addIdent(currentIdent, i);
	}

	/**
	 * Initialise la variable dans la table interne et réserve l'espace mémoire associée.
	 * La variable est initialisé à 0 (ou false si c'est un booléen)
	 * @param name identifiant de la déclaration
	 * @param t type de la valeur
	 */
	public static void createVar(String name) {
		TabIdent.addIdent(name, new IdVar(currentType));
		nbVariables++;
	}
	// Créer une variable à partir d'un autre identifiant est impossible

}
