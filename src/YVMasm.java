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

	public void inot(){
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"and ax,FALSE");
		Ecriture.ecrireStringln(nomFich,"push ax");
	}
	public void ineg(){
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"mov bx,-1");
		Ecriture.ecrireStringln(nomFich,"imul bx")
		Ecriture.ecrireStringln(nomFich,"push ax");
	}
	
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

	public void iinf(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"jge $+6");
		Ecriture.ecrireStringln(nomFich,"push -1");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push 0");
	}

	public void isup(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp bx,ax");
		Ecriture.ecrireStringln(nomFich,"jge $+6");
		Ecriture.ecrireStringln(nomFich,"push -1");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push 0");
	}

	public void iinfegal(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"jg $+6");
		Ecriture.ecrireStringln(nomFich,"push -1");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push 0");
	}

	public void isupegal(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp bx,ax");
		Ecriture.ecrireStringln(nomFich,"jg $+6");
		Ecriture.ecrireStringln(nomFich,"push -1");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push 0");
	}

	public void iegal(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"jne $+6");
		Ecriture.ecrireStringln(nomFich,"push -1");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push 0");
	}

	public void idiff(){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"je $+6");
		Ecriture.ecrireStringln(nomFich,"push -1");
		Ecriture.ecrireStringln(nomFich,"jmp $+4");
		Ecriture.ecrireStringln(nomFich,"push 0");
	}

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

	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(nomFich,"pop bx");
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,bx");
		Ecriture.ecrireStringln(nomFich,"je "+etiquette);
	}

	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(nomFich,"pop ax");
		Ecriture.ecrireStringln(nomFich,"cmp ax,FALSE");
		Ecriture.ecrireStringln(nomFich,"je "+etiquette);
	}

	public void jump(String etiquette){
		Ecriture.ecrireStringln(nomFich,"jmp "+etiquette);
	}

	public void entete(){
		Ecriture.ecrireStringln(nomFich,".model SMALL");
		Ecriture.ecrireStringln(nomFich,".586");
		Ecriture.ecrireStringln(nomFich,".DATA");
		Ecriture.ecrireStringln(nomFich,"FALSE EQU 0");
		Ecriture.ecrireStringln(nomFich,"TRUE EQU 1");
		Ecriture.ecrireStringln(nomFich,".CODE");
		Ecriture.ecrireStringln(nomFich,"debut :");
		Ecriture.ecrireStringln(nomFich,"	STARTUPCODE");
	}

	public void ouvrePrinc(int var){
		Ecriture.ecrireStringln(nomFich,"mov bp,sp");
		Ecriture.ecrireStringln(nomFich,"sub sp,"+var);
	}

	public void queue(){
		Ecriture.ecrireStringln(nomFich,"nop");
		Ecriture.ecrireStringln(nomFich,"exitcode");
		Ecriture.ecrireStringln(nomFich,"end debut");
	}
}
