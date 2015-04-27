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
	public static int error = 0;

	public static void checkAnalyse() throws ParseException {
		if (error > 0)
			throw new ParseException("You have " + error + " errors!\n");
	}

	public static void beginProgram() {
		// Crée le fichier en utilisant * le nom fourni en début de programme
		// * l'extension du language utilisé
		Yaka.yvm = new YVMasm(YakaTokenManager.identLu);
		Yaka.expression = new Expression(Yaka.yvm);
		Yaka.yvm.entete();
	}

	public static void beginPrincipal() {
		Declaration.setCurrentFunction(new IdFPrinc());
		Declaration.setNameCurrentFunction("main");
		Yaka.yvm.beginPrincipal();
	}

	public static void startIf() {
		Yaka.yvm.startIf();
	}

	public static void condIf() {
		Yaka.yvm.condIf();
	}

	public static void elseIf() {
		Yaka.yvm.elseIf();
	}

	public static void endIf() {
		Yaka.yvm.endIf();
	}

	public static void endProgram() {
		Yaka.yvm.queue();
	}

	public static void evaluate() {
		try {
			Yaka.expression.evaluate();
		} catch (YakaException e) {
			System.err.println(e.toString());
			
		}
	}

	public static void startLoop() {
		Yaka.yvm.startLoop();
	}

	public static void endLoop() {
		Yaka.yvm.endLoop();
	}

	public static void condLoop() {
		Yaka.yvm.condLoop();
	}

	public static void howFatAreYou() {
		Yaka.yvm.ouvreBloc(TabIdent.countLocalVars());
	}

	public static void defineConstant() {
		Declaration.setCurrentIdent(YakaTokenManager.identLu);
	}

	public static void defineInt() {
		Declaration.createConst(YakaTokenManager.entierLu, Type.INTEGER);
	}

	public static void defineIdent() {
		try {
			Declaration.createConst(YakaTokenManager.identLu);
		} catch (DeclarationException e) {
			System.err.println(e.toString());
			
		}
	}

	public static void defineTrue() {
		Declaration.createConst(-1, Type.BOOLEAN);
	}

	public static void defineFalse() {
		Declaration.createConst(0, Type.BOOLEAN);
	}

	public static void createVar() {
		Declaration.createVar(YakaTokenManager.identLu);
	}

	public static void declareVarBool() {
		Declaration.setCurrentType(Type.BOOLEAN);
	}

	public static void declareVarInt() {
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
			System.err.println(e.toString());
			
		}

	}

	public static void assignment() {
		Ident i;
		try {
			i = TabIdent.getIdent(Declaration.getCurrentIdent());

			Yaka.yvm.istore(((IdVar) i).getOffset());
		} catch (UnknownIdentException e) {
			System.err.println(e.toString());
			
		}

	}

	public static void writeExpression(Expression e) {
		switch (e.getCurrentType()) {
		case BOOLEAN:
			Yaka.yvm.ecrireBool();
			break;
		case INTEGER:
			Yaka.yvm.ecrireEnt();
			break;
		default:
			break;
		}

	}

	public static void writeString() {
		// Enlève touts les guillemets dans la chaine
		Yaka.yvm.ecrireChaine(YakaTokenManager.chaineLue.replaceAll("\"", ""));
	}

	public static void aLaLigne() {
		Yaka.yvm.aLaLigne();
	}

	public static void valueInt() {
		Yaka.yvm.iconst(YakaTokenManager.entierLu);
	}

	public static void valueIdent() {
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
			System.err.println(e.toString());
			
		}
	}

	public static void pushIdentType() {
		Ident id;
		try {
			id = TabIdent.getIdent(YakaTokenManager.identLu);
			Yaka.expression.pushValue(id);
		} catch (UnknownIdentException e) {
			System.err.println(e.toString());
			
		}
	}

	public static void valueTrue() {
		Yaka.yvm.iconst(-1);
	}

	public static void valueFalse() {
		Yaka.yvm.iconst(0);
	}

	/*****************************************
	 * Manipulation de fonctions : Appel
	 *****************************************/

	/**
	 * Libère l'espace mémoire des paramètres
	 */
	public static void putReturn() {
		Yaka.yvm.ireturn(Declaration.getCurrentFunction().getReturnOffset());
	}

	/**
	 * Stocke le nom de la fonction (si elle existe) sur le haut de la pile.
	 * Réserve également la valeur de retour
	 */
	public static void beginFunctionCall() {
		try {
			Yaka.expression.pushFunction(YakaTokenManager.identLu);
			Yaka.yvm.reserveRetour();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public static void pushFunctionType() {
		Type t;
		try {
			t = Yaka.expression.getCurrentFunctionType();
			Yaka.expression.pushValue(t);
		} catch (UnknownFunctionException e) {
			System.err.println(e.toString());
			
		}
	}

	public static void checkArgumentType() {
		try {
			Yaka.expression.checkArgumentType();
		} catch (YakaException e) {
			System.err.println(e.toString());
			
		} catch (UnknownFunctionException e) {
			System.err.println(e.toString());
			
		}
	}

	/**
	 * Appelle la fonction. Les paramètres ont été mis au préalable sur le haut
	 * de la pile
	 */
	public static void callFunction() {
		Yaka.yvm.call(Yaka.expression.popFunction());
	}

	/*****************************************
	 * Manipulation de fonctions : Déclaration
	 *****************************************/

	/**
	 * Créé une nouvelle fonction CreateFun fait appel à
	 * setNameCurrentFunction(name);
	 */
	public static void createFun() {
		Declaration.createFun(YakaTokenManager.identLu);
		Yaka.yvm.beginFunction(YakaTokenManager.identLu);
	}

	/**
	 * Créé un nouveau paramètre à la fonction courante
	 */
	public static void newParam() {
		Declaration.addParameter(YakaTokenManager.identLu);
	}

	/**
	 * Ferme le bloc courant (leave) et enregistre la fonction dans la table
	 */
	public static void closeBlock() {
		// System.out.println("EndBlock"+TabIdent.dump());
		Yaka.yvm.fermeBloc(Declaration.getCurrentFunction()
				.getNumberOfParameters());
		TabIdent.cleanIdentTable();
		IdVar.resetOffset();
	}

	public static void checkReturn() {
		try {
			Yaka.expression.checkReturn();
		} catch (BadTypeException e) {
			System.err.println(e.toString());
			
		}
	}

	public static void assertType(Type t) {
		try {
			Yaka.expression.assertType(t);
		} catch (BadTypeException e) {
			System.err.println(e.toString());
			
		}
	}

	public static void assertAssignementType() {

		try {
			Yaka.expression.assertAssignementType();
		} catch (BadTypeException e) {
			System.err.println(e.toString());
			
		} catch (UnknownIdentException e) {
			System.err.println(e.toString());
			
		}

	}
}
