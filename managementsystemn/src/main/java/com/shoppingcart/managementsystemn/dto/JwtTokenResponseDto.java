package com.shoppingcart.managementsystemn.dto;



public class JwtTokenResponseDto {
	
	private String username;
	private String email;
	private String JwtToken;
	
	
	public JwtTokenResponseDto(String username, String email, String jwtToken) {
		super();
		this.username = username;
		this.email = email;
		JwtToken = jwtToken;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getJwtToken() {
		return JwtToken;
	}


	public void setJwtToken(String jwtToken) {
		JwtToken = jwtToken;
	}


	@Override
	public String toString() {
		return "JwtTokenResponseDto [username=" + username + ", email=" + email + ", JwtToken=" + JwtToken + "]";
	}
	
	
	
	
	
	

}
