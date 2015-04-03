package exception;

import compiler.Type;

public class BadTypeException extends SyntaxErrorException {

	public BadTypeException(int numArgument,Type expectedType, Type foundType) {
		super("there is an error with the argument number "+numArgument+" : Expected type "+foundType+" but receive "+expectedType);
		
	}
	
	public BadTypeException(Type expectedType, Type foundType) {
		super("there is an error in assignement : Expected type "+foundType+" but receive "+expectedType);
		
	}
	
	public BadTypeException(String string){
		super(string);
	}

}
