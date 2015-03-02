public abstract class YVM {

  public void iadd();
  
  public void isub();
  
  public void imul();
  
  public void idiv();
  
  public void inot();
  
  public void ineg();
  
  public void iand();
  
  public void ior();
  
  public void iinf();
  
  public void isup();
  
  public void iinfegal();
  
  public void isupegal();
  
  public void iegal();
  
  public void idiff();
  
  public void iconst(int valeur);
  
  public istore(int offset);
  
  public iload(int offset);
  
  public ifeq(String etiquette);
  
  public iffaux(String etiquette);
  
  public goto(String etiquette);
  
  public entete();
  
  public ouvrePrinc(int var);
}
