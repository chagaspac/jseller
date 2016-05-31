package br.com.pacdev.reader;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;

public class CustomAuthenticator extends Authenticator {
	private String username = null;
	private String password = null;
	public CustomAuthenticator(String username, String password){
		this.username = username;
		this.password = password;
	}
	protected PasswordAuthentication getPasswordAuthentication() {
		// Get information about the request
		//String prompt = getRequestingPrompt(); 
		//String hostname = getRequestingHost();
		//InetAddress ipaddr = getRequestingSite();
		//int port = getRequestingPort();
		return new PasswordAuthentication(this.username, this.password.toCharArray());
	}
}
