package com.pojo;

import java.util.Set;

public class UserPojo {
	
	private int uid;
	private String firstName;
	private String lastName;
	private Set address;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set getAddress() {
		return address;
	}
	public void setAddress(Set address) {
		this.address = address;
	}
}
