import java.io.OutputStream;

public class YVMasm extends YVM {
	
	/**
	 * Constructeur d'un YVMasm à partir d'un OutputStream
	 * @param out
	 */
	public YVMasm (OutputStream out){
		super(out);
	}
	/**
	 * Haut de pile : int / int
	 * Aditionne les deux éléments en sommet de pile 
	 */
	public void iadd(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"add ax,bx");
		Ecriture.ecrireStringln(fich,"push bx");
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void isub(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"sub ax,bx");
		Ecriture.ecrireStringln(fich,"push bx");
	}

	/**
	 * Haut de pile : int / int
	 * Multiplie les deux éléments en haut de pile
	 */
	public void imul(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"imul bx");
		Ecriture.ecrireStringln(fich,"push bx");
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void idiv(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"cwd");
		Ecriture.ecrireStringln(fich,"idiv bx");
		Ecriture.ecrireStringln(fich,"push bx");
	}

	/**
	 * Haut de pile : bool
	 * Transforme l'élément (booléen) en haut de pile par son opposé
	 */
	public void inot(){
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"and ax,FALSE");
		Ecriture.ecrireStringln(fich,"push ax");
	}
	
	/**
	 * Haut de pile : int
	 * Transforme l'élément en haut de pile par son opposé
	 */
	public void ineg(){
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"mov bx,-1");
		Ecriture.ecrireStringln(fich,"imul bx");
		Ecriture.ecrireStringln(fich,"push ax");
	}
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test ET sur les deux éléments en haut de la pile
	 */
	public void iand(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"and ax,bx");
		Ecriture.ecrireStringln(fich,"push ax");
	}

	/**
	 * Haut de pile : bool / bool
	 * Fait un test OU sur les deux éléments en haut de la pile
	 */
	public void ior(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"or ax,bx");
		Ecriture.ecrireStringln(fich,"push ax");
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void iinf(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"cmp ax,bx");
		Ecriture.ecrireStringln(fich,"jge $+6");
		Ecriture.ecrireStringln(fich,"push TRUE");
		Ecriture.ecrireStringln(fich,"jmp $+4");
		Ecriture.ecrireStringln(fich,"push FALSE");
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur au premier 
	 */
	public void isup(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"cmp bx,ax");
		Ecriture.ecrireStringln(fich,"jge $+6");
		Ecriture.ecrireStringln(fich,"push TRUE");
		Ecriture.ecrireStringln(fich,"jmp $+4");
		Ecriture.ecrireStringln(fich,"push FALSE");
	}
	
	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur ou égal au premier
	 */
	public void iinfegal(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"cmp ax,bx");
		Ecriture.ecrireStringln(fich,"jg $+6");
		Ecriture.ecrireStringln(fich,"push TRUE");
		Ecriture.ecrireStringln(fich,"jmp $+4");
		Ecriture.ecrireStringln(fich,"push FALSE");
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur ou égal au premier
	 */
	public void isupegal(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"cmp bx,ax");
		Ecriture.ecrireStringln(fich,"jg $+6");
		Ecriture.ecrireStringln(fich,"push TRUE");
		Ecriture.ecrireStringln(fich,"jmp $+4");
		Ecriture.ecrireStringln(fich,"push FALSE");
	}

	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est égal au premier
	 */
	public void iegal(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"cmp ax,bx");
		Ecriture.ecrireStringln(fich,"jne $+6");
		Ecriture.ecrireStringln(fich,"push TRUE");
		Ecriture.ecrireStringln(fich,"jmp $+4");
		Ecriture.ecrireStringln(fich,"push FALSE");
	}

	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void idiff(){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"cmp ax,bx");
		Ecriture.ecrireStringln(fich,"je $+6");
		Ecriture.ecrireStringln(fich,"push TRUE");
		Ecriture.ecrireStringln(fich,"jmp $+4");
		Ecriture.ecrireStringln(fich,"push FALSE");
	}

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * @param valeur
	 */
	public void iconst(int valeur){
		Ecriture.ecrireStringln(fich,"push "+valeur);
	}
	
	/**
	 * Haut de pile : anything
	 * Met la valeur se trouvant en sommet de pile dans la variable d'offset "offset"
	 * @param offset
	 */
	public void istore(int offset){
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"mov word ptr[bp-"+offset+"],ax");
	}
	
	/**
	 * Haut de pile : anything
	 * Met en sommet de pile la valeur contenue dans la variable d'offset "offset"
	 * @param offset
	 */
	public void iload(int offset){
		Ecriture.ecrireStringln(fich,"push word ptr [bp-"+offset+"]");
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0.
	 * Si la valeur est 0, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(fich,"pop bx");
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"cmp ax,bx");
		Ecriture.ecrireStringln(fich,"je "+etiquette);
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX.
	 * Si la valeur est FAUX, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(fich,"pop ax");
		Ecriture.ecrireStringln(fich,"cmp ax,FALSE");
		Ecriture.ecrireStringln(fich,"je "+etiquette);
	}

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette"
	 * goto is a reserved word
	 * @param etiquette
	 */
	public void jump(String etiquette){
		Ecriture.ecrireStringln(fich,"jmp "+etiquette);
	}

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .asm
	 * Génère l'entete d'un fichier .asm
	 */
	public void entete(){
		Ecriture.ecrireStringln(fich,".model SMALL");
		Ecriture.ecrireStringln(fich,".586");
		Ecriture.ecrireStringln(fich,".DATA");
		Ecriture.ecrireStringln(fich,"FALSE EQU 0");
		Ecriture.ecrireStringln(fich,"TRUE EQU -1");
		Ecriture.ecrireStringln(fich,".CODE");
		Ecriture.ecrireStringln(fich,"debut :");
		Ecriture.ecrireStringln(fich,"	STARTUPCODE");
	}

	/**
	 * Permet de réserver directement un ensemble de variable dans la pile
	 * @param var
	 */
	public void ouvrePrinc(int var){
		Ecriture.ecrireStringln(fich,"mov bp,sp");
		Ecriture.ecrireStringln(fich,"sub sp,"+var);
	}

	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .asm
	 * Génère la fin d'un fichier .asm
	 */
	public void queue(){
		Ecriture.ecrireStringln(fich,"nop");
		Ecriture.ecrireStringln(fich,"exitcode");
		Ecriture.ecrireStringln(fich,"end debut");
	}
}
