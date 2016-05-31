package br.com.pacdev.exception;

public class TopLevelException extends Exception {
	public TopLevelException() { super(); }
	public TopLevelException(ErrorEnum ee) { super(ee.getMsg()); }
	public TopLevelException(String message) { super(message); }
	public TopLevelException(String message, Throwable cause) { super(message, cause); }
	public TopLevelException(Throwable cause) { super(cause); }
}
