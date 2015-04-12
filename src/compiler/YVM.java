package compiler;
import java.io.*;
import java.util.Stack;

public class YVM {
	protected OutputStream flux;
	protected boolean error = false;
	protected int indent = 1;
	protected int loopCounterName=0;
	protected int condCounterName=0;
	protected Stack<Integer> labelNameStack = new Stack<Integer>();
	
	/**
	 * Constructeur par défaut d'un YVM vide.
	 */
	public YVM(){
		flux = null;
	}
	
	/**
	 * Constructeur d'un YVM à partir d'une chaine de caractères.
	 * @param name
	 */
	public YVM (String name){
		flux = Ecriture.ouvrir(name+this.getFileExtension());
	}
	
	/**
	 * Débute la fonction principale
	 */
	public void beginPrincipal(){
		Ecriture.ecrireStringln(flux,"main :",0);
	}
	
	/**
	 * Débute une fonction classique
	 * @param name le nom de la fonction 
	 */
	public void beginFunction(String name){
		Ecriture.ecrireStringln(flux,name+" :",0);
	}
	
	/**
	 * En début de fonction, réserve la place pour le nombre de variables placé en paramètre.
	 * @param var le nombre de variables
	 */
	public void ouvreBloc(int var){
		Ecriture.ecrireStringln(flux, "ouvrebloc "+var*2,indent);
	}
	
	/**
	 * En fin de fonction, donne la taille du nombre de paramètres placé en paramètre.
	 * @param param le nombre de paramètres
	 */
	public void fermeBloc(int param){
		Ecriture.ecrireStringln(flux, "fermebloc "+param*2,indent);
	}
	
	/**
	 * Place le résultat de la fonction, qui en sommet de pile, à l'offset donné.
	 * @param offset emplacement réservé lors de l'appel
	 */
	public void ireturn(int offset){
		Ecriture.ecrireStringln(flux,"ireturn "+offset,indent);
	}
	
	/**
	 * Instruction à appeler avant l'appel d'une fonction qui retourne un résultat.
	 */
	public void reserveRetour(){
		Ecriture.ecrireStringln(flux, "reserveRetour", indent);
	}
	
	/**
	 * Instruction pour appeler la fonction de nom "nomFun"
	 * @param nomFun le nom de la fonction
	 */
	public void call(String nomFun){
		Ecriture.ecrireStringln(flux, "call "+nomFun, indent);
	}
	
	/**
	 * Retourne la chaine extention du fichier associé au language YVM.
	 * @return l'extension, point compris
	 */
	public String getFileExtension(){
		return ".yvm";
	}
	
	/**
	 * Création de l'étiquette SI pour la CONDITIONNELLE
	 */
	public void startIf(){
		condCounterName++;
		Ecriture.ecrireStringln(flux,"SI"+condCounterName+":",indent);
		labelNameStack.push(new Integer(condCounterName));	
		indent++;
	}
	
	/**
	 * Création de l'étiquette ALORS pour la CONDITIONNELLE
	 */
	public void condIf(){
		int id = (int)labelNameStack.pop();
		String etiquette= "SINON"+id;
		iffaux(etiquette);
		labelNameStack.push(new Integer(id));
	}
	
	/**
	 * Création de l'étiquette SINON pour la CONDITIONNELLE
	 */
	public void elseIf(){
		int id = (int)labelNameStack.pop();
		String etiquette= "FSI"+id;
		jump(etiquette);
		Ecriture.ecrireStringln(flux,"SINON"+id+":",indent-1);
		labelNameStack.push(new Integer(id));	
	}
		
	/**
	 * Création de l'étiquette FSI pour la CONDITIONNELLE
	 */
	public void endIf(){
		int id = (int)labelNameStack.pop(); 
		Ecriture.ecrireStringln(flux,"FSI"+id+":",indent-1);
		indent--;	
	}	
	
	/**
	 * Création de l'étiquette pour la boucle TANTQUE
	 */
	public void startLoop(){
		loopCounterName++;
		Ecriture.ecrireStringln(flux,"FAIRE"+loopCounterName+":",indent-1);
		labelNameStack.push(new Integer(loopCounterName));	
		indent++;
	}
	
	/**
	 * Gestion de la boucle TANTQUE
	 * 
	 */
	public void condLoop(){
		int id = (int)labelNameStack.pop();
		String etiquette= "FAIT"+id;
		iffaux(etiquette);
		labelNameStack.push(new Integer(id));	
	}
	
	/**
	 * Fermeture de la boucle TANTQUE courante
	 */
	public void endLoop(){
		int id = (int)labelNameStack.pop(); 
		jump("FAIRE"+id);
		Ecriture.ecrireStringln(flux,"FAIT"+id+":",indent-2);
		indent--;	
	}
	
