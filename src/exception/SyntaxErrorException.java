package exception;

public class SyntaxErrorException extends FunctionException {

	public SyntaxErrorException(String string) {
		super("syntaxe error, "+string);
	}

}
