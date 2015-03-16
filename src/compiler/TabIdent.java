package compiler;

import java.util.HashMap;

import exception.UnknownIdentException;

/**
 * Tableau des identifiants pour la correspondance nom/valeur.
 */
public class TabIdent {
	static private HashMap<String, Ident> global = new HashMap<String, Ident>();
static private HashMap<String, Ident> local = new HashMap<String, Ident>();


	static Ident getIdent(String clef) throws UnknownIdentException {
		Ident i = global.get(clef);
		if(i==null)throw new UnknownIdentException(clef);
		return i;
	}

	static void addIdent(String clef, Ident id) {
		global.put(clef, id);
	}
	static boolean existeIdent(String clef) {
		return global.containsKey(clef);
	}

}