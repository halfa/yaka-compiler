package exception;

import compiler.Yaka;

public class YakaException extends Exception {

	int line;
	public YakaException(String string) {
		super("At line"+Yaka.token.beginLine+" : "+string);
		
	}

}
