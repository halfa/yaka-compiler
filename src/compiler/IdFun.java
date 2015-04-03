package compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestion des fonctions usuelles, de leur paramètres et valeur de retour.
 * 
 */
public class IdFun extends Ident {
	
	// L'ordre des paramètres est important car c'est TODO il manque un truc là ^^ 
	private List<Parameter> parameters;
	private int currentParameterIndex = -1; // no parameters
	
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
			p.setOffset(parameters.size()*2+4);
		}
		
		/* GetSet */
		public String getName(){ return name; }
		public IdVar getIdent(){ return id; }

		public String toString(){
			return name+" "+id;
		}
		
	}
	
	// Contructeur de fonction (sans paramètre)
	public IdFun(Type t) {
		super(t); // type de retour
		parameters =  new ArrayList<Parameter>();
	}
	
	/* GetSet */
	public List<Parameter> getParameters(){ return parameters; }

	/**
	 * Ajoute un paramètre à la fonction.
	 * L'offset est mis à la construction
	 */
	public void addParameter(String name, IdVar p){
		//System.out.println("Add parameter to "+Declaration.getNameCurrentFunction()+"@"+p.getOffset());
		parameters.add(new Parameter(name, p));
	}
	
	/**
	 * Retourne le paramètre correspondant à l'appel courant.
	 */
	public void callParameter(String name){
		parameters.get(currentParameterIndex++);
	}
	
	/**
	 * TODO retourne l'offset de retour de la fonction.
	 * = sp - n_param*2 ?
	 */
	public int getReturnOffset(){
		return 0;
	}
	
	public int getNumberOfParameters(){
		return parameters.size();
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
