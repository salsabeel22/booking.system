package com.booking.dtos;

public class AuthenticateDTO {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthenticateDTO(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
public AuthenticateDTO() {
	
	}

}
