package com.pojo;

import java.util.SortedSet;

public class UserPojo {
	
	private int id;
	private String firstName;
	private String lastName;
	
	/* private List<AddressPojo> list; */
	/* private Set list;  set */
	private SortedSet<AddressPojo> list;
	
	
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
	public SortedSet<AddressPojo> getList() {
		return list;
	}
	public void setList(SortedSet<AddressPojo> list) {
		this.list = list;
	}
	
	
	/*
	 * 
	 * for Set
	 * public Set getList() { return list; } public void setList(Set list) {
	 * this.list = list; }
	 */
	/*
	 * for list and bag
	 * 
	 * public List<AddressPojo> getList() { return list; }
	 * public void setList(List<AddressPojo> list) { this.list = list; }
	 */
	
}
