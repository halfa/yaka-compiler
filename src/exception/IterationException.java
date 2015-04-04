package exception;

public class IterationException extends SyntaxErrorException {
	private static final long serialVersionUID = -7627370946312127215L;

	public IterationException(String string) {
		super("in Iteration: "+string);
	}

}
