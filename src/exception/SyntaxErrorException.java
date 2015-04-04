package exception;

public class SyntaxErrorException extends FunctionException {
	private static final long serialVersionUID = 466187451713193487L;

	public SyntaxErrorException(String string) {
		super("syntaxe error, "+string);
	}

}
