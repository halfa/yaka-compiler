package exception;

public class DeclarationException extends FunctionException {

	public DeclarationException(String string) {
		super("during the declaration, "+string);
	}

}
