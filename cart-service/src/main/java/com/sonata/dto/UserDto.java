package com.sonata.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UserDto {
	@Id
	@GeneratedValue
	private int userId;

	private String userName;
	private String phoneNumber;
	private String email;

	public UserDto() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
