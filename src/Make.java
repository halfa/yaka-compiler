/**
 * Générateur et librairie pour le compilateur.
 * @see Yaka.jj
 */
public class Make {
	
	public static void begin_program(){
		Yaka.yvm = new YVM(YakaTokenManager.identLu);
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
	
	public static void reading(){
		Yaka.yvm.lireEnt(((IdVar) (TabIdent.getIdent(YakaTokenManager.identLu))).getOffset());
		
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
}