	/**
	 * Haut de pile : int / int
	 * Aditionne les deux éléments en sommet de pile 
	 */
	public void iadd(){
		Ecriture.ecrireStringln(flux,"iadd",indent);
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void isub(){
		Ecriture.ecrireStringln(flux,"isub",indent);
	}

	/**
	 * Haut de pile : int / int
	 * Multiplie les deux éléments en haut de pile
	 */
	public void imul(){
		Ecriture.ecrireStringln(flux,"imul",indent);
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void idiv(){
		Ecriture.ecrireStringln(flux,"idiv",indent);
	};

	/**
	 * Haut de pile : bool
	 * Transforme l'élément en haut de pile en son opposé
	 */
	public void inot(){
		Ecriture.ecrireStringln(flux,"inot",indent);
	};

	/**
	 * Haut de pile : int
	 * Transforme l'élément en haut de pile en son opposé
	 */
	public void ineg(){
		Ecriture.ecrireStringln(flux,"ineg",indent);
	};

	/**
	 * Haut de pile : bool / bool
	 * Fait un test "ET" sur les deux éléments en haut de la pile
	 */
	public void iand(){
		Ecriture.ecrireStringln(flux,"iand",indent);
	};

	/**
	 * Haut de pile : bool / bool
	 * Fait un test "OU" sur les deux éléments en haut de la pile
	 */
	public void ior(){
		Ecriture.ecrireStringln(flux,"ior",indent);
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void iinf(){
		Ecriture.ecrireStringln(flux,"iinf",indent);
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est supérieur au premier 
	 */
	public void isup(){
		Ecriture.ecrireStringln(flux,"isup",indent);
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur ou égal au premier
	 */
	public void iinfegal(){
		Ecriture.ecrireStringln(flux,"iinfegal",indent);
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est supérieur ou égal au premier
	 */
	public void isupegal(){
		Ecriture.ecrireStringln(flux,"isupegal",indent);
	};

	/**
	 * Haut de pile : bool / bool
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est égal au premier
	 */
	public void iegal(){
		Ecriture.ecrireStringln(flux,"iegal",indent);
	};

	/**
	 * Haut de pile : bool / bool
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void idiff(){
		Ecriture.ecrireStringln(flux,"idiff",indent);
	};

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * @param valeur
	 */
	public void iconst(int valeur){
		
		Ecriture.ecrireStringln(flux,"iconst "+valeur,indent);
	};

	/**
	 * Haut de pile : anything
	 * Met la valeur se trouvant en sommet de pile dans la mémoiree à l'offset "offset"
	 * @param offset
	 */
	public void istore(int offset){
		Ecriture.ecrireStringln(flux,"istore "+offset,indent);
	};

	/**
	 * Haut de pile : anything
	 * Met en sommet de pile la valeur contenue dans la mémoire à l'offset "offset"
	 * @param offset
	 */
	public void iload(int offset){
		Ecriture.ecrireStringln(flux,"iload "+offset,indent);
	};

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0.
	 * Si la valeur est 0, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(flux,"ifeq "+etiquette,indent);
	};

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX.
	 * Si la valeur est FAUX, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(flux,"iffaux "+etiquette,indent);
	};

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette".
	 * L'instruction "goto" est un mot réservé en java, on utilise donc la dénomination "jump",
	 * car il s'agit d'un saut inconditionel
	 * @param etiquette
	 */
	public void jump(String etiquette){
		Ecriture.ecrireStringln(flux,"goto "+etiquette,indent);
	};

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .yvm
	 * Génère l'entête d'un fichier .yvm
	 */
	public void entete(){
		Ecriture.ecrireStringln(flux,"entete",indent);
	}; 

	/**
	 * Permet de réserver directement un ensemble de variables dans la pile
	 * @param nbVar
	 */
	public void ouvrePrinc(int nbVar){
		Ecriture.ecrireStringln(flux,"ouvrePrinc "+nbVar*2,0);
	}; 

	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .yvm
	 * Génère la fin d'un fichier .yvm
	 */
	public void queue(){
		Ecriture.ecrireStringln(flux,"queue",indent);
		Ecriture.fermer(flux);
	};

	/**
	 * Permet d'afficher à l'écran la chaine de caractères placée en paramètre.
	 * Les quotes <",'> sont issue du yaka lui-même. #programationParContrat.
	 * TODO vérifier le premier et le dernier caractère ?
	 * @param s
	 */
	public void ecrireChaine(String chaine){
		Ecriture.ecrireStringln(flux,"ecrireChaine "+"\""+chaine+"\"",indent);
	}

	/**
	 * Permet d'afficher à l'écran l'entier en sommet de pile
	 */
	public void ecrireEnt(){
		Ecriture.ecrireStringln(flux,"ecrireEnt",indent);
	}

	/**
	 * Permet d'afficher à l'écran le booleen en sommet de pile
	 */
	public void ecrireBool(){
		Ecriture.ecrireStringln(flux,"ecrireBool",indent);
	}

	/**
	 * Lit l'entier tapé au clavier et le place dans la mémoire à l'offset "offset"
	 */
	public void lireEnt(int offset){
		Ecriture.ecrireStringln(flux,"lireEnt "+offset,indent);
		//todo
	}

	/**
	 * Va à la ligne
	 */
	public void aLaLigne(){
		Ecriture.ecrireStringln(flux,"aLaLigne",indent);
	}
}
