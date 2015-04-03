package exception;

public class UnknownFunctionException extends Exception {

	public UnknownFunctionException(String clef) {
		super("function not found : "+clef);
	}

}
