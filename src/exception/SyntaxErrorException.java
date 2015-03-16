package exception;

public class SyntaxErrorException extends YakaException {

	public SyntaxErrorException(String string) {
		super("Syntax Error: "+string);
	}

}
