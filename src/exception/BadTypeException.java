package exception;

import compiler.Type;

public class BadTypeException extends SyntaxErrorException {

	public BadTypeException(Type foundType, Type expectedType) {
		super("there is an error in assignement : Expected type "+foundType+" but receive "+expectedType);
		
	}
	
	public BadTypeException(String string){
		super(string);
	}

}
