package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

public class AuthenticationBody {
	
	private String email;
	private String password;
	
	public AuthenticationBody(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	
}