import java.io.OutputStream;

public class YVM {
	protected OutputStream fich;
	
	/**
	 * Constructeur d'un YVM à partir d'un OutputStream
	 * @param out
	 */
	public YVM (OutputStream out){
		fich = out;
	}
	
	/**
	 * Haut de pile : int / int
	 * Aditionne les deux éléments en sommet de pile 
	 */
	public void iadd(){
		Ecriture.ecrireStringln(fich,"iadd");
	};
	
	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void isub(){
		Ecriture.ecrireStringln(fich,"isub");
	};
	
	/**
	 * Haut de pile : int / int
	 * Multiplie les deux éléments en haut de pile
	 */
	public void imul(){
		Ecriture.ecrireStringln(fich,"imul");
	};

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void idiv(){
		Ecriture.ecrireStringln(fich,"idiv");
	};
	
	/**
	 * Haut de pile : bool
	 * Transforme l'élément en haut de pile en son opposé
	 */
	public void inot(){
		Ecriture.ecrireStringln(fich,"inot");
	};
	
	/**
	 * Haut de pile : int
	 * Transforme l'élément en haut de pile en son opposé
	 */
	public void ineg(){
		Ecriture.ecrireStringln(fich,"ineg");
	};
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test "ET" sur les deux éléments en haut de la pile
	 */
	public void iand(){
		Ecriture.ecrireStringln(fich,"iand");
	};
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test "OU" sur les deux éléments en haut de la pile
	 */
	public void ior(){
		Ecriture.ecrireStringln(fich,"ior");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void iinf(){
		Ecriture.ecrireStringln(fich,"iinf");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est supérieur au premier 
	 */
	public void isup(){
		Ecriture.ecrireStringln(fich,"isup");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur ou égal au premier
	 */
	public void iinfegal(){
		Ecriture.ecrireStringln(fich,"iinfegal");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est supérieur ou égal au premier
	 */
	public void isupegal(){
		Ecriture.ecrireStringln(fich,"isupegal");
	};

	/**
	 * Haut de pile : bool / bool
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est égal au premier
	 */
	public void iegal(){
		Ecriture.ecrireStringln(fich,"iegal");
	};
	
	/**
	 * Haut de pile : bool / bool
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void idiff(){
		Ecriture.ecrireStringln(fich,"idiff");
	};

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * @param valeur
	 */
	public void iconst(int valeur){
		Ecriture.ecrireStringln(fich,"iconst "+valeur);
	};

	/**
	 * Haut de pile : anything
	 * Met la valeur se trouvant en sommet de pile dans la mémoiree à l'offset "offset"
	 * @param offset
	 */
	public void istore(int offset){
		Ecriture.ecrireStringln(fich,"istore "+offset);
	};

	/**
	 * Haut de pile : anything
	 * Met en sommet de pile la valeur contenue dans la mémoire à l'offset "offset"
	 * @param offset
	 */
	public void iload(int offset){
		Ecriture.ecrireStringln(fich,"iload "+offset);
	};

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0.
	 * Si la valeur est 0, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(fich,"ifeq "+etiquette);
	};

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX.
	 * Si la valeur est FAUX, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(fich,"iffaux "+etiquette);
	};

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette".
	 * L'instruction "goto" est un mot réservé en java, on utilise donc la dénomination "jump",
   * car il s'agit d'un saut inconditionel
	 * @param etiquette
	 */
	public void jump(String etiquette){
		Ecriture.ecrireStringln(fich,"goto "+etiquette);
	};

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .asm
	 * Génère l'entête d'un fichier .asm
	 */
	public void entete(){
		Ecriture.ecrireStringln(fich,"entete");
	}; 
	
	/**
	 * Permet de réserver directement un ensemble de variable dans la pile
	 * @param var
	 */
	public void ouvrePrinc(int var){
		Ecriture.ecrireStringln(fich,"ouvrePrinc "+var);
	}; 
	
	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .asm
	 * Génère la fin d'un fichier .asm
	 */
	public void queue(){
		Ecriture.ecrireStringln(fich,"queue");
	};
	
	/**
	 * Permet d'afficher à l'écran la chaine de caractères placée en paramètre
	 * @param s
	 */
	public void ecrireChaine(String chaine){
		Ecriture.ecrireStringln(fich,"ecrireChaine \""+chaine+"\"");
	}
	
	/**
	 * Permet d'afficher à l'écran l'entier en sommet de pile
	 */
	public void ecrireEnt(){
		Ecriture.ecrireStringln(fich,"ecrireEnt");
	}
	
	/**
	 * Permet d'afficher à l'écran le booleen en sommet de pile
	 */
	public void ecrireBool(){
		Ecriture.ecrireStringln(fich,"ecrireBool");
	}
	
	/**
	 * Lit l'entier tapé au clavier et le place dans la mémoire à l'offset "offset"
	 */
	public void lireEnt(int offset){
		Ecriture.ecrireStringln(fich,"lireEnt "+offset);
		//todo
	}
	
	/**
	 * Va à la ligne
	 */
	public void aLaLigne(){
		Ecriture.ecrireStringln(fich,"aLaLigne");
	}
}
