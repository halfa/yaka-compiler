public class YVMasm extends YVM {
	
	/**
	 * Constructeur par défaut d'un YVMasm vide
	 */
	public YVMasm(){
		super();
	}
	
	/**
	 * Constructeur d'un YVMasm à partir d'une chaine de caratères
	 * @param name
	 */
	public YVMasm (String name){
		super(name);
	}
	
	/**
	 * Haut de pile : int / int
	 * Aditionne les deux éléments en sommet de pile 
	 */
	public void iadd(){
		Ecriture.ecrireStringln(flux,";iadd",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"add ax,bx",1);
		Ecriture.ecrireStringln(flux,"push bx",1);
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void isub(){
		Ecriture.ecrireStringln(flux,";isub",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"sub ax,bx",1);
		Ecriture.ecrireStringln(flux,"push bx",1);
	}

	/**
	 * Haut de pile : int / int
	 * Multiplie les deux éléments en haut de pile
	 */
	public void imul(){
		Ecriture.ecrireStringln(flux,";imul",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"imul bx",1);
		Ecriture.ecrireStringln(flux,"push bx",1);
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void idiv(){
		Ecriture.ecrireStringln(flux,";idiv",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"cwd",1);
		Ecriture.ecrireStringln(flux,"idiv bx",1);
		Ecriture.ecrireStringln(flux,"push bx",1);
	}

	/**
	 * Haut de pile : bool
	 * Transforme l'élément (booléen) en haut de pile par son opposé
	 */
	public void inot(){
		Ecriture.ecrireStringln(flux,";inot",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"and ax,FALSE",1);
		Ecriture.ecrireStringln(flux,"push ax",1);
	}
	
	/**
	 * Haut de pile : int
	 * Transforme l'élément en haut de pile par son opposé
	 */
	public void ineg(){
		Ecriture.ecrireStringln(flux,";ineg",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"mov bx,-1",1);
		Ecriture.ecrireStringln(flux,"imul bx",1);
		Ecriture.ecrireStringln(flux,"push ax",1);
	}
	
	/**
	 * Haut de pile : bool / bool
	 * Fait un test ET sur les deux éléments en haut de la pile
	 */
	public void iand(){
		Ecriture.ecrireStringln(flux,";iand",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"and ax,bx",1);
		Ecriture.ecrireStringln(flux,"push ax",1);
	}

	/**
	 * Haut de pile : bool / bool
	 * Fait un test OU sur les deux éléments en haut de la pile
	 */
	public void ior(){
		Ecriture.ecrireStringln(flux,";ior",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"or ax,bx",1);
		Ecriture.ecrireStringln(flux,"push ax",1);
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void iinf(){
		Ecriture.ecrireStringln(flux,";iinf",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"cmp ax,bx",1);
		Ecriture.ecrireStringln(flux,"jge $+6",1);
		Ecriture.ecrireStringln(flux,"push TRUE",1);
		Ecriture.ecrireStringln(flux,"jmp $+4",1);
		Ecriture.ecrireStringln(flux,"push FALSE",1);
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur au premier 
	 */
	public void isup(){
		Ecriture.ecrireStringln(flux,";iinf",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"cmp bx,ax",1);
		Ecriture.ecrireStringln(flux,"jge $+6",1);
		Ecriture.ecrireStringln(flux,"push TRUE",1);
		Ecriture.ecrireStringln(flux,"jmp $+4",1);
		Ecriture.ecrireStringln(flux,"push FALSE",1);
	}
	
	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur ou égal au premier
	 */
	public void iinfegal(){
		Ecriture.ecrireStringln(flux,";iinfegal",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"cmp ax,bx",1);
		Ecriture.ecrireStringln(flux,"jg $+6",1);
		Ecriture.ecrireStringln(flux,"push TRUE",1);
		Ecriture.ecrireStringln(flux,"jmp $+4",1);
		Ecriture.ecrireStringln(flux,"push FALSE",1);
	}

	/**
	 * Haut de pile : int / int
	 * Met TRUE en haut de pile si le deuxième élément de la pile est supérieur ou égal au premier
	 */
	public void isupegal(){
		Ecriture.ecrireStringln(flux,";isupegal",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"cmp bx,ax",1);
		Ecriture.ecrireStringln(flux,"jg $+6",1);
		Ecriture.ecrireStringln(flux,"push TRUE",1);
		Ecriture.ecrireStringln(flux,"jmp $+4",1);
		Ecriture.ecrireStringln(flux,"push FALSE",1);
	}

	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est égal au premier
	 */
	public void iegal(){
		Ecriture.ecrireStringln(flux,";iegal",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"cmp ax,bx",1);
		Ecriture.ecrireStringln(flux,"jne $+6",1);
		Ecriture.ecrireStringln(flux,"push TRUE",1);
		Ecriture.ecrireStringln(flux,"jmp $+4",1);
		Ecriture.ecrireStringln(flux,"push FALSE",1);
	}

	/**
	 * Haut de pile : bool / bool
	 * Met TRUE en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void idiff(){
		Ecriture.ecrireStringln(flux,";idiff",1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"cmp ax,bx",1);
		Ecriture.ecrireStringln(flux,"je $+6",1);
		Ecriture.ecrireStringln(flux,"push TRUE",1);
		Ecriture.ecrireStringln(flux,"jmp $+4",1);
		Ecriture.ecrireStringln(flux,"push FALSE",1);
	}

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * @param valeur
	 */
	public void iconst(int valeur){
		Ecriture.ecrireStringln(flux,";iconst "+valeur,1);
		Ecriture.ecrireStringln(flux,"push "+valeur,1);
	}
	
	/**
	 * Haut de pile : anything
	 * Met la valeur se trouvant en sommet de pile dans la variable d'offset "offset"
	 * @param offset
	 */
	public void istore(int offset){
		Ecriture.ecrireStringln(flux,";istore "+offset,1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"mov word ptr[bp-"+offset+"],ax",1);
	}
	
	/**
	 * Haut de pile : anything
	 * Met en sommet de pile la valeur contenue dans la variable d'offset "offset"
	 * @param offset
	 */
	public void iload(int offset){
		Ecriture.ecrireStringln(flux,";iload "+offset,1);
		Ecriture.ecrireStringln(flux,"push word ptr [bp-"+offset+"]",1);
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0.
	 * Si la valeur est 0, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(flux,";ifeq "+etiquette,1);
		Ecriture.ecrireStringln(flux,"pop bx",1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"cmp ax,bx",1);
		Ecriture.ecrireStringln(flux,"je "+etiquette,1);
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX.
	 * Si la valeur est FAUX, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(flux,";iffaux "+etiquette,1);
		Ecriture.ecrireStringln(flux,"pop ax",1);
		Ecriture.ecrireStringln(flux,"cmp ax,FALSE",1);
		Ecriture.ecrireStringln(flux,"je "+etiquette,1);
	}

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette"
	 * goto is a reserved word
	 * @param etiquette
	 */
	public void jump(String etiquette){
		Ecriture.ecrireStringln(flux,";jump "+etiquette,1);
		Ecriture.ecrireStringln(flux,"jmp "+etiquette,1);
	}

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .asm
	 * Génère l'entete d'un fichier .asm
	 */
	public void entete(){
		Ecriture.ecrireStringln(flux,";entete",1);
		Ecriture.ecrireStringln(flux,"extrn lirent:proc",1);
		Ecriture.ecrireStringln(flux,"extrn ecrent:proc",1);
		Ecriture.ecrireStringln(flux,"extrn ecrbool:proc",1);
		Ecriture.ecrireStringln(flux,"extrn ecrch:proc",1);
		Ecriture.ecrireStringln(flux,"extrn ligsuiv:proc",1);
		Ecriture.ecrireStringln(flux,".model SMALL",0);
		Ecriture.ecrireStringln(flux,".586",0);
		Ecriture.ecrireStringln(flux,".DATA",0);
		Ecriture.ecrireStringln(flux,"FALSE EQU 0",1);
		Ecriture.ecrireStringln(flux,"TRUE EQU -1",1);
		Ecriture.ecrireStringln(flux,".CODE",0);
		Ecriture.ecrireStringln(flux,"debut :",0);
		Ecriture.ecrireStringln(flux,"STARTUPCODE",1);
	}

	/**
	 * Permet de réserver directement un ensemble de variable dans la pile
	 * @param var
	 */
	public void ouvrePrinc(int var){
		Ecriture.ecrireStringln(flux,";ouvrePrinc "+var,1);
		Ecriture.ecrireStringln(flux,"mov bp,sp",1);
		Ecriture.ecrireStringln(flux,"sub sp,"+var,1);
	}

	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .asm
	 * Génère la fin d'un fichier .asm
	 */
	public void queue(){
		Ecriture.ecrireStringln(flux,";queue",1);
		Ecriture.ecrireStringln(flux,"nop",1);
		Ecriture.ecrireStringln(flux,"EXITCODE",1);
		Ecriture.ecrireStringln(flux,"end debut",1);
		Ecriture.fermer(flux);
	}
	
	/**
	 * Permet d'afficher à l'écran la chaine de caractères placée en paramètre
	 * @param chaine
	 */
	public void ecrireChaine(String chaine){
		Ecriture.ecrireStringln(flux,"	;ecrireChaine \""+chaine+"\"");
		Ecriture.ecrireStringln(flux,".DATA");
		//ajout de "$" comme caractère de fin de chaine
		Ecriture.ecrireStringln(flux,"	mess0 DB \""+chaine+"$\"");
		Ecriture.ecrireStringln(flux,".CODE");
		Ecriture.ecrireStringln(flux,"	lea dx, mess0");
		Ecriture.ecrireStringln(flux,"	push dx");
		Ecriture.ecrireStringln(flux,"	call ecrch");
	}
	
	/**
	 * Permet d'afficher à l'écran l'entier en sommet de pile
	 */
	public void ecrireEnt(){
		Ecriture.ecrireStringln(flux,"	;ecrireEnt");
		Ecriture.ecrireStringln(flux,"	call ecrent");
	}
	
	/**
	 * Permet d'afficher à l'écran le booleen en sommet de pile
	 */
	public void ecrireBool(){
		Ecriture.ecrireStringln(flux,"	;ecrireBool");
		Ecriture.ecrireStringln(flux,"	call ecrbool");
	}
	
	/**
	 * Lit l'entier tapé au clavier et le place dans la mémoire à l'offset "offset"
	 */
	public void lireEnt(int offset){
		Ecriture.ecrireStringln(flux,"	;lireEnt "+offset);
		Ecriture.ecrireStringln(flux,"	lea dx,[bp-4]");
		Ecriture.ecrireStringln(flux,"	push dx");
		Ecriture.ecrireStringln(flux,"	call lirent");
	}
	
	/**
	 * Va à la ligne
	 */
	public void aLaLigne(){
		Ecriture.ecrireStringln(flux,"	;aLaLigne");
		Ecriture.ecrireStringln(flux,"	call ligsuiv");
	}
}
