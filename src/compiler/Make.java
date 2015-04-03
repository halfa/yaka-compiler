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
		Yaka.yvm = new YVM(YakaTokenManager.identLu);
		Yaka.expression = new Expression(Yaka.yvm);
		Yaka.yvm.entete();
	}

	public static void begin_principal(){
		Declaration.setCurrentFunction(new IdFPrinc());
		Declaration.setNameCurrentFunction("main");
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
	
	public static void evaluate(){
		try {
			Yaka.expression.evaluate();
		} catch (YakaException e) {
			// TODO Bloc catch généré automatiquement
			//Sy
			System.out.println(e.toString());
		}
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
		Yaka.yvm.ouvreBloc(TabIdent.countLocalVars());
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
			System.out.println(e.toString());
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
			System.out.println(e.toString());
		}

	}

	public static void assignment() {
		Ident i;
		try {
			i = TabIdent.getIdent(Declaration.getCurrentIdent());

			Yaka.yvm.istore(((IdVar) i).getOffset());
		} catch (UnknownIdentException e) {
			System.out.println(e.toString());
		}

	}

	public static void write_expression(Expression e) {
		switch (e.getCurrentType()){
		case BOOLEAN :
			Yaka.yvm.ecrireBool();
			break;
		case INTEGER :
			Yaka.yvm.ecrireEnt();
			break;
		default :
			break;
		}
		
	}

	public static void write_string() {
		// Enlève touts les guillemets dans la chaine
		Yaka.yvm.ecrireChaine(YakaTokenManager.chaineLue.replaceAll("\"",""));
	}

	public static void aLaLigne() {
		Yaka.yvm.aLaLigne();
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
						.getIdent(YakaTokenManager.identLu)).getOffset()*2);
			} else {
				Yaka.yvm.iconst(((IdConst) TabIdent
						.getIdent(YakaTokenManager.identLu)).getVal()*2);
			}
		} catch (UnknownIdentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	
	public static void pushIdentType(){
		Ident id;
		try {
			id = TabIdent.getIdent(YakaTokenManager.identLu);
			Yaka.expression.pushValue(id);
		} catch (UnknownIdentException e) {
			// TODO Bloc catch généré automatiquement
			System.out.println(e.toString());
		}
	}

	public static void value_true() {
		Yaka.yvm.iconst(-1);
	}

	public static void value_false() {
		Yaka.yvm.iconst(0);
	}

	/*****************************************
	 * Manipulation de fonctions : Appel
	 *****************************************/

	/**
	 * Retourne 
	 */
	public static void putReturn(){
		Yaka.yvm.ireturn(
				Declaration.getCurrentFunction().getNumberOfParameters()*2
				+4);
	}

	/**
	 * Stocke le nom de la fonction (si elle existe) sur le haut de la pile.
	 */
	public static void begin_function_call(){
		try { Yaka.expression.pushFunction(YakaTokenManager.identLu);
		} catch (Exception e) { System.err.println(e); e.printStackTrace(); }
	}
	
	
	public static void pushFunctionType(){
		
		Type t;
		try {
			t=Yaka.expression.getCurrentFunctionType();
			Yaka.expression.pushValue(t);
		} catch (UnknownFunctionException e) {
			// TODO Bloc catch généré automatiquement
			System.out.println(e.toString());
		}
	}
	
	public static void checkArgumentType(){
		try {
			Yaka.expression.checkArgumentType();
		} catch (YakaException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		} catch (UnknownFunctionException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}
	/**
	 * Ajoute un nouveau paramètre à l'appel courant.
	 *  - evaluer l'expression
	 * 	- vérifie le type du paramètre
	 *  - le push au dessus de la pile 
	 */
	public static void addParameterToCall(){
		
	}
	
	/**
	 * Appelle la fonction.
	 * Les paramètres ont été mis au préalable sur le haut de la pile
	 */
	public static void callFunction(){
		Yaka.yvm.call(Yaka.expression.popFunction());
	}

	/*****************************************
	 * Manipulation de fonctions : Déclaration
	 *****************************************/
	
	/**
	 * Créé une nouvelle fonction
	 * Create_fun fait appel à setNameCurrentFunction(name);
	 */
	public static void create_fun(){
		Declaration.createFun(YakaTokenManager.identLu);
		Yaka.yvm.begin_function(YakaTokenManager.identLu);
	}

	/**
	 * Créé un nouveau paramètre à la fonction courante
	 */
	public static void new_param(){
		Declaration.addParameter(YakaTokenManager.identLu);
	}
	
	/**
	 * Ferme le bloc courant (leave) et enregistre la fonction dans la table
	 */
	public static void closeBlock(){
		System.out.println("EndBlock"+TabIdent.dump());
		Yaka.yvm.fermeBloc(Declaration.getCurrentFunction().getNumberOfParameters());
		TabIdent.cleanIdentTable();
		IdVar.resetOffset();
	}
	
	public static void assertType(Type t){
		try {
			Yaka.expression.assertType(t);
		} catch (BadTypeException e) {
			// TODO Bloc catch généré automatiquement
			System.out.println(e.toString());
		}
	}

	public static void assertAssignementType() {
		
		try {
			Yaka.expression.assertAssignementType();
		} catch (BadTypeException e) {
			// TODO Bloc catch généré automatiquement
			System.out.println(e.toString());
		} catch (UnknownIdentException e) {
			// TODO Bloc catch généré automatiquement
			System.out.println(e.toString());
		}
		
	}
}
