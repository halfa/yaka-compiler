package exception;

import compiler.Yaka;

public class YakaException extends Exception {
	private static final long serialVersionUID = 5567527384256537327L;
	
	int line;
	public YakaException(String string) {
		super("At line "+Yaka.token.beginLine+" "+string);
		
	}

}
