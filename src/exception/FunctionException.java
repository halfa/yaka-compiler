package exception;

import compiler.Declaration;

public class FunctionException extends YakaException {

	public FunctionException(String string) {
		super("in function "+Declaration.getNameCurrentFunction()+ " : "+string);
		// TODO Auto-generated constructor stub
	}

}
