import java.util.HashMap;

public class TabIdent{

	private HashMap<String,Ident> table;


	/* Constructeur */
	public TabIdent()
	{
		table= new HashMap<String,Ident>();
	}

	/* Méthodes */
	public Ident chercheIdent(String clef){
		
		return table.get(clef);
	}
	public boolean existeIdent(String clef){
		
		return table.containsKey(clef);
		}
	public void rangeIdent(String clef,Ident id){
		
		table.put(clef, id);
	}


} 