import java.io.OutputStream;

public class YVMasm extends YVM {
	private OutputStream fichAsm;

	/**
	 * Haut de pile : int / int
	 * Aditionne les deux éléments en sommet de pile 
	 */
	public void iadd(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"add ax,bx");
		Ecriture.ecrireStringln(fichAsm,"push bx");
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void isub(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"sub ax,bx");
		Ecriture.ecrireStringln(fichAsm,"push bx");
	}

	/**
	 * Haut de pile : int / int
	 * Multiplie les deux éléments en haut de pile
	 */
	public void imul(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"imul bx");
		Ecriture.ecrireStringln(fichAsm,"push bx");
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void idiv(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"cwd");
		Ecriture.ecrireStringln(fichAsm,"idiv bx");
		Ecriture.ecrireStringln(fichAsm,"push bx");
	}

	/**
	 * Haut de pile : bool
	 * Transforme l'élément (booléen) en haut de pile par son opposé
	 */
	public void inot(){
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"and ax,FALSE");
		Ecriture.ecrireStringln(fichAsm,"push ax");
	}
	
	/**
	 * Haut de pile : int
	 * Transforme l'élément en haut de pile par son opposé
	 */
	public void ineg(){
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"mov bx,-1");
		Ecriture.ecrireStringln(fichAsm,"imul bx");
		Ecriture.ecrireStringln(fichAsm,"push ax");
	}
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test ET sur les deux éléments en haut de la pile
	 */
	public void iand(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"and ax,bx");
		Ecriture.ecrireStringln(fichAsm,"push ax");
	}

	/**
	 * Haut de pile : bool / bool
	 * Fait un test OU sur les deux éléments en haut de la pile
	 */
	public void ior(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"or ax,bx");
		Ecriture.ecrireStringln(fichAsm,"push ax");
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void iinf(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"cmp ax,bx");
		Ecriture.ecrireStringln(fichAsm,"jge $+6");
		Ecriture.ecrireStringln(fichAsm,"push TRUE");
		Ecriture.ecrireStringln(fichAsm,"jmp $+4");
		Ecriture.ecrireStringln(fichAsm,"push FALSE");
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur au premier 
	 */
	public void isup(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"cmp bx,ax");
		Ecriture.ecrireStringln(fichAsm,"jge $+6");
		Ecriture.ecrireStringln(fichAsm,"push TRUE");
		Ecriture.ecrireStringln(fichAsm,"jmp $+4");
		Ecriture.ecrireStringln(fichAsm,"push FALSE");
	}
	
	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur ou égal au premier
	 */
	public void iinfegal(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"cmp ax,bx");
		Ecriture.ecrireStringln(fichAsm,"jg $+6");
		Ecriture.ecrireStringln(fichAsm,"push TRUE");
		Ecriture.ecrireStringln(fichAsm,"jmp $+4");
		Ecriture.ecrireStringln(fichAsm,"push FALSE");
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur ou égal au premier
	 */
	public void isupegal(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"cmp bx,ax");
		Ecriture.ecrireStringln(fichAsm,"jg $+6");
		Ecriture.ecrireStringln(fichAsm,"push TRUE");
		Ecriture.ecrireStringln(fichAsm,"jmp $+4");
		Ecriture.ecrireStringln(fichAsm,"push FALSE");
	}

	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est égal au premier
	 */
	public void iegal(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"cmp ax,bx");
		Ecriture.ecrireStringln(fichAsm,"jne $+6");
		Ecriture.ecrireStringln(fichAsm,"push TRUE");
		Ecriture.ecrireStringln(fichAsm,"jmp $+4");
		Ecriture.ecrireStringln(fichAsm,"push FALSE");
	}

	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void idiff(){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"cmp ax,bx");
		Ecriture.ecrireStringln(fichAsm,"je $+6");
		Ecriture.ecrireStringln(fichAsm,"push TRUE");
		Ecriture.ecrireStringln(fichAsm,"jmp $+4");
		Ecriture.ecrireStringln(fichAsm,"push FALSE");
	}

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * @param valeur
	 */
	public void iconst(int valeur){
		Ecriture.ecrireStringln(fichAsm,"push "+valeur);
	}
	
	/**
	 * Haut de pile : anything
	 * Met la valeur se trouvant en sommet de pile dans la variable d'offset "offset"
	 * @param offset
	 */
	public void istore(int offset){
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"mov word ptr[bp-"+offset+"],ax");
	}
	
	/**
	 * Haut de pile : anything
	 * Met en sommet de pile la valeur contenue dans la variable d'offset "offset"
	 * @param offset
	 */
	public void iload(int offset){
		Ecriture.ecrireStringln(fichAsm,"push word ptr [bp-"+offset+"]");
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0.
	 * Si la valeur est 0, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(fichAsm,"pop bx");
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"cmp ax,bx");
		Ecriture.ecrireStringln(fichAsm,"je "+etiquette);
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX.
	 * Si la valeur est FAUX, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(fichAsm,"pop ax");
		Ecriture.ecrireStringln(fichAsm,"cmp ax,FALSE");
		Ecriture.ecrireStringln(fichAsm,"je "+etiquette);
	}

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette"
	 * goto is a reserved word
	 * @param etiquette
	 */
	public void jump(String etiquette){
		Ecriture.ecrireStringln(fichAsm,"jmp "+etiquette);
	}

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .asm
	 * Génère l'entete d'un fichier .asm
	 */
	public void entete(){
		Ecriture.ecrireStringln(fichAsm,".model SMALL");
		Ecriture.ecrireStringln(fichAsm,".586");
		Ecriture.ecrireStringln(fichAsm,".DATA");
		Ecriture.ecrireStringln(fichAsm,"FALSE EQU 0");
		Ecriture.ecrireStringln(fichAsm,"TRUE EQU -1");
		Ecriture.ecrireStringln(fichAsm,".CODE");
		Ecriture.ecrireStringln(fichAsm,"debut :");
		Ecriture.ecrireStringln(fichAsm,"	STARTUPCODE");
	}

	/**
	 * Permet de réserver directement un ensemble de variable dans la pile
	 * @param var
	 */
	public void ouvrePrinc(int var){
		Ecriture.ecrireStringln(fichAsm,"mov bp,sp");
		Ecriture.ecrireStringln(fichAsm,"sub sp,"+var);
	}

	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .asm
	 * Génère la fin d'un fichier .asm
	 */
	public void queue(){
		Ecriture.ecrireStringln(fichAsm,"nop");
		Ecriture.ecrireStringln(fichAsm,"exitcode");
		Ecriture.ecrireStringln(fichAsm,"end debut");
	}
}
