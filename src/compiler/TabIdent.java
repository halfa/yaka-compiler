package compiler;

import java.util.HashMap;
import exception.UnknownIdentException;

/**
 * Tableau des identifiants pour la correspondance nom/valeur.
 * 
 */
public class TabIdent {
	
	static private HashMap<String, Ident> global = new HashMap<String, Ident>();
	
	/**
	 * Récupère un identifiant depuis la table.
	 * @throws UnknownIdentException
	 */
	static Ident getIdent(String clef) throws UnknownIdentException {
		if (existeIdent(clef))
			return global.get(clef);
		else
			throw new UnknownIdentException(clef);
	}

	static void addIdent(String clef, Ident id) {
		global.put(clef, id);
	}

	static boolean existeIdent(String clef) {
		return global.containsKey(clef);
	}
	
	/**
	 * Donne le nombre de variables locales pour le bloc courant.
	 */
	static int countLocalVars(){
		return global.size();
	}
	
	/**
	 * Dump tables for debug purpose.
	 */
	static public String dump(){
		String dump = new String("** TabIdent **\n");
		dump += "Variables globales\n";
		for (String name : global.keySet()) {
			dump += name+global.get(name).toString()+"\n";
		}
		return dump;
	}
}