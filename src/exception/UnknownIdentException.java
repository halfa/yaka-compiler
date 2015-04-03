package exception;

public class UnknownIdentException extends DeclarationException {

	public UnknownIdentException(String string) {
		super("ident not found : "+string);
	}

	
}
