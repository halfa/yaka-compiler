package exception;

import compiler.Type;

public class BadTypeException extends SyntaxErrorException {
	private static final long serialVersionUID = -3143838361681774331L;

	public BadTypeException(int numArgument,Type expectedType, Type foundType) {
		super("error with argument number "+numArgument+" : Expected type "+foundType+" but receive "+expectedType);
		
	}
	
	public BadTypeException(Type expectedType, Type foundType) {
		super("error in assignement : Expected type "+foundType+" but receive "+expectedType);
		
	}
	
	public BadTypeException(String expected,String found){
		super("error in the expression: use of "+expected+" operator on a(n) "+found);
	}
	
	public BadTypeException(String string){
		super(string);
	}

}
