package compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestion des fonctions usuelles, de leur paramètres et valeur de retour.
 * 
 */
public class IdFun extends IdFPrinc {
	
	// L'ordre des paramètres est important car c'est 
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
	public List<Parameter> getParameters(){ return parameters; }

	/**
	 * Ajoute un paramètre à la fonction
	 */
	public void addParameter(String name, IdVar p){
		parameters.add(new Parameter(name, p));
	}
	
	/**
	 * TODO retourne l'offset de retour de la fonction
	 */
	public int getReturnOffset(){
		return 0;
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
