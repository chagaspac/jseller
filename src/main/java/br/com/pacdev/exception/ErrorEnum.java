package br.com.pacdev.exception;

public enum ErrorEnum {
	WRONG_USER_OR_PASSWORD("Wrong user or password"),
	CANNOT_REACH_SERVER_ADDRESS("Cannot reach to server address");
	
	private final String msg;

	private ErrorEnum(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}


}
