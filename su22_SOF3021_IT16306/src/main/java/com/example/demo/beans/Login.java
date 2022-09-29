package com.example.demo.beans;

public class Login {
	private String email;
//	phải giôgs với name của thuộc tính ben form
	private String password;
	
	

	public Login() {
		super();
		
	}

	public Login(String email, String password) {
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
