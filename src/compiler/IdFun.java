package compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Gestion des fonctions usuelles, de leur paramètres et valeur de retour.
 * 
 */
public class IdFun extends Ident {

	// L'ordre des paramètres est important car c'est
	// lui qui défini l'odre d'appel
	private List<Parameter> parameters;
	/**
	 *  Pile qui indique l'état actuel de l'appel des paramètres pour cette fonction
	 *  au cours de leur traitement.
	 *  Il s'agit d'une pile car la fonction peut être rappelé récursivement.
	 *  Exemple : foo(entier i, entier j) peut s'écrire foo(5, foo(3, 8))
	 */ 
	private Stack<Integer> currentParameterIndex = new Stack<Integer>();

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

	/**
	 * Contructeur de fonction.
	 * Initialement sans paramètres
	 * @param t
	 */
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
		parameters.add(new Parameter(name, p));
		computeParametersOffets();
	}
	
	/**
	 * Calcul les offsets des paramètres et les assignes.
	 * Chaque paramètre fait 2 octets.
	 */
	public void computeParametersOffets(){
		int end = parameters.size()*2+2;
		for (Parameter p : parameters) {
			p.getIdent().setOffset(end);
			end -= 2;
		}
	}

	/**
	 * Retourne le paramètre correspondant à l'appel courant.
	 * Passe également à l'appel suivant.
	 */
	public void callParameter(String name){
		int index = currentParameterIndex.pop();
		parameters.get(index++);
		currentParameterIndex.push(index);
	}

	/**
	 * Retourne l'offset de retour de la fonction.
	 * @return (n_param + 2) * 2
	 */
	public int getReturnOffset(){
		return getNumberOfParameters()*2+4;
	}

	/**
	 * Retourne le nombre de paramètres de la fonction
	 * @return nombre de paramètres de la fonction
	 */
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
