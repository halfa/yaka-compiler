package compiler;

public class YVMasm extends YVM {
	
	private int compteurChaine = 0;

	/**
	 * Constructeur par défaut d'un YVMasm vide
	 */
	public YVMasm() {
		super();
	}

	/**
	 * Constructeur d'un YVMasm à partir d'une chaine de caratères
	 * 
	 * @param name
	 */
	public YVMasm(String name) {
		super(name);
	}
	
	public void begin_principal(){
		Ecriture.ecrireStringln(flux, "debut :",indent);
		Ecriture.ecrireStringln(flux, "STARTUPCODE",indent);
		Ecriture.ecrireStringln(flux,"main :",0);
	}
	
	public void begin_function(String name){
		Ecriture.ecrireStringln(flux, name + " :",0);
	}
	
	/**
	 * En début de fonction, réserve la place pour le nombre de variables
	 * placé en paramètre
	 * @param var le nombre de variables
	 */
	public void ouvreBloc(int var){
		Ecriture.ecrireStringln(flux, ";ouvrebloc "+var*2, indent);
		Ecriture.ecrireStringln(flux, "enter "+var*2+",0",indent);
	}
	
	/**
	 * En fin de fonction, donne la taille du nombre de paramètres
	 * placé en paramètre
	 * @param param le nombre de paramètres
	 */
	public void fermeBloc(int param){
		Ecriture.ecrireStringln(flux, ";fermebloc "+param*2, indent);
		Ecriture.ecrireStringln(flux, "leave",indent);
		Ecriture.ecrireStringln(flux, "ret "+param*2);
	}
	
	/**
	 * Place le résultat de la fonction, qui en sommet de pile,
	 * à l'offset donné
	 * @param offset emplacement réservé lors de l'appel
	 */
	public void ireturn(int offset){
		Ecriture.ecrireStringln(flux,";ireturn "+offset,indent);
		Ecriture.ecrireStringln(flux,"pop ax",indent);
		Ecriture.ecrireStringln(flux,"mov [bp+"+offset+"], ax");
	}
	
	/**
	 * Instruction à appeler avant l'appel d'une fonction qui 
	 * retourne un résultat
	 */
	public void reserveRetour(){
		Ecriture.ecrireStringln(flux, ";reserveRetour", indent);
		Ecriture.ecrireStringln(flux, "sub sp,2", indent);
	}
	
	/**
	 * Instruction pour appeler la fonction de nom "nomFun"
	 * @param nomFun le nom de la fonction
	 */
	public void call(String nomFun){
		Ecriture.ecrireStringln(flux, ";call "+nomFun, indent);
		Ecriture.ecrireStringln(flux, "call "+nomFun,indent);
	}

	/**
	 * Retourne la chaine extention du fichier associé au language ASM.
	 * 
	 * @return l'extension, point compris
	 */
	public String getFileExtension() {
		return ".asm";
	}

	/**
	 * Haut de pile : int / int Aditionne les deux éléments en sommet de pile
	 */
	public void iadd() {
		Ecriture.ecrireStringln(flux, ";iadd",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "add ax,bx",indent);
		Ecriture.ecrireStringln(flux, "push ax",indent);
	}

	/**
	 * Haut de pile : int / int Soustrait le deuxième élément de la pile par le
	 * premier
	 */
	public void isub() {
		Ecriture.ecrireStringln(flux, ";isub",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "sub ax,bx",indent);
		Ecriture.ecrireStringln(flux, "push ax",indent);
	}

	/**
	 * Haut de pile : int / int Multiplie les deux éléments en haut de pile
	 */
	public void imul() {
		Ecriture.ecrireStringln(flux, ";imul",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "imul bx",indent);
		Ecriture.ecrireStringln(flux, "push ax",indent);
	}

	/**
	 * Haut de pile : int / int Soustrait le deuxième élément de la pile par le
	 * premier
	 */
	public void idiv() {
		Ecriture.ecrireStringln(flux, ";idiv",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "cwd",indent);
		Ecriture.ecrireStringln(flux, "idiv bx",indent);
		Ecriture.ecrireStringln(flux, "push ax",indent);
	}

	/**
	 * Haut de pile : bool Transforme l'élément (booléen) en haut de pile en
	 * son opposé
	 */
	public void inot() {
		Ecriture.ecrireStringln(flux, ";inot",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "and ax,FALSE",indent);
		Ecriture.ecrireStringln(flux, "push ax",indent);
	}

	/**
	 * Haut de pile : int Transforme l'élément en haut de pile en son opposé
	 */
	public void ineg() {
		Ecriture.ecrireStringln(flux, ";ineg",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "mov bx,-1",indent);
		Ecriture.ecrireStringln(flux, "imul bx",indent);
		Ecriture.ecrireStringln(flux, "push ax",indent);
	}

	/**
	 * Haut de pile : bool / bool Fait un test ET sur les deux éléments en haut
	 * de la pile
	 */
	public void iand() {
		Ecriture.ecrireStringln(flux, ";iand",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "and ax,bx",indent);
		Ecriture.ecrireStringln(flux, "push ax",indent);
	}

