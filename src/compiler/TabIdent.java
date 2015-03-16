package compiler;
import java.util.HashMap;
/**
 * Tableau des identifiants pour la correspondance nom/valeur.
 */
public class TabIdent {
	
	static private HashMap<String, Ident> global = new HashMap<String, Ident>();
	// TODO implémenter la priorité local/globale dans les getSet
	static private HashMap<String, Ident> local = new HashMap<String, Ident>();
	
	static Ident getIdent(String clef) { return global.get(clef); }
	static void addIdent(String clef, Ident id){ global.put(clef, id); }
	
	static boolean existeIdent(String clef) {
		return global.containsKey(clef);
	}

}