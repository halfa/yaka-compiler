public abstract class YVM {
	
	/**
	 * Haut de pile : int / int
	 * Aditionne les deux éléments en sommet de pile 
	 */
	public void iadd(){};
	
	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void isub(){};
	
	/**
	 * Haut de pile : int / int
	 * Multiplie les deux éléments en haut de pile
	 */
	public void imul(){};

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void idiv(){};
	
	/**
	 * Haut de pile : bool
	 * Transforme l'élément (booléen) en haut de pile par son opposé
	 */
	public void inot(){};
	
	/**
	 * Haut de pile : int
	 * Transforme l'élément en haut de pile par son opposé
	 */
	public void ineg(){};
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test ET sur les deux éléments en haut de la pile
	 */
	public void iand(){};
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test OU sur les deux éléments en haut de la pile
	 */
	public void ior(){};

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void iinf(){};

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur au premier 
	 */
	public void isup(){};

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur ou égal au premier
	 */
	public void iinfegal(){};

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur ou égal au premier
	 */
	public void isupegal(){};

	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est égal au premier
	 */
	public void iegal(){};
	
	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void idiff(){};

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * @param valeur
	 */
	public void iconst(int valeur){};

	/**
	 * Haut de pile : anything
	 * Met la valeur se trouvant en sommet de pile dans la variable d'offset "offset"
	 * @param offset
	 */
	public void istore(int offset){};

	/**
	 * Haut de pile : anything
	 * Met en sommet de pile la valeur contenue dans la variable d'offset "offset"
	 * @param offset
	 */
	public void iload(int offset){};

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0.
	 * Si la valeur est 0, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void ifeq(String etiquette){};

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX.
	 * Si la valeur est FAUX, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void iffaux(String etiquette){};

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette"
	 * goto is a reserved word
	 * @param etiquette
	 */
	public void jump(String etiquette){};

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .asm
	 * Génère l'entete d'un fichier .asm
	 */
	public void entete(){}; 
	
	/**
	 * Permet de réserver directement un ensemble de variable dans la pile
	 * @param var
	 */
	public void ouvrePrinc(int var){}; 
	
	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .asm
	 * Génère la fin d'un fichier .asm
	 */
	public void queue(){};
}
