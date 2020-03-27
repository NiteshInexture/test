package com.pojo;

import java.util.List;

public class User {
	private int uid;
	private String name;
	private List<Address> list;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}
}
