package com.design.prototype;

public class WorkEperience implements Prototype{
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public Prototype clone(){
		return new WorkEperience();
	}
}
