package compiler;

import exception.*;

/**
 * Générateur et librairie pour le compilateur.
 * 
 * @see Yaka.jj
 */
public class Make {

	/*************************************
	 * Analyse syntaxique et déclarations.
	 ************************************/
	public static void begin_program() {
		// Crée le fichier en utilisant * le nom fourni en début de programme
		//                              * l'extension du language utilisé
		Yaka.yvm = new YVMasm(YakaTokenManager.identLu);
		Yaka.expression = new Expression(Yaka.yvm);
		Yaka.yvm.entete();
	}
	
	public static void begin_principal(){
		Yaka.yvm.begin_principal();
	}
	
	public static void startIf(){
		Yaka.yvm.startIf();
	}
	public static void condIf(){
		Yaka.yvm.condIf();
	}
	public static void elseIf(){
		Yaka.yvm.elseIf();
	}

	public static void endIf(){
		Yaka.yvm.endIf();
	}
	
	public static void end_program(){
		Yaka.yvm.queue();
	}
	
	public static void startLoop(){
		Yaka.yvm.startLoop();
	}
	
	public static void endLoop(){
		Yaka.yvm.endLoop();
	}
	
	public static void condLoop(){
		Yaka.yvm.condLoop();
	}

	public static void how_fat_are_you() {
		Yaka.yvm.ouvrePrinc(Declaration.getNbVariables());
	}

	public static void define_constant() {
		Declaration.setCurrentIdent(YakaTokenManager.identLu);
	}

	public static void define_int() {
		Declaration.createConst(YakaTokenManager.entierLu, Type.INTEGER);
	}

	public static void define_ident() {
		try {
			Declaration.createConst(YakaTokenManager.identLu);
		} catch (DeclarationException e) {
			e.printStackTrace();
		}
	}

	public static void define_true() {
		Declaration.createConst(-1, Type.BOOLEAN);
	}

	public static void define_false() {
		Declaration.createConst(0, Type.BOOLEAN);
	}

	public static void create_var() {
		Declaration.createVar(YakaTokenManager.identLu);
	}

	public static void declare_var_bool() {
		Declaration.setCurrentType(Type.BOOLEAN);
	}

	public static void declare_var_int() {
		Declaration.setCurrentType(Type.INTEGER);
	}

	/***************************
	 * Syntaxe des expressions.
	 ***************************/
	public static void reading() {
		try {
			Yaka.yvm.lireEnt(((IdVar) (TabIdent
					.getIdent(YakaTokenManager.identLu))).getOffset());
		} catch (UnknownIdentException e) {
			e.printStackTrace();
		}

	}

	public static void assignment() {
		Ident i;
		try {
			i = TabIdent.getIdent(Declaration.getCurrentIdent());

			Yaka.yvm.istore(((IdVar) i).getOffset());
		} catch (UnknownIdentException e) {
			e.printStackTrace();
		}

	}

	public static void write_expression() {
		Yaka.yvm.ecrireEnt();
	}

	public static void write_string() {
		// Enlève touts les guillemets dans la chaine
		Yaka.yvm.ecrireChaine(YakaTokenManager.chaineLue.replaceAll("\"",""));
	}

	public static void aLaLigne() {
		Yaka.yvm.aLaLigne();
	}

	public static void whatRel(){
		try {
			Yaka.expression.whatRel();
		} catch (YakaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void whatAdd() {
		try {
			Yaka.expression.whatAdd();
		} catch (YakaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void whatMul() {
		try {
			Yaka.expression.whatMul();
		} catch (YakaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void whatNeg() {
		try {
			Yaka.expression.whatNeg();
		} catch (YakaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void value_int() {
		Yaka.yvm.iconst(YakaTokenManager.entierLu);
	}

	public static void value_ident() {
		Ident id;
		try {
			id = TabIdent.getIdent(YakaTokenManager.identLu);

			if (id instanceof IdVar) {
				Yaka.yvm.iload(((IdVar) TabIdent
						.getIdent(YakaTokenManager.identLu)).getOffset());
			} else {
				Yaka.yvm.iconst(((IdConst) TabIdent
						.getIdent(YakaTokenManager.identLu)).getVal());
			}
		} catch (UnknownIdentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void value_true() {
		Yaka.yvm.iconst(-1);
	}

	public static void value_false() {
		Yaka.yvm.iconst(0);
	}
	
	//ceci est un commentaire utile qui aide à la compréhension
	/**
	 * A appeler après la lecture du token RETOURNE
	 */
	public static void putReturn(){
		//vide
	}
	
	/**
	 * Appelle la fonction
	 */
	public static void callFun(){
		
	}
	
	/**
	 * Stocke le nom de la fonction
	 */
	public static void begin_function_call(){
		
	}
	
	/**
	 * Créé une nouvelle fonction
	 */
	public static void create_fun(){
		Declaration.createFun(YakaTokenManager.identLu);
	}
	
	/**
	 * Créé un nouveau paramètre à la fonction courante
	 */
	public static void new_param(){
		Declaration.addParamter(YakaTokenManager.identLu);
	}
}
