package com.shoppingcart.managementsystemn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserEntity {
	
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer user_id;
	
	
	@Column(name="name")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phoneNo")
	private Long phoneNo;
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(Integer user_id, String username, String email, String password, Long phoneNo) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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
		return "UserEntity [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password="
				+ password + ", phoneNo=" + phoneNo + "]";
	}

	
	
	
	
	
}
