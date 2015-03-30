package exception;

public class SyntaxErrorException extends FunctionException {

	public SyntaxErrorException(String string) {
		super("Syntax Error: "+string);
	}

}
