package compiler;

import java.util.HashMap;

import exception.UnknownFunctionException;
import exception.UnknownIdentException;

/**
 * Tableau des identifiants pour la correspondance nom/valeur.
 * 
 */
public class TabIdent {
	
	static private HashMap<String, Ident> values = new HashMap<String, Ident>();
	static private HashMap<String, IdFun> functions = new HashMap<String, IdFun>();
	
	/**
	 * Récupère un identifiant depuis la table.
	 * @throws UnknownIdentException
	 */
	static Ident getIdent(String key) throws UnknownIdentException {
		if (existIdent(key))
			return values.get(key);
		else
			throw new UnknownIdentException(key);
	}
	
	/**
	 * Récupère une focntion depuis la table.
	 * @throws UnknownFunctionException
	 */
	static IdFun getFunction(String key) throws UnknownFunctionException {
		if (existFunction(key))
			return functions.get(key);
		else
			throw new UnknownFunctionException(key);
	}
	
	/**
	 * Retourne la dernière fonction de la pile d'appel
	 * @return
	 * @throws UnknownFunctionException
	 */
	static IdFun getLastFunction() throws UnknownFunctionException{
		//System.out.println(Yaka.expression.popFunction());
		return getFunction(Yaka.expression.popFunction());
	}
	
	static void addIdent(String key, Ident id) {
		values.put(key, id);
	}
	
	/**
	 * Ajoute la fonction à la table des identifiants
	 * @param key nom de la fonction
	 * @param id la fonction
	 */
	static void finalizeFunction(String key, IdFun id){
		//System.out.println("Add "+key+" to table function");
		functions.put(key, id);
	}
	
	/**
	 * Test l'existence d'un identifiant dans la table
	 * @param key le nom de l'identifiant
	 * @return vrai si l'identifiant existe
	 */
	static boolean existIdent(String key) {
		return values.containsKey(key);
	}
	
	
	/**
	 * Test l'existence d'une fonction dans la table
	 * @param key le nom de la fonction
	 * @return vrai si la fonction existe
	 */
	static boolean existFunction(String key){
		//System.out.println("Check "+key+"");
		return functions.containsKey(key);
	}
	
	/**
	 * Vide la table des identifiants.
	 * Utilisé pour changer de contexte entre les fonctions
	 */
	static void cleanIdentTable(){
		values.clear();
		IdVar.resetOffset();
	}
	
	/**
	 * Donne le nombre de variables locales pour le bloc courant.
	 */
	static int countLocalVars(){
		return values.size() - Declaration.getCurrentFunction().getNumberOfParameters();
	}
	
	/**
	 * Dump tables for debug purpose.
	 */
	static public String dump(){
		String dump = new String(" ** TabIdent **\n");
		for (String name : values.keySet()) {
			dump += name+" "+values.get(name).toString()+"\n";
		}
		return dump;
	}
}