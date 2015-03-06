public abstract class YVM {

	public void iadd(){};

	public void isub(){};

	public void imul(){};

	public void idiv(){};

	public void inot(){};

	public void ineg(){};

	public void iand(){};

	public void ior(){};

	public void iinf(){};

	public void isup(){};

	public void iinfegal(){};

	public void isupegal(){};

	public void iegal(){};

	public void idiff(){};

	public void iconst(int valeur){};

	public void istore(int offset){};

	public void iload(int offset){};

	public void ifeq(String etiquette){};

	public void iffaux(String etiquette){};

	/* goto is a reserved word */
	public void jump(String etiquette){};

	public void entete(){};

	public void ouvrePrinc(int var){};

	public void queue(){};
}
