package exception;

public class UnknownIdentException extends DeclarationException {
	private static final long serialVersionUID = 7569671964750917863L;

	public UnknownIdentException(String string) {
		super("ident not found : "+string);
	}

	
}
