package compiler;
/**
 * Générateur et librairie pour le compilateur.
 * @see Yaka.jj
 */
public class Make {
	
	/*************************************
	 * Analyse syntaxique et déclarations.
	 ************************************/
	public static void begin_program(){
		// Crée le fichier en utilisant * le nom fourni en début de programme
		//                              * l'extension du language utilisé
		Yaka.yvm = new YVMasm(YakaTokenManager.identLu+Yaka.yvm.getFileExtension());
		Yaka.expression = new Expression(Yaka.yvm);
		Yaka.yvm.entete();
	}

	public static void end_program(){
		Yaka.yvm.queue();
	}

	public static void how_fat_are_you(){
		Yaka.yvm.ouvrePrinc(Declaration.getNbVariables());
	}

	public static void define_constant(){
		Declaration.setCurrentIdent(YakaTokenManager.identLu);
	}

	public static void define_int(){
		Declaration.createConst(YakaTokenManager.entierLu, Type.INTEGER);
	}

	public static void define_ident(){
		Declaration.createConst(YakaTokenManager.identLu);
	}

	public static void define_true(){
		Declaration.createConst(-1, Type.BOOLEAN);
	}

	public static void define_false(){
		Declaration.createConst(0, Type.BOOLEAN);
	}

	public static void create_var(){
		Declaration.createVar(YakaTokenManager.identLu);
	}

	public static void declare_var_bool(){
		Declaration.setCurrentType(Type.BOOLEAN);
	} 

	public static void declare_var_int(){
		Declaration.setCurrentType(Type.INTEGER);
	} 
	
	/***************************
	 * Syntaxe des expressions.
	 ***************************/
	public static void reading(){
		Yaka.yvm.lireEnt(((IdVar) (TabIdent.getIdent(YakaTokenManager.identLu))).getOffset());

	}
	public static void assignment(){
		Ident i = TabIdent.getIdent(Declaration.getCurrentIdent());
		if(i instanceof IdVar){
			Yaka.yvm.istore(((IdVar) i).getOffset());
		} else {
			// FIXME need safety
		}
	}
	public static void write_expression(){
		Yaka.yvm.ecrireEnt();
	}

	public static void write_string(){
		Yaka.yvm.ecrireChaine(YakaTokenManager.chaineLue);
	}

	public static void aLaLigne(){
		Yaka.yvm.aLaLigne();
	}

	public static void whatRel(){
		Yaka.expression.whatRel();
	}

	public static void whatAdd(){
		Yaka.expression.whatAdd();
	}

	public static void whatMul(){
		Yaka.expression.whatMul();
	}

	public static void whatNeg(){
		Yaka.expression.whatNeg();
	}

	public static void value_int(){
		Yaka.yvm.iconst(YakaTokenManager.entierLu);
	}

	public static void value_ident(){
		Ident id = TabIdent.getIdent(YakaTokenManager.identLu);
		if (id instanceof IdVar){
			Yaka.yvm.iload(((IdVar) TabIdent.getIdent(YakaTokenManager.identLu)).getOffset());
		} else {
			Yaka.yvm.iconst(((IdConst)TabIdent.getIdent(YakaTokenManager.identLu)).getVal());
		}
	}

	public static void value_true(){
		Yaka.yvm.iconst(-1);
	}

	public static void value_false(){
		Yaka.yvm.iconst(0);
	}
}
