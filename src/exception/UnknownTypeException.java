package exception;

public class UnknownTypeException extends SyntaxErrorException {

	public UnknownTypeException(String string) {
		super("unknown type: "+string);
		// TODO Auto-generated constructor stub
	}

}
