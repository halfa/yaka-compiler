package compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestion des fonctions, de leur type et paramètres.
 *
 */
public class IdFun extends Ident {
	
	static private IdFun currentFunction;
	private List<Parameter> parameters;
	
	/****************************************
	 * Sous-classe pour gérer les paramètres.
	 ****************************************/
	class Parameter {
		String name;
		IdVar id;
		
		/* Constructeur */
		public Parameter(String n, IdVar p) {
			name = n;
			id = p;
		}
		
		/* GetSet */
		public String getName(){ return name; }
		public IdVar getIdent(){ return id; }

		
		public String toString(){
			return name+" "+id;
		}
		
	}
	
	// Contructeur de fonction sans paramètre
	public IdFun(Type t) {
		super(t); // type de retour
		parameters =  new ArrayList<Parameter>();
	}
	
	/* GetSet */
	public static IdFun getCurrentFunction() { return currentFunction; }
	public static void setCurrentFunction(IdFun currentFunction) { IdFun.currentFunction = currentFunction; }
	public List<Parameter> getParameters(){ return parameters; }

	/**
	 * Ajoute un paramètre à la fonction
	 */
	public void addParameter(String name, IdVar p){
		parameters.add(new Parameter(name, p));
	}
	
	/**
	 * String output for debug purpose
	 */
	public String toString(){
		String s = new String("FONCTION\n");
		for (Parameter i : parameters) {
			s += i;
		}
		return s;
	}
}
