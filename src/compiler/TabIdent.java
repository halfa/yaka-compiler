package compiler;

import java.util.HashMap;
import exception.UnknownIdentException;

/**
 * Tableau des identifiants pour la correspondance nom/valeur.
 * 
 */
public class TabIdent {
	static private HashMap<String, Ident> global = new HashMap<String, Ident>();
	static private HashMap<String, Ident> local = new HashMap<String, Ident>();
	
	/**
	 * Récupère un identifiant depuis la table.
	 * Les identifiants en contexte local sont prioritaires.
	 * @throws UnknownIdentException
	 */
	static Ident getIdent(String clef) throws UnknownIdentException {
		Ident i = local.get(clef);
		if (i == null)
			i = global.get(clef);
		if (i == null)
			throw new UnknownIdentException(clef);
		return i;
	}

	static void addIdent(String clef, Ident id) {
		global.put(clef, id);
	}
	static void addIdentLocal(String clef, Ident i){
		local.put(clef, i);
	}

	static boolean existeIdent(String clef) {
		return global.containsKey(clef) || local.containsKey(clef);
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
		dump += "Variables locales\n";
		for (String name : local.keySet()) {
			dump += name+local.get(name).toString()+"\n";
		}
		return dump;
	}
}