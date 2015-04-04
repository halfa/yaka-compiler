package exception;

public class UnknownFunctionException extends Exception {
	private static final long serialVersionUID = -187088714127608596L;

	public UnknownFunctionException(String clef) {
		super("function not found : "+clef);
	}

}
