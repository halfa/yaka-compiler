package exception;

public class UnknownTypeException extends SyntaxErrorException {

	public UnknownTypeException(String string) {
		super("Unknown type: "+string);
	}

}