	/**
	 * Haut de pile : bool / bool Fait un test OU sur les deux éléments en haut
	 * de la pile
	 */
	public void ior() {
		Ecriture.ecrireStringln(flux, ";ior",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "or ax,bx",indent);
		Ecriture.ecrireStringln(flux, "push ax",indent);
	}

	/**
	 * Haut de pile : int / int Met TRUE en haut de pile si le deuxième élément
	 * de la pile est inférieur au premier
	 */
	public void iinf() {
		Ecriture.ecrireStringln(flux, ";iinf",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "cmp ax,bx",indent);
		Ecriture.ecrireStringln(flux, "jge $+6",indent);
		Ecriture.ecrireStringln(flux, "push TRUE",indent);
		Ecriture.ecrireStringln(flux, "jmp $+4",indent);
		Ecriture.ecrireStringln(flux, "push FALSE",indent);
	}

	/**
	 * Haut de pile : int / int Met TRUE en haut de pile si le deuxième élément
	 * de la pile est supérieur au premier
	 */
	public void isup() {
		Ecriture.ecrireStringln(flux, ";iinf",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "cmp bx,ax",indent);
		Ecriture.ecrireStringln(flux, "jge $+6",indent);
		Ecriture.ecrireStringln(flux, "push TRUE",indent);
		Ecriture.ecrireStringln(flux, "jmp $+4",indent);
		Ecriture.ecrireStringln(flux, "push FALSE",indent);
	}

	/**
	 * Haut de pile : int / int Met TRUE en haut de pile si le deuxième élément
	 * de la pile est inférieur ou égal au premier
	 */
	public void iinfegal() {
		Ecriture.ecrireStringln(flux, ";iinfegal",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "cmp ax,bx",indent);
		Ecriture.ecrireStringln(flux, "jg $+6",indent);
		Ecriture.ecrireStringln(flux, "push TRUE",indent);
		Ecriture.ecrireStringln(flux, "jmp $+4",indent);
		Ecriture.ecrireStringln(flux, "push FALSE",indent);
	}

	/**
	 * Haut de pile : int / int Met TRUE en haut de pile si le deuxième élément
	 * de la pile est supérieur ou égal au premier
	 */
	public void isupegal() {
		Ecriture.ecrireStringln(flux, ";isupegal",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "cmp bx,ax",indent);
		Ecriture.ecrireStringln(flux, "jg $+6",indent);
		Ecriture.ecrireStringln(flux, "push TRUE",indent);
		Ecriture.ecrireStringln(flux, "jmp $+4",indent);
		Ecriture.ecrireStringln(flux, "push FALSE",indent);
	}

	/**
	 * Haut de pile : bool / bool Met TRUE en haut de pile si le deuxième
	 * élément de la pile est égal au premier
	 */
	public void iegal() {
		Ecriture.ecrireStringln(flux, ";iegal",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "cmp ax,bx",indent);
		Ecriture.ecrireStringln(flux, "jne $+6",indent);
		Ecriture.ecrireStringln(flux, "push TRUE",indent);
		Ecriture.ecrireStringln(flux, "jmp $+4",indent);
		Ecriture.ecrireStringln(flux, "push FALSE",indent);
	}

	/**
	 * Haut de pile : bool / bool Met TRUE en haut de pile si le deuxième
	 * élément de la pile est inférieur au premier
	 */
	public void idiff() {
		Ecriture.ecrireStringln(flux, ";idiff",indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "cmp ax,bx",indent);
		Ecriture.ecrireStringln(flux, "je $+6",indent);
		Ecriture.ecrireStringln(flux, "push TRUE",indent);
		Ecriture.ecrireStringln(flux, "jmp $+4",indent);
		Ecriture.ecrireStringln(flux, "push FALSE",indent);
	}

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * 
	 * @param valeur
	 */
	public void iconst(int valeur) {
		Ecriture.ecrireStringln(flux, ";iconst " + valeur,indent);
		Ecriture.ecrireStringln(flux, "push " + valeur,indent);
	}

	/**
	 * Haut de pile : anything Met la valeur se trouvant en sommet de pile dans
	 * la variable d'offset "offset"
	 * 
	 * @param offset
	 */
	public void istore(int offset) {
		Ecriture.ecrireStringln(flux, ";istore " + offset,indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "mov word ptr[bp" + offset + "],ax",indent);
	}

