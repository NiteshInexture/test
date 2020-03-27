package com.pojo;

import java.util.Map;

public class UserPojo {
	
	private int id;
	private String firstName;
	private String lastName;
	
	private Map list;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Map getList() {
		return list;
	}
	public void setList(Map list) {
		this.list = list;
	}
	
}
