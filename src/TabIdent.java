import java.util.HashMap;

public class TabIdent {

	static private HashMap<String, Ident> table=new HashMap<String, Ident>();
	static private String currentIdent; // TODO move into declaration

	/* Constructeur */
	
	/* Méthodes */
	static Ident chercheIdent(String clef) {

		return table.get(clef);
	}

	static boolean existeIdent(String clef) {
		return table.containsKey(clef);
	}

	static void rangeIdent(String key, Ident id) {
		table.put(key, id);
	}

	static void rangeIdent(Ident id) {

		table.put(currentIdent, id);
	}

	static String getCurrentIdent() {
		return currentIdent;
	}

	static void setCurrentIdent(String currentIdent) {
		currentIdent = currentIdent;
	}

}