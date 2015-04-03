package exception;

public class SyntaxErrorException extends FunctionException {

	public SyntaxErrorException(String string) {
		super("there is a syntaxe error, "+string);
	}

}
