package exception;

public class IterationException extends SyntaxErrorException {

	public IterationException(String string) {
		super("in Iteration: "+string);
	}

}
