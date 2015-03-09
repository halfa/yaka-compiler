
/*
 * Gère les déclarations des variables et constantes en début de programme
 */

public class Declaration {

	static private String currentIdent;
	
	/* GetSet */
	public static void setCurrentIdent(String s) { currentIdent = s; }
	public static String getCurrentIdent(){ return currentIdent; }
	
	/* Declaration tools */
	public static void createConst(String name, int value){
		
	}

	public static void createVar(){ createVar(currentIdent); }
	public static void createVar(String name){
		
	}
}
