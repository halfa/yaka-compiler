public class YVMasm extends YVM {
  private OutputStream nomFich;
  
  public void iadd(){
    Ecriture.ecrireStringln(nomFich,"pop bx");
    Ecriture.ecrireStringln(nomFich,"pop ax");
    Ecriture.ecrireStringln(nomFich,"add ax,bx");
    Ecriture.ecrireStringln(nomFich,"push bx");
  }
  
  public void isub(){
    Ecriture.ecrireStringln(nomFich,"pop bx");
    Ecriture.ecrireStringln(nomFich,"pop ax");
    Ecriture.ecrireStringln(nomFich,"sub ax,bx");
    Ecriture.ecrireStringln(nomFich,"push bx");
  }
  
  public void imul(){
    Ecriture.ecrireStringln(nomFich,"pop bx");
    Ecriture.ecrireStringln(nomFich,"pop ax");
    Ecriture.ecrireStringln(nomFich,"imul bx");
    Ecriture.ecrireStringln(nomFich,"push bx");
  }
  
  public void idiv(){
    Ecriture.ecrireStringln(nomFich,"pop bx");
    Ecriture.ecrireStringln(nomFich,"pop ax");
    Ecriture.ecrireStringln(nomFich,"cwd");
    Ecriture.ecrireStringln(nomFich,"idiv bx");
    Ecriture.ecrireStringln(nomFich,"push bx");
  }
  
  public void inot(){}
  public void ineg(){}
  public void iand(){
    Ecriture.ecrireStringln(nomFich,"pop bx");
    Ecriture.ecrireStringln(nomFich,"pop ax");
    Ecriture.ecrireStringln(nomFich,"and ax,bx");
    Ecriture.ecrireStringln(nomFich,"push ax");
  }
  
  public void ior(){
    Ecriture.ecrireStringln(nomFich,"pop bx");
    Ecriture.ecrireStringln(nomFich,"pop ax");
    Ecriture.ecrireStringln(nomFich,"or ax,bx");
    Ecriture.ecrireStringln(nomFich,"push ax");
  }
  
  public void iinf(){}
  
  public void isup(){}
  
  public void iinfegal(){
    Ecriture.ecrireStringln(nomFich,"pop bx");
    Ecriture.ecrireStringln(nomFich,"pop ax");
    Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
    Ecriture.ecrireStringln(nomFich,"jg $+6");
    Ecriture.ecrireStringln(nomFich,"push -1");
    Ecriture.ecrireStringln(nomFich,"jmp $+4");
    Ecriture.ecrireStringln(nomFich,"push 0");
  }
  
  public void isupegal(){}
  
  public void iegal(){}
  
  public void idiff(){}
  
  public void iconst(int valeur){
    Ecriture.ecrireStringln(nomFich,"push "+valeur);
  }
  
  public void istore(int offset){
    Ecriture.ecrireStringln(nomFich,"pop ax");
    Ecriture.ecrireStringln(nomFich,"mov word ptr[bp-"+offset+"],ax");
  }
  
  public void iload(int offset){
    Ecriture.ecrireStringln(nomFich,"push word ptr [bp-"+offset+"]");
  }
  
  public void ifeq(String etiquette){}
  
  public void iffaux(String etiquette){}
  
  public void goto(String etiquette){
     Ecriture.ecrireStringln(nomFich,"jmp "+etiquette);
  }
  
  public void entete(){}
  
  public void ouvrePrinc(int var){}
}
