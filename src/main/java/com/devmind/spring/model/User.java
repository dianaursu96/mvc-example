package com.devmind.spring.model;

import java.util.Date;

public class User {
	private String userName;
	private String email;
	private String phoneNumber;
	private Date birthDate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthdate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
