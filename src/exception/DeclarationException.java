package exception;

public class DeclarationException extends FunctionException {
	private static final long serialVersionUID = -6347102774608843097L;

	public DeclarationException(String string) {
		super("during the declaration, "+string);
	}

}
