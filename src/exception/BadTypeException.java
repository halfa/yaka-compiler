package exception;

public class BadTypeException extends SyntaxErrorException {

	public BadTypeException(String string) {
		super("bad type: "+string);
		
	}

}
