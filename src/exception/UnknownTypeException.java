package exception;

public class UnknownTypeException extends SyntaxErrorException {
	private static final long serialVersionUID = -7373334759551545384L;

	public UnknownTypeException(String string) {
		super("Unknown type: "+string);
	}

}
