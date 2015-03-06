import java.io.OutputStream;

public class YVMasm extends YVM {
	private OutputStream nomFich;

	/**
	 * Haut de pile : int / int
	 * Aditionne les deux éléments en sommet de pile 
	 */
	public void iadd(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"add ax,bx");
		Ecriture.ecrireStringln(nomFich,"push bx");
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void isub(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"sub ax,bx");
		Ecriture.ecrireStringln(nomFich,"push bx");
	}

	/**
	 * Haut de pile : int / int
	 * Multiplie les deux éléments en haut de pile
	 */
	public void imul(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"imul bx");
		Ecriture.ecrireStringln(nomFich,"push bx");
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void idiv(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cwd");
		Ecriture.ecrireStringln(nomFich,"idiv bx");
		Ecriture.ecrireStringln(nomFich,"push bx");
	}

	/**
	 * Haut de pile : bool
	 * Transforme l'élément (booléen) en haut de pile par son opposé
	 */
	public void inot(){
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"and ax,FALSE");
		Ecriture.ecrireStringln(nomFich,"push ax");
	}
	
	/**
	 * Haut de pile : int
	 * Transforme l'élément en haut de pile par son opposé
	 */
	public void ineg(){
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"mov bx,-1");
		Ecriture.ecrireStringln(nomFich,"imul bx");
		Ecriture.ecrireStringln(nomFich,"push ax");
	}
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test ET sur les deux éléments en haut de la pile
	 */
	public void iand(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"and ax,bx");
		Ecriture.ecrireStringln(nomFich,"push ax");
	}

	/**
	 * Haut de pile : bool / bool
	 * Fait un test OU sur les deux éléments en haut de la pile
	 */
	public void ior(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"or ax,bx");
		Ecriture.ecrireStringln(nomFich,"push ax");
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void iinf(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"jge $+6");
		Ecriture.ecrireStringln(nomFich,"push TRUE");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push FALSE");
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur au premier 
	 */
	public void isup(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp bx,ax");
		Ecriture.ecrireStringln(nomFich,"jge $+6");
		Ecriture.ecrireStringln(nomFich,"push TRUE");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push FALSE");
	}
	
	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur ou égal au premier
	 */
	public void iinfegal(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"jg $+6");
		Ecriture.ecrireStringln(nomFich,"push TRUE");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push FALSE");
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur ou égal au premier
	 */
	public void isupegal(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp bx,ax");
		Ecriture.ecrireStringln(nomFich,"jg $+6");
		Ecriture.ecrireStringln(nomFich,"push TRUE");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push FALSE");
	}

	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est égal au premier
	 */
	public void iegal(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"jne $+6");
		Ecriture.ecrireStringln(nomFich,"push TRUE");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push FALSE");
	}

	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void idiff(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"je $+6");
		Ecriture.ecrireStringln(nomFich,"push TRUE");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push FALSE");
	}

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * @param valeur
	 */
	public void iconst(int valeur){
		Ecriture.ecrireStringln(nomFich,"push "+valeur);
	}
	
	/**
	 * Haut de pile : anything
	 * Met la valeur se trouvant en sommet de pile dans la variable d'offset "offset"
	 * @param offset
	 */
	public void istore(int offset){
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"mov word ptr[bp-"+offset+"],ax");
	}
	
	/**
	 * Haut de pile : anything
	 * Met en sommet de pile la valeur contenue dans la variable d'offset "offset"
	 * @param offset
	 */
	public void iload(int offset){
		Ecriture.ecrireStringln(nomFich,"push word ptr [bp-"+offset+"]");
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0.
	 * Si la valeur est 0, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"je "+etiquette);
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX.
	 * Si la valeur est FAUX, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,FALSE");
		Ecriture.ecrireStringln(nomFich,"je "+etiquette);
	}

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette"
	 * goto is a reserved word
	 * @param etiquette
	 */
	public void jump(String etiquette){
		Ecriture.ecrireStringln(nomFich,"jmp "+etiquette);
	}

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .asm
	 * Génère l'entete d'un fichier .asm
	 */
	public void entete(){
		Ecriture.ecrireStringln(nomFich,".model SMALL");
		Ecriture.ecrireStringln(nomFich,".586");
		Ecriture.ecrireStringln(nomFich,".DATA");
		Ecriture.ecrireStringln(nomFich,"FALSE EQU 0");
		Ecriture.ecrireStringln(nomFich,"TRUE EQU -1");
		Ecriture.ecrireStringln(nomFich,".CODE");
		Ecriture.ecrireStringln(nomFich,"debut :");
		Ecriture.ecrireStringln(nomFich,"	STARTUPCODE");
	}

	/**
	 * Permet de réserver directement un ensemble de variable dans la pile
	 * @param var
	 */
	public void ouvrePrinc(int var){
		Ecriture.ecrireStringln(nomFich,"mov bp,sp");
		Ecriture.ecrireStringln(nomFich,"sub sp,"+var);
	}

	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .asm
	 * Génère la fin d'un fichier .asm
	 */
	public void queue(){
		Ecriture.ecrireStringln(nomFich,"nop");
		Ecriture.ecrireStringln(nomFich,"exitcode");
		Ecriture.ecrireStringln(nomFich,"end debut");
	}
}
