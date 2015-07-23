package com.unknow.gson;

import java.util.List;

public class Person {

	private int id;
	private String name;
	private String address;
	
	private List<Person> pList;
	
	public Person(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [address=" + address + ", id=" + id + ", name=" + name
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Person() {
	}

	public List<Person> getpList() {
		return pList;
	}

	public void setpList(List<Person> pList) {
		this.pList = pList;
	}

}
