package com.shoppingcart.managementsystemn.dto;



public class JwtTokenResponseDto {
	
	private String username;
	private String password;
	private String JwtToken;
	
	public JwtTokenResponseDto(String username, String password, String jwtToken) {
		super();
		this.username = username;
		this.password = password;
		JwtToken = jwtToken;
	}

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

	public String getJwtToken() {
		return JwtToken;
	}

	public void setJwtToken(String jwtToken) {
		JwtToken = jwtToken;
	}

	@Override
	public String toString() {
		return "JwtTokenResponseDto [username=" + username + ", password=" + password + ", JwtToken=" + JwtToken + "]";
	}
	
	
	
	

}
