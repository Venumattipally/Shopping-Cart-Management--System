package com.shoppingcart.managementsystemn.dto;



public class UserRequestDto {

	
	
	private String username;

	private String email;
	
	
	private String password;
	
	private Long phoneNo;

	public UserRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRequestDto(String username, String email, String password, Long phoneNo) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "UserRequestDto [username=" + username + ", email=" + email + ", password=" + password + ", phoneNo="
				+ phoneNo + "]";
	}
	
	
	
}
