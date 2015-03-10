import java.util.HashMap;
/**
 * Tableau des identifiants pour la correspondance nom/valeur.
 */
public class TabIdent {
	
	static private HashMap<String, Ident> table = new HashMap<String, Ident>();
	
	static Ident getIdent(String clef) { return table.get(clef); }
	static void addIdent(String clef, Ident id){ table.put(clef, id); }
	
	static boolean existeIdent(String clef) {
		return table.containsKey(clef);
	}

}