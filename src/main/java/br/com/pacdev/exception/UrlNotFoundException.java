package br.com.pacdev.exception;

public class UrlNotFoundException extends Exception {
	public UrlNotFoundException() { super(); }
	public UrlNotFoundException(ErrorEnum ee) { super(ee.getMsg()); }
	public UrlNotFoundException(String message) { super(message); }
	public UrlNotFoundException(String message, Throwable cause) { super(message, cause); }
	public UrlNotFoundException(Throwable cause) { super(cause); }
}