	/**
	 * Haut de pile : anything Met en sommet de pile la valeur contenue dans la
	 * variable d'offset "offset"
	 * 
	 * @param offset
	 */
	public void iload(int offset) {
		Ecriture.ecrireStringln(flux, ";iload " + offset,indent);
		Ecriture.ecrireStringln(flux, "push word ptr [bp" + offset + "]",indent);
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0. Si la valeur est 0,
	 * alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * 
	 * @param etiquette
	 */
	public void ifeq(String etiquette) {
		Ecriture.ecrireStringln(flux, ";ifeq " + etiquette,indent);
		Ecriture.ecrireStringln(flux, "pop bx",indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "cmp ax,bx",indent);
		Ecriture.ecrireStringln(flux, "je " + etiquette,indent);
	}

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX. Si la valeur est
	 * FAUX, alors l'expression suivante exécutée se trouve à l'étiquette
	 * "etiquette"
	 * 
	 * @param etiquette
	 */
	public void iffaux(String etiquette) {
		Ecriture.ecrireStringln(flux, ";iffaux " + etiquette,indent);
		Ecriture.ecrireStringln(flux, "pop ax",indent);
		Ecriture.ecrireStringln(flux, "cmp ax,FALSE",indent);
		Ecriture.ecrireStringln(flux, "je " + etiquette,indent);
	}

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette"
	 * goto is a reserved word
	 * 
	 * @param etiquette
	 */
	public void jump(String etiquette) {
		Ecriture.ecrireStringln(flux, ";jump " + etiquette,indent);
		Ecriture.ecrireStringln(flux, "jmp " + etiquette,indent);
	}

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .asm Génère l'entete d'un fichier
	 * .asm
	 */
	public void entete() {
		Ecriture.ecrireStringln(flux, ";entete",indent);
		Ecriture.ecrireStringln(flux, "extrn lirent:proc",indent);
		Ecriture.ecrireStringln(flux, "extrn ecrent:proc",indent);
		Ecriture.ecrireStringln(flux, "extrn ecrbool:proc",indent);
		Ecriture.ecrireStringln(flux, "extrn ecrch:proc",indent);
		Ecriture.ecrireStringln(flux, "extrn ligsuiv:proc",indent);
		Ecriture.ecrireStringln(flux, ".model SMALL",0);
		Ecriture.ecrireStringln(flux, ".586",0);
		Ecriture.ecrireStringln(flux, ".DATA",0);
		Ecriture.ecrireStringln(flux, "FALSE EQU 0",indent);
		Ecriture.ecrireStringln(flux, "TRUE EQU -1",indent);
		Ecriture.ecrireStringln(flux, ".CODE",0);
	}

	/**
	 * Permet de réserver directement un ensemble de variable dans la pile
	 * 
	 * @param nbVar
	 */
	public void ouvrePrinc(int nbVar) {
		nbVar *= 2;
		Ecriture.ecrireStringln(flux, ";ouvrePrinc " + nbVar,indent);
		Ecriture.ecrireStringln(flux, "mov bp,sp",indent);
		Ecriture.ecrireStringln(flux, "sub sp," + nbVar,indent);
	}

	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .asm Génère la fin d'un fichier .asm
	 */
	public void queue() {
		Ecriture.ecrireStringln(flux, ";queue",indent);
		Ecriture.ecrireStringln(flux, "nop",indent);
		Ecriture.ecrireStringln(flux, "EXITCODE",indent);
		Ecriture.ecrireStringln(flux, "end debut",indent);
		Ecriture.fermer(flux);
	}

	/**
	 * Permet d'afficher à l'écran la chaine de caractères placée en paramètre
	 * 
	 * @param chaine
	 */
	public void ecrireChaine(String chaine) {
		Ecriture.ecrireStringln(flux, ";ecrireChaine \"" + chaine + "\"",indent);
		Ecriture.ecrireStringln(flux, ".DATA",indent);
		// ajout de "$" comme caractère de fin de chaine
		Ecriture.ecrireStringln(flux, "mess"+this.compteurChaine+" DB \"" + chaine + "$\"",indent);
		Ecriture.ecrireStringln(flux, ".CODE",indent);
		Ecriture.ecrireStringln(flux, "lea dx, mess"+compteurChaine,indent);
		compteurChaine++;
		Ecriture.ecrireStringln(flux, "push dx",indent);
		Ecriture.ecrireStringln(flux, "call ecrch",indent);
	}

	/**
	 * Permet d'afficher à l'écran l'entier en sommet de pile
	 */
	public void ecrireEnt() {
		Ecriture.ecrireStringln(flux, ";ecrireEnt",indent);
		Ecriture.ecrireStringln(flux, "call ecrent",indent);
	}

	/**
	 * Permet d'afficher à l'écran le booleen en sommet de pile
	 */
	public void ecrireBool() {
		Ecriture.ecrireStringln(flux, ";ecrireBool",indent);
		Ecriture.ecrireStringln(flux, "call ecrbool",indent);
	}

	/**
	 * Lit l'entier tapé au clavier et le place dans la mémoire à l'offset
	 * "offset"
	 */
	public void lireEnt(int offset) {
		Ecriture.ecrireStringln(flux, ";lireEnt " + offset,indent);
		Ecriture.ecrireStringln(flux, "lea dx,[bp"+offset+"]",indent);
		Ecriture.ecrireStringln(flux, "push dx",indent);
		Ecriture.ecrireStringln(flux, "call lirent",indent);
	}

	/**
	 * Va à la ligne
	 */
	public void aLaLigne() {
		Ecriture.ecrireStringln(flux, ";aLaLigne",indent);
		Ecriture.ecrireStringln(flux, "call ligsuiv",indent);
	}
}
