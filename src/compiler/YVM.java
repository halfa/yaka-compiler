package compiler;
import java.io.*;
import java.util.Stack;

public class YVM {
	protected OutputStream flux;
	protected boolean error = false;
	protected int indent = 0;
	protected int loopCounterName=-1;
	protected Stack<Integer> loopDepthStack = new Stack<Integer>();
	
	/**
	 * Constructeur par défaut d'un YVM vide
	 */
	public YVM(){
		flux = null;
	}
	
	/**
	 * Constructeur d'un YVM à partir d'une chaine de caractères
	 * @param name
	 */
	public YVM (String name){
		flux = Ecriture.ouvrir(name);
	}
	
	/**
	 * Retourne la chaine extention du fichier associé au language YVM.
	 * @return l'extension, point compris
	 */
	public String getFileExtension(){
		return ".yvm";
	}
	
	/**
	 * Création de l'étiquette pour la boucle TANTQUE
	 * 
	 */
	public void startLoop(){
		loopCounterName++;
		Ecriture.ecrireStringln(flux,"FAIRE"+loopCounterName+":",indent);
		loopDepthStack.push(new Integer(loopCounterName));	
		indent++;
	}
	
	/**
	 * Gestion de la boucle TANTQUE
	 * 
	 */
	public void condLoop(){
		String etiquette= "FAIT"+loopCounterName+":";
		iffaux(etiquette);
	}
	
	/**
	 * Fermeture de la boucle TANTQUE courante
	 * 
	 */
	public void endLoop(){
		int id = (int)loopDepthStack.pop(); 
		jump("FAIRE"+id+" :");
		Ecriture.ecrireStringln(flux,"FAIT"+id+":",indent);
		indent--;	
	}
	
	/**
	 * Haut de pile : int / int
	 * Aditionne les deux éléments en sommet de pile 
	 */
	public void iadd(){
		Ecriture.ecrireStringln(flux,"iadd");
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void isub(){
		Ecriture.ecrireStringln(flux,"isub");
	}

	/**
	 * Haut de pile : int / int
	 * Multiplie les deux éléments en haut de pile
	 */
	public void imul(){
		Ecriture.ecrireStringln(flux,"imul");
	}

	/**
	 * Haut de pile : int / int
	 * Soustrait le deuxième élément de la pile par le premier
	 */
	public void idiv(){
		Ecriture.ecrireStringln(flux,"idiv");
	};

	/**
	 * Haut de pile : bool
	 * Transforme l'élément en haut de pile en son opposé
	 */
	public void inot(){
		Ecriture.ecrireStringln(flux,"inot");
	};

	/**
	 * Haut de pile : int
	 * Transforme l'élément en haut de pile en son opposé
	 */
	public void ineg(){
		Ecriture.ecrireStringln(flux,"ineg");
	};

	/**
	 * Haut de pile : bool / bool
	 * Fait un test "ET" sur les deux éléments en haut de la pile
	 */
	public void iand(){
		Ecriture.ecrireStringln(flux,"iand");
	};

	/**
	 * Haut de pile : bool / bool
	 * Fait un test "OU" sur les deux éléments en haut de la pile
	 */
	public void ior(){
		Ecriture.ecrireStringln(flux,"ior");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void iinf(){
		Ecriture.ecrireStringln(flux,"iinf");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est supérieur au premier 
	 */
	public void isup(){
		Ecriture.ecrireStringln(flux,"isup");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur ou égal au premier
	 */
	public void iinfegal(){
		Ecriture.ecrireStringln(flux,"iinfegal");
	};

	/**
	 * Haut de pile : int / int
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est supérieur ou égal au premier
	 */
	public void isupegal(){
		Ecriture.ecrireStringln(flux,"isupegal");
	};

	/**
	 * Haut de pile : bool / bool
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est égal au premier
	 */
	public void iegal(){
		Ecriture.ecrireStringln(flux,"iegal");
	};

	/**
	 * Haut de pile : bool / bool
	 * Met "VRAI" en haut de pile si le deuxième élément de la pile est inférieur au premier
	 */
	public void idiff(){
		Ecriture.ecrireStringln(flux,"idiff");
	};

	/**
	 * Met la valeur "valeur" en sommet de pile
	 * @param valeur
	 */
	public void iconst(int valeur){
		
		Ecriture.ecrireStringln(flux,"iconst "+valeur);
	};

	/**
	 * Haut de pile : anything
	 * Met la valeur se trouvant en sommet de pile dans la mémoiree à l'offset "offset"
	 * @param offset
	 */
	public void istore(int offset){
		Ecriture.ecrireStringln(flux,"istore "+offset);
	};

	/**
	 * Haut de pile : anything
	 * Met en sommet de pile la valeur contenue dans la mémoire à l'offset "offset"
	 * @param offset
	 */
	public void iload(int offset){
		Ecriture.ecrireStringln(flux,"iload "+offset);
	};

	/**
	 * Compare la valeur se trouvant en sommet de pile à 0.
	 * Si la valeur est 0, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(flux,"ifeq "+etiquette);
	};

	/**
	 * Compare la valeur se trouvant en sommet de pile à FAUX.
	 * Si la valeur est FAUX, alors l'expression suivante exécutée se trouve à l'étiquette "etiquette"
	 * @param etiquette
	 */
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(flux,"iffaux "+etiquette);
	};

	/**
	 * La prochaine instruction exécutée se trouve après l'étiquette "etiquette".
	 * L'instruction "goto" est un mot réservé en java, on utilise donc la dénomination "jump",
	 * car il s'agit d'un saut inconditionel
	 * @param etiquette
	 */
	public void jump(String etiquette){
		Ecriture.ecrireStringln(flux,"goto "+etiquette);
	};

	/**
	 * APPELER AVANT LA CREATION D'UN FICHIER .yvm
	 * Génère l'entête d'un fichier .yvm
	 */
	public void entete(){
		Ecriture.ecrireStringln(flux,"entete");
	}; 

	/**
	 * Permet de réserver directement un ensemble de variables dans la pile
	 * @param nbVar
	 */
	public void ouvrePrinc(int nbVar){
		Ecriture.ecrireStringln(flux,"ouvrePrinc "+nbVar*2);
	}; 

	/**
	 * APPELER A LA FERMETURE D'UN FICHIER .yvm
	 * Génère la fin d'un fichier .yvm
	 */
	public void queue(){
		Ecriture.ecrireStringln(flux,"queue");
		Ecriture.fermer(flux);
	};

	/**
	 * Permet d'afficher à l'écran la chaine de caractères placée en paramètre.
	 * Les quotes <",'> sont issue du yaka lui-même. #programationParContrat.
	 * TODO on vérifie le premier et le dernier caractère ?
	 * @param s
	 */
	public void ecrireChaine(String chaine){
		Ecriture.ecrireStringln(flux,"ecrireChaine "+chaine);
	}

	/**
	 * Permet d'afficher à l'écran l'entier en sommet de pile
	 */
	public void ecrireEnt(){
		Ecriture.ecrireStringln(flux,"ecrireEnt");
	}

	/**
	 * Permet d'afficher à l'écran le booleen en sommet de pile
	 */
	public void ecrireBool(){
		Ecriture.ecrireStringln(flux,"ecrireBool");
	}

	/**
	 * Lit l'entier tapé au clavier et le place dans la mémoire à l'offset "offset"
	 */
	public void lireEnt(int offset){
		Ecriture.ecrireStringln(flux,"lireEnt "+offset);
		//todo
	}

	/**
	 * Va à la ligne
	 */
	public void aLaLigne(){
		Ecriture.ecrireStringln(flux,"aLaLigne");
	}
}
