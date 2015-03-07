import java.io.OutputStream;

public class YVM {
	private OutputStream fichYvm;
	
	/**
	 * Haut de pile : int / int
	 * Aditionne les deux éléments en sommet de pile 
	 */
	public void iadd(){
		Ecriture.ecrireStringln(fichYvm,"iadd");
	};
	
	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void isub(){
		Ecriture.ecrireStringln(fichYvm,"isub");
	};
	
	/**
	 * Haut de pile : int / int
	 * Multiplie les deux éléments en haut de pile
	 */
	public void imul(){
		Ecriture.ecrireStringln(fichYvm,"imul");
	};

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void idiv(){
		Ecriture.ecrireStringln(fichYvm,"idiv");
	};
	
	/**
	 * Haut de pile : bool
	 * Transforme l'élément en haut de pile en son opposé
	 */
	public void inot(){
		Ecriture.ecrireStringln(fichYvm,"inot");
	};
	
	/**
	 * Haut de pile : int
	 * Transforme l'élément en haut de pile en son opposé
	 */
	public void ineg(){
		Ecriture.ecrireStringln(fichYvm,"ineg");
	};
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test "ET" sur les deux éléments en haut de la pile
	 */
	public void iand(){
		Ecriture.ecrireStringln(fichYvm,"iand");
	};
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test "OU" sur les deux éléments en haut de la pile
	 */
	public void ior(){
		Ecriture.ecrireStringln(fichYvm,"ior");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void iinf(){
		Ecriture.ecrireStringln(fichYvm,"iinf");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est supérieur au premier 
	 */
	public void isup(){
		Ecriture.ecrireStringln(fichYvm,"isup");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur ou égal au premier
	 */
	public void iinfegal(){
		Ecriture.ecrireStringln(fichYvm,"iinfegal");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est supérieur ou égal au premier
	 */
	public void isupegal(){
		Ecriture.ecrireStringln(fichYvm,"isupegal");
	};

	/**
	 * Haut de pile : bool / bool
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est égal au premier
	 */
	public void iegal(){
		Ecriture.ecrireStringln(fichYvm,"iegal");
	};
	
	/**
	 * Haut de pile : bool / bool
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void idiff(){
		Ecriture.ecrireStringln(fichYvm,"idiff");
	};

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * @param valeur
	 */
	public void iconst(int valeur){
		Ecriture.ecrireStringln(fichYvm,"iconst "+valeur);
	};

	/**
	 * Haut de pile : anything
	 * Met la valeur se trouvant en sommet de pile dans la mémoiree à l'offset "offset"
	 * @param offset
	 */
	public void istore(int offset){
		Ecriture.ecrireStringln(fichYvm,"istore "+offset);
	};

	/**
	 * Haut de pile : anything
	 * Met en sommet de pile la valeur contenue dans la mémoire à l'offset "offset"
	 * @param offset
	 */
	public void iload(int offset){
		Ecriture.ecrireStringln(fichYvm,"iload "+offset);
	};

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0.
	 * Si la valeur est 0, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(fichYvm,"ifeq "+etiquette);
	};

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX.
	 * Si la valeur est FAUX, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(fichYvm,"iffaux "+etiquette);
	};

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette".
	 * L'instruction "goto" est un mot réservé en java, on utilise donc la dénomination "jump",
   * car il s'agit d'un saut inconditionel
	 * @param etiquette
	 */
	public void jump(String etiquette){
		Ecriture.ecrireStringln(fichYvm,"goto "+etiquette);
	};

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .asm
	 * Génère l'entête d'un fichier .asm
	 */
	public void entete(){
		Ecriture.ecrireStringln(fichYvm,"entete");
	}; 
	
	/**
	 * Permet de réserver directement un ensemble de variable dans la pile
	 * @param var
	 */
	public void ouvrePrinc(int var){
		Ecriture.ecrireStringln(fichYvm,"ouvrePrinc "+var);
	}; 
	
	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .asm
	 * Génère la fin d'un fichier .asm
	 */
	public void queue(){
		Ecriture.ecrireStringln(fichYvm,"queue");
	};
}
