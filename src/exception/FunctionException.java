package exception;

import compiler.Declaration;

public class FunctionException extends YakaException {
	private static final long serialVersionUID = -3735046604754574880L;

	public FunctionException(String string) {
		super("in function "+Declaration.getNameCurrentFunction()+", "+string);
	}

}
